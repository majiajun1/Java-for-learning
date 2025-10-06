public class SimpleFactoryLearn {
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.doSomething(); // Output: Product A

        Product productB = ProductFactory.createProduct("B");
        productB.doSomething(); // Output: Product B
    }
}

// 产品接口
interface Product {
    void doSomething();
}

// 具体产品
  class ConcreteProductA implements Product {
    public void doSomething() {
        System.out.println("Product A");
    }
}

  class ConcreteProductB implements Product {
    public void doSomething() {
        System.out.println("Product B");
    }
}

// 工厂类
  class ProductFactory {
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        } else if ("B".equals(type)) {
            return new ConcreteProductB();
        }
        return null;
    }
}