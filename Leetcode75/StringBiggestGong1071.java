import java.util.ArrayList;

public class StringBiggestGong1071 {
    public static void main(String[] args) {
        String str1="ABABAB";
        String str2="ABAB";
        String ans=gcdOfStrings(str1,str2);
        System.out.println(ans);
    }

    public static String gcdOfStrings(String str1, String str2) {  //欧几里得算法又称辗转相除法，是指用于计算两个非负整数a，b的最大公约数
        //以除数和余数反复做除法运算，当余数为 0 时，取当前算式除数为最大公约数
        //双指针

        int a = str1.length();
        int b = str2.length();
        if ((str1 + str2) .equals (str2 + str1)) {
            return "";

        }
        while(a != 0) {
            int temp = a; //temp是上一个除数
            a = b % a;//a是余数
            b = temp;
        }

        return str1.substring(0, b);


    }
}
