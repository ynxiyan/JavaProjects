#创建test数据库
create database test;

#使用test数据库
use test;

#创建person表
create table `person`(`number` int(4) primary key auto_increment comment '序号',`name` varchar(50) not null comment '姓名',`sex` char(2) comment '性别',`bornDate` datetime comment '出生日期');

#修改表名为tb_person
alter table `person` rename `tb_person`;

#删除出生日期字段
alter table `tb_person` drop `bornDate`;

#t添加出生日期字段（DATE）
alter table `tb_person` add `bornDate` date;

#修改序号字段名（BIGINT）
alter table `tb_person` change `number` `id` bigint;

#查看表结构
desc `tb_person`;