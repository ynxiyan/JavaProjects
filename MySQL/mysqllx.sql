#mysql习题数据##################################################################
create database mysqllx;

use mysqllx;

create table `Student`(`s_id` int,`s_name` varchar(8),`s_birth` date,`s_sex` varchar(4));

insert into `student` values(1,'赵雷','1990-01-01','男'),(2,'钱电','1990-12-21','男'),(3,'孙风','1990-05-20','男'),(4,'李云','1990-08-06','男'),(5,'周梅','1991-12-01','女'),(6,'吴兰','1992-03-01','女'),(7,'郑竹','1989-07-01','女'),(8,'王菊','1990-01-20','女');

create table `course`(`c_id` int,`c_name` varchar(8),`t_id` int);

insert into course values(1,'语文',2),(2,'数学',1),(3,'英语',3);

create table teacher(t_id int,t_name varchar(8));

insert into teacher values(1,'张三'),(2,'李四'),(3,'王五');

create table score(s_id int,c_id int,s_score int);

insert into score values(1,1,80),(1,2,90),(1,3,99),(2,1,70),(2,2,60),(2,3,65),(3,1,80),(3,2,80),(3,3,80),(4,1,50),(4,2,30),(4,3,40),
(5,1,76),(5,2,87),(6,1,31),(6,3,34),(7,2,89),(7,3,98);
##########################################################################

#习题##################################################################
1、查询"01"课程比"02"课程成绩高的学生的信息及课程分数
select student.s_id,s_name,s_birth,s_sex,s_score1.s_score,s_score2.s_score from student,(select * from score where c_id = 1) as s_score1,(select * from score where c_id = 2) as s_score2 where student.s_id = s_score1.s_id and student.s_id = s_score2.s_id and s_score1.s_score > s_score2.s_score;

2、查询"01"课程比"02"课程成绩低的学生的信息及课程分数
select student.s_id,s_name,s_birth,s_sex,s_score1.s_score,s_score2.s_score from student,(select * from score where c_id = 1) as s_score1,(select * from score where c_id = 2) as s_score2 where student.s_id = s_score1.s_id and student.s_id = s_score2.s_id and s_score1.s_score < s_score2.s_score;

3、查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
select student.s_id,s_name,score.avgscore from student,(select s_id,avg(s_score) as avgscore from score group by s_id having avg(s_score) >= 60) as score where student.s_id = score.s_id;

'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'4、查询平均成绩小于60分的同学的学生编号和学生姓名和平均成绩(包括有成绩的和无成绩的)
select student.s_id,s_name,ifnull(round(avg_score, 2), 0) as avg_score
from student
left join (
	select s_id,avg(s_score) as avg_score
	from score
	group by s_id
) t1
on student.s_id = t1.s_id
where avg_score is null or avg_score < 60;


5、查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
select student.s_id,s_name,coursecount,scoresum from student,(select s_id,count(s_id) as coursecount,sum(s_score) as scoresum from score group by s_id having count(s_id)) as countsum where student.s_id = countsum.s_id;

6、查询"李"姓老师的数量
select count(*) as count from teacher where t_name like '李%';

7、查询学过"张三"老师授课的同学的信息
select student.s_id,s_name,s_birth,s_sex from student,teacher,course,score where student.s_id = score.s_id and course.c_id = score.c_id and course.t_id = teacher.t_id and t_name = '张三';

8、查询没学过"张三"老师授课的同学的信息
select * from student where s_id not in (select s_id from score inner join (select c_id from course inner join teacher on course.t_id = teacher.t_id where t_name = '张三') courseta on score.c_id = courseta.c_id);

9、查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息
select student.* from student,(select * from score where c_id in(1,2) group by s_id having count(*) = 2) as scoreg where student.s_id = scoreg.s_id;

10、查询学过编号为"01"但是没有学过编号为"02"的课程的同学的信息
select * from student where s_id in (select s_id from score where c_id = 1 and s_id not in (select s_id from score where c_id = 2));

11、查询没有学全所有课程的同学的信息
12、查询至少有一门课与学号为"01"的同学所学相同的同学的信息
13、查询和"01"号的同学学习的课程完全相同的其他同学的信息
14、查询没学过"张三"老师讲授的任一门课程的学生姓名
15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
16、检索"01"课程分数小于60，按分数降序排列的学生信息
17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
18、查询各科成绩最高分、最低分和平均分，以如下形式显示：
19、按各科成绩进行排序，并显示排名
20、查询学生的总成绩并进行排名



21、查询不同老师所教不同课程平均分从高到低显示
22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
23、统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比
24、查询学生平均成绩及其名次
25、查询各科成绩前三名的记录
26、查询每门课程被选修的学生数
27、查询出只有两门课程的全部学生的学号和姓名
28、查询男生、女生人数
29、查询名字中含有"风"字的学生信息
30、查询同名同性学生名单，并统计同名人数



31、查询1990年出生的学生名单
32、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列
33、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩
34、查询课程名称为"数学"，且分数低于60的学生姓名和分数
35、查询所有学生的课程及分数情况
36、查询任何一门课程成绩在70分以上的学生姓名、课程名称和分数
37、查询课程不及格的学生
38、查询课程编号为01且课程成绩在80分以上的学生的学号和姓名
39、求每门课程的学生人数
40、查询选修"张三"老师所授课程的学生中，成绩最高的学生信息及其成绩



41、查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩
42、查询每门课程成绩最好的前三名
43、统计每门课程的学生选修人数（超过5人的课程才统计）
44、检索至少选修两门课程的学生学号
45、查询选修了全部课程的学生信息
46、查询各学生的年龄(周岁)
47、查询本周过生日的学生
48、查询下周过生日的学生
49、查询本月过生日的学生
50、查询12月份过生日的学生
####################################################################3