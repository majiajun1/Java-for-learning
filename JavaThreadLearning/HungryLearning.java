
//饿汉式
public class HungryLearning {
    private byte[]  data1=new byte[1024*1024];
    private byte[]  data2=new byte[1024*1024];
    private byte[]  data3=new byte[1024*1024];
    private byte[]  data4=new byte[1024*1024];
    //可能会浪费空间


    private HungryLearning(){

    }

    private final static HungryLearning hungryLearning = new HungryLearning();

    public static HungryLearning getInstance(){
        return hungryLearning;
    }

}
