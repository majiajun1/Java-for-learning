abstract class Handler {
    protected Handler nextHandler;

    // 设置下一个处理者
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 处理请求
    public abstract void handleRequest(int request);
}



// 具体处理者1：处理 1-5 的请求
class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 1 && request <= 5) {
            System.out.println("ConcreteHandler1 处理请求: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request); // 传递给下一个处理者
        }
    }
}

// 具体处理者2：处理 6-10 的请求
class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 6 && request <= 10) {
            System.out.println("ConcreteHandler2 处理请求: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// 具体处理者3：处理 11-15 的请求
class ConcreteHandler3 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 11 && request <= 15) {
            System.out.println("ConcreteHandler3 处理请求: " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}



public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // 创建处理者
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        // 设置责任链
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        // 向链条发送请求
        System.out.println("请求 3:");
        handler1.handleRequest(3);

        System.out.println("\n请求 8:");
        handler1.handleRequest(8);

        System.out.println("\n请求 12:");
        handler1.handleRequest(12);

        System.out.println("\n请求 20:");
        handler1.handleRequest(20);
    }
}