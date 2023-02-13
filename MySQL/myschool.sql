#使用myschool数据库
use myschool;

#为表result的学号、课程编号、考试日期创建组合主键
alter table `result` add constraint `pk_result` primary key `result`(`studentNo`,`subjectNo`,`examDate`);

#为表student和表result通过studentNo字段建立主外键关联
alter table `result` add constraint `fk_student_studentNo` foreign key `result`(`studentNo`) references `student`(`studentNo`);

#查看表结构
desc `result`;

#############################################################################################

#将学生表中学号为20000的学生的邮箱修改为stu20000@163.com，密码改为000
update student set email = 'stu20000@163.com',loginPwd = '000' where studentNo = '20000';
select * from student;

#将科目表中课时数大于200且年级编号为1的科目的课时减少10
update `subject` set classHour = classHour - 10 where classHour > 200 and gradeID = 1;
select * from `subject`;

#将所有年级编号为1的学员姓名、性别、出生日期、手机号码信息保存到新表student_grade1中
create table student_grade1(select studentName,sex,bornDate,phone from student where gradeID = 1);
select * from student_grade1;

#查询2016年2月17日考试前5名的学员的学号和分数
select studentNo,studentResult from result where examDate = '2016-2-17' order by studentResult desc limit 5;

#将所有女学生按年龄从大到小排序，从第2条记录开始显示6名女学生的姓名、年龄、出生日期、手机号信息
select studentName,floor(datediff(now(),`bornDate`)/365) as age,bornDate,phone from student where sex = '女' order by bornDate limit 1,6;

#查询参加2016年2月17日考试的所有学员的最高分、最低分、平均分
select max(studentResult),min(studentResult),avg(studentResult) from result where examDate = '2016-2-17';

#查询参加“javaBasic”课程最近一次考试的在读学生名单
select studentNo,studentName,sex,gradeID,phone,address,bornDate,email,identityCard from student where studentNo in (select studentNo from result where subjectNo in (select subjectNo from `subject` where subjectName = 'javaBasic') and examDate in (select max(examDate) from result where subjectNo in (select subjectNo from `subject` where subjectName = 'javaBasic')));

#查询未参加“javaBasic”课程最近一次考试的在读学生名单
select studentNo,studentName,sex,gradeID,phone,address,bornDate,email,identityCard from student where studentNo not in (select studentNo from result where subjectNo in (select subjectNo from `subject` where subjectName = 'javaBasic') and examDate in (select max(examDate) from result where subjectNo in (select subjectNo from `subject` where subjectName = 'javaBasic')));

#################################################################################################

#检查“javaBasic”课程最近一次考试成绩如果全部未通过考试（60分及格），认为本次考试偏难，计算的该次考试平均分加5分
select avg(studentResult)+5 as '平均分' from result where not exists (select max(examDate) from result where subjectNo in (select subjectNo from `subject` where subjectName = 'javaBasic') and studentResult >= 60);

#使用事务向表中插入多条记录批量插入参加今天“javaBasic”课程考试的十名学生成绩如果输入的成绩大于100分，则取消操作
/*正确插入*/
begin;
insert into result values('10008',1,'2022-12-07',89),('20000',4,'2022-12-07',65),('20010',4,'2022-12-07',57);
commit;
end;

/*删除*/
begin;
delete from result where studentNo = '10008';
delete from result where studentNo = '20000';
delete from result where studentNo = '20010';
commit;
end;

/*错误插入并回滚*/
begin;
insert into result values('10008',1,'2022-12-07',120),('20000',4,'2022-12-07',65),('20010',4,'2022-12-07',109);
rollback;
end;

#将毕业学生的基本信息和考试成绩分别保存到历史表中使用事务完成以下操作
/*查询result表中所有二年级学员的考试成绩，保存到表historyResult中
删除result表中所有二年级学员的考试成绩
查询student表中所有二年级学员的记录，保存到表historyStudent中
删除student表中所有二年级学员的记录*/
#提交事务，查看各表中数据的变化
begin;
create table historyResult (select * from result where subjectNo in (select subjectNo from `subject` where gradeID = 2));
delete from result where subjectNo in (select subjectNo from `subject` where gradeID = 2);
create table historyStudent (select * from student where gradeID = 2);
delete from student where gradeID = 2;
commit;
end;

/*查看historyResult*/
select * from historyResult;

/*查看historyStudent*/
select * from historyStudent;

/*重新插入二年级数据并删除historyResult、historyStudent*/
insert into student (select * from historyStudent where gradeID = 2);
insert into result (select * from historyResult where subjectNo = 4);
drop table historyStudent;
drop table historyResult;

#回滚事务，查看各表中数据的变化
begin;
create table historyResult (select * from result where subjectNo in (select subjectNo from `subject` where gradeID = 2));
delete from result where subjectNo in (select subjectNo from `subject` where gradeID = 2);
create table historyStudent (select * from student where gradeID = 2);
delete from student where gradeID = 2;
rollback;
end;

#创建方便教师查看成绩的视图
create view view_student_result as (select studentName as '姓名',student.studentNo as '学号',studentResult as '成绩',subjectName as '课程名称',examDate as '考试日期' from student inner join result on student.studentNo = result.studentNo inner join `subject` on result.subjectNo = `subject`.subjectNo);

/*查看视图*/
select * from view_student_result;

#使用视图获取多表中数据统计每个学生所参考课程的平均成绩
create view view_student_avgresult as (select studentName as '学生姓名',subjectName as '课程名',avg(studentResult) as '平均成绩' from student inner join result on student.studentNo = result.studentNo inner join `subject` on result.subjectNo = `subject`.subjectNo group by studentName,subjectName having avg(studentResult));

/*查看视图*/
select * from view_student_avgresult;

#为提高以下查询的速度，为学生表和成绩表添加适合的索引，并查看索引
/*按学生名和年级编号组合查询*/
create index index_studentName_gradeID on student(studentName,gradeID);

/*学生身份证号是唯一的*/
create unique index index_identityCard on student(identityCard);

/*查看student表的索引*/
show index from student;

/*按成绩区间范围查找学生考试信息*/
select studentNo,subjectNo,examDate,studentResult from result where studentResult between 60 and 90;
