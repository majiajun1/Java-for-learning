# MySQL



## 初识

企业级java开发  web

前段  展示 数据！

后台 （链接点：链接数据库JDBC,链接前端（控制，控制视图跳转，和给前端传递数据））

数据库（存数据，Txt,Excel,word)











关系型数据库：SQL

  MySQL、Orcale、Sql server、DB2、SQLlite

通过表和表之间，行和列之间的关系进行数据的存储，学院信息表，考勤表



非关系型数据库： （NoSQL） (Not only sql)

key value

Redis,MongDB

非关系型数据库，对象存储，通过对象的自身属性来决定



## DBMS

数据库管理系统

有效的管理我们的数据，维护和获取数据；

MySQL 5.7 稳定



## 链接数据库

~~~sql
mysql -uroot -p123456   --注释用--


update mysql.user set authentication_string=password('123456') where user='root' and Host='localhost';  --修改密码
flush privileges;    --刷新权限

--------------------------------------------------
-- 所有的语句都使用；结尾

show databases; --查看数据库

use  XXXXXXX   --切换数据库
show tables;  --查看数据库中所有的表
describe xxxx;  --显示数据库中表的所有信息
create database xxxx; --创建一个数据库
exit; --退出连接
~~~

DDL 定义

DML操作

DQL查询

DCL 控制



# 操作数据库

## 操作数据库中表的数据





如果表名是特殊字符 则用` 

 创建数据库

CREATE   DATABASE  (IF NOT EXISTS)  xxx;

 删除数据库 DROP DATABASE   (IF EXISTS)  xxxxxx;

使用数据库  use xxxxxx;

查看数据库

SHOW DATABASES;





## 数据库的列类型

> 数值

tinyint  十分小的数据  只占一个字节

smallint 较小的数据  两个字节

int    标准整数 四个字节  (常用的)

 mediumint  中等大小     三个字节

bigint  大int  八个字节   (java的long)



float  浮点数  四个字节

double  浮点数 八个字节

decimal  字符串形式的浮点数   金融的     



> 字符串

char   比较小的字符串  固定大小  0~255

varchar   常用的可变字符串  0~65535   对应java的String

tinytext  微型文本   2^8-1

text  文本串  大型文章    2^16-1

> 时间日期

Java.util.date

date     YYYY-MM-DD,  日期

time  HH:mm:ss  时间格式

datetime  上面加起来  最常用的

timestamp  时间戳     1970.1.1到现在的毫秒数  较为常用

year  年份



> null

空值  未知

注意  不要使用null进行运算



## 数据库字段属性



Unsigned：

无符号整数   不能声明为负数

zerofill：

0填充的  

不足的位数 使用0来填充   int(3)  写了个5  会填为005

自增：

自动在上一条记录的基础上+1

用来设计为唯一的主键，必须是整数类型

可以自定义设计主键自增的起始值和步长

非空：NULL  not null

假设设置为not null  如果不给它赋值  就会报错

如果不填写值 默认为Null



默认：

设置默认的值



每一个表都必须存在以下五个字段

![image-20241227160313839](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241227160313839.png)



## 用语法创建 数据库表

```sql
CREATE TABLE IF NOT EXISTS `student3` (
  `id` INT(4)  NOT NULL  AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名' ,
  `pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` VARCHAR(2) NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
  `address` VARCHAR(100) DEFAULT NULL COMMENT '住址',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY  (`id`)    
   
)ENGINE=INNODB DEFAULT CHARSET=utf8
```

SHOW CREATE TABLE 'student3'   查看表的定义语句

SHOW CREATE DATABASE school2	查看创建数据库的语句

DESC newstudent  显示表的结构





## 数据表的类型

Innodb  默认使用

MyISAM  早些年使用的

 ![image-20241227163018021](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241227163018021.png)

MYISAM 节约空间 速度较快

INNODB 安全性高 事务的处理  多表多用户操作



> 在物理空间中存在的位置

所有数据库文件都在data目录下

本质还是文件的存储！

> MySQL 引擎在物理文件上区别

Innodb 在数据库表中只有一个  .frm文件，以及上级目录下的ibdata1文件

MYISAM 对应文件    .frm 表结构的定义文件，  .MYD 数据文件(data)  .MYI 索引文件



> 字符集编码 

Charset=utf8

默认Latin1 不支持中文

my.ini中配置默认的编码  character-set-server=utf8





## 修改删除表

> 修改表

~~~sql
ALter TABLE teacher rename as teacher1  -- 修改表名
alter table teacher1 add age int (11)  -- 加一个字段

ALTER TABLE student1 MODIFY age VARCHAR(11)  -- 修改约束
ALTER TABLE student1 CHANGE age age1 INT(11)  -- 改名 也可以改约束就是要一样的名字

ALTER TABLE student1 DROP age1  -- 删除字段
DROP TABLE  IF EXISTS student1   -- 删除表（如果表存在）
~~~

创建和删除操作尽量加上判断，以免报错





# mysql 数据管理

## 外键(了解即可)

方式1

```sql
CREATE TABLE `grade`(
`gradeid` INT(10) NOT NULL AUTO_INCREMENT COMMENT '年纪id',
`gradename` VARCHAR(50) NOT NULL COMMENT '年纪名称',
PRIMARY KEY (`gradeid`)

)ENGINE=INNODB DEFAULT CHARSET=utf8
-- 学生表的gradeid字段 要去引用年级表的gradeid
-- 定义外键key
-- 给这个外键添加约束（执行引用）
CREATE TABLE IF NOT EXISTS `student` (
  `id` INT(4)  NOT NULL  AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名' ,
  `pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` VARCHAR(2) NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
  `gradeid` INT(10) NOT NULL COMMENT '学生的年纪',
  `address` VARCHAR(100) DEFAULT NULL COMMENT '住址',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY  (`id`) ,
  KEY `FK_gradeid`   (`gradeid`),
   CONSTRAINT `FK_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade` (`gradeid`)
   
)ENGINE=INNODB DEFAULT CHARSET=utf8
```

有外键的话 先删除被引用的 





~~~sql

ALTER TABLE `student`
ADD CONSTRAINT  `fk_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade` (`gradeid`);

先创表再加外键
~~~



以上都是物理外键  数据库级别的外键  不建议使用  避免数据库过多造成困扰



## DML 语言（全部记住，背下来）



数据库意义：数据存储，数据管理

DML语言：数据操作语言

Insert

update

delete

## 添加



~~~sql
INSERT INTO `grade`( `gradename`)VALUES('大一')

INSERT INTO `grade`( `gradename`)VALUES('大一'),('大二'),('大三'),('大四')   -- 插入多个值
~~~



主键gradeid 自增 可以省略

如果不写表的字段 他就会一一匹配  但是最好一一对应去插入

可以省略字段  但是值要一一对应

可以同时插入多条数据  

## 修改











## 删除

