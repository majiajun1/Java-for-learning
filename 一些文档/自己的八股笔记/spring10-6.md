# Spring

## Bean

> bean是单例的

singletion 默认单例

可以使用prototype 来多例

单例由spring容器管理，多例不管理



> bean不是线程安全的

并没有可变的状态    （不能修改的类）

某种程度上线程安全

但是可变的成员变量要考虑线程安全



> 生命周期

把xml信息传递到beandefinition      

构造函数 实例化bean

——》依赖注入

--》Aware接口    -----(beannameaware,beanfactoryaware,applicationaware)  三个要记住

--->BeanPostPrecessor  #before

--->初始化方法---(initializingbean ，自定义化方法)

--->BeanPostProcessro#after   (---->AOP-->动态代理)   这里可以功能增强

--->销毁bean



> 循环引用

A用到B  B用到A

可能会死循环

初始化的循环依赖

![image-20250214165141080](..\..\TyporaImage\image-20250214165141080.png)



三级缓存解决循环依赖  (都是concurrenthashmap，三级是普通hashmap)

一级缓存  singletonObjects   单例池，缓存已经经历了完整的生命周期，已经初始化完成的bean对象  **（为了实现单例模式）**

二级缓存 earlySingletionObjects    缓存早期的bean对象（生命周期还没走完）（半成品）

三级缓存 singletonFactories  缓存的是ObjectFactory,表示对象工厂，用来创建某个对象的



二级缓存解决普通循环问题

![image-20250214165551785](..\..\TyporaImage\image-20250214165551785.png)



如果 A是代理对象 那就需要三级缓存解决

![image-20250214165811793](..\..\TyporaImage\image-20250214165811793.png)

对比二级缓存解决  其实就是存了个单例的工厂 然后用工厂拿到A  再把A放到**早期单例池**

例如事务就要代理对象 @transaction



如果构造方法出了循环依赖  那就用懒加载 @Lazy





## AOP

切面

基于动态代理

@Around    是完全控制（代理）

，通常需要先使用 `@Pointcut` 注解来声明一个切点函数，然后再通过其他通知注解（如 `@Before`、`@After`、`@Around` 等）来引用这个切点函数。

```java
@Pointcut("execution(* com.example.service.UserService.*(..))")
public void logPointcut() {}

@Before("logPointcut()")  // 引用刚才定义的切点函数
```



事务的本质是AOP    开启事务再执行    失败就回滚



## 事务及事务失效的场景

使用@Transactional即可使用事务

还能使用  `TransactionTemplate`

```java

@Service
public class UserService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void updateUser(User user) {
        transactionTemplate.execute(status -> {
            // 业务逻辑
            userMapper.update(user);
            
            // 如果出现异常，事务会自动回滚,亦可自己catch然后手动回滚
            return null;
        });
    }
}

```





情况1：异常捕获处理

让try catch给捕获 但是没有throw   导致spring没处理和回滚 

 情况2：抛出检查异常

在方法上定义了throws   IO异常

Spring默认回滚非检查异常(Runtime)



 设置@Transactional(rollback=Exeption.class)  直接顶格 处理所有异常（实现exeption的异常）

情况三：非public方法导致的失效

spring默认处理public  与代理有关

java默认是default  方法具有包私有访问权限，只有同一包中的类能够访问  不能被包外的类访问。



## SpringMVC

> 执行流程

视图阶段



![image-20250214173715445](..\..\TyporaImage\image-20250214173715445.png)

 **这一部分看PDF**

![image-20250214173905290](..\..\TyporaImage\image-20250214173905290.png)

**其实就是把后面的视图省掉了**





## 自动配置原理

@SpringBootApplication包含以下三个注解

@SpringBootConfiguration

@ComponentScane

> **@EnableAutoConfiguration**

它实际上是 `@Import(AutoConfigurationImportSelector.class)` 的一种简化写法，意味着它导入了 `AutoConfigurationImportSelector` 类，这个类负责从所有自动配置类中挑选出与当前应用环境匹配的配置。

读取引用的jar包,component和查meta-inf/spring.factories 





@ConditionalOnClass 

判断是否有对应的类，如果有则加载   把配置类的所有bean放入容器





## Spinrg三件套常见注解

> Spring

 自己背吧

![image-20250214175016204](..\..\TyporaImage\image-20250214175016204.png)



> SpringMVC

![image-20250214175118788](..\..\TyporaImage\image-20250214175118788.png)

> Springboot

![image-20250214175143445](..\..\TyporaImage\image-20250214175143445.png)





## Mybatis

> 执行流程

mybatis-config.xml

配置

指定mapper

有springboot就不用这些了

```java
public interface UserMapper {
    User selectById(@Param("id") Long id);
    
     // 返回多条记录
    List<User> selectByStatus(@Param("status") String status);
}



<!-- resources/mapper/UserMapper.xml -->
<mapper namespace="com.example.mapper.UserMapper">
    <select id="selectById" parameterType="long" resultType="com.example.model.User">
        SELECT * FROM user WHERE id = #{id}
    </select>
        
         <select id="selectByStatus" parameterType="string" resultType="com.example.model.User">
        SELECT * FROM user WHERE status = #{status}
    </select>
</mapper>

        //#{status}和@Param("status")是要对上的
        多个参数时必须用 @Param，单参数情况下不加 @Param 可能也行
```





构建会话工厂---》创建会话SqlSession 项目与sql的会话----》执行器(里面有映射信息)---》MappedStatement对象 ----->数据库



> 延迟加载

默认不开启

什么是延迟加载？

简单讲就是按需加载   fetchtype可以设置为lazy  （局部修改）

全局修改:lazyloadingenabled  

用的cglib代理对象

通常场景是 一个对象里面包着另外一个对象，此时另外一个对象可以延迟加载，此时这个对象被代理，只有在get里面的对象时才会执行查询（代理拦截和invoke）



![image-20250214195335763](..\..\TyporaImage\image-20250214195335763.png)





> 缓存

![image-20250214195440558](..\..\TyporaImage\image-20250214195440558.png)

一级缓存：单一sqlsession



二级缓存：不同会话之间的

二级缓存默认关闭 可以开启  要记得打上</cache>标签

一级缓存和二级缓存namespeaces增删改后 二级缓存select中的缓存会被清空

只有会话提交或者关闭以后  一级缓存中的数据才会存到二级缓存



> #和$的区别？

#会替换为占位符"?"，也就是PreaparedStatment的防注入方式。

$不能防注入

> JDBC的回忆

Connection建立，调用Connection的create方法创建statement，调用statement的方法执行SQL语句，然后close资源

记得要用try with resources和使用事务，还有PreparedStatement

```java
import java.sql.*;

public class JdbcTransactionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1. 获取连接
            conn = DriverManager.getConnection(url, username, password);

            // 2. 关闭自动提交
            conn.setAutoCommit(false);

            // 3. 准备 SQL
            String sql1 = "INSERT INTO user(id, name) VALUES (?, ?)";
            ps = conn.prepareStatement(sql1);
            ps.setLong(1, 1L);
            ps.setString(2, "Alice");
            ps.executeUpdate();


            // 4. 提交事务
            conn.commit();
            System.out.println("事务提交成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    // 5. 回滚事务
                    conn.rollback();
                    System.out.println("事务回滚！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // 6. 关闭资源
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

```



## Spring代理相关

Spring **默认优先使用 JDK 动态代理**，但 **如果目标类没有实现接口**，Spring **只能使用 CGLIB**。其核心原因在于 **JDK 动态代理的限制** 和 **CGLIB 的继承机制**。





CGLIB 代理的本质是 **继承目标类并重写方法**，但 **`final` 方法不能被重写**，所以当 CGLIB 试图对 `final` 方法进行代理增强时，可能会导致 **代理对象内部依赖的 Spring 组件未被正确初始化**，从而引发 **空指针异常（NullPointerException, NPE）**。



CGLIB 代理是通过 **创建目标类的子类** 来实现的，但 **`final` 方法不能被子类重写**，所以当外部调用该 `final` 方法时，实际上调用的是 **目标类（父类）自身的方法**，而**代理对象的依赖注入（DI）在 Spring 中是针对代理类进行的，目标类本身并没有被 Spring 进行 DI**，因此会导致 `null` 引用，从而引发 **空指针异常**。





## spring一些杂

### 依赖注入 

Spring直接autowired即可

 其他方式如下：

> 构造器注入 

```java
@Service
public class UserService {

    private final UserMapper userMapper;

    // 构造器注入
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
//Spring 容器创建 UserService 时：

发现 UserService 只有一个构造器

找到类型为 UserMapper 的 Bean

调用构造器 new UserService(userMapper)

注入完成

✅ 整个过程自动完成，不需要手动调用构造器
```

Spring 容器创建 Bean 时，如果找不到依赖 Bean，会报错，防止创建了一个包含空对象的Bean，防止使用时出现 `NullPointerException`

使用 `final` 修饰依赖，保证 Bean 生命周期内不会被修改，提高对象设计的健壮性

> setter注入

```java
@Service
public class UserService {

    private UserMapper userMapper;

    // Setter 注入
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void updateUser(User user) {
        userMapper.update(user);
    }
}
setter方法不能动final的变量，但构造对象（构造函数）的时候可以
```

比setter糟糕，废物。