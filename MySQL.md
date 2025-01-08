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

update

```sql
UPDATE `student` SET `name`='MJJ' WHERE id=1;
where是指定条件 
UPDATE `student` SET `name`='MJJ2',`email`='sdadas@s.com' WHERE id=2;
update多个

```

where条件子句   id等于某个值 大于某个值   在区间内修改

<>  不等于运算符

!= 不等于运算符

'>' 大于

<小于

<=  >=       

between.... and .....  在某个闭合区间内

通过多个条件

AND   相当于&&

OR   相当于||

 

## 删除

delete 命令

~~~sql
DELETE FROM `student` WHERE id=1;
删掉id=1的行
~~~



> TRUNCATE命令

清空表的数据

和delete from  的区别： TRUNCATE重新设置自增计数器 

不会影响事务（事务)



delete删除的问题： 

对于innodb 重启数据库后 自增也会从1开始

对于MylSAM  继续从上一个增量开始 没有重置自增



# 查询

DQL

data query language

SELECT

数据库最核心



指定查询字段

```sql


SELECT * FROM student
查询所有学生 * 通配符
SELECT `studentno`,`studentname` FROM student
查列


别名
给结果起一个名字
SELECT `studentno` AS 学号,`studentname` AS 学生姓名 FROM student
也可以给表起别名


函数  concat(a,b)

SELECT CONCAT('姓名：',Studentname) AS 新名字  FROM student
```

> 去重 distinct

```sql
SELECT DISTINCT `studentno` FROM result
去重 
SELECT 100*3-1  AS 计算结果   查计算机表达式
SELECT VERSION()   查版本    函数
SELECT @@auto_increment_increment   查变量  查询自增步长

SELECT `studentno`,`studentresult`+1 AS '提分后' FROM result
加分


```

select 表达式 from 表

 



## where条件



> 逻辑运算符   尽量用英文符号

与或非

and  &&    

or   ||   

not  !

between   ....and ....

!=   也可以表示为   not xxx = sss







> 模糊查询

比较运算符

IS NULL       a为空 则为真

IS NOT NULL   不空则真

BETWEEN       a between  b and c   如果a在b和c之间 则为真

Like    a like b      SQL匹配   如果a匹配b   则为真

In     a in (a1,a2,a3.......)   在某一个值中则为真



```sql
SELECT  `studentno`,`studentname` FROM `student` WHERE studentname LIKE '张%'
%代表任何字符 任何字数
SELECT  `studentno`,`studentname` FROM `student` WHERE studentname LIKE '张_'   只有一个字符的
SELECT  `studentno`,`studentname` FROM `student` WHERE studentname LIKE '%B%'
名字中间有B的  都查出来

SELECT  `studentno`,`studentname` FROM `student` WHERE studentno IN (1001,1000)

SELECT  `studentno`,`studentname` FROM `student` WHERE `address` IN ('广东深圳')
IN只能具体   LIKE才能模糊查

SELECT  `studentno`,`studentname` FROM `student` WHERE `address`='' OR address IS NULL
```



##  联表查询



- `INNER JOIN`：如果表中有至少一个匹配，则返回行；
- 2、`LEFT JOIN`：即使右表中没有匹配，也从左表返回所有的行；
- 3、`RIGHT JOIN`：即使左表中没有匹配，也从右表返回所有的行；
- 4、`FULL JOIN`：只要其中一个表中存在匹配，则返回行

![img](https://i-blog.csdnimg.cn/blog_migrate/7db7f7dd78c1352b04c8c96103140357.png)

 逻辑上 leftjoin  (right join) where is not null   等价于 inner join



**`ON`**：定义表之间的连接规则，决定哪些行参与连接。

**`WHERE`**：过滤连接后的结果集，决定哪些行出现在最终结果中。

在复杂查询中，理解 `ON` 和 `WHERE` 的执行顺序和作用范围是正确设计 SQL 查询的关键。

 只有innerjoin  where和on 能混用

select 我要查的数据

从哪个表查 from  xxxx    join  连接的表 on 交叉条件



```sql
SELECT  s.studentno,studentname,subjectno,studentresult
FROM student AS s 
INNER JOIN result AS r
WHERE s.studentno=r.studentno
 


SELECT  s.studentno,studentname,subjectno,studentresult
FROM student AS s 
RIGHT JOIN result AS r
ON s.studentno=r.studentno
 




SELECT  s.studentno,studentname,subjectno,studentresult
FROM student AS s 
LEFT JOIN result AS r
ON s.studentno=r.studentno



```



> 自连接

自己的表和自己的表连接

一张表拆为两张一样的表即可

查询父类信息

```sql
SELECT a.`categoryName`  AS '父栏目',b.`categoryname` AS '子栏目'
FROM `category` AS a, `category` AS b
WHERE a.`categoryid`=b.`pid`

```

![image-20250105165205570](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250105165205570.png)

![image-20250105165318531](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250105165318531.png)



## 分页和排序

升序ASC  降序DESC

order by 

```sql

SELECT  s.studentno,studentname,subjectname,studentresult
FROM student AS s 
RIGHT JOIN result AS r
ON r.studentno=s.studentno
INNER JOIN `subject` sub
ON r.subjectno=sub.subjectno
WHERE subjectname LIKE '高等数学%'  
（因为表数据少 所以用like模糊查）
ORDER BY studentresult DESC
```

分页 缓解数据库压力

limit 当前页 页面的大小

```sql
SELECT  s.studentno,studentname,subjectname,studentresult
FROM student AS s 
RIGHT JOIN result AS r
ON r.studentno=s.studentno
INNER JOIN `subject` sub
ON r.subjectno=sub.subjectno
WHERE subjectname LIKE '高等数学%'
ORDER BY studentresult DESC
LIMIT 0,2   0到2  （由0开始，大小为2）
```

(n-1)*pagesize, pagesize    n为当前页





## 子查询

where  (这个值是算出来的)

嵌套一个子查询语句    支持like 就是要concat结果 使得字段带 _或者带%   不然不行

where  

```sql
 
SELECT   studentno, subjectno,studentresult 
FROM `result` 
WHERE subjectno =(SELECT subjectno FROM `subject` WHERE subjectname='高等数学-1' )
order by studentresult desc
```

其实inner更快





# MySQL函数

## 常用函数

~~~	 sql 
ABS() 绝对值
CEILING()  向上取整
FLOOR()  向下取整
RAND()   0到1的随机数
SIGN()  判断符号
CHAR_LENGTH()   返回字符串长度
CONCAT()  拼接函数
INSERT(str,pos,posize,str)    字符串的某个位置开始固定长度替换为其他字符串
LOWER() 小写
upper() 大写
instr(str,substr)   第一次出现子串的位置
SELECT REPLACE('abc','ab','ss')     替换出现的指定字符串 （注意要完全匹配才能换）
substr(str,pos,pos) 返回指定的字符串  从指定位置开始固定长度
reverse()  反转

 current_date() 日期
 now() 时间
localtime()  本地时间
sysdate() 系统时间
year(now())  年
month(now())  月  以此类推  day hour minute second

system_user()或user()
VERSION() 版本
~~~

## 聚合函数

~~~sql
count()
sum()
avg()
max()
min()




SELECT COUNT(studentname) FROM student; 会忽略所有的Null值 
SELECT COUNT(*) FROM student;  包括null值  计算行数

SELECT COUNT(1) FROM student;  计算行数和上面没啥区别

SELECT SUM(`studentresult`) AS 总和  FROM result 



SELECT  subjectname,AVG(studentresult) ,MAX(studentresult)   FROM result AS r
INNER JOIN `subject` AS sub
ON r.`subjectno`=sub.`subjectno`
GROUP BY r.subjectno
HAVING AVG(studentresult) >=80

~~~

​	where在group by之前执行的  所以要having过滤



## MD5加密

不可逆

具体值的MD5加密值一样  比对加密值 是否对齐  

```sql
UPDATE testmd5 SET pwd=MD5(pwd)
```





## select 总结

```sql
SELECT
    [ALL | DISTINCT | DISTINCTROW ]
    [HIGH_PRIORITY]
    [STRAIGHT_JOIN]
    [SQL_SMALL_RESULT] [SQL_BIG_RESULT] [SQL_BUFFER_RESULT]
    [SQL_CACHE | SQL_NO_CACHE] [SQL_CALC_FOUND_ROWS]
    select_expr [, select_expr] ...
    [into_option]
    [FROM table_references
      [PARTITION partition_list]]
    [WHERE where_condition]
    [GROUP BY {col_name | expr | position}
      [ASC | DESC], ... [WITH ROLLUP]]
    [HAVING where_condition]
    [ORDER BY {col_name | expr | position}
      [ASC | DESC], ...]
    [LIMIT {[offset,] row_count | row_count OFFSET offset}]
    [PROCEDURE procedure_name(argument_list)]
    [into_option]
    [FOR UPDATE | LOCK IN SHARE MODE]
 
 distinct 去重
 xxxx join on
 where
 group by
having
order by
limit



```





# 事务

 SQL执行

要是同时成功 要不同时失败



将一组sql放在一个批次中执行

事务原则  ACID

原子性  一致性  隔离性  持久性   

1. ‌**原子性（Atomicity）**‌：原子性确保事务中的所有操作要么全部成功执行，要么全部失败回滚。事务是数据库操作的最小单位，不能部分执行。即使系统崩溃，未完成的事务也不会对数据库产生任何影响，所有操作要么完全生效，要么完全无效。
2. ‌**一致性（Consistency）**‌：一致性保证数据库在事务执行前后保持一致状态。任何事务执行前，数据库处于一致状态，事务执行结束后，也必须处于一致状态。如果事务中发生错误，一致性应该通过回滚操作得到保证。
3. ‌**隔离性（Isolation）**‌：隔离性确保并发执行的事务不会互相干扰。即一个事务的中间状态不会对其他事务可见。事务必须独立执行，彼此之间看不到未提交的修改。不同的隔离级别可以提供不同程度的保护，防止脏读、不可重复读和幻读等。
4. ‌**持久性（Durability）**‌：持久性确保一旦事务提交，数据将被永久保存在数据库中，即使系统崩溃或发生硬件故障，已提交的数据不会丢失。持久性通常依赖于数据库的日志记录和备份机制。

‌**实现ACID原则的技术手段**‌包括使用日志和锁来保证原子性，通过约束检查防止违反数据完整性规则的操作，使用不同级别的锁定机制和并发控制来实现隔离性，以及依赖日志记录和备份机制来实现持久性。

‌**ACID原则在分布式系统中的挑战**‌包括需要在多个节点间协调，确保整个分布式事务的原子性、一致性、隔离性和持久性。在分布式系统中，通常要在ACID属性和性能、可用性之间做出权衡。



脏读 幻读  不可重复读





## 事务 



```sql
-- 转账
CREATE DATABASE shop  CHARACTER SET utf8  COLLATE utf8_general_ci
USE shop
CREATE TABLE `account` (
 `id` INT(3) NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(30)  NOT NULL,
 `money` DECIMAL(9,2)  NOT NULL,
 PRIMARY KEY (`id`)
)ENGINE=INNODB  DEFAULT CHARSET=utf8



INSERT INTO account (`name`,`money`)
VALUES ('A',2000.00),('B',10000.00)

-- 模拟转账：事务
SET autocommit =0;  -- 关闭自动转账
START TRANSACTION -- 开启一个事务
UPDATE account SET money=money-500  WHERE `name`='A' -- A减500
UPDATE account SET money=money+500  WHERE `name`='B' -- B加500

COMMIT; -- 提交事务

ROLLBACK; -- 回滚  提交了无法回滚
SET autocommit-1;  -- 恢复默认值
```

## 索引

### 主键索引 primary key

唯一的表示，主键不可能重复，只能有一个列作为主键

　　主键必须保证每条记录都有唯一的标识符。这意味着在表中的每一行中，主键列的值都是唯一的，不能有重复。主键的值通常在数据的整个生命周期内保持不变，因为它用于唯一标识每一行。主键常被其他表用于建立关联关系，以实现数据的一致性和完整性。

 主键字段不允许为空值（NULL）。

### 唯一索引 unique key 

避免重复的列出现，唯一索引可以重复，多个列都可以标识为唯一索引

一个表只能有一个PRIMARY KEY，但可以有多个UNIQUE KEY。唯一键列可以包含空值（NULL），但只能有一个空值。这与主键不允许空值不同。和主键一样，唯一键保证列中的值不能重复。一个表可以有多个唯一键，而主键在一个表中只能有一个。

常规索引  key / index

默认的

全文索引  fulltext

特定的数据库引擎下才有，快速定位数据



```sql
EXPLAIN SELECT * FROM student 
分析sql执行的状况
```



### 测试索引

```sql
-- 插入一百万条数据
DELIMITER $$ -- 写函数之前必须要写，标志
CREATE FUNCTION mock_data()
RETURNS INT
BEGIN
	DECLARE num INT DEFAULT 1000000;
	DECLARE i INT DEFAULT 0;
	WHILE i<num DO
		INSERT INTO app_user(`name`,`email`,`phone`,`gender`,`password`,`age`)
		VALUES (CONCAT('用户',i),'4684618668@qq.com',CONCAT('18',FLOOR(RAND()*((999999999-100000000)+100000000))),
		FLOOR(RAND()*2),UUID(),FLOOR(RAND()*100));  
		SET i=i+1;
		
	END WHILE;
	RETURN i;




END;

SELECT mock_data(); -- 运行函数

DROP FUNCTION mock_data;  -- 删除函数



-- id_表名_字段名  命名方式
-- create index 索引名 on 表(字段）
CREATE INDEX id_app_user_name  ON app_user(`name`);
SELECT * FROM app_user WHERE `name`='用户9999';  查得更快了

索引在小数据量的时候 用处小 但是在大数据量的时候 区别十分明显

```

## 索引原则

索引不是越多越好

不要对经常变动的数据加索引

小数据量不需要加索引

索引一般加在常用来查询的字段上



innodb默认btree     

# 权限管理

## 用户管理

> SQL yog 可视化管理



> sql 命令操作

mysql.user 用户表

```sql
-- 创建用户
CREATE USER mjj IDENTIFIED BY '123456'

-- 修改密码（修改当前用户密码）
SET PASSWORD = PASSWORD ('111111')

-- 修改密码 （修改指定用户密码）
SET PASSWORD FOR mjj = PASSWORD('111111')

-- 重命名  
RENAME USER mjj TO mjj2

-- 用户授权
GRANT ALL PRIVILEGES ON *.* TO mjj2
-- 无论如何 只有root 才能grant

-- 查询权限
SHOW GRANTS FOR mjj2

-- 查询指定用户权限
SHOW GRANTS FOR mjj2
-- 查root
SHOW GRANTS FOR root@localhost

-- 撤销权限 revoke 哪些权限，在哪个库撤销，给谁撤销
REVOKE ALL PRIVILEGES ON *.*  FROM mjj2

DROP USER mjj2  -- 删掉用户

```

## Mysql 备份

方式：

拷贝物理文件
在sqlyog 这种可视化工具中手动导出

使用命令行导出  mysqldump

mysqldump -hlocalhost -uroot -p123456  school student >D:/desktop/1.sql

source  导入（要登录）





# 规范数据库设计

良好的数据库设计：

节省内存空间 

保证数据库的完整性

方便我们开发系统

软件开发中 ，关于数据库的设计

分析需求：分析业务和需要处理的数据库的需求

概要设计：设计关系图  E-R 图



> 设计数据库的步骤 个人博客为例

- 收集信息和需求

  -用户表 （用户登录和注销，个人信息，写博客，创建分类）

 -分类表（文章分类，谁创建的）

 -文章表（文章的信息）

-评论表

-友链表（友链信息）

-自定义表（系统信息，某个关键的字，或者一些主字段）.

说说表。。。。等等各种功能需求



- 标识实体（把需求落地到每个字段）

- 标识实体之间的关系

写博客 user->blog

创建分类：user ->category

关注：user->user

友链：links

评论：user-user-blog





## 三大范式

第一范式：每一列都是不可分割的原子数据项

第二范式：每张表只描述一件事情   

需要确保数据库表中的每一列都和主键相关，而不能只与主键的某一部分相关（主要针对联合主键而言）。

第三范式：在第二范式的基础上消除传递依赖

确保每一列数据都和主键相关，而不能间接相关。



故意增加冗余的字段（从多表查询中变为单表查询）

故意增加一些计算列 （从大数据量降低为小数据量的查询：索引）



# JDBC

## 数据库驱动







```
CREATE DATABASE `jdbcStudy` CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `jdbcStudy`;

CREATE TABLE `users`(
`id` INT PRIMARY KEY,
`NAME` VARCHAR(40),
`PASSWORD` VARCHAR(40),
`email` VARCHAR(60),
birthday DATE
);

INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`)
VALUES('1','zhangsan','123456','zs@sina.com','1980-12-04'),
('2','lisi','123456','lisi@sina.com','1981-12-04'),
('3','wangwu','123456','wangwu@sina.com','1979-12-04')

```

带入jar包驱动

写代码测试

```java
package JDBClearning;

import java.sql.*;

public class FirstClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");//固定写法




        //2.用户信息和url
        String url="jdbc:mysql://localhost:3306/jdbcstudy" +
                "?useUnicode=true" +
                "&characterEncoding=utf8&useSSL=false"; //版本问题 要false
        String username="root";
        String password="123456";

        //3.连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);


        //4.执行sql的对象
        Statement statement = connection.createStatement();


        //5.执行sql的对象
        String sql="SELECT * FROM `users`";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("NAME"));
            System.out.println(resultSet.getString("password"));

            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getString("birthday"));
            System.out.println("=================================");
        }

        //6.释放连接
    }
}

```

### 对象





**静态代码块**是 Java 中用于在类加载时执行初始化代码的一段代码块。它用 **`static {}`** 定义，属于类本身（而不是某个对象），在类加载时仅执行一次。

```java
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");//固定写法  静态代码块 自动注册




public class Driver extends NonRegisteringDriver implements java.sql.Driver {
    public Driver() throws SQLException {
    }

    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
    }
}



 String url="jdbc:mysql://localhost:3306/jdbcstudy" +
                "?useUnicode=true" +
                "&characterEncoding=utf8&useSSL=false"; //版本问题 要false
```

mysql默认3306

 

oralce  1521   jdbc:oracleLthinL@localhost:1521:sid

connection 代表数据库

```java
Connection connection = DriverManager.getConnection(url, username, password
  connection.rollback();
        connection.commit();
        connection.setAutoCommit(false);                                                  
                                                    
```

Statement  执行sql的对象

```java
Statement statement = connection.createStatement();


//5.执行sql的对象
String sql="SELECT * FROM `users`";  写sql
ResultSet resultSet = statement.executeQuery(sql);


        statement.execute();
        statement.executeUpdate(); //更新、插入、删除  返回一个受影响的行数
        statement.executeQuery();
        statement.executeBatch();
```



Resultset查询的结果集

获得指定的数据类型

```java
ResultSet resultSet = statement.executeQuery(sql);

        resultSet.getObject(); //不知道列的类型用这个
        resultSet.getString();
        resultSet.getInt();
        resultSet.getFloat();
        resultSet.getDate();
        resultSet.getDate();


遍历。resultSet.next()
    
resultSet.beforeFirst();  //移动最前面
resultSet.afterLast();  //移动到最后
        resultSet.previous();//移动到前一行
        resultSet.absolute(1);//移动到指定行
```

释放资源很重要  

```java
resultSet.close();
statement.close();
connection.close();
```



## statement对象

statement 对象用于向数据库发送sql语句

 statement.executeQuery(); //查

statement.executeUpdate(); //更新、插入、删除  返回一个受影响的行数



代码实现

~~~java
public class Lesson2 {
    public static void main(String[] args) throws SQLException {

        Connection conn=null;
        Statement st=null;


        conn=JdbcUtils.getConnection(); //获得数据库连接
        st=conn.createStatement(); //获得SQL的执行对象
        String sql="INSERT INTO users(id,`name`,`password`,`email`,`birthday`)" +
                "VALUES (5,'mjj2','123456','asdasdasd@qq,com','2020-01-01')";

        String sql2=
                "DELETE FROM users WHERE `id`=5";
        String sql3=
                "UPDATE users SET `name`='zjx' WHERE `name`='mjj'";
        int i=st.executeUpdate(sql3);
        if(i>0)
        {
            System.out.println("修改成功");
        }

        JdbcUtils.release(conn,st,null);



    }
    
    
    
    
package JDBClearning;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;



    static{
        try{
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            driver = properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            //1.驱动只需加载一次
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }


    //释放连接资源
    public static void release(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if(rs!=null)
        {
            rs.close();
        }
        if(stmt!=null)
        {
            stmt.close();
        }
        if(conn!=null)
        {
            conn.close();
        }
    }
}

    
    
    
    
    
    
    
    
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false
username=root
password=123456
    
    
    
    
    
    
    
    
    
    
    
    
    public class TestSelect {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        conn=JdbcUtils.getConnection();
        stmt=conn.createStatement();
        String sql="select * from users where id=1";
        resultSet=stmt.executeQuery(sql);
         while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("NAME"));
            System.out.println(resultSet.getString("password"));

            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getString("birthday"));
            System.out.println("=================================");
        }
         JdbcUtils.release(conn, stmt, resultSet);
    }
}
~~~

## sql注入的问题  

漏洞和攻击

```sql

SELECT * FROM users WHERE NAME=''OR'1=1' AND PASSWORD='123456';
SELECT * FROM users WHERE NAME=''OR'1=1' AND PASSWORD=''OR'1=1'
1=1标准sql注入操作

```

## PreparedStatement 

更安全 防止sql注入

效率更高

比普通的Statement 多了问号占位符和预编译

参数存在转义字符  会直接被转义



```java
public class Lesson3 {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=JdbcUtils.getConnection();

        //区别
        //使用问号占位符  代替参数
        String sql="INSERT INTO users(id,`name`,`password`,`email`,`birthday`)" +
                "VALUES (?,?,?,?,?)";

        ps=conn.prepareStatement(sql);//预编译sql,先写sql

        //手动给参数赋值
        ps.setInt(1,5);
        ps.setString(2,"mjj2");
        ps.setString(3,"123456");
        ps.setString(4,"mjj2@gmail.com");
        ps.setDate(5, new java.sql.Date(System.currentTimeMillis()));

        //执行
        int i=ps.executeUpdate();
        if(i>0)
        {
            System.out.println("插入成功");
        }

        JdbcUtils.release(conn,ps,rs);



    }
}

        //删除
        String sql2="delete from users where id=?";
        ps=conn.prepareStatement(sql2);
        ps.setInt(1,5);
//查
         String sql3="select * from users where id=?";
         ps=conn.prepareStatement(sql3);
         ps.setInt(1,1);
         rs=ps.executeQuery();
         while(rs.next()){
             System.out.println(rs.getString("name"));

         }
```

## 使用IDEA连接数据库









## 事务

ACID 原则

原子性 一致性 隔离性  持久性

**CID原则** 是数据库事务的四个核心属性，用于确保数据库操作的可靠性和一致性。以下是每个属性的详细解释：

------

### **1. 原子性（Atomicity）**

事务中的所有操作要么全部成功，要么全部失败，不能只执行部分操作。

- **核心含义**：事务是最小的不可分割单元。

- **实现方式**：通过回滚机制（Rollback），在事务执行失败时撤销已经完成的部分操作。

- 举例

  ：

  - 银行转账：从账户 A 转账到账户 B，要么 A 扣款和 B 入账都成功，要么两个操作都取消。

------

### **2. 一致性（Consistency）**

事务执行前后，数据库的状态必须保持一致，不能破坏数据库的完整性约束。

- **核心含义**：数据库的数据遵循约束和规则，比如主键约束、外键约束等。

- **实现方式**：依赖数据库的约束和事务管理机制。

- 举例

  ：

  - 商品库存：当库存减少时，总销售量应同步增加，数据间的约束关系保持一致。

------

### **3. 隔离性（Isolation）**

并发事务之间相互独立，不能互相干扰。一个事务未提交前，其操作对其他事务是不可见的。

- **核心含义**：事务应该像独立执行一样，不受其他事务的影响。

- 隔离级别

  （从低到高）：

  1. **读未提交（Read Uncommitted）**：事务可以读到其他未提交事务的数据，可能导致脏读问题。
  2. **读已提交（Read Committed）**：只能读到已提交事务的数据，避免脏读。
  3. **可重复读（Repeatable Read）**：同一事务中多次读的结果一致，避免不可重复读。
  4. **序列化（Serializable）**：事务完全串行化执行，避免幻读。

------

### **4. 持久性（Durability）**

事务一旦提交，所做的修改将永久保存在数据库中，即使发生系统故障。

- **核心含义**：事务的结果具有永久性。

- **实现方式**：通过日志（WAL）或快照（Snapshot）等技术，确保事务数据可以恢复。

- 举例

  ：

  - 银行系统：转账事务提交后，扣款和存款操作永久生效，即使系统崩溃，转账记录也会保留。

------

### **ACID 的重要性**

- **保障数据一致性**：确保在各种异常情况下数据不会出现逻辑错误。
- **增强可靠性**：尤其在金融、医疗等对数据要求极高的领域，ACID原则是核心标准。
- **对性能的权衡**：ACID原则提供可靠性，但也会对性能产生一定影响，通常需要权衡事务隔离级别和系统吞吐量。

------

  脏读：读取了另一个没有提交的事务

不可重复读：重复读取表的数据 数据发生了改变

虚读 幻读：在一个事务内  读取到了别人插入的数据 导致前后读出来结果不一致

