import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MinGenechange433 {
    public static void main(String[] args) {
        minMutation("AACCGGTT","AACCGGTA",new String[]{"AACCGGTA"});
    }


        public static int minMutation(String startGene, String endGene, String[] bank) {
            ArrayDeque<String> stack = new ArrayDeque<>();
            HashMap<String,Integer> map = new HashMap<>();
            if(startGene.equals("endGene")){return 0;}


            stack.addFirst(startGene);
            map.put(startGene,0);
            while (!stack.isEmpty()) {
                String gene = stack.removeLast();
                int steps=map.get(gene);
                if (gene.equals(endGene)) {return steps;}
                for(String i:bank)
                {
                    if(map.containsKey(i)) continue;
                    if(getHammingDistance(i,gene))
                    {
                        stack.addFirst(i);
                        map.put(i,steps+1);
                    }
                }
            }
            return -1;

    }
    public static boolean getHammingDistance(String str1, String str2) {
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException("Strings must be of equal length");
        }
        int distance = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                distance++;
            }
        }
        return distance==1;
    }
}
