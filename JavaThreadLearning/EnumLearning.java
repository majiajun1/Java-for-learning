
//enum本身也是一个类

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumLearning {
    INSTANCE;

    public EnumLearning getEnumLearning() {

        return INSTANCE;
    }
}


class EnumTest
{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumLearning instance1 = EnumLearning.INSTANCE;
        Constructor<EnumLearning> declaredConstructor = EnumLearning.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true); //反射
        EnumLearning instance2 = declaredConstructor.newInstance();
        //EnumLearning instance2 = EnumLearning.INSTANCE;

        System.out.println(instance1);
        System.out.println(instance2);
    }
}