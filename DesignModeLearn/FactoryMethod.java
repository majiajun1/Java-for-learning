public class FactoryMethod {
    public static void main(String[] args) {
        Creator creatorC = new ConcreteCreatorC();
        AnotherProduct productC = creatorC.createProduct();
        productC.doSomething(); // Output: Product A

        Creator creatorD = new ConcreteCreatorD();
        AnotherProduct productD = creatorD.createProduct();
        productD.doSomething(); // Output: Product B
    }
}
// 产品接口
 interface AnotherProduct {
    void doSomething();
}

// 具体产品
 class ConcreteProductC implements AnotherProduct {
    public void doSomething() {
        System.out.println("Product C");
    }
}

class ConcreteProductD implements AnotherProduct {
    public void doSomething() {
        System.out.println("Product D");
    }
}

abstract class Creator {
    public abstract AnotherProduct createProduct();
}

// 具体工厂
  class ConcreteCreatorC extends Creator {
    public AnotherProduct createProduct() {
        return new ConcreteProductC();
    }
}

 class ConcreteCreatorD extends Creator {
    public AnotherProduct createProduct() {
        return new ConcreteProductD();
    }
}