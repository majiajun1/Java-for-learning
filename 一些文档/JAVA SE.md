# JAVA SE



- **类名**：对于所有的类来说，类名的首字母应该大写。如果类名由若干单词组成，那么每个单词的首字母应该大写，例如 **MyFirstJavaClass** 。
- **方法名**：所有的方法名都应该以小写字母开头。如果方法名含有若干单词，则后面的每个单词首字母大写。
- **源文件名**：源文件名必须和类名相同。当保存文件的时候，你应该使用类名作为文件名保存（切记 Java 是大小写敏感的），文件名的后缀为 **.java**。（如果文件名和类名不相同则会导致编译错误）。
- **主方法入口**：所有的 Java 程序由 **public static void main(String[] args)** 方法开始执行。

- 访问控制修饰符 : default, public , protected, private
- 非访问控制修饰符 : final, abstract, static, synchronized

Java 5.0引入了枚举，枚举限制变量只能是预先设定好的值。使用枚举可以减少代码中的 bug。，我们为果汁店设计一个程序，它将限制果汁为小杯、中杯、大杯

下面列出了 Java 关键字。这些保留字不能用于常量、变量、和任何标识符的名称。

| 类别                 | 关键字                         | 说明                 |
| :------------------- | :----------------------------- | :------------------- |
| 访问控制             | private                        | 私有的               |
| protected            | 受保护的                       |                      |
| public               | 公共的                         |                      |
| default              | 默认                           |                      |
| 类、方法和变量修饰符 | abstract                       | 声明抽象             |
| class                | 类                             |                      |
| extends              | 扩充、继承                     |                      |
| final                | 最终值、不可改变的             |                      |
| implements           | 实现（接口）                   |                      |
| interface            | 接口                           |                      |
| native               | 本地、原生方法（非 Java 实现） |                      |
| new                  | 创建                           |                      |
| static               | 静态                           |                      |
| strictfp             | 严格浮点、精准浮点             |                      |
| synchronized         | 线程、同步                     |                      |
| transient            | 短暂                           |                      |
| volatile             | 易失                           |                      |
| 程序控制语句         | break                          | 跳出循环             |
| case                 | 定义一个值以供 switch 选择     |                      |
| continue             | 继续                           |                      |
| do                   | 运行                           |                      |
| else                 | 否则                           |                      |
| for                  | 循环                           |                      |
| if                   | 如果                           |                      |
| instanceof           | 实例                           |                      |
| return               | 返回                           |                      |
| switch               | 根据值选择执行                 |                      |
| while                | 循环                           |                      |
| 错误处理             | assert                         | 断言表达式是否为真   |
| catch                | 捕捉异常                       |                      |
| finally              | 有没有异常都执行               |                      |
| throw                | 抛出一个异常对象               |                      |
| throws               | 声明一个异常可能被抛出         |                      |
| try                  | 捕获异常                       |                      |
| 包相关               | import                         | 引入                 |
| package              | 包                             |                      |
| 基本类型             | boolean                        | 布尔型               |
| byte                 | 字节型                         |                      |
| char                 | 字符型                         |                      |
| double               | 双精度浮点                     |                      |
| float                | 单精度浮点                     |                      |
| int                  | 整型                           |                      |
| long                 | 长整型                         |                      |
| short                | 短整型                         |                      |
| 变量引用             | super                          | 父类、超类           |
| this                 | 本类                           |                      |
| void                 | 无返回值                       |                      |
| 保留关键字           | goto                           | 是关键字，但不能使用 |
| const                | 是关键字，但不能使用           |                      |





Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型

在 Java 中使用 final 关键字来修饰常量，声明方式和变量类似：

| \n     | 换行 (0x0a)              |
| ------ | ------------------------ |
| \r     | 回车 (0x0d)              |
| \f     | 换页符(0x0c)             |
| \b     | 退格 (0x08)              |
| \0     | 空字符 (0x0)             |
| \s     | 空格 (0x20)              |
| \t     | 制表符                   |
| \"     | 双引号                   |
| \'     | 单引号                   |
| \\     | 反斜杠                   |
| \ddd   | 八进制字符 (ddd)         |
| \uxxxx | 16进制Unicode字符 (xxxx) |

低  ------------------------------------>  高

byte,short,char—> int —> long—> float —> double 

**静态变量或类变量（Class Variables）：**类变量是在类中用 static 关键字声明的变量，它们属于类而不是实例，所有该类的实例共享同一个类变量的值，类变量在类加载时被初始化，而且只初始化一次。

Static

private public



### 受保护的访问修饰符-protected

protected 需要从以下两个点来分析说明：

- **子类与基类在同一包中**：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问；
- **子类与基类不在同一包中**：那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，而不能访问基类实例的protected方法。

protected 可以修饰数据成员，构造方法，方法成员，**不能修饰类（内部类除外）**。接口及接口的成员变量和成员方法不能声明为 protected

- 父类中声明为 public 的方法在子类中也必须为 public。
- 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
- 父类中声明为 private 的方法，不能够被子类继承。

static 关键字用来声明独立于对象的静态变量，无论一个类实例化多少对象，它的静态变量只有一份拷贝。 静态变量也被称为类变量。局部变量不能被声明为 static 变量。

final 方法 和final 类

### abstract 修饰符

**抽象类：**

抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。

一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。

under construction 的意思

### synchronized 修饰符

synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符。

## 位运算符

A = 0011 1100
B = 0000 1101
-----------------
A&B = 0000 1100
A | B = 0011 1101
A ^ B = 0011 0001
~A= 1100 0011

下表列出了位运算符的基本运算，假设整数变量 A 的值为 60 和变量 B 的值为 13：

| ＆   | 如果相对应位都是1，则结果为1，否则为0                        | （A＆B），得到12，即0000 1100  |
| ---- | ------------------------------------------------------------ | ------------------------------ |
| \|   | 如果相对应位都是 0，则结果为 0，否则为 1                     | （A \| B）得到61，即 0011 1101 |
| ^    | 如果相对应位值相同，则结果为0，否则为1                       | （A ^ B）得到49，即 0011 0001  |
| 〜   | 按位取反运算符翻转操作数的每一位，即0变成1，1变成0。         | （〜A）得到-61，即1100 0011    |
| <<   | 按位左移运算符。左操作数按位左移右操作数指定的位数。         | A << 2得到240，即 1111 0000    |
| >>   | 按位右移运算符。左操作数按位右移右操作数指定的位数。         | A >> 2得到15即 1111            |
| >>>  | 按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。 | A>>>2得到15即0000 1111         |





### 短路逻辑运算符

当使用与逻辑运算符时，在两个操作数都为true时，结果才为true，但是当得到第一个操作为false时，其结果就必定是false，这时候就不会再判断第二个操作了。

| + =     | 加和赋值操作符，它把左操作数和右操作数相加赋值给左操作数     | C + = A等价于C = C + A                   |
| ------- | ------------------------------------------------------------ | ---------------------------------------- |
| - =     | 减和赋值操作符，它把左操作数和右操作数相减赋值给左操作数     | C - = A等价于C = C - A                   |
| * =     | 乘和赋值操作符，它把左操作数和右操作数相乘赋值给左操作数     | C * = A等价于C = C * A                   |
| / =     | 除和赋值操作符，它把左操作数和右操作数相除赋值给左操作数     | C / = A，C 与 A 同类型时等价于 C = C / A |
| （％）= | 取模和赋值操作符，它把左操作数和右操作数取模后赋值给左操作数 | C％= A等价于C = C％A                     |
| << =    | 左移位赋值运算符                                             | C << = 2等价于C = C << 2                 |
| >> =    | 右移位赋值运算符                                             | C >> = 2等价于C = C >> 2                 |
| ＆=     | 按位与赋值运算符                                             | C＆= 2等价于C = C＆2                     |
| ^ =     | 按位异或赋值操作符                                           | C ^ = 2等价于C = C ^ 2                   |
| \| =    | 按位或赋值操作符                                             | C \| = 2等价于C = C \| 2                 |

## 条件运算符（?:）

条件运算符也被称为三元运算符。该运算符有3个操作数，并且需要判断布尔表达式的值。该运算符的主要是决定哪个值应该赋值给变量。

```java
variable x = (expression) ? value if true : value if false
```

 // 如果 a 等于 1 成立，则设置 b 为 20，否则为 30      

```java
b = (a == 1) ? 20 : 30;

```

## instanceof 运算符

该运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。

下表中具有最高优先级的运算符在的表的最上面，最低优先级的在表的底部。

| 后缀     | () [] . (点操作符)                         | 左到右   |
| -------- | ------------------------------------------ | -------- |
| 一元     | expr++ expr--                              | 从左到右 |
| 一元     | ++expr --expr + - ～ ！                    | 从右到左 |
| 乘性     | * /％                                      | 左到右   |
| 加性     | + -                                        | 左到右   |
| 移位     | >> >>>  <<                                 | 左到右   |
| 关系     | > >= < <=                                  | 左到右   |
| 相等     | == !=                                      | 左到右   |
| 按位与   | ＆                                         | 左到右   |
| 按位异或 | ^                                          | 左到右   |
| 按位或   | \|                                         | 左到右   |
| 逻辑与   | &&                                         | 左到右   |
| 逻辑或   | \| \|                                      | 左到右   |
| 条件     | ？：                                       | 从右到左 |
| 赋值     | = + = - = * = / =％= >> = << =＆= ^ = \| = | 从右到左 |
| 逗号     | ，                                         | 左到右   |



## 循环

while和for跟CPP一样

增强for  跟python的读取一样

break 和continue一个样

switch case  if else 





## Math 类

| [xxxValue()](https://www.runoob.com/java/number-xxxvalue.html) 将 Number 对象转换为xxx数据类型的值并返回。 |                                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 2                                                            | [compareTo()](https://www.runoob.com/java/number-compareto.html) 将number对象与参数比较。 |
| 3                                                            | [equals()](https://www.runoob.com/java/number-equals.html) 判断number对象是否与参数相等。 |
| 4                                                            | [valueOf()](https://www.runoob.com/java/number-valueof.html) 返回一个 Number 对象指定的内置数据类型 |
| 5                                                            | [toString()](https://www.runoob.com/java/number-tostring.html) 以字符串形式返回值。 |
| 6                                                            | [parseInt()](https://www.runoob.com/java/number-parseInt.html) 将字符串解析为int类型。 |
| 7                                                            | [abs()](https://www.runoob.com/java/number-abs.html) 返回参数的绝对值。 |
| 8                                                            | [ceil()](https://www.runoob.com/java/number-ceil.html) 返回大于等于( >= )给定参数的的最小整数，类型为双精度浮点型。 |
| 9                                                            | [floor()](https://www.runoob.com/java/number-floor.html) 返回小于等于（<=）给定参数的最大整数 。 |
| 10                                                           | [rint()](https://www.runoob.com/java/number-rint.html) 返回与参数最接近的整数。返回类型为double。 |
| 11                                                           | [round()](https://www.runoob.com/java/number-round.html) 它表示**四舍五入**，算法为 **Math.floor(x+0.5)**，即将原来的数字加上 0.5 后再向下取整，所以，Math.round(11.5) 的结果为12，Math.round(-11.5) 的结果为-11。 |
| 12                                                           | [min()](https://www.runoob.com/java/number-min.html) 返回两个参数中的最小值。 |
| 13                                                           | [max()](https://www.runoob.com/java/number-max.html) 返回两个参数中的最大值。 |
| 14                                                           | [exp()](https://www.runoob.com/java/number-exp.html) 返回自然数底数e的参数次方。 |
| 15                                                           | [log()](https://www.runoob.com/java/number-log.html) 返回参数的自然数底数的对数值。 |
| 16                                                           | [pow()](https://www.runoob.com/java/number-pow.html) 返回第一个参数的第二个参数次方。 |
| 17                                                           | [sqrt()](https://www.runoob.com/java/number-sqrt.html) 求参数的算术平方根。 |
| 18                                                           | [sin()](https://www.runoob.com/java/number-sin.html) 求指定double类型参数的正弦值。 |
| 19                                                           | [cos()](https://www.runoob.com/java/number-cos.html) 求指定double类型参数的余弦值。 |
| 20                                                           | [tan()](https://www.runoob.com/java/number-tan.html) 求指定double类型参数的正切值。 |
| 21                                                           | [asin()](https://www.runoob.com/java/number-asin.html) 求指定double类型参数的反正弦值。 |
| 22                                                           | [acos()](https://www.runoob.com/java/number-acos.html) 求指定double类型参数的反余弦值。 |
| 23                                                           | [atan()](https://www.runoob.com/java/number-atan.html) 求指定double类型参数的反正切值。 |
| 24                                                           | [atan2()](https://www.runoob.com/java/number-atan2.html) 将笛卡尔坐标转换为极坐标，并返回极坐标的角度值。 |
| 25                                                           | [toDegrees()](https://www.runoob.com/java/number-todegrees.html) 将参数转化为角度。 |
| 26                                                           | [toRadians()](https://www.runoob.com/java/number-toradians.html) 将角度转换为弧度。 |
| 27                                                           | [random()](https://www.runoob.com/java/number-random.html) 返回一个随机数。 |





Java语言为内置数据类型char提供了包装类Character类。

| \t   | 在文中该处插入一个tab键  |
| ---- | ------------------------ |
| \b   | 在文中该处插入一个后退键 |
| \n   | 在文中该处换行           |
| \r   | 在文中该处插入回车       |
| \f   | 在文中该处插入换页符     |
| \'   | 在文中该处插入单引号     |
| \"   | 在文中该处插入双引号     |
| \\   | 在文中该处插入反斜杠     |

下面是Character类的方法：

| 1    | [isLetter()](https://www.runoob.com/java/character-isletter.html) 是否是一个字母 |
| ---- | ------------------------------------------------------------ |
| 2    | [isDigit()](https://www.runoob.com/java/character-isdigit.html) 是否是一个数字字符 |
| 3    | [isWhitespace()](https://www.runoob.com/java/character-iswhitespace.html) 是否是一个空白字符 |
| 4    | [isUpperCase()](https://www.runoob.com/java/character-isuppercase.html) 是否是大写字母 |
| 5    | [isLowerCase()](https://www.runoob.com/java/character-islowercase.html) 是否是小写字母 |
| 6    | [toUpperCase()](https://www.runoob.com/java/character-touppercase.html) 指定字母的大写形式 |
| 7    | [toLowerCase](https://www.runoob.com/java/character-tolowercase.html)() 指定字母的小写形式 |
| 8    | [toString](https://www.runoob.com/java/character-tostring.html)() |







String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了（详看笔记部分解析）

String 相当于指针 

| 1    | [char charAt(int index)](https://www.runoob.com/java/java-string-charat.html) 返回指定索引处的 char 值。 |
| ---- | ------------------------------------------------------------ |
| 2    | [int compareTo(Object o)](https://www.runoob.com/java/java-string-compareto.html) 把这个字符串和另一个对象比较。 |
| 3    | [int compareTo(String anotherString)](https://www.runoob.com/java/java-string-compareto.html) 按字典顺序比较两个字符串。 |
| 4    | [int compareToIgnoreCase(String str)](https://www.runoob.com/java/java-string-comparetoignorecase.html) 按字典顺序比较两个字符串，不考虑大小写。 |
| 5    | [String concat(String str)](https://www.runoob.com/java/java-string-concat.html) 将指定字符串连接到此字符串的结尾。 |
| 6    | [boolean contentEquals(StringBuffer sb)](https://www.runoob.com/java/java-string-contentequals.html) 当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真。 |
| 7    | [static String copyValueOf(char[\] data)](https://www.runoob.com/java/java-string-copyvalueof.html) 返回指定数组中表示该字符序列的 String。 |
| 8    | [static String copyValueOf(char[\] data, int offset, int count)](https://www.runoob.com/java/java-string-copyvalueof.html) 返回指定数组中表示该字符序列的 String。 |
| 9    | [boolean endsWith(String suffix)](https://www.runoob.com/java/java-string-endswith.html) 测试此字符串是否以指定的后缀结束。 |
| 10   | [boolean equals(Object anObject)](https://www.runoob.com/java/java-string-equals.html) 将此字符串与指定的对象比较。 |
| 11   | [boolean equalsIgnoreCase(String anotherString)](https://www.runoob.com/java/java-string-equalsignorecase.html) 将此 String 与另一个 String 比较，不考虑大小写。 |
| 12   | [byte[\] getBytes()](https://www.runoob.com/java/java-string-getbytes.html)  使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。 |
| 13   | [byte[\] getBytes(String charsetName)](https://www.runoob.com/java/java-string-getbytes.html) 使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。 |
| 14   | [void getChars(int srcBegin, int srcEnd, char[\] dst, int dstBegin)](https://www.runoob.com/java/java-string-getchars.html) 将字符从此字符串复制到目标字符数组。 |
| 15   | [int hashCode()](https://www.runoob.com/java/java-string-hashcode.html) 返回此字符串的哈希码。 |
| 16   | [int indexOf(int ch)](https://www.runoob.com/java/java-string-indexof.html) 返回指定字符在此字符串中第一次出现处的索引。 |
| 17   | [int indexOf(int ch, int fromIndex)](https://www.runoob.com/java/java-string-indexof.html) 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。 |
| 18   | [int indexOf(String str)](https://www.runoob.com/java/java-string-indexof.html)  返回指定子字符串在此字符串中第一次出现处的索引。 |
| 19   | [int indexOf(String str, int fromIndex)](https://www.runoob.com/java/java-string-indexof.html) 返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。 |
| 20   | [String intern()](https://www.runoob.com/java/java-string-intern.html)  返回字符串对象的规范化表示形式。 |
| 21   | [int lastIndexOf(int ch)](https://www.runoob.com/java/java-string-lastindexof.html)  返回指定字符在此字符串中最后一次出现处的索引。 |
| 22   | [int lastIndexOf(int ch, int fromIndex)](https://www.runoob.com/java/java-string-lastindexof.html) 返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。 |
| 23   | [int lastIndexOf(String str)](https://www.runoob.com/java/java-string-lastindexof.html) 返回指定子字符串在此字符串中最右边出现处的索引。 |
| 24   | [int lastIndexOf(String str, int fromIndex)](https://www.runoob.com/java/java-string-lastindexof.html)  返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。 |
| 25   | [int length()](https://www.runoob.com/java/java-string-length.html) 返回此字符串的长度。 |
| 26   | [boolean matches(String regex)](https://www.runoob.com/java/java-string-matches.html) 告知此字符串是否匹配给定的正则表达式。 |
| 27   | [boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)](https://www.runoob.com/java/java-string-regionmatches.html) 测试两个字符串区域是否相等。 |
| 28   | [boolean regionMatches(int toffset, String other, int ooffset, int len)](https://www.runoob.com/java/java-string-regionmatches.html) 测试两个字符串区域是否相等。 |
| 29   | [String replace(char oldChar, char newChar)](https://www.runoob.com/java/java-string-replace.html) 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。 |
| 30   | [String replaceAll(String regex, String replacement)](https://www.runoob.com/java/java-string-replaceall.html) 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。 |
| 31   | [String replaceFirst(String regex, String replacement)](https://www.runoob.com/java/java-string-replacefirst.html)  使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。 |
| 32   | [String[\] split(String regex)](https://www.runoob.com/java/java-string-split.html) 根据给定正则表达式的匹配拆分此字符串。 |
| 33   | [String[\] split(String regex, int limit)](https://www.runoob.com/java/java-string-split.html) 根据匹配给定的正则表达式来拆分此字符串。 |
| 34   | [boolean startsWith(String prefix)](https://www.runoob.com/java/java-string-startswith.html) 测试此字符串是否以指定的前缀开始。 |
| 35   | [boolean startsWith(String prefix, int toffset)](https://www.runoob.com/java/java-string-startswith.html) 测试此字符串从指定索引开始的子字符串是否以指定前缀开始。 |
| 36   | [CharSequence subSequence(int beginIndex, int endIndex)](https://www.runoob.com/java/java-string-subsequence.html)  返回一个新的字符序列，它是此序列的一个子序列。 |
| 37   | [String substring(int beginIndex)](https://www.runoob.com/java/java-string-substring.html) 返回一个新的字符串，它是此字符串的一个子字符串。 |
| 38   | [String substring(int beginIndex, int endIndex)](https://www.runoob.com/java/java-string-substring.html) 返回一个新字符串，它是此字符串的一个子字符串。 |
| 39   | [char[\] toCharArray()](https://www.runoob.com/java/java-string-tochararray.html) 将此字符串转换为一个新的字符数组。 |
| 40   | [String toLowerCase()](https://www.runoob.com/java/java-string-tolowercase.html) 使用默认语言环境的规则将此 String 中的所有字符都转换为小写。 |
| 41   | [String toLowerCase(Locale locale)](https://www.runoob.com/java/java-string-tolowercase.html)  使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。 |
| 42   | [String toString()](https://www.runoob.com/java/java-string-tostring.html)  返回此对象本身（它已经是一个字符串！）。 |
| 43   | [String toUpperCase()](https://www.runoob.com/java/java-string-touppercase.html) 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。 |
| 44   | [String toUpperCase(Locale locale)](https://www.runoob.com/java/java-string-touppercase.html) 使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。 |
| 45   | [String trim()](https://www.runoob.com/java/java-string-trim.html) 返回字符串的副本，忽略前导空白和尾部空白。 |
| 46   | [static String valueOf(primitive data type x)](https://www.runoob.com/java/java-string-valueof.html) 返回给定data type类型x参数的字符串表示形式。 |
| 47   | [contains(CharSequence chars)](https://www.runoob.com/java/java-string-contains.html) 判断是否包含指定的字符系列。 |
| 48   | [isEmpty()](https://www.runoob.com/java/java-string-isempty.html) 判断字符串是否为空。 |

当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类

然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。

| 1    | public StringBuffer append(String s) 将指定的字符串追加到此字符序列。 |
| ---- | ------------------------------------------------------------ |
| 2    | public StringBuffer reverse()  将此字符序列用其反转形式取代。 |
| 3    | public delete(int start, int end) 移除此序列的子字符串中的字符。 |
| 4    | public insert(int offset, int i) 将 `int` 参数的字符串表示形式插入此序列中。 |
| 5    | insert(int offset, String str) 将 `str` 参数的字符串插入此序列中。 |
| 6    | replace(int start, int end, String str) 使用给定 `String` 中的字符替换此序列的子字符串中的字符。 |

| 1    | int capacity() 返回当前容量。                                |
| ---- | ------------------------------------------------------------ |
| 2    | char charAt(int index) 返回此序列中指定索引处的 `char` 值。  |
| 3    | void ensureCapacity(int minimumCapacity) 确保容量至少等于指定的最小值。 |
| 4    | void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 将字符从此序列复制到目标字符数组 `dst`。 |
| 5    | int indexOf(String str) 返回第一次出现的指定子字符串在该字符串中的索引。 |
| 6    | int indexOf(String str, int fromIndex) 从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。 |
| 7    | int lastIndexOf(String str) 返回最右边出现的指定子字符串在此字符串中的索引。 |
| 8    | int lastIndexOf(String str, int fromIndex) 返回 String 对象中子字符串最后出现的位置。 |
| 9    | int length()  返回长度（字符数）。                           |
| 10   | void setCharAt(int index, char ch) 将给定索引处的字符设置为 `ch`。 |
| 11   | void setLength(int newLength) 设置字符序列的长度。           |
| 12   | CharSequence subSequence(int start, int end) 返回一个新的字符序列，该字符序列是此序列的子序列。 |
| 13   | String substring(int start) 返回一个新的 `String`，它包含此字符序列当前所包含的字符子序列。 |
| 14   | String substring(int start, int end) 返回一个新的 `String`，它包含此序列当前所包含的字符子序列。 |
| 15   | String toString() 返回此序列中数据的字符串表示形式。         |





数组加强型循环

```
for(type element: array)
{
    System.out.println(element);
}

```

## Arrays 类

java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的。

| 1    | **public static int binarySearch(Object[] a, Object key)** 用二分查找算法在给定数组中搜索给定值的对象(Byte,Int,double等)。数组在调用前必须排序好的。如果查找值包含在数组中，则返回搜索键的索引；否则返回 (-(*插入点*) - 1)。 |
| ---- | ------------------------------------------------------------ |
| 2    | **public static boolean equals(long[] a, long[] a2)** 如果两个指定的 long 型数组彼此*相等*，则返回 true。如果两个数组包含相同数量的元素，并且两个数组中的所有相应元素对都是相等的，则认为这两个数组是相等的。换句话说，如果两个数组以相同顺序包含相同的元素，则两个数组是相等的。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）。 |
| 3    | **public static void fill(int[] a, int val)** 将指定的 int 值分配给指定 int 型数组指定范围中的每个元素。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）。 |
| 4    | **public static void sort(Object[] a)** 对指定对象数组根据其元素的自然顺序进行升序排列。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）。 |



## 日期类 Date

| 1    | **boolean after(Date date)** 若当调用此方法的Date对象在指定日期之后返回true,否则返回false。 |
| ---- | ------------------------------------------------------------ |
| 2    | **boolean before(Date date)** 若当调用此方法的Date对象在指定日期之前返回true,否则返回false。 |
| 3    | **Object clone( )** 返回此对象的副本。                       |
| 4    | **int compareTo(Date date)** 比较当调用此方法的Date对象和指定日期。两者相等时候返回0。调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。 |
| 5    | **int compareTo(Object obj)** 若obj是Date类型则操作等同于compareTo(Date) 。否则它抛出ClassCastException。 |
| 6    | **boolean equals(Object date)** 当调用此方法的Date对象和指定日期相等时候返回true,否则返回false。 |
| 7    | **long getTime( )** 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。 |
| 8    | **int hashCode( )**  返回此对象的哈希码值。                  |
| 9    | **void setTime(long time)**   用自1970年1月1日00:00:00 GMT以后time毫秒数设置时间和日期。 |
| 10   | **String toString( )** 把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)。 |

## 使用 SimpleDateFormat 格式化日期



 ~~~ java
 import  java.util.*;
 import java.text.*;
  
 public class DateDemo {
    public static void main(String[] args) {
  
       Date dNow = new Date( );
       SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
  
       System.out.println("当前时间为: " + ft.format(dNow));
    }
 }
 ~~~



其中 yyyy 是完整的公元年，MM 是月份，dd 是日期，HH:mm:ss 是时、分、秒。

**注意**:有的格式大写，有的格式小写，例如 MM 是月份，mm 是分；HH 是 24 小时制，而 hh 是 12 小时制。

| G    | 纪元标记                 | AD                      |
| ---- | ------------------------ | ----------------------- |
| y    | 四位年份                 | 2001                    |
| M    | 月份                     | July or 07              |
| d    | 一个月的日期             | 10                      |
| h    | A.M./P.M. (1~12)格式小时 | 12                      |
| H    | 一天中的小时 (0~23)      | 22                      |
| m    | 分钟数                   | 30                      |
| s    | 秒数                     | 55                      |
| S    | 毫秒数                   | 234                     |
| E    | 星期几                   | Tuesday                 |
| D    | 一年中的日子             | 360                     |
| F    | 一个月中第几周的周几     | 2 (second Wed. in July) |
| w    | 一年中第几周             | 40                      |
| W    | 一个月中第几周           | 1                       |
| a    | A.M./P.M. 标记           | PM                      |
| k    | 一天中的小时(1~24)       | 24                      |
| K    | A.M./P.M. (0~11)格式小时 | 10                      |
| z    | 时区                     | Eastern Standard Time   |
| '    | 文字定界符               | Delimiter               |
| "    | 单引号                   | `                       |

**printf**  不是println

| %tc  | 包括全部日期和时间信息      | 星期六 十月 27 14:21:20 CST 2007 |
| ---- | --------------------------- | -------------------------------- |
| %tF  | "年-月-日"格式              | 2007-10-27                       |
| %tD  | "月/日/年"格式              | 10/27/07                         |
| %tr  | "HH:MM:SS PM"格式（12时制） | 02:25:51 下午                    |
| %tT  | "HH:MM:SS"格式（24时制）    | 14:28:16                         |
| %tR  | "HH:MM"格式（24时制）       | 14:28                            |



- %tY：输出四位数的年份，例如：2023
- %ty：输出两位数的年份，例如：23
- %tm：输出两位数的月份，例如：02
- %tB：输出月份的全名，例如：February
- %tb：输出月份的缩写，例如：Feb
- %tA：输出星期的全名，例如：Wednesday
- %ta：输出星期的缩写，例如：Wed
- %td：输出两位数的日期，例如：24
- %te：输出一位或两位数的日期，例如：24 或 02
- %tH：输出24小时制的小时数，例如：23
- %tI：输出12小时制的小时数，例如：11
- %tM：输出分钟数，例如：45
- %tS：输出秒数，例如：30
- %tp：输出上午还是下午，例如：AM 或 PM
- %tZ：输出时区，例如：GMT+08:00





Calendar类


| Calendar.YEAR         | 年份                           |
| --------------------- | ------------------------------ |
| Calendar.MONTH        | 月份                           |
| Calendar.DATE         | 日期                           |
| Calendar.DAY_OF_MONTH | 日期，和上面的字段意义完全相同 |
| Calendar.HOUR         | 12小时制的小时                 |
| Calendar.HOUR_OF_DAY  | 24小时制的小时                 |
| Calendar.MINUTE       | 分钟                           |
| Calendar.SECOND       | 秒                             |
| Calendar.DAY_OF_WEEK  | 星期几                         |



add函数和get函数 set 函数

GregorianCalendar是Calendar类的一个具体实现。

| 1    | **GregorianCalendar()** 在具有默认语言环境的默认时区内使用当前时间构造一个默认的 GregorianCalendar。 |
| ---- | ------------------------------------------------------------ |
| 2    | **GregorianCalendar(int year, int month, int date)** 在具有默认语言环境的默认时区内构造一个带有给定日期设置的 GregorianCalendar |
| 3    | **GregorianCalendar(int year, int month, int date, int hour, int minute)** 为具有默认语言环境的默认时区构造一个具有给定日期和时间设置的 GregorianCalendar。 |
| 4    | **GregorianCalendar(int year, int month, int date, int hour, int minute, int second)**  为具有默认语言环境的默认时区构造一个具有给定日期和时间设置的 GregorianCalendar。 |
| 5    | **GregorianCalendar(Locale aLocale)** 在具有给定语言环境的默认时区内构造一个基于当前时间的 GregorianCalendar。 |
| 6    | **GregorianCalendar(TimeZone zone)** 在具有默认语言环境的给定时区内构造一个基于当前时间的 GregorianCalendar。 |
| 7    | **GregorianCalendar(TimeZone zone, Locale aLocale)**  在具有给定语言环境的给定时区内构造一个基于当前时间的 GregorianCalendar。 |

| 1    | **void add(int field, int amount)** 根据日历规则，将指定的（有符号的）时间量添加到给定的日历字段中。 |
| ---- | ------------------------------------------------------------ |
| 2    | **protected void computeFields()** 转换UTC毫秒值为时间域值   |
| 3    | **protected void computeTime()** 覆盖Calendar ，转换时间域值为UTC毫秒值 |
| 4    | **boolean equals(Object obj)** 比较此 GregorianCalendar 与指定的 Object。 |
| 5    | **int get(int field)** 获取指定字段的时间值                  |
| 6    | **int getActualMaximum(int field)** 返回当前日期，给定字段的最大值 |
| 7    | **int getActualMinimum(int field)** 返回当前日期，给定字段的最小值 |
| 8    | **int getGreatestMinimum(int field)**  返回此 GregorianCalendar 实例给定日历字段的最高的最小值。 |
| 9    | **Date getGregorianChange()** 获得格里高利历的更改日期。     |
| 10   | **int getLeastMaximum(int field)** 返回此 GregorianCalendar 实例给定日历字段的最低的最大值 |
| 11   | **int getMaximum(int field)** 返回此 GregorianCalendar 实例的给定日历字段的最大值。 |
| 12   | **Date getTime()** 获取日历当前时间。                        |
| 13   | **long getTimeInMillis()** 获取用长整型表示的日历的当前时间  |
| 14   | **TimeZone getTimeZone()** 获取时区。                        |
| 15   | **int getMinimum(int field)** 返回给定字段的最小值。         |
| 16   | **int hashCode()** 重写hashCode.                             |
| 17   | **boolean isLeapYear(int year)** 确定给定的年份是否为闰年。  |
| 18   | **void roll(int field, boolean up)** 在给定的时间字段上添加或减去（上/下）单个时间单元，不更改更大的字段。 |
| 19   | **void set(int field, int value)** 用给定的值设置时间字段。  |
| 20   | **void set(int year, int month, int date)** 设置年、月、日的值。 |
| 21   | **void set(int year, int month, int date, int hour, int minute)** 设置年、月、日、小时、分钟的值。 |
| 22   | **void set(int year, int month, int date, int hour, int minute, int second)** 设置年、月、日、小时、分钟、秒的值。 |
| 23   | **void setGregorianChange(Date date)** 设置 GregorianCalendar 的更改日期。 |
| 24   | **void setTime(Date date)** 用给定的日期设置Calendar的当前时间。 |
| 25   | **void setTimeInMillis(long millis)** 用给定的long型毫秒数设置Calendar的当前时间。 |
| 26   | **void setTimeZone(TimeZone value)** 用给定时区值设置当前时区。 |
| 27   | **String toString()**                                        |





Hour of Day 是24小时制









Java 的控制台输入由 System.in 完成。

为了获得一个绑定到控制台的字符流，你可以把 System.in 包装在一个 BufferedReader 对象中来创建一个字符流。

```java
BufferedReader br = new BufferedReader(new 
                      InputStreamReader(System.in));
```



从 BufferedReader 对象读取一个字符要使用 read() 方法，它的语法如下：

```java
int read( ) throws IOException
    
```

从标准输入读取一个字符串需要使用 BufferedReader 的 readLine() 方法。

~~~java	
String readLine( ) throws IOException
~~~

readline 和read不一样



PrintStream 继承了 OutputStream类，并且实现了方法 write()。这样，write() 也可以用来往控制台写操作。

PrintStream 定义 write() 的最简单格式如下所示：

~~~java	
void write(int byteval)
~~~

write() 方法不经常使用，因为 print() 和 println() 方法用起来更为方便。

![img](https://www.runoob.com/wp-content/uploads/2013/12/iostream2xx.png)

| `Reader`           | 抽象类 (输入流) | 所有字符输入流的超类，处理字符的输入操作。                |
| ------------------ | --------------- | --------------------------------------------------------- |
| `Writer`           | 抽象类 (输出流) | 所有字符输出流的超类，处理字符的输出操作。                |
| `FileReader`       | 输入流          | 从文件中读取字符数据。                                    |
| `FileWriter`       | 输出流          | 将字符数据写入文件。                                      |
| `BufferedReader`   | 输入流          | 为字符输入流提供缓冲功能，支持按行读取，提高读取效率。    |
| `BufferedWriter`   | 输出流          | 为字符输出流提供缓冲功能，支持按行写入，提高写入效率。    |
| `CharArrayReader`  | 输入流          | 将字符数组作为输入源。                                    |
| `CharArrayWriter`  | 输出流          | 将数据写入到字符数组。                                    |
| `StringReader`     | 输入流          | 将字符串作为输入源。                                      |
| `StringWriter`     | 输出流          | 将数据写入到字符串缓冲区。                                |
| `PrintWriter`      | 输出流          | 便捷的字符输出流，支持自动刷新和格式化输出。              |
| `PipedReader`      | 输入流          | 用于在管道中读取字符数据，通常与 `PipedWriter` 配合使用。 |
| `PipedWriter`      | 输出流          | 用于在管道中写入字符数据，通常与 `PipedReader` 配合使用。 |
| `LineNumberReader` | 输入流          | 带行号的缓冲字符输入流，允许跟踪读取的行号。              |
| `PushbackReader`   | 输入流          | 允许在读取字符后将字符推回流中，以便再次读取。            |

| `InputStream`           | 抽象类 (输入流) | 所有字节输入流的超类，处理字节的输入操作。                   |
| ----------------------- | --------------- | ------------------------------------------------------------ |
| `OutputStream`          | 抽象类 (输出流) | 所有字节输出流的超类，处理字节的输出操作。                   |
| `FileInputStream`       | 输入流          | 从文件中读取字节数据。                                       |
| `FileOutputStream`      | 输出流          | 将字节数据写入文件。                                         |
| `BufferedInputStream`   | 输入流          | 为字节输入流提供缓冲功能，提高读取效率。                     |
| `BufferedOutputStream`  | 输出流          | 为字节输出流提供缓冲功能，提高写入效率。                     |
| `ByteArrayInputStream`  | 输入流          | 将内存中的字节数组作为输入源。                               |
| `ByteArrayOutputStream` | 输出流          | 将数据写入到内存中的字节数组。                               |
| `DataInputStream`       | 输入流          | 允许从输入流中读取 Java 原生数据类型（如 `int`、`float`、`boolean`）。 |
| `DataOutputStream`      | 输出流          | 允许向输出流中写入 Java 原生数据类型。                       |
| `ObjectInputStream`     | 输入流          | 从输入流中读取序列化对象。                                   |
| `ObjectOutputStream`    | 输出流          | 将对象序列化并写入输出流中。                                 |
| `PipedInputStream`      | 输入流          | 用于在管道中读取字节数据，通常与 `PipedOutputStream` 配合使用。 |
| `PipedOutputStream`     | 输出流          | 用于在管道中写入字节数据，通常与 `PipedInputStream` 配合使用。 |
| `FilterInputStream`     | 输入流          | 字节输入流的包装类，用于对其他输入流进行过滤处理。           |
| `FilterOutputStream`    | 输出流          | 字节输出流的包装类，用于对其他输出流进行过滤处理。           |
| `SequenceInputStream`   | 输入流          | 将多个输入流串联为一个输入流进行处理。                       |



## 辅助类

| `File`             | 文件和目录操作 | 用于表示文件或目录，并提供文件操作，如创建、删除、重命名等。 |
| ------------------ | -------------- | ------------------------------------------------------------ |
| `RandomAccessFile` | 随机访问文件   | 支持文件的随机访问，可以从文件的任意位置读写数据。           |
| `Console`          | 控制台输入输出 | 提供对系统控制台的输入和输出支持。                           |

## FileInputStream

该流用于从文件读取数据，它的对象可以用关键字 new 来创建。

有多种构造方法可用来创建对象。

可以使用字符串类型的文件名来创建一个输入流对象来读取文件：

~~~java	
InputStream f = new FileInputStream("C:/java/hello");
~~~

也可以使用一个文件对象来创建一个输入流对象来读取文件。我们首先得使用 File() 方法来创建一个文件对象：

~~~java
File f = new File("C:/java/hello"); 
InputStream in = new FileInputStream(f);
~~~

| `int read()`                           | 读取一个字节的数据，返回值为 0 到 255 之间的整数。如果到达流的末尾，返回 -1。 | `int data = inputStream.read();`                             |
| -------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `int read(byte[] b)`                   | 从输入流中读取字节，并将其存储在字节数组 `b` 中，返回实际读取的字节数。如果到达流的末尾，返回 -1。 | `byte[] buffer = new byte[1024]; int bytesRead = inputStream.read(buffer);` |
| `int read(byte[] b, int off, int len)` | 从输入流中读取最多 `len` 个字节，并将它们存储在字节数组 `b` 的 `off` 偏移位置，返回实际读取的字节数。如果到达流的末尾，返回 -1。 | `byte[] buffer = new byte[1024]; int bytesRead = inputStream.read(buffer, 0, buffer.length);` |
| `long skip(long n)`                    | 跳过并丢弃输入流中的 `n` 个字节，返回实际跳过的字节数。      | `long skippedBytes = inputStream.skip(100);`                 |
| `int available()`                      | 返回可以读取的字节数（不阻塞）。                             | `int availableBytes = inputStream.available();`              |
| `void close()`                         | 关闭输入流并释放与该流相关的所有资源。                       | `inputStream.close();`                                       |
| `void mark(int readlimit)`             | 在流中的当前位置设置标记，`readlimit` 是可以读取的字节数上限。 | `inputStream.mark(1024);`                                    |
| `void reset()`                         | 将流重新定位到上次标记的位置，如果没有标记或标记失效，抛出 `IOException`。 | `inputStream.reset();`                                       |
| `boolean markSupported()`              | 检查当前输入流是否支持 `mark()` 和 `reset()` 操作。          | `boolean isMarkSupported = inputStream.markSupported();`     |

**输入流必须要 `close()`**，否则可能会导致一些问题，尤其是资源管理和性能方面的问题。



## FileOutputStream

| `void write(int b)`                      | 将指定的字节写入输出流，`b` 的低 8 位将被写入流中。          | `outputStream.write(255);`                                   |
| ---------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `void write(byte[] b)`                   | 将字节数组 `b` 中的所有字节写入输出流。                      | `byte[] data = "Hello".getBytes(); outputStream.write(data);` |
| `void write(byte[] b, int off, int len)` | 将字节数组 `b` 中从偏移量 `off` 开始的 `len` 个字节写入输出流。 | `byte[] data = "Hello".getBytes(); outputStream.write(data, 0, data.length);` |
| `void flush()`                           | 刷新输出流并强制写出所有缓冲的数据，确保数据被立即写入目标输出。 | `outputStream.flush();`                                      |
| `void close()`                           | 关闭输出流并释放与该流相关的所有资源。关闭后不能再写入。     | `outputStream.close();`                                      |





- **mkdir( )**方法创建一个文件夹，成功则返回true，失败则返回false。失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，该文件夹不能被创建。
- **mkdirs()**方法创建一个文件夹和它的所有父文件夹



`mkdir()` 只能创建**单个目录**，如果父目录不存在，它不会自动创建。例如，假设路径 `"D:/Document/JAVA/tmp/justfortest"` 中的 `"D:/Document/JAVA/tmp"` 目录不存在，`mkdir()` 会失败。







## Scanner 

我们可以通过 Scanner 类来获取用户的输入。

next() 识别到空格就无了

### next() 与 nextLine() 区别

next():

- 1、一定要读取到有效字符后才可以结束输入。
- 2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
- 3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
- next() 不能得到带有空格的字符串。

nextLine()：

- 1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
- 2、可以获得空白。





如果要输入 int 或 float 类型的数据，在 Scanner 类中也有支持，但是在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取：







## Java 异常处理



- **try**：用于包裹可能会抛出异常的代码块。
- **catch**：用于捕获异常并处理异常的代码块。
- **finally**：用于包含无论是否发生异常都需要执行的代码块。
- **throw**：用于手动抛出异常。
- **throws**：用于在方法声明中指定方法可能抛出的异常。
- **Exception**类：是所有异常类的父类，它提供了一些方法来获取异常信息，如 **getMessage()、printStackTrace()** 等。

![img](https://www.runoob.com/wp-content/uploads/2013/12/exception-hierarchy.png)



| ArithmeticException             | 当出现异常的运算条件时，抛出此异常。例如，一个整数"除以零"时，抛出此类的一个实例。 |
| ------------------------------- | ------------------------------------------------------------ |
| ArrayIndexOutOfBoundsException  | 用非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引。 |
| ArrayStoreException             | 试图将错误类型的对象存储到一个对象数组时抛出的异常。         |
| ClassCastException              | 当试图将对象强制转换为不是实例的子类时，抛出该异常。         |
| IllegalArgumentException        | 抛出的异常表明向方法传递了一个不合法或不正确的参数。         |
| IllegalMonitorStateException    | 抛出的异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器而本身没有指定监视器的线程。 |
| IllegalStateException           | 在非法或不适当的时间调用方法时产生的信号。换句话说，即 Java 环境或 Java 应用程序没有处于请求操作所要求的适当状态下。 |
| IllegalThreadStateException     | 线程没有处于请求操作所要求的适当状态时抛出的异常。           |
| IndexOutOfBoundsException       | 指示某排序索引（例如对数组、字符串或向量的排序）超出范围时抛出。 |
| NegativeArraySizeException      | 如果应用程序试图创建大小为负的数组，则抛出该异常。           |
| NullPointerException            | 当应用程序试图在需要对象的地方使用 `null` 时，抛出该异常     |
| NumberFormatException           | 当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。 |
| SecurityException               | 由安全管理器抛出的异常，指示存在安全侵犯。                   |
| StringIndexOutOfBoundsException | 此异常由 `String` 方法抛出，指示索引或者为负，或者超出字符串的大小。 |
| UnsupportedOperationException   | 当不支持请求的操作时，抛出该异常。                           |

| ClassNotFoundException     | 应用程序试图加载类时，找不到相应的类，抛出该异常。           |
| -------------------------- | ------------------------------------------------------------ |
| CloneNotSupportedException | 当调用 `Object` 类中的 `clone` 方法克隆对象，但该对象的类无法实现 `Cloneable` 接口时，抛出该异常。 |
| IllegalAccessException     | 拒绝访问一个类的时候，抛出该异常。                           |
| InstantiationException     | 当试图使用 `Class` 类中的 `newInstance` 方法创建一个类的实例，而指定的类对象因为是一个接口或是一个抽象类而无法实例化时，抛出该异常。 |
| InterruptedException       | 一个线程被另一个线程中断，抛出该异常。                       |
| NoSuchFieldException       | 请求的变量不存在                                             |
| NoSuchMethodException      | 请求的方法不存在                                             |



| 1    | **public String getMessage()** 返回关于发生的异常的详细信息。这个消息在Throwable 类的构造函数中初始化了。 |
| ---- | ------------------------------------------------------------ |
| 2    | **public Throwable getCause()** 返回一个 Throwable 对象代表异常原因。 |
| 3    | **public String toString()** 返回此 Throwable 的简短描述。   |
| 4    | **public void printStackTrace()** 将此 Throwable 及其回溯打印到标准错误流。 |
| 5    | **public StackTraceElement [] getStackTrace()** 返回一个包含堆栈层次的数组。下标为0的元素代表栈顶，最后一个元素代表方法调用堆栈的栈底。 |
| 6    | **public Throwable fillInStackTrace()** 用当前的调用栈层次填充Throwable 对象栈层次，添加到栈层次任何先前信息中。 |







~~~java	
try
{
   // 程序代码
}catch(ExceptionName e1)
{
   //Catch 块
}

~~~

无非就是把编译器的活也干了 让代码本身抛异常 方便查错吗？

在Java中， **throw** 和 **throws** 关键字是用于处理异常的。

**throw** 关键字用于在代码中抛出异常，而 **throws** 关键字用于在方法声明中指定可能会抛出的异常类型。

finally 关键字用来创建在 try 代码块后面执行的代码块。

无论是否发生异常，finally 代码块中的代码总会被执行。

在 finally 代码块中，可以运行清理类型等收尾善后性质的语句。

finally 代码块出现在 catch 代码块最后，语法如下：

~~~java	
try{
  // 程序代码
}catch(异常类型1 异常的变量名1){
  // 程序代码
}catch(异常类型2 异常的变量名2){
  // 程序代码
}finally{
  // 程序代码
}
~~~

- catch 不能独立于 try 存在。
- 在 try/catch 后面添加 finally 块并非强制性要求的。
- try 代码后不能既没 catch 块也没 finally 块。
- try, catch, finally 块之间不能添加任何代码。



JDK7 之后，Java 新增的 **try-with-resource** 语法结构，旨在自动管理资源，确保资源在使用后能够及时关闭，避免资源泄露 。

try-with-resources 是一种异常处理机制，它能够自动关闭在 try 块中声明的资源，无需显式地在 finally 块中关闭。

在 try-with-resources 语句中，你只需要在 try 关键字后面声明资源，然后跟随一个代码块。无论代码块中的操作是否成功，资源都会在 try 代码块执行完毕后自动关闭。。

~~~java	
try (resource declaration) {
  // 使用的资源
} catch (ExceptionType e1) {
  // 异常块
}
~~~

## 声明自定义异常

在 Java 中你可以自定义异常。编写自己的异常类时需要记住下面的几点。

- 所有异常都必须是 Throwable 的子类。
- 如果希望写一个检查性异常类，则需要继承 Exception 类。
- 如果你想写一个运行时异常类，那么需要继承 RuntimeException 类。

可以像下面这样定义自己的异常类：

~~~java	
class MyException extends Exception{
}
~~~

将自定义异常改为 `RuntimeException` 之后，能够解决“在相应的 try 语句主体中不能抛出异常”的错误，主要是因为 **检查型异常** 和 **非检查型异常**（运行时异常）之间的区别。以下是详细解释：

### 1. **检查型异常与非检查型异常的区别**

- **检查型异常 (Checked Exception)**：
  - 需要在方法签名中显式声明，或者在方法内部处理。
  - 例如，`IOException`、`SQLException` 等。
  - 这种设计旨在强制开发者在编译时处理这些异常，以确保程序的健壮性。
- **非检查型异常 (Unchecked Exception)**：
  - 不需要在方法签名中声明，也不需要在调用时处理。
  - 例如，`RuntimeException` 及其子类（如 `NullPointerException`、`ArrayIndexOutOfBoundsException`、`IllegalArgumentException` 等）。
  - 这种设计允许开发者在代码中选择性地处理异常，通常用于表示程序逻辑错误。

### 2. **为什么改为 `RuntimeException` 就好**

- **无需显式声明**：如果你的自定义异常类继承自 `RuntimeException`，那么在方法中抛出该异常时，不需要在方法签名中添加 `throws` 声明。因此，调用这个方法的代码不必显式地处理这个异常。
- **灵活性**：由于非检查型异常允许更大的灵活性，开发者可以选择在合适的地方处理异常，而不被编译器强制要求。

必须在方法签名中使用 `throws` 声明（如 `public void AgeCount() throws Ageerrorthrowtest`）

不需要在方法签名中声明，可以直接抛出（如 `public void AgeCount()`）。



## 类的继承

需要注意的是 Java 不支持多继承，但支持多重继承。



![img](https://www.runoob.com/wp-content/uploads/2013/12/java-extends-2020-12-08.png)



### implements关键字

使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔）。

### super 与 this 关键字

**super 关键字：**我们可以通过 super 关键字来实现对父类成员的访问，用来引用当前对象的父类。

**this 关键字：**指向自己的引用，引用当前对象，即它所在的方法或构造函数所属的对象实例。。



## 重写(Override)

重写（Override）是指子类定义了一个与其父类中具有相同名称、参数列表和返回类型的方法，并且子类方法的实现覆盖了父类方法的实现。 **即外壳不变，核心重写！**

重写就是   

~~~java	
父类 a = new 子类();
父类和子类有相同的方法，那么执行时用的是子类方法。
但如果子类有而父类没有 ，那么执行会出错，除非是 子类 a =new 子类（）;
~~~



当需要在子类中调用父类的被重写方法时，要使用 super 关键字。

## 重载(Overload)

重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。

每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。

最常用的地方就是构造器的重载。

## Java 多态

 多态就是继承+重写

# Java 抽象类

在面向对象的概念中，所有的对象都是通过类来描绘的，但是反过来，并不是所有的类都是用来描绘对象的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。

抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。



## 抽象类总结规定

- \1. 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
- \2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
- \3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
- \4. 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
- \5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。

# Java 封装

在面向对象程式设计方法中，封装（英语：Encapsulation）是指一种将抽象性函式接口的实现细节部分包装、隐藏起来的方法。

封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。

要访问该类的代码和数据，必须通过严格的接口控制。

封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。

适当的封装可以让程式码更容易理解与维护，也加强了程式码的安全性。



## 实现Java封装的步骤

修改属性的可见性来限制对属性的访问（一般限制为private）

 对每个值属性提供对外的公共方法访问，也就是创建一对赋取值方法，用于对私有属性的访问

# Java 接口

接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。   interface和implement

接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。类描述对象的属性和方法。接口则包含类要实现的方法。

除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。

接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。另外，在 Java 中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象。

### 接口与类相似点：

- 一个接口可以有多个方法。
- 接口文件保存在 .java 结尾的文件中，文件名使用接口名。
- 接口的字节码文件保存在 .class 结尾的文件中。
- 接口相应的字节码文件必须在与包名称相匹配的目录结构中。

### 接口与类的区别：

- 接口不能用于实例化对象。
- 接口没有构造方法。
- 接口中所有的方法必须是抽象方法，Java 8 之后 接口中可以使用 default 关键字修饰的非抽象方法。
- 接口不能包含成员变量，除了 static 和 final 变量。
- 接口不是被类继承了，而是要被类实现。
- 接口支持多继承。

### 接口特性

- 接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 **public abstract**（只能是 public abstract，其他修饰符都会报错）。
- 接口中可以含有变量，但是接口中的变量会被隐式的指定为 **public static final** 变量（并且只能是 public，用 private 修饰会报编译错误）。
- 接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。

### 抽象类和接口的区别

- \1. 抽象类中的方法可以有方法体，就是能实现方法的具体功能，但是接口中的方法不行。
- \2. 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是 **public static final** 类型的。
- \3. 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法。
- \4. 一个类只能继承一个抽象类，而一个类却可以实现多个接口。



- 接口是隐式抽象的，当声明一个接口的时候，不必使用**abstract**关键字。
- 接口中每一个方法也是隐式抽象的，声明时同样不需要**abstract**关键字。
- 接口中的方法都是公有的。

当类实现接口的时候，类要实现接口中所有的方法。否则，类必须声明为抽象的类。

类使用implements关键字实现接口。在类声明中，Implements关键字放在class声明后面。



 Java 教程 

[Java 教程](https://www.runoob.com/java/java-tutorial.html)[Java 简介](https://www.runoob.com/java/java-intro.html)[Java 开发环境配置](https://www.runoob.com/java/java-environment-setup.html)[Java AI 编程助手](https://www.runoob.com/java/fitten-code-java.html)[Java 基础语法](https://www.runoob.com/java/java-basic-syntax.html)[Java 注释](https://www.runoob.com/java/java-comments.html)[Java 对象和类](https://www.runoob.com/java/java-object-classes.html)[Java 基本数据类型](https://www.runoob.com/java/java-basic-datatypes.html)[Java 变量类型](https://www.runoob.com/java/java-variable-types.html)[Java 变量命名规则](https://www.runoob.com/java/java-variable-naming-rules.html)[Java 修饰符](https://www.runoob.com/java/java-modifier-types.html)[Java 运算符](https://www.runoob.com/java/java-operators.html)[Java 循环结构](https://www.runoob.com/java/java-loop.html)[Java 条件语句](https://www.runoob.com/java/java-if-else-switch.html)[Java switch case](https://www.runoob.com/java/java-switch-case.html)[Java Number & Math 类](https://www.runoob.com/java/java-number.html)[Java Character 类](https://www.runoob.com/java/java-character.html)[Java String 类](https://www.runoob.com/java/java-string.html)[Java StringBuffer](https://www.runoob.com/java/java-stringbuffer.html)[Java 数组](https://www.runoob.com/java/java-array.html)[Java 日期时间](https://www.runoob.com/java/java-date-time.html)[Java 正则表达式](https://www.runoob.com/java/java-regular-expressions.html)[Java 方法](https://www.runoob.com/java/java-methods.html)[Java Stream、File、IO](https://www.runoob.com/java/java-files-io.html)[Java Scanner 类](https://www.runoob.com/java/java-scanner-class.html)[Java 异常处理](https://www.runoob.com/java/java-exceptions.html)

## Java 面向对象

[Java 继承](https://www.runoob.com/java/java-inheritance.html)[Java Override/Overload](https://www.runoob.com/java/java-override-overload.html)[Java 多态](https://www.runoob.com/java/java-polymorphism.html)[Java 抽象类](https://www.runoob.com/java/java-abstraction.html)[Java 封装](https://www.runoob.com/java/java-encapsulation.html)[ Java 接口](https://www.runoob.com/java/java-interfaces.html)[Java 枚举](https://www.runoob.com/java/java-enum.html)[Java 包(package)](https://www.runoob.com/java/java-package.html)[Java 反射](https://www.runoob.com/java/java-reflection.html)

## Java 高级教程

[Java 数据结构](https://www.runoob.com/java/java-data-structures.html)[Java 集合框架](https://www.runoob.com/java/java-collections.html)[Java ArrayList](https://www.runoob.com/java/java-arraylist.html)[Java LinkedList](https://www.runoob.com/java/java-linkedlist.html)[Java HashSet](https://www.runoob.com/java/java-hashset.html)[Java HashMap](https://www.runoob.com/java/java-hashmap.html)[Java Iterator](https://www.runoob.com/java/java-iterator.html)[Java Object](https://www.runoob.com/java/java-object-class.html)[Java 泛型](https://www.runoob.com/java/java-generics.html)[Java 序列化](https://www.runoob.com/java/java-serialization.html)[Java 网络编程](https://www.runoob.com/java/java-networking.html)[Java 发送邮件](https://www.runoob.com/java/java-sending-email.html)[Java 多线程编程](https://www.runoob.com/java/java-multithreading.html)[Java Applet 基础](https://www.runoob.com/java/java-applet-basics.html)[Java 文档注释](https://www.runoob.com/java/java-documentation.html)[Java 实例](https://www.runoob.com/java/java-examples.html)[Java 8 新特性](https://www.runoob.com/java/java8-new-features.html)[Java MySQL 连接](https://www.runoob.com/java/java-mysql-connect.html)[Java 9 新特性](https://www.runoob.com/java/java9-new-features.html)[Java 测验](https://www.runoob.com/quiz/java-quiz.html)

 [Java 封装](https://www.runoob.com/java/java-encapsulation.html)

[Java 枚举](https://www.runoob.com/java/java-enum.html) 

[![img](https://static.jyshare.com/images/re/tylm-53-10-1.png)](https://developer.aliyun.com/article/1605527)

# Java 接口

接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。

接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。类描述对象的属性和方法。接口则包含类要实现的方法。

除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。

接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。另外，在 Java 中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象。

### 接口与类相似点：

- 一个接口可以有多个方法。
- 接口文件保存在 .java 结尾的文件中，文件名使用接口名。
- 接口的字节码文件保存在 .class 结尾的文件中。
- 接口相应的字节码文件必须在与包名称相匹配的目录结构中。

### 接口与类的区别：

- 接口不能用于实例化对象。
- 接口没有构造方法。
- 接口中所有的方法必须是抽象方法，Java 8 之后 接口中可以使用 default 关键字修饰的非抽象方法。
- 接口不能包含成员变量，除了 static 和 final 变量。
- 接口不是被类继承了，而是要被类实现。
- 接口支持多继承。

### 接口特性

- 接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 **public abstract**（只能是 public abstract，其他修饰符都会报错）。
- 接口中可以含有变量，但是接口中的变量会被隐式的指定为 **public static final** 变量（并且只能是 public，用 private 修饰会报编译错误）。
- 接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。

### 抽象类和接口的区别

- \1. 抽象类中的方法可以有方法体，就是能实现方法的具体功能，但是接口中的方法不行。
- \2. 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是 **public static final** 类型的。
- \3. 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法。
- \4. 一个类只能继承一个抽象类，而一个类却可以实现多个接口。

> **注**：JDK 1.8 以后，接口里可以有静态方法和方法体了。
>
> **注**：JDK 1.8 以后，接口允许包含具体实现的方法，该方法称为"默认方法"，默认方法使用 default 关键字修饰。更多内容可参考 [Java 8 默认方法](https://www.runoob.com/java/java8-default-methods.html)。
>
> **注**：JDK 1.9 以后，允许将方法定义为 private，使得某些复用的代码不会把方法暴露出去。更多内容可参考 [Java 9 私有接口方法](https://www.runoob.com/java/java9-private-interface-methods.html)。

------

## 接口的声明

接口的声明语法格式如下：

[可见度] interface 接口名称 [extends 其他的接口名] {        // 声明变量        // 抽象方法 }

Interface关键字用来声明一个接口。下面是接口声明的一个简单例子。

## NameOfInterface.java 文件代码：

/* 文件名 : NameOfInterface.java */ import java.lang.*; //引入包  public interface NameOfInterface {   //任何类型 final, static 字段   //抽象方法 }



接口有以下特性：



- 接口是隐式抽象的，当声明一个接口的时候，不必使用**abstract**关键字。
- 接口中每一个方法也是隐式抽象的，声明时同样不需要**abstract**关键字。
- 接口中的方法都是公有的。

### 实例

## Animal.java 文件代码：

/* 文件名 : Animal.java */ interface Animal {   public void eat();   public void travel(); }

------

## 接口的实现

当类实现接口的时候，类要实现接口中所有的方法。否则，类必须声明为抽象的类。

类使用implements关键字实现接口。在类声明中，Implements关键字放在class声明后面。

实现一个接口的语法，可以使用这个公式：

## 接口语法：

...implements 接口名称[, 其他接口名称, 其他接口名称..., ...] ...

### 实例

## MammalInt.java 文件代码：

/* 文件名 : MammalInt.java */ public class MammalInt implements Animal{    public void eat(){      System.out.println("Mammal eats");   }    public void travel(){      System.out.println("Mammal travels");   }     public int noOfLegs(){      return 0;   }    public static void main(String args[]){      MammalInt m = new MammalInt();      m.eat();      m.travel();   } }

以上实例编译运行结果如下:

```
Mammal eats
Mammal travels
```

重写接口中声明的方法时，需要注意以下规则：

- 类在实现接口的方法时，不能抛出强制性异常，只能在接口中，或者继承接口的抽象类中抛出该强制性异常。
- 类在重写方法时要保持一致的方法名，并且应该保持相同或者相兼容的返回值类型。
- 如果实现接口的类是抽象类，那么就没必要实现该接口的方法。

在实现接口的时候，也要注意一些规则：

- 一个类可以同时实现多个接口。
- 一个类只能继承一个类，但是能实现多个接口。
- 一个接口能继承另一个接口，这和类之间的继承比较相似。

------

## 接口的继承

一个接口能继承另一个接口，和类之间的继承方式比较相似。接口的继承使用extends关键字，子接口继承父接口的方法。

在Java中，类的多继承是不合法，但接口允许多继承。



没有任何方法的接口被称为标记接口。标记接口主要用于以下两种目的：

- 建立一个公共的父接口：

  正如EventListener接口，这是由几十个其他接口扩展的Java API，你可以使用一个标记接口来建立一组接口的父接口。例如：当一个接口继承了EventListener接口，Java虚拟机(JVM)就知道该接口将要被用于一个事件的代理方案。

- 向一个类添加数据类型：

  这种情况是标记接口最初的目的，实现标记接口的类不需要定义任何接口方法(因为标记接口根本就没有方法)，但是该类通过多态性变成一个接口类型。

## 接口的多继承

通过接口的多继承，可以创建一个复合接口，将多个接口的能力合并到一个接口中，为实现类提供更丰富的行为组合。



## Java 枚举



```java
 enum Color 
{ 
    RED, GREEN, BLUE; 
} 
public class MyClass { 
  public static void main(String[] args) { 
    for (Color myVar : Color.values()) {
      System.out.println(myVar);
    }
  } 
}
```

RED
GREEN
BLUE

### values(), ordinal() 和 valueOf() 方法

enum 定义的枚举类默认继承了 java.lang.Enum 类，并实现了 java.lang.Serializable 和 java.lang.Comparable 两个接口。

values(), ordinal() 和 valueOf() 方法位于 java.lang.Enum 类中：

- values() 返回枚举类中所有的值。
- ordinal()方法可以找到每个枚举常量的索引，就像数组索引一样。
- valueOf()方法返回指定字符串值的枚举常量。

.

枚举跟普通类一样可以用自己的变量、方法和构造函数，构造函数只能使用 private 访问修饰符，所以外部无法调用

枚举既可以包含具体方法，也可以包含抽象方法。 如果枚举类具有抽象方法，则枚举类的每个实例都必须实现它。



~~~java
enum Color
{
    RED, GREEN, BLUE;
 
    // 构造函数
    private Color()
    {
        System.out.println("Constructor called for : " + this.toString());
    }
 
    public void colorInfo()
    {
        System.out.println("Universal Color");
    }
}
 
public class Test
{    
    // 输出
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
        c1.colorInfo();
    }
}
~~~





package关键字  加入类 创建包

下面的 payroll 包已经包含了 Employee 类，接下来向 payroll 包中添加一个 Boss 类。Boss 类引用 Employee 类的时候可以不用使用 payroll 前缀，Boss 类的实例如下。

~~~java	
package payroll;
 
public class Boss
{
   public void payEmployee(Employee e)
   {
      e.mailCheck();
   }
}
~~~

# Java 反射（Reflection）

Java 反射（Reflection）是一个强大的特性，它允许程序在运行时查询、访问和修改类、接口、字段和方法的信息。反射提供了一种动态地操作类的能力，这在很多框架和库中被广泛使用，例如Spring框架的依赖注入。



具体看https://www.runoob.com/java/java-reflection.html





~~~java	
Class<?> clazz = String.class;

String str = "Hello";


Class<?> clazz = str.getClass();
Class<?> clazz = Class.forName("java.lang.String"); 要配合try 
~~~



Java 数据结构

### 列表（Lists）

~~~java
List<String> arrayList = new ArrayList<>();
List<Integer> linkedList = new LinkedList<>();

List<String> list = new ArrayList<>();
list.add("apple");
list.add(0, "banana"); // 在索引 0 处插入 "banana"
String firstElement = list.get(0); // 获取第一个元素
list.set(1, "orange"); // 将第二个元素改为 "orange"
list.remove(0); // 删除第一个元素
list.remove("orange"); // 删除元素 "orange"
contains(Object o)：检查列表中是否包含指定元素。
indexOf(Object o)：返回指定元素首次出现的索引。
lastIndexOf(Object o)：返回指定元素最后出现的索引。
isEmpty()：检查列表是否为空。
size()：返回列表中的元素数量。
clear()：清空列表中的所有元素。
List<String> subList = list.subList(1, 3); // 获取从索引 1 到 3 的子列表
Collections.sort(list); // 排序
Collections.fill(list, "kiwi"); // 用 "kiwi" 替换所有元素
String[] array = list.toArray(new String[0]);toArray()：将 List 转换为对象数组。
toArray(T[] array)：将 List 转换为指定类型的数组。

~~~



**HashSet:**

- **特点：** 无序集合，基于HashMap实现。
- **优点：** 高效的查找和插入操作。
- **缺点：** 不保证顺序。

**TreeSet:**

- **特点：**TreeSet 是有序集合，底层基于红黑树实现，不允许重复元素。
- **优点：** 提供自动排序功能，适用于需要按顺序存储元素的场景。
- **缺点：** 性能相对较差，不允许插入 null 元素。

函数跟list一样

### 映射（Maps）

映射（Maps）用于存储键值对，常见的实现有 HashMap 和 TreeMap。

```
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();
```

**HashMap:**

- **特点：** 基于哈希表实现的键值对存储结构。
- **优点：** 高效的查找、插入和删除操作。
- **缺点：** 无序，不保证顺序。

**TreeMap:**

- **特点：** 基于红黑树实现的有序键值对存储结构。
- **优点：** 有序，支持按照键的顺序遍历。
- **缺点：** 插入和删除相对较慢。

### 队列（Queue）

队列（Queue）遵循先进先出（FIFO）原则，常见的实现有 LinkedList 和 PriorityQueue。

```
Queue<String> queue = new LinkedList<>();
```

**Queue 接口:**

- **特点：** 代表一个队列，通常按照先进先出（FIFO）的顺序操作元素。
- **实现类：** LinkedList, PriorityQueue, ArrayDeque。

### 堆（Heap）

堆（Heap）优先队列的基础，可以实现最大堆和最小堆。

```
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

### 树（Trees）

Java 提供了 TreeNode 类型，可以用于构建二叉树等数据结构。

```
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

**Dictionary 类在较新的 Java 版本中已经被弃用（deprecated），推荐使用 Map 接口及其实现类，如 HashMap、TreeMap 等，来代替 Dictionary。**

## 集合框架

https://www.runoob.com/java/java-collections.html

感觉不太重要 略过好了

![img](https://www.runoob.com/wp-content/uploads/2014/01/2243690-9cd9c896e0d512ed.gif)

![img](https://www.runoob.com/wp-content/uploads/2014/01/java-coll-2020-11-16.png)



![在这里插入图片描述](https://img-blog.csdnimg.cn/574e95e38a794f52a40aab63b8f32a18.png)

List、Set集合是继承了Colection接口，跟Collection是继承关系

而ArrayList、LinkedList跟List是继承关系，HashSet、TreeSet跟Set也是继承关系，HashMap、TreeMap跟Map也是继承关系

- Collection接口：泛指广义上集合，主要表示List和Set两种存储方式。

- List接口：表示列表，规定了允许记录添加顺序，允许元素重复的规范。

- Set接口：表示狭义上集合，规定了不记录添加顺序，不允许元素重复的规范。

- Map接口：表示映射关系，规定了两个集合映射关系的规范。

  

  List(列表)：允许记录添加顺序，允许元素重复。=> **元素有序且可重复** Set(数据集)：不记录添加顺序，不允许元素重复。=> **元素无序且唯一**

## ArrayList



![img](https://www.runoob.com/wp-content/uploads/2020/06/ArrayList-1-768x406-1.png)

~~~java	
ArrayList<E> objectName =new ArrayList<>();
Integer（用于 int）
Double（用于 double）
Float（用于 float）
Character（用于 char）
Boolean（用于 boolean）
Byte、Short、Long（分别用于 byte、short、long）
ArrayList 可以存储任何 Java 类或接口的实例，包括自定义类。
ArrayList<String> stringList = new ArrayList<>(); // 用于存储字符串
ArrayList<MyClass> myClassList = new ArrayList<>(); // 用于存储 MyClass 的实例
其他数据结构和集合类型
ArrayList<HashMap<String, Integer>> mapList = new ArrayList<>(); // 用于存储 HashMap 对象
ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>(); // 用于存储整数列表的列表
通配符类型（? extends 或 ? super）
使用通配符可以在 ArrayList 中存储具有泛型限制的对象，比如 ArrayList<? extends Number> 可以存储 Number 类型或其子类型。
ArrayList<? extends Number> numList = new ArrayList<Integer>(); // 可存储 Integer、Double 等 Number 的子类型 //这行代码有问题
通配符 ? extends 适用于只读情况，因为编译器无法确定具体类型而限制了添加操作。如果需要动态修改 ArrayList，建议直接使用具体类型 Number 或 Integer
不如 ArrayList<Number> intarray=new ArrayList<>();
~~~

`ArrayList<? extends Number>` 使用了通配符 `? extends Number`，它表示这个 `ArrayList` 的元素可以是 `Number` 类型或其子类型，但不允许添加元素。这样设计是因为编译器无法确定具体的子类型，因此限制了添加操作。



add()  set(index,element)   size()  remove() Collections.sort

在 Java 中，`Collections.sort()` 方法只能对实现了 `Comparable` 接口的元素类型进行排序。然而，`Number` 类本身并没有实现 `Comparable` 接口，因此不能直接对 `ArrayList<Number>` 进行排序。

如果原列表中有元素，可以使用 `addAll()` 方法将所有元素复制到新列表中：

`ArrayList<Integer>` 不能自动转换为 `ArrayList<Number>`，反之亦然。

强转为integer

~~~java
List<Number> numberList = List.of(1, 2.5, 3, 4.0); // 示例 `Number` 类型
List<Integer> integerList = new ArrayList<>();

for (Number num : numberList) {
    integerList.add(num.intValue());  // 将 `Number` 转换为 `Integer` 并添加到新列表中
}

System.out.println(integerList);  // 输出 [1, 2, 3, 4]

~~~

| [add()](https://www.runoob.com/java/java-arraylist-add.html) | 将元素插入到指定位置的 arraylist 中           |
| ------------------------------------------------------------ | --------------------------------------------- |
| [addAll()](https://www.runoob.com/java/java-arraylist-addall.html) | 添加集合中的所有元素到 arraylist 中           |
| [clear()](https://www.runoob.com/java/java-arraylist-clear.html) | 删除 arraylist 中的所有元素                   |
| [clone()](https://www.runoob.com/java/java-arraylist-clone.html) | 复制一份 arraylist                            |
| [contains()](https://www.runoob.com/java/java-arraylist-contains.html) | 判断元素是否在 arraylist                      |
| [get()](https://www.runoob.com/java/java-arraylist-get.html) | 通过索引值获取 arraylist 中的元素             |
| [indexOf()](https://www.runoob.com/java/java-arraylist-indexof.html) | 返回 arraylist 中元素的索引值                 |
| [removeAll()](https://www.runoob.com/java/java-arraylist-removeall.html) | 删除存在于指定集合中的 arraylist 里的所有元素 |
| [remove()](https://www.runoob.com/java/java-arraylist-remove.html) | 删除 arraylist 里的单个元素                   |
| [size()](https://www.runoob.com/java/java-arraylist-size.html) | 返回 arraylist 里元素数量                     |
| [isEmpty()](https://www.runoob.com/java/java-arraylist-isempty.html) | 判断 arraylist 是否为空                       |
| [subList()](https://www.runoob.com/java/java-arraylist-sublist.html) | 截取部分 arraylist 的元素                     |
| [set()](https://www.runoob.com/java/java-arraylist-set.html) | 替换 arraylist 中指定索引的元素               |
| [sort()](https://www.runoob.com/java/java-arraylist-sort.html) | 对 arraylist 元素进行排序                     |
| [toArray()](https://www.runoob.com/java/java-arraylist-toarray.html) | 将 arraylist 转换为数组                       |
| [toString()](https://www.runoob.com/java/java-arraylist-tostring.html) | 将 arraylist 转换为字符串                     |
| [ensureCapacity](https://www.runoob.com/java/java-arraylist-surecapacity.html)() | 设置指定容量大小的 arraylist                  |
| [lastIndexOf()](https://www.runoob.com/java/java-arraylist-lastindexof.html) | 返回指定元素在 arraylist 中最后一次出现的位置 |
| [retainAll()](https://www.runoob.com/java/java-arraylist-retainall.html) | 保留 arraylist 中在指定集合中也存在的那些元素 |
| [containsAll()](https://www.runoob.com/java/java-arraylist-containsall.html) | 查看 arraylist 是否包含指定集合中的所有元素   |
| [trimToSize()](https://www.runoob.com/java/java-arraylist-trimtosize.html) | 将 arraylist 中的容量调整为数组中的元素个数   |
| [removeRange()](https://www.runoob.com/java/java-arraylist-removerange.html) | 删除 arraylist 中指定索引之间存在的元素       |
| [replaceAll()](https://www.runoob.com/java/java-arraylist-replaceall.html) | 将给定的操作内容替换掉数组中每一个元素        |
| [removeIf()](https://www.runoob.com/java/java-arraylist-removeif.html) | 删除所有满足特定条件的 arraylist 元素         |
| [forEach()](https://www.runoob.com/java/java-arraylist-foreach.html) | 遍历 arraylist 中每一个元素并执行特定操作     |



## Linkedlist

![img](https://www.runoob.com/wp-content/uploads/2020/06/linkedlist-2020-11-16.png)

LinkedList 继承了 AbstractSequentialList 类。

LinkedList 实现了 Queue 接口，可作为队列使用。

LinkedList 实现了 List 接口，可进行列表的相关操作。

LinkedList 实现了 Deque 接口，可作为队列使用。

LinkedList 实现了 Cloneable 接口，可实现克隆。

LinkedList 实现了 java.io.Serializable 接口，即可支持序列化，能通过序列化去传输。

| public boolean add(E e)                        | 链表末尾添加元素，返回是否成功，成功为 true，失败为 false。  |
| ---------------------------------------------- | ------------------------------------------------------------ |
| public void add(int index, E element)          | 向指定位置插入元素。                                         |
| public boolean addAll(Collection c)            | 将一个集合的所有元素添加到链表后面，返回是否成功，成功为 true，失败为 false。 |
| public boolean addAll(int index, Collection c) | 将一个集合的所有元素添加到链表的指定位置后面，返回是否成功，成功为 true，失败为 false。 |
| public void addFirst(E e)                      | 元素添加到头部。                                             |
| public void addLast(E e)                       | 元素添加到尾部。                                             |
| public boolean offer(E e)                      | 向链表末尾添加元素，返回是否成功，成功为 true，失败为 false。 |
| public boolean offerFirst(E e)                 | 头部插入元素，返回是否成功，成功为 true，失败为 false。      |
| public boolean offerLast(E e)                  | 尾部插入元素，返回是否成功，成功为 true，失败为 false。      |
| public void clear()                            | 清空链表。                                                   |
| public E removeFirst()                         | 删除并返回第一个元素。                                       |
| public E removeLast()                          | 删除并返回最后一个元素。                                     |
| public boolean remove(Object o)                | 删除某一元素，返回是否成功，成功为 true，失败为 false。      |
| public E remove(int index)                     | 删除指定位置的元素。                                         |
| public E poll()                                | 删除并返回第一个元素。                                       |
| public E remove()                              | 删除并返回第一个元素。                                       |
| public boolean contains(Object o)              | 判断是否含有某一元素。                                       |
| public E get(int index)                        | 返回指定位置的元素。                                         |
| public E getFirst()                            | 返回第一个元素。                                             |
| public E getLast()                             | 返回最后一个元素。                                           |
| public int indexOf(Object o)                   | 查找指定元素从前往后第一次出现的索引。                       |
| public int lastIndexOf(Object o)               | 查找指定元素最后一次出现的索引。                             |
| public E peek()                                | 返回第一个元素。                                             |
| public E element()                             | 返回第一个元素。                                             |
| public E peekFirst()                           | 返回头部元素。                                               |
| public E peekLast()                            | 返回尾部元素。                                               |
| public E set(int index, E element)             | 设置指定位置的元素。                                         |
| public Object clone()                          | 克隆该列表。                                                 |
| public Iterator descendingIterator()           | 返回倒序迭代器。                                             |
| public int size()                              | 返回链表元素个数。                                           |
| public ListIterator listIterator(int index)    | 返回从指定位置开始到末尾的迭代器。                           |
| public Object[] toArray()                      | 返回一个由链表元素组成的数组。                               |
| public T[] toArray(T[] a)                      | 返回一个由链表元素转换类型而成的数组。                       |



## Hashset



![img](https://www.runoob.com/wp-content/uploads/2020/07/java-hashset-hierarchy.png)

HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。HashSet 是无序的，即不会记录插入的顺序。![HashSet](https://i-blog.csdnimg.cn/blog_migrate/1dd73c82382e0c52779ac411a8fa5331.png)





## Hashmap

![img](https://www.runoob.com/wp-content/uploads/2020/07/WV9wXLl.png)

HashMap 是无序的，即不会记录插入的顺序。

![img](https://static.jyshare.com/images/mix/java-map.svg)



添加键值对(key-value)可以使用 put() 方法

get(key) 方法来获取 key 对应的 value

remove(key) 方法来删除 key 对应的键值对(key-value):

删除所有键值对(key-value)可以使用 clear 方法

计算 HashMap 中的元素数量可以使用 size() 方法

可以使用 for-each 来迭代 HashMap 中的元素。

如果你只想获取 key，可以使用 keySet() 方法，然后可以通过 get(key) 获取对应的 value，如果你只想获取 value，可以使用 values() 方法。

| [clear()](https://www.runoob.com/java/java-hashmap-clear.html) | 删除 hashMap 中的所有键/值对                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [clone()](https://www.runoob.com/java/java-hashmap-clone.html) | 复制一份 hashMap                                             |
| [isEmpty()](https://www.runoob.com/java/java-hashmap-isempty.html) | 判断 hashMap 是否为空                                        |
| [size()](https://www.runoob.com/java/java-hashmap-size.html) | 计算 hashMap 中键/值对的数量                                 |
| [put()](https://www.runoob.com/java/java-hashmap-put.html)   | 将键/值对添加到 hashMap 中                                   |
| [putAll()](https://www.runoob.com/java/java-hashmap-putall.html) | 将所有键/值对添加到 hashMap 中                               |
| [putIfAbsent()](https://www.runoob.com/java/java-hashmap-putifabsent.html) | 如果 hashMap 中不存在指定的键，则将指定的键/值对插入到 hashMap 中。 |
| [remove()](https://www.runoob.com/java/java-hashmap-remove.html) | 删除 hashMap 中指定键 key 的映射关系                         |
| [containsKey()](https://www.runoob.com/java/java-hashmap-containskey.html) | 检查 hashMap 中是否存在指定的 key 对应的映射关系。           |
| [containsValue()](https://www.runoob.com/java/java-hashmap-containsvalue.html) | 检查 hashMap 中是否存在指定的 value 对应的映射关系。         |
| [replace()](https://www.runoob.com/java/java-hashmap-replace.html) | 替换 hashMap 中是指定的 key 对应的 value。                   |
| [replaceAll()](https://www.runoob.com/java/java-hashmap-replaceall.html) | 将 hashMap 中的所有映射关系替换成给定的函数所执行的结果。    |
| [get()](https://www.runoob.com/java/java-hashmap-get.html)   | 获取指定 key 对应对 value                                    |
| [getOrDefault()](https://www.runoob.com/java/java-hashmap-getordefault.html) | 获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值 |
| [forEach()](https://www.runoob.com/java/java-hashmap-foreach.html) | 对 hashMap 中的每个映射执行指定的操作。                      |
| [entrySet()](https://www.runoob.com/java/java-hashmap-entryset.html) | 返回 hashMap 中所有映射项的集合集合视图。                    |
| [keySet](https://www.runoob.com/java/java-hashmap-keyset.html)() | 返回 hashMap 中所有 key 组成的集合视图。                     |
| [values()](https://www.runoob.com/java/java-hashmap-values.html) | 返回 hashMap 中存在的所有 value 值。                         |
| [merge()](https://www.runoob.com/java/java-hashmap-merge.html) | 添加键值对到 hashMap 中                                      |
| [compute()](https://www.runoob.com/java/java-hashmap-compute.html) | 对 hashMap 中指定 key 的值进行重新计算                       |
| [computeIfAbsent()](https://www.runoob.com/java/java-hashmap-computeifabsent.html) | 对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hashMap 中 |
| [computeIfPresent()](https://www.runoob.com/java/java-hashmap-computeifpresent.html) | 对 hashMap 中指定 key 的值进行重新计算，前提是该 key 存在于 hashMap 中。 |



## Iterator

![img](https://www.runoob.com/wp-content/uploads/2020/07/ListIterator-Class-Diagram.jpg)

集合想获取一个迭代器可以使用 iterator() 方法:

让迭代器 it 逐个返回集合中所有元素最简单的方法是使用 while 循环：

~~~java	
while(it.hasNext()) {
    System.out.println(it.next());
}
~~~

iter感觉是指针，  执行next()就下一个了

remove() 方法移除

hasNext() - 用于判断集合中是否还有下一个元素可以访问。

通过使用迭代器，我们可以逐个访问集合中的元素，而不需要使用传统的 for 循环或索引。这种方式更加简洁和灵活，并且适用于各种类型的集合。





## Object 类

Java Object 类是所有类的父类，也就是说 Java 的所有类都继承了 Object，**子类可以使用 Object 的所有方法**

| 1    | [protected Object clone()](https://www.runoob.com/java/java-object-clone.html)创建并返回一个对象的拷贝 |
| ---- | ------------------------------------------------------------ |
| 2    | [boolean equals(Object obj)](https://www.runoob.com/java/java-object-equals.html)比较两个对象是否相等 |
| 3    | [protected void finalize()](https://www.runoob.com/java/java-object-finalize.html)当 GC (垃圾回收器)确定不存在对该对象的有更多引用时，由对象的垃圾回收器调用此方法。 |
| 4    | [Class getClass()](https://www.runoob.com/java/java-object-getclass.html)获取对象的运行时对象的类 |
| 5    | [int hashCode()](https://www.runoob.com/java/java-object-hashcode.html)获取对象的 hash 值 |
| 6    | [void notify()](https://www.runoob.com/java/java-object-notify.html)唤醒在该对象上等待的某个线程 |
| 7    | [void notifyAll()](https://www.runoob.com/java/java-object-notifyall.html)唤醒在该对象上等待的所有线程 |
| 8    | [String toString()](https://www.runoob.com/java/java-object-tostring.html)返回对象的字符串表示形式 |
| 9    | [void wait()](https://www.runoob.com/java/java-object-wait.html)让当前线程进入等待状态。直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。 |
| 10   | [void wait(long timeout)](https://www.runoob.com/java/java-object-wait-timeout.html)让当前线程处于等待(阻塞)状态，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过参数设置的timeout超时时间。 |
| 11   | [void wait(long timeout, int nanos)](https://www.runoob.com/java/java-object-wait-nanos.html)与 wait(long timeout) 方法类似，多了一个 nanos 参数，这个参数表示额外时间（以纳秒为单位，范围是 0-999999）。 所以超时的时间还需要加上 nanos 纳秒。。 |





## 泛型

下面是定义泛型方法的规则：

- 所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的 **<E>**）。
- 每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
- 类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
- 泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像 **int、double、char** 等）。

**java 中泛型标记符：**

- **E** - Element (在集合中使用，因为集合中存放的是元素)
- **T** - Type（Java 类）
- **K** - Key（键）
- **V** - Value（值）
- **N** - Number（数值类型）
- **？** - 表示不确定的 java 类型

有点像函数模版

~~~java
public static < E > void printArray( E[] inputArray )
    <E> 是泛型声明，需要放在返回类型之前声明  
public static <T extends Comparable<T>> T maximum(T x, T y, T z)
  希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
    
<T extends Comparable<T>>表明T实现了Comaprable<T>接口，此条件强制约束， 声明该泛型的类型必须是Comparable<T>的子类 泛型类型为T
   一整个<>是泛型声明 第三个T指的是返回函数返回T类型 而不是void+
    
    Comparable<T> 接口是Java中的一个泛型接口
   public interface Comparable<T> {
    int compareTo(T o);
}
e1.compareTo(e2) > 0 即 e1 > e2
e1.compareTo(e2) = 0 即 e1 = e2
e1.compareTo(e2) < 0 即 e1 < e2
 实现了Comparable接口的类的对象的列表或数组可以通过Collections.sort或Arrays.sort进行自动排序。
    一个类型实现了Compareable接口，表明了这个类具有了可排序的功能或者说标准，两个对象通过Compareable接口中的compareTo方法的返回值来比较大小。
    int、double 这些基本数据类型在 Java 中并不能直接使用 compareTo 方法，因为它们不是对象类型。compareTo 是属于接口方法，而基本数据类型没有实现任何接口，也没有任何方法。因此，我们无法对 int、double 这样的类型直接使用 compareTo 方法。
    Java 的自动装箱机制（autoboxing）使得 int 可以自动转换为 Integer，double 可以转换为 Double 等，而这些包装类都实现了 Comparable 接口。
~~~

要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。

## 泛型类

~~~java	
public class Box<T> {
   
  private T t;
 
  public void add(T t) {
    this.t = t;
  }
 
  public T get() {
    return t;
  }
 
  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<Integer>();
    Box<String> stringBox = new Box<String>();
 
    integerBox.add(new Integer(10));
    stringBox.add(new String("菜鸟教程"));
 
    System.out.printf("整型值为 :%d\n\n", integerBox.get());
    System.out.printf("字符串为 :%s\n", stringBox.get());
  }
}
~~~

类型通配符一般是使用 **?** 代替具体的类型参数。例如 **List<?>** 在逻辑上是 **List<String>,List<Integer>** 等所有 **List<具体类型实参>** 的父类



~~~java	
import java.util.*;
 
public class GenericTest {
     
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        
        name.add("icon");
        age.add(18);
        number.add(314);
 
        getData(name);
        getData(age);
        getData(number);
       
   }
 
   public static void getData(List<?> data) {
      System.out.println("data :" + data.get(0));
   }
}
~~~

类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。

~~~java	
   public static void getUperNumber(List<? extends Number> data) {
          System.out.println("data :" + data.get(0));
       }
 //1 处会出现错误，因为 getUperNumber() 方法中的参数已经限定了参数泛型上限为 Number，所以泛型为 String 是不在这个范围之内，所以会报错。
~~~

类型通配符下限通过形如 **List<? super Number>** 来定义，表示类型只能接受 **Number** 及其上层父类类型，如 **Object** 类型的实例。

## 序列化

Java 序列化是一种将对象转换为字节流的过程，以便可以将对象保存到磁盘上，将其传输到网络上，或者将其存储在内存中，以后再进行反序列化，将字节流重新转换为对象。

序列化在 Java 中是通过 **java.io.Serializable** 接口来实现的，该接口没有任何方法，只是一个标记接口，用于标识类可以被序列化。

当你序列化对象时，你把它包装成一个特殊文件，可以保存、传输或存储。反序列化则是打开这个文件，读取序列化的数据，然后将其还原为对象，以便在程序中使用。

序列化是一种用于保存、传输和还原对象的方法，它使得对象可以在不同的计算机之间移动和共享，这对于分布式系统、数据存储和跨平台通信非常有用。

以下是 Java 序列化的基本概念和用法：

实现 Serializable 接口： 要使一个类可序列化，需要让该类实现 java.io.Serializable 接口，这告诉 Java 编译器这个类可以被序列化，例如

~~~java
import java.io.Serializable;

public class MyClass implements Serializable {
    // 类的成员和方法
}
MyClass obj = new MyClass();
try {
    FileOutputStream fileOut = new FileOutputStream("object.ser");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);   //创建一个对象输出流 out，它包装了 fileOut。ObjectOutputStream 可以将对象序列化，并将其内容写入文件。
    out.writeObject(obj); //方法将对象 obj 序列化，并写入到文件 "object.ser" 中。注意，obj 必须实现 Serializable 接口，才能被序列化，否则会抛出 NotSerializableException 异常。
    out.close();
    fileOut.close();
} catch (IOException e) {
    e.printStackTrace();
}
~~~





使用 ObjectInputStream 类来从字节流中反序列化对象

~~~java	
MyClass obj = null;
try {
    FileInputStream fileIn = new FileInputStream("object.ser");
    ObjectInputStream in = new ObjectInputStream(fileIn);
    obj = (MyClass) in.readObject();//表示从流中读取的对象需要强制转换成 MyClass 类型。
    in.close();
    fileIn.close();
} catch (IOException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
~~~



请注意，一个类的对象要想序列化成功，必须满足两个条件：

该类必须实现 java.io.Serializable 接口。

该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。

如果你想知道一个 Java 标准类是否是可序列化的，请查看该类的文档。检验一个类的实例是否能序列化十分简单， 只需要查看该类有没有实现 java.io.Serializable接口。



![TCP/IP 四层模型](https://oss.javaguide.cn/github/javaguide/cs-basics/network/tcp-ip-4-model.png)

如上图所示，OSI 七层协议模型中，表示层做的事情主要就是对应用层的用户数据进行处理转换为二进制流。反过来的话，就是将二进制流转换成应用层的用户数据。这不就对应的是序列化和反序列化么？

因为，OSI 七层协议模型中的应用层、表示层和会话层对应的都是 TCP/IP 四层模型中的应用层，所以序列化协议属于 TCP/IP 协议应用层的一部分 

JDK 自带的序列化，只需实现 `java.io.Serializable`接口即可。

序列化号 `serialVersionUID` 属于版本控制的作用。反序列化时，会检查 `serialVersionUID` 是否和当前类的 `serialVersionUID` 一致。如果 `serialVersionUID` 不一致则会抛出 `InvalidClassException` 异常。强烈推荐每个序列化类都手动指定其 `serialVersionUID`，如果不手动指定，那么编译器会动态生成默认的 `serialVersionUID`。

`static` 修饰的变量是静态变量，属于类而非类的实例，本身是不会被序列化的。然而，`serialVersionUID` 是一个特例，`serialVersionUID` 的序列化做了特殊处理。当一个对象被序列化时，`serialVersionUID` 会被写入到序列化的二进制流中；在反序列化时，也会解析它并做一致性判断，以此来验证序列化对象的版本一致性。如果两者不匹配，反序列化过程将抛出 `InvalidClassException`，因为这通常意味着序列化的类的定义已经发生了更改，可能不再兼容。

也就是说，`serialVersionUID` 只是用来被 JVM 识别，实际并没有被序列化。

`transient` 关键字的作用是：阻止实例中那些用此关键字修饰的的变量序列化；当对象被反序列化时，被 `transient` 修饰的变量值不会被持久化和恢复。

关于 `transient` 还有几点注意：

- `transient` 只能修饰变量，不能修饰类和方法。
- `transient` 修饰的变量，在反序列化后变量值将会被置成类型的默认值。例如，如果是修饰 `int` 类型，那么反序列后结果就是 `0`。
- `static` 变量因为不属于任何对象(Object)，所以无论有没有 `transient` 关键字修饰，均不会被序列化。

使用 `transient` 的主要原因是：

- 不希望某些敏感数据（如密码）存储到硬盘中。
- 某些字段的值在序列化后并不需要保存（如缓存数据、临时计算结果等），所以无需在反序列化时还原这些字段的内容。

Kryo 是专门针对 Java 语言序列化方式并且性能非常好，如果你的应用是专门针对 Java 语言的话可以考虑使用，并且 Dubbo 官网的一篇文章中提到说推荐使用 Kryo 作为生产环境的序列化方式\





在 Java 中，`static` 关键字是用来标识静态成员（方法、变量、内部类等）的，它表示该成员属于类本身，而不是类的某个实例。要理解为什么有时需要在本类中运行自己的函数时加上 `static`，我们可以从以下几个方面来解释。

### 1. 静态方法 (`static` 方法) 和实例方法的区别

- **静态方法**：属于类本身，而不是某个特定的对象。你可以直接通过类名调用静态方法，而不需要创建该类的实例。
- **实例方法**：属于类的实例（即对象）。调用实例方法时，你需要首先创建类的实例对象，然后通过该实例对象来调用方法。

### 2. 为什么类方法要加 `static`？

- 如果方法是 `static` 的，那么你可以 **不创建类的实例**，直接通过类名来调用它。这对于一些工具方法或操作类本身的功能是非常有用的。
- 如果没有加 `static`，则该方法依赖于类的实例，也就是说，在调用该方法之前，必须先创建该类的对象实例。
