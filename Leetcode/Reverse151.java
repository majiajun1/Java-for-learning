import java.util.ArrayList;

public class Reverse151 {
    public static void main(String[] args) {
        String str="the sky is blue";
        System.out.println(reverseWords(str));

    }
    public static String reverseWords(String s) {
        int index=0;

        StringBuilder sb=new StringBuilder();
        ArrayList<String> list=new ArrayList<>();

        while(index<s.length()){
            if(s.charAt(index)==' '){
                if(sb.length()!=0){
                     list.add(sb.toString());
                }

                sb.setLength(0);


            }
            else {

                sb.append(s.charAt(index));
            }
            index++;
        }
        if(sb.length()!=0){list.add(sb.toString());}

        sb.setLength(0);
        for (int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i));
            if(i!=0){
                sb.append(" ");
            }

        }

        return sb.toString();
    }
}
