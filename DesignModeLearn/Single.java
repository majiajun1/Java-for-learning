import java.sql.SQLOutput;
import java.util.SplittableRandom;

class SingleMason{
    private static volatile SingleMason thisMason;

    private SingleMason(){
        //构造函数
    }

    public static SingleMason getInstance(){
        if(thisMason==null)
        {
            synchronized(SingleMason.class){
                if(thisMason==null)
                {
                    thisMason= new SingleMason();
                    System.out.println("SingleMason Instance created");
                }else
                {
                    System.out.println("SingleMason Instance already created");
                }
            }
        }else
        {
            System.out.println("SingleMason Instance already created");
        }
        return thisMason;
    }

}


class SingleMe{
    private SingleMe()
    {}

    private static class SingleMeHolder
    {
        private final static SingleMe INSTANCE = new SingleMe();
    }

    public  static SingleMe getInstance(){
        return SingleMeHolder.INSTANCE;
    }
}




public class Single {
    public static void main(String[] args) {
        SingleMason singleMason = SingleMason.getInstance() ;
        SingleMason singleMason1 = SingleMason.getInstance() ;
        SingleMason singleMason2 = SingleMason.getInstance() ;
        System.out.println(singleMason.hashCode());
        System.out.println(singleMason1.hashCode());
        System.out.println(singleMason2.hashCode());


        SingleMe singleMe = SingleMe.getInstance() ;
        SingleMe singleMe1 = SingleMe.getInstance() ;
        System.out.println(singleMe.hashCode());
        System.out.println(singleMe1.hashCode());
    }
}
