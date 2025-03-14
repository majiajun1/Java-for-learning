# Java se

## 基本数据类型

byte short int long 

float double 

char

boole

> byte

8位有符号

> short

16位有符号

> int

32位有符号

> long

64位有符号

> float

32位浮点数

 

1+8+23

> double

64位浮点数

1+11+52

> char

16位 字符

> boolean

一个字节 8位



### 一些问题

浮点数默认double  float要加f 大小写均可

整数默认int  声明long 加上l

浮点数精度问题最好还是 用 decimal.Decimal 



小字节数的数转大字节数的问题不大  类型自动提升 （隐式） 但可能会**溢出（额外填充高位）**

大转小会可能**丢失**（强转）（显式）（截取低位）

float转double 精度损失

