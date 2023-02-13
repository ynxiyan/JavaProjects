#创建Information数据库
create database Information;

#使用Information数据库
use Information;

#创建Department表
create table Department (did int(4) primary key auto_increment,dname varchar(50) comment '部门名称',dtel varchar(50) comment '部门电话') comment '部门表';

#向Department表添加数据
insert into Department values(1,'研发部','0710-3525000'),(2,'市场部','0710-3521900'),(3,'行政部','0710-3525201'),(4,'财务部','0710-3525001');

#查看Department表数据
select * from Department;

#创建Employee表
create table Employee (eid int(4) primary key auto_increment,ename varchar(50) comment '员工姓名',bdate date comment '出生日期',sex char(2) comment '性别',startdata date comment '入职日期',salary decimal(10,2) comment '工资',did int(4) comment '所在部门') comment '员工表';

#向Employee表添加数据
insert into Employee values(1,'张三', '1980-1-5','M',
'2008-1-1',4000,1),(2,'李思','1982-10-5','M','2008-4-5'
,3600,2),(3,'王武','1984-12-20','M','2008-10-15',2000,3),(4,'马柳','1989-1-1','M','2008-4-20',2500,4),(5,'李青','1987-6-13','F','2008-10-15',2700,1),(6,'雷锋','1982-5-23','M','2008-7-5',3200,1),(7,'夏天','1984-5-20','F','2008-7-7',2800,2),(8,'吴奇','1987-12-130','M','2008-3-15',2900,2),(9,'夏启','1985-8-19','F','2008-4-5',3200,3),(10,'柳青','1989-12-12','M','2008-6-25',3100,4);

#查看Employee表数据
select * from Employee;

#1.查询出Employee表中的工资最高的5人的信息。
select eid,ename,bdate,sex,startdata,salary,did from Employee order by salary desc limit 5;

#2.查询Employee表中的所有记录,按照入职日期的降序,工资的升序进行排序
select eid,ename,bdate,sex,startdata,salary,did from Employee order by startdata asc,salary desc;

#3.修改姓名为马柳的员工,将其日入日期改为2008.11.10日,工资改为3500
update Employee set startdata = '2008.11.10',salary = 3500 where ename = '马柳';

#查看修改后的Employee表
select * from Employee;

#4.查询每个部门的工资,显示部门名称、部门电话、部门的最高工资、最低工资、平均工资
select dname,dtel,max(salary),min(salary),avg(salary) from Department Department inner join Employee on Department.did = Employee.did group by dname;

#5.联接查询每个部门员工总人数，显示部门名称、部门电话、该部门的员工人数
select dname,dtel,count(1) from Department inner join Employee on Department.did = Employee.did group by dname;

#6.联接查询部门员工人数大于2人的部门基本信息
select Department.did,dname,dtel from Department,(select did,count(did) from Employee group by did having count(did) > 2)as countEmployee where Department.did = countEmployee.did;