import java.util.*;

public class Concil649 {
    public static void main(String[] args) {
        String senate="RD";
        String ans=predictPartyVictory(senate);
        System.out.println(ans);
    }

    public static String predictPartyVictory(String senate) {
        //创建一个队列
        Queue<Character> queue = new LinkedList();
        int len = senate.length();

        int radiant = 0;
        int dire = 0;
        //杀死R阵营的次数
        int killRadiant = 0;
        //杀死D阵营的次数
        int killDire = 0;

        for(int i=0;i<len;i++){
            char c = senate.charAt(i);
            if(c=='R'){
                radiant++;
            }else{
                dire++;
            }
            queue.add(c);
        }
        //都不同时为0才继续
        while(radiant!=0&&dire!=0){
            char c = queue.remove();
            if(c=='R'){
                if(killRadiant==0){
                    queue.add('R');
                    killDire++;
                }else{
                    killRadiant--;
                    radiant--;
                }
            }
            if(c=='D'){
                if(killDire==0){
                    queue.add('D');
                    killRadiant++;
                }else{
                    killDire--;
                    dire--;
                }
            }
        }
        return radiant!=0? "Radiant":"Dire";

    }
}
