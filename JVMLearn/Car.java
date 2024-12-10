public class Car {
    public static void main(String[] args) {
        Car car1=new Car();
        Car car2=new Car();
        Car car3=new Car();

        Class<? extends Car> aClass=car1.getClass();
        Class<? extends Car> bClass=car2.getClass();
        Class<? extends Car> cClass=car3.getClass();

        System.out.println(aClass);
        System.out.println(bClass);
        System.out.println(cClass);



    }
}
