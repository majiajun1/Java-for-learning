

/*
    题目要求：一分钟内完成此题，只能用一行代码实现！
    现在有五个用户！筛选：
    1、ID必须是偶数
    2、年龄必须大于23岁
    3、用户名转为大写字母
    4、用户名字母倒着排序
    5、只输出一个用户
 */
import java.util.*;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamLearning {
    public static void main(String[] args) {
        UserA u1 = new UserA(1, "a", 21);
        UserA u2 = new UserA(2, "b", 22);
        UserA u3 = new UserA(3, "c", 23);
        UserA u4 = new UserA(4, "d", 24);
        UserA u5 = new UserA(5, "e", 25);
        List<UserA> list= Arrays.asList(u1, u2, u3, u4, u5);
        //集合就是存储
        //计算交给Stream流
        //链式编程
        list.stream().filter((u)->{
            return u.getId()%2==0;
        }).filter((u)->{return u.getAge()>23;}).map((u)->{return u.getName().toUpperCase();}).
                sorted((uu1,uu2)->{return  uu1.compareTo(uu2);}).limit(1)
        .forEach(System.out::println);


    }
}
