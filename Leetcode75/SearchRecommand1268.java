import java.util.*;

public class SearchRecommand1268 {
    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord="mouse";

        List<List<String>> ans=suggestedProducts(products, searchWord);
        System.out.println(ans);
    }



    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
         Trie208  temp = new Trie208();

         Arrays.sort(products);



        for (String product : products) {

            temp.insert(product);
        }
//        temp.printTrie(temp.root,"");
        List<List<String>> ans=new ArrayList<>();
        Trie208.TrieNode cur= temp.root;
        StringBuilder temp2=new StringBuilder();
         for (char c : searchWord.toCharArray()) {
             temp2.append(c);


             if (!cur.children.containsKey(c) ) {
                // 如果当前字符在Trie中不存在，补充空列表
                 int length=searchWord.length()-temp2.length();
                 for(int i=0;i<=length;i++){
                     ans.add(new ArrayList<>());
                 }
                break;
            }
           else cur = cur.children.get(c);




            List<String> list=new ArrayList<>();

            getAllWordsFromNode(cur ,list,temp2.toString());
             Collections.sort(list);

            if (list.size() > 3) {
                list = list.subList(0, 3);
            }
            ans.add(list);

        }
        return ans;
    }




    public static  void getAllWordsFromNode (Trie208.TrieNode node, List<String> list,String prefix){

        if(node==null ){
            return;
        }
        if(node.isWord)
        {

            list.add(prefix);
        }


        for (Map.Entry<Character, Trie208.TrieNode> entry : node.children.entrySet()) {
            // 递归调用，拼接字符
//             System.out.println("Current prefix: " + prefix + ", visiting child: " + entry.getKey());

            getAllWordsFromNode(entry.getValue(),  list,prefix + entry.getKey() );
        }




    }
}
