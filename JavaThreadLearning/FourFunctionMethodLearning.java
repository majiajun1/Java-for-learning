/*
 Function 函数型接口
    只要是函数型接口 可以用lambda表达式简化
 */
import java.util.function.*;

public class FourFunctionMethodLearning {

    public static void main(String[] args) {
/*        Function function=new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };*/
        Function<String,String> function=(str)->{return  str;};
        System.out.println(function.apply("hello"));

        //判断字符串是否为空
/*        Predicate predicate=new Predicate<String>() {
            @Override
            public boolean test(String o) {

                return o.isEmpty();
            }
        };*/


        Predicate<String> predicate=(str)->{return str.isEmpty();};
        System.out.println(predicate.test(""));


        Consumer <String> consumer=(str)->{System.out.println(str);};
        consumer.accept("hello");

        Supplier<String> supplier=()->{return "hello";};
        System.out.println(supplier.get());

    }
}
