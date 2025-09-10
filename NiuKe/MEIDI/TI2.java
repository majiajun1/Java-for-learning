package MEIDI;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class TI2 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StringBuilder prefix=new StringBuilder();
            String curA="";
            String curB="";
            while (sc.hasNextLine())
            {
                String curline=sc.nextLine();
                int index=0;
                for(int i=0;i<curline.length();i++)
                {
                    if(curline.charAt(i)==' ')
                    {
                        index++;

                    }else
                    {
                        break;
                    }
                }
                curline=curline.substring(index,curline.length());
                if(curline.equals("#"))
                {
                    System.out.println(curline);
                    break;
                }
                if(curline.substring(0,2).equals("-A"))
                {
                    curA=new String(curline.substring(0,3));
                    System.out.println(curline);
                    continue;
                }

                if(curline.charAt(0)=='B')
                {
                    String[] temp=curline.split(":");
                    curB=new String(temp[0]);
                    System.out.println(curA+'-'+curline);
                    continue;
                }

                if(curline.charAt(0)=='C')
                {

                    System.out.println(curA+'-'+curB+'-'+curline);
                }
            }
    }
}
