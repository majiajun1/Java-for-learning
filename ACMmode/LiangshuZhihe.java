import java.util.ArrayDeque;
import java.util.ArrayList;

public class LiangshuZhihe {

    public static void main(String[] args) {
//        int[] arr={1,2,3,4,5};
//        int target=7;
//        for (int i:LiangShu(arr,target))
//        {
//            System.out.println(i);
//        }

        String example="123";
        System.out.println(StringToInt(example));

    }


//    public static int[] LiangShu(int[ ] nums,int target)
//    {
//
//        int index1=0;
//        int index2=nums.length-1;
//        while(index1<index2)
//        {
//            if(nums[index1]+nums[index2]==target)
//            {
//                return new int[]{index1,index2};
//            }
//            else if(nums[index1]+nums[index2]>target)
//            {
//                index2--;
//            }else{
//                index1++;
//            }
//        }
//        return  null;
//    }


    public static int  StringToInt(String str)
    {
        ArrayList<Character> chars = new ArrayList<Character>();
        for(char c:str.toCharArray())
        {
            chars.add(c);
        }
        int ans=0;

        for(int i=chars.size()-1;i>=0;i++)
        {
            if(i==chars.size()-1)
            {
                ans=ans+ (chars.get(i)-'0');
            }else
            {
                ans=ans+ ((chars.get(i)-'0'))*10;
            }


        }

        return ans;
    }


}
