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
