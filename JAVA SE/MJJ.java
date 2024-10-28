

public class MJJ implements student {
    public void study(){
        System.out.println("student study");
    }
    public static void main(String[] args) {
        MJJ a = new MJJ();
        a.study();
        //Class<?> clazz=a.getClass();
        //System.out.println(clazz);
        try{
        Class<?> clazz=Class.forName("MJJ");
        System.out.println(clazz);
    }catch(ClassNotFoundException e){}

    }
}
