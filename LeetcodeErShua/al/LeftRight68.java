package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRight68 {
    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        fullJustify(words,16);
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        int index = 0;
        List<String> singleLine=new ArrayList<>();
        int curLine=0;
        int curLength=0;
        while(index<words.length)
        {
            while(index<words.length&& curLine+words[index].length()<=maxWidth)
            {
                 curLine+=words[index].length();
                 curLength+=words[index].length();
                 curLine++;
                 singleLine.add(words[index]);
                 index++;
            }
            boolean lastrow=false;
            if(index>=words.length)
            {
                lastrow=true;
            }
            list.add(combie(singleLine,curLength,maxWidth,lastrow));
            singleLine=new ArrayList<>();
            curLine=0;
            curLength=0;


        }
        return list;
    }

    public static String combie(List<String> list,int curLength,int maxWidth,boolean lastrow)
    {

         int prefixNum=maxWidth-curLength;
         int positionBlank=list.size()-1;
         int[]  numBlank=new int[positionBlank];
         StringBuilder result=new StringBuilder();
         if(positionBlank==0)
         {
             result.append(list.get(0));
             result.append(" ".repeat(prefixNum));
             return result.toString();
         }
         Arrays.fill(numBlank,prefixNum/positionBlank);
         int lastBlank=prefixNum%positionBlank;
         int index=0;
         while(lastBlank>0)
         {
             numBlank[index++]++;
             lastBlank--;
         }

         if(!lastrow){
         for (int i=0;i<list.size()-1;i++)
         {
             result.append(list.get(i));
             result.append(" ".repeat(numBlank[i]));
         }
         result.append(list.get(list.size()-1));
         }else
         {
             for (int i=0;i<list.size()-1;i++)
                 {
                     result.append(list.get(i));
                     result.append(" ");
                 }
             result.append(list.get(list.size()-1));
             while (result.length()<maxWidth)
             {
                 result.append(" ");
             }
         }

         return result.toString();

    }

}
