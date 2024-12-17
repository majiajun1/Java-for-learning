package JVM;

import java.util.ArrayList;

//Dump


//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
public class JProfilerTest {
    byte[] array=new byte[1024*1024];

    public static void main(String[] args) {
        ArrayList<JProfilerTest> list=new ArrayList<>();
        int count=0;

        try{
            while(true){
                list.add(new JProfilerTest());
                count=count+1;

            }
        }catch (Exception e){
            System.out.println("count:"+count);
            System.out.println("========");
            e.printStackTrace();
        }
    }
}
