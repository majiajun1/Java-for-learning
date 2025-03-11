import java.util.HashMap;
import java.util.Scanner;

public class JieXiUrl {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        int index=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!='?'&&input.charAt(i)!='/'){
                index++;
            }else
            {
                index=i;
                break;
            }
        }

        StringBuilder sb=new StringBuilder();

        HashMap<String,String> map=new HashMap<>();
        index++;
        String[] temp=new String[2];
        for(int i=index;i<input.length();i++){
             char c=input.charAt(i);
             if(c==' ')
             {
                 break;
             }

            if(c!='='&&c!='&' ){
            sb.append(c);}else if (c=='=')
            {
                temp[0]=new String(sb.toString()) ;
                sb=new StringBuilder();
            }else if(c=='&'){
                temp[1]=new String(sb.toString()) ;
                sb=new StringBuilder();
                map.put(new String(temp[0]) ,new String(temp[1]));
               temp[0]="";
               temp[1]="";
            }
            index++;
        }
        if(temp[0].length()!=0&&temp[1].length()!=0)
        {
            if(!map.containsKey(temp[0].toString()))
            {
                map.put( new String(temp[0]),new String(temp[1]));
            }
        }


        StringBuilder sb3=new StringBuilder();
        for (int k=index+1;k<input.length();k++){
            sb3.append(input.charAt(k));
        }
        if(map.containsKey(sb3.toString())){System.out.println(Integer.parseInt(map.get(sb3.toString()))  );}else
        {
            System.out.println("null");
        }

        sc.close();

    }
}
