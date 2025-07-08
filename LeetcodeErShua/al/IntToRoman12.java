/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.HashMap;
import java.util.function.BiFunction;

public class IntToRoman12 {
    public static void main(String[] args) {
        int num=101;
        System.out.println(intToRoman(num));

    }
    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int weiShu=1;
        int yuShu=0;
        if(num==10){
            return "X";
        }else if(num==100){return "C";}
        else if(num==500){return "D";}
        else if(num==1000){return "M";}
        while(num > 0){
            yuShu=num%10;
            num=num/10;
            roman.insert(0,deal(yuShu,weiShu++));


        }
        return roman.toString();
    }
    public static String deal(int num,int weiShu){
        if(weiShu==1){
            if(num==0)
            {
                return "";
            }
            if(num==1){
                return "I";
            }else if(num==2){
                return "II";
            }else if(num==3){
                return "III";
            }else if(num==4){
                return "IV";
            }else if(num==5){
                return "V";
            }else if (num==6){
                return "VI";
            }else if(num==7){
                return "VII";
            }else if(num==8){
                return "VIII";
            }else if(num==9){
                return "IX";
            }
        }else if(weiShu==2){
            if(num==0)
            {
                return "";
            }
            if(num==1){
                return "X";
            }else if(num==2){
                return "XX";
            }else if(num==3){
                return "XXX";
            }else if(num==4){
                return "XL";
            }else if(num==5){
                return "L";
            }else if(num==6){
                return "LX";
            }else if(num==7){
                return "LXX";
            }else if(num==8){
                return "LXXX";
            }else if(num==9){
                return "XC";
            }
        }else if(weiShu==3){
            if(num==0)
            {
                return "";
            }
            if(num==1){
                return "C";
            }else if(num==2){
                return "CC";
            }else if (num==3){
                return "CCC";
            }else if(num==4){
                return "CD";
            }else if(num==5){
                return "D";
            }else if(num==6){
                return "DC";
            }else if(num==7){
                return "DCC";
            }else if(num==8){
                return "DCCC";
            }else if(num==9){
                return "CM";
            }
        }else if(weiShu==4){
            if(num==0)
            {
                return "";
            }
            StringBuilder temp=new StringBuilder();
            for (int i=0;i<num;i++){
                temp.append("M");
            }
            return temp.toString();
        }
        return null;
    }
}
