import java.util.Scanner;

public class Meidi03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input=sc.nextLine();
        String[] words = input.split(" ");
        String deal=words[0];
        int num=Integer.parseInt(words[1]);
        StringBuilder sb=new StringBuilder();
        if(num<=0)
        {
            System.out.println("ERROR");
            return;
        }




        int count=1;
        for(int i=0;i<deal.length();i++)
        {
            char ch=deal.charAt(i);
            if(!(ch>='a'&&ch<='z') )
            {
                System.out.println("ERROR");
                 
            }else
            {
                sb.append(ch);
                count++;
                if(count>num&&i<deal.length()-1)
                {
                    sb.append(",");
                    count=1;
                }

            }

        }
        String[] finalWords=sb.toString().split(",");
        String last=finalWords[finalWords.length-1];
        if(last.length()<num)
        {
            for(int i=0;i<num-last.length();i++)
            {
                sb.append("0");
            }
        }
        System.out.println(sb);
    }
}
