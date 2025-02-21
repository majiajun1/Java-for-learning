public class WDTest {
    public static void main(String[] args) {

        WordDictionary wd=new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
    }
}
