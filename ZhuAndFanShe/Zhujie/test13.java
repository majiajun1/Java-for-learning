package Zhujie;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.List;
//通过反射获取泛型
public class test13 {

    public void test01(Map<String,user>map,List<user> list)
    {
        System.out.println("test01");
    }

    public Map<String,user> test2()
    {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = test13.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes)
        {
            System.out.println("#"+genericParameterType);
            if(genericParameterType instanceof ParameterizedType)
            {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                    for (Type actualTypeArgument : actualTypeArguments){
                        System.out.println(actualTypeArgument);}
                }
        }
        System.out.println("===================");
        Method method1 = test13.class.getMethod("test2",null);
        Type genericReturnType = method1.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType)
            {
                Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
                    for (Type actualTypeArgument : actualTypeArguments){
                        System.out.println(actualTypeArgument);}
                }

    }
}
