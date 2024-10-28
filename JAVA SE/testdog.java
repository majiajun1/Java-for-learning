class Animal2{
    public void move(){
        System.out.println("I am an animal");
    }
}

class Dog extends Animal2{
    public void move(){
        //super.move();
        System.out.println("I am a dog");
    }
    public void move2(){
        System.out.println("I am a dog2");
    }
}


public class testdog {
     public static void main(String[] args) {
         Animal2 a = new Animal2();
         Animal2 b = new Dog();
         Dog c = new Dog();
         a.move();
         b.move();
        // b.move2();运行不了
         c.move2();

     }
}
