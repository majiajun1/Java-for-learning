package HaiKang;

public class Titwo {
    static final int minValue=1+2+3+4;
    public int[] minimumNumber (int[] target) {
        // write code here
        int[] answer = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            int cur=target[i];

                if(cur<minValue)
            {
                answer[i]=-1;
                continue;
            }else if(cur==minValue)
            {
                answer[i]= 4;
                continue;
            }
                int count=(cur-minValue+3)/4;
                answer[i]=count+4;


        }
        return answer;

    }



}
