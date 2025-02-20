import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;

public class ChuFaQiuZhi399ERSHUA {  //{{"a","b"}, {"b","c"}}

    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c"),
            Arrays.asList("bc", "cd")
        );

        double[] values = {1.5,2.5,5.0};
                List<List<String>> list2 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("c", "b"),
            Arrays.asList("bc", "cd"),
            Arrays.asList("cd", "bc")
        );

//        calcEquation(list,values,list2);


    }

//     public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//         LinkedHashMap<String, Double> map = new LinkedHashMap<>();
//         LinkedHashMap<String, ArrayList<String>> map2 = new LinkedHashMap<>();
//
//
//         for (int i = 0; i < equations.size(); i++) {
//             StringBuilder sb = new StringBuilder();
//             for (int j = 0; j < equations.get(i).size(); j++) {
//                 sb.append(equations.get(i).get(j));
//             }
//             if(sb.length()>2)
//             {
//                 sb= new StringBuilder(sb.substring(0, 1) + sb.substring(sb.length() - 1, sb.length()));
//             }
//
//             map.put(sb.toString(), values[i]);
//             map2.computeIfAbsent(sb.substring(0, 1), k -> new ArrayList<>())
//    .add(sb.substring(sb.length() - 1, sb.length()));
//
//         }
//
//         for (Map.Entry<String,  ArrayList<String>> entry : map2.entrySet()) {
//             String key = entry.getKey();
//             ArrayList<String> temp=entry.getValue();
//             temp.add(key);
//             map.put(key + key, 1.0);
//             for(int i=0;i<temp.size();i++)
//             {
//                 String cur=temp.get(i);
//                 if(!map2.containsKey(cur))
//                 {
//                     map.put(cur+cur, 1.0);
//                     map2.computeIfAbsent(cur, k -> new ArrayList<>())
//    .add(cur);
//                 }
//
//
//                 if(!map.containsKey(cur+key))
//                 {
//                     if(map.containsKey(key+cur))
//                     {
//                         map.put(cur+key,1.0/map.get(key+cur));
//                         if(map2.containsKey(cur))
//                         {
//                         ArrayList<String> addlist=map2.get(cur);
//                         addlist.add(key);
//                         }else
//                         {
//                             ArrayList<String> addlist=new ArrayList<>();
//                             addlist.add(key);
//                             map2.put(cur,addlist);
//                         }
//
//                     }
//                 }
//             }
//         }
//
//         List<Double> ans = new ArrayList<>();
//        for (int i = 0; i < queries.size(); i++) {
//            List<String> curlist=queries.get(i);
//            String cur=curlist.get(0)+new StringBuilder(curlist.get(1)).reverse().toString();
//            if(cur.length()>2) {
//                double temp=1;
//                int index1 = 0;
//                int index2 = 1;
//
//                while (index2 < cur.length()) {
//                    String curnow = cur.substring(index1, index2 + 1);
//                    if(map.containsKey(curnow))
//                    {
//                        temp=temp*map.get(curnow);
//                    }else
//                    {
//                        temp=temp*(-1.0);
//                    }
//                }
//                ans.add(temp);
//
//            }else
//            {
//                if(map.containsKey(cur))
//                {
//                    ans.add(map.get(cur));
//                }else
//                {
//                    ans.add(-1.0);
//                }
//            }
//        }
//        double[] array = ans.stream().mapToDouble(Double::doubleValue).toArray();
//
//
//
//
//
//
//         return array;
//     }


}
