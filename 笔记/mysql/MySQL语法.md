# [MySQL语法](https://www.cnblogs.com/ynxiyan/p/17026438.html)

#### 一、数据库引擎

###### #显示系统默认存储引擎

```mysql
show variables like '%engine%';
```

#### 二、数据库操作

###### #如果数据库存在先删除

```mysql
drop database if exists myschool;
```

###### #创建数据库

```mysql
create database myschool;
```

###### #查看数据库

```bash
show databases;
```

###### #使用数据库

```mysql
use myschool;
```

###### #删除数据库

```mysql
drop database myschool;
```

###### #刷新缓冲区，可以不用重启mysql服务

```bash
flush privileges;
```

###### #查看所有视图

```bash
select * from view/G;
```

###### #查看表

```bash
show tables;
```

#### 三、表操作

###### #如果表存在先删除

```mysql
drop table if exists `student`;
```

###### #创建表

```mysql
create table `student`(`studentNo` int(4) primary key auto_increment comment '学号',`loginPwd` varchar(20) not null comment '密码',`studentName` varchar(50) not null comment '姓名',`sex` char(2) not null default '男' comment '性别',`gradeID` int(4) comment '年级编号',`phone` varchar(50) comment '电话',`address` varchar(255) default '地址不详' comment '地址',`bornDate` datetime comment '出生日期',`email` varchar(50) comment '电子邮箱',`identityCard` varchar(18) unique key comment '身份证号')comment '学生表';
```

###### #查看表

```mysql
show table `student`;
```

###### #查看表定义

```mysql
desc `student`;
```

###### #修改表名

```mysql
alter table `demo01` rename `demo02`;
```

###### #添加字段

```mysql
alter table `demo02` add `password` varchar(32) not null;
```

###### #为字段添加主键

```mysql
alter table `demo02` add constraint 'pk_demo02_id' primary key `demo02`(`id`);
```

###### #为字段添加外键

```mysql
alter table `demo02` add constraint `fk_demo02_id` foreign key`demo02`(`id`) references `demo01`(`id`);
```

###### #修改字段

```mysql
alter table `demo02` change `name` `username` char(10) not null;
```

###### #删除字段

```mysql
alter table `demo02` drop `password`;
```

##### 1.删除

###### #删除数据

```mysql
delete from `sutdent` where `studentNo`= ;
```

###### #删除表里的所有数据并重置自增id(重置索引)

```mysql
truncate table `student`;
```

###### #删除表

```mysql
drop table `student`;
```

##### 2.插入

###### #插入数据

```mysql
insert into `student` values();
```

###### #插入多条数据

```mysql
insert into `student` values(),();
```

###### #指定字段添加

```mysql
insert into `student`(`loginPwd`,`studentName`,`sex`) vlues() ;
```

###### #指定字段添加多条数据

```mysql
insert into `student`(`loginPwd`,`studentName`,`sex`) vlues(),() ;
```

##### 3.更新

###### #更新数据

```mysql
update `student` set   where ; 
```

##### 4.查询

完整语法([可选项])

SELECT < 字段名列表 > FROM < 表名或视图 > [WHERE < 查询条件 > ] [GROUP BY < 分组的字段名 > ] [HAVING < 筛选分组的条件 > [ 只能和 GROUP BY— 起用 ]] [ORDER BY < 排序的列名 > [ 默认ASC 或 DESC]] [ LIMIT [ 位置偏移量 ], [ 行数]]

###### #查询数据

```mysql
select * from `student`;
```

###### #查询email为空

```mysql
select studentName from student where email is null;
```

###### #查询email不为空

```mysql
select studentName from student where email is not null;
```

###### #查询时插入列

```mysql
select studentName,address,'昆明华信' as '学校名称' from student;
```

##### 5.聚合函数

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012525847-1412528529.png)

###### #平均分avg()

```mysql
select avg(studentResult) as 'JavaBasic考试成绩平均分' from result where subjectNo = 1;
```

###### #总数量count()

```mysql
select count(1) from student;
```

###### #最低分名min()

```mysql
select min(studentResult) from result;
```

###### #最高分max()

```mysql
select max(studentResult) from result;
```

###### #求和sum()

```mysql
select sum(studentResult) from result;
```

##### 6.时间日期函数

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012525395-500736331.png)

##### 7.ORDER BY排序(ASC[默认升序]，DESC[降序])

ORDER BY前不能加WHERE

###### #把成绩都降低 10 ％ 后加 5 分 ， 再查询及格成绩 ， 并按照成绩从高到低排序

```mysql
select result.*,(studentResult*0.9+5) as 及格成绩 from result where (studentResult*0.9+5) >=60 order by 及格成绩 desc;
```

##### 8.分页(LIMIT[开始数据行，分页数])

###### #查询所有年级编号为 1 的学员信息 ， 按学号升序排序显示前 4 条记录

```mysql
select * from student where gradeID = 1 order by studentNo limit 4;
```

###### #每页 4 条 ，显示第 2 页 ，即从第 5 条记录开始显示4 条数据

```mysql
select * from student where gradeID = 1 order by studentNo limit 4,4;
```

##### 9.子查询

子查询是一个嵌套在 SELECT 、 INSERT 、 UPDATE或 DELETE 语句或其他子查询中的查询(子查询 WHERE 语句中的一般用法)

###### #编写 SQL 语句 ， 查看年龄比 “ 李斯文 ' 小的学生 ， 要求显示这些学生的信息

```mysql
select * from student where bornDate > (select bornDate from student where studentName = '李斯文');
```

###### #询参加最近一次Java Basic考试成绩的学生最高分和最低分

```mysql
select max(studentResult),min(studentResult) FROM result where subjectNo = (select subjectNo from `subject` where subjectName = 'JavaBasic') and examDate = (select max(examDate) from result where subjectNo = (select subjectNo from `subject` where subjectName = 'JavaBasic'));
```

##### 10.NOT IN/IN查询

###### #查询Java Basic课程成绩为 60 分的学生名单

```mysql
select * from student where studentNo in (select studentNo from `result` where subjectNo = (select subjectNo from `subject` where subjectName = 'JavaBasic') and studentResult = 60);
```

###### #查询Java Basic课程成绩不为 60 分的学生名单

```mysql
select * from student where studentNo not in (select studentNo from `result` where subjectNo = (select subjectNo from `subject` where subjectName = 'JavaBasic') and studentResult = 60);
```

##### 11.NOT EXISTS/EXISTS子查询(相当于if)

SELECT · FROM 表名 WHERE EXISTS(子查询)

子查询有返回结果 ：EXISTS 子查询结果为 TRUE 子查询无返回结果 ：EXISTS 子查询结果为 FALSE, 外层查询不执行

###### #检查 "java Basic” 课程最近一次考试成绩如果有 10 分以上的成绩 ， 显示分数排在前5名的学员学号和分数

```mysql
select studentNo,studentResult from result where exists (select * from result where studentResult < 10 and examDate in (select max(examDate) from result where subjectNo in (select subjectNo from `subject` where subjectName = 'javaBasic'))) order by studentResult desc limit 5;
```

##### 12.GROUP BY分组

SELECT 列表中只能包含:

GROUP BY前不能加WHERE

1.被分组的列 2.为每个分组返回一个值的表达式 ， 如聚合函数

###### #统计每门课程平均分各是多少 ？

```mysql
select subjectNo,avg(studentResult) from result group by subjectNo;
```

##### 13.HAVING(与GROUP BY使用)分组筛选

![image-20221207101947081](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012524755-1622633644.png)

###### #如何获得课程平均分及格的课程编号 ？

```mysql
select subjectNo,avg(studentResult) from result group by subjectNo having avg(studentResult) >= 60;
```

##### 14.INNER JOIN · ON内连接

###### #查询学生表和成绩表，显示学生姓名 、 科目编号、考试成绩(双表连接)

```mysql
select studentName,subjectNo,studentResult from student inner join result on student.studentNo = result.studentNo;
```

###### #三表联接查询显示学生姓名 、科目名称 、考试成绩

```mysql
select studentName,subjectName,studentResult from student inner join `result` on student.studentNo = `result`.studentNo inner join `subject` on result.subjectNo = `subject`.subjectNo
```

##### 15.外连接

![image-20221207110850824](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012524318-619445076.png)

###### #LEFT JOIN · ON左外连接(主表 LEFT JION 从表 ON)

```mysql
select * from student left join result on student.studentNo = result.studentNo;
```

###### #RIGHT JOIN · ON右外连接(从表 RIGHT JOIN 主表 ON)

```mysql
select * from student right join result on student.studentNo = result.studentNo;
```

##### 16.模糊查询LIKE

###### #查询学生表里性张的学生名单

```mysql
select * from student where studentName like '张%';
```

##### 17.区间BETWEEN · AND

###### #在查询成绩表里90-100分的学生学号

```mysql
select studentNo from result where studentResult between 93 and 100;
```

#### 四、事务处理

###### #什么是事务

![image-20221207142614276](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012523761-1944839300.png)

###### #事务的特性

操作原子、数据一致、事务隔离、数据持久

![image-20221207142647230](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012523190-234712469.png)

###### #如何创建事务

![image-20221207143115088](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012522707-1361862312.png)

###### #语法

```mysql
#开始
begin;
#事务
update bank set currentMoney = currentMoney -500 where customerName = '张三';
update bank set currentMoney = currentMoney +500 where customerName = '李四';
#提交
commit;
#回滚
rollback;
#结束
end;
```

###### #关闭事务(默认开启)

![image-20221207144318171](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012522219-127544728.png)

#### 五、视图(虚拟表)

![image-20221207150422777](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012521677-1672103765.png)

注意事项

![image-20221207151832747](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012521099-1726076604.png)

###### #创建视图,显示学生姓名 、科目名称 、考试成绩

```mysql
create view view_student_result as (select studentName,subjectNo,studentResult from student inner join result on student.studentNo = result.studentNo);
select * from view_student_result;
```

###### #查看视图

```mysql
select * from view_student_result;
```

###### #删除视图

```mysql
drop view view_student_result;
```

#### 六、索引

常见索引类型

![image-20221207152347185](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012520387-1102616987.png)

创建索引的原则

![image-20221207153454844](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012519613-1691047659.png)

注意事项

![image-20221207153703094](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105012518914-324811794.png)

###### #创建索引，给学生表里的学生姓名建一个普通索引

```mysql
create index index_studentName on student(studentName);
```

###### #删除学生表里的index_studentName索引

```mysql
drop index index_studentName on student;
```

###### #查看学生表里的索引

```mysql
show index from student;
```

 
