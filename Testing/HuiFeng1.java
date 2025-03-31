import java.util.HashMap;

public class HuiFeng1 {
    public String encrypt(String text) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('A','E');
        map.put('B','F');
        map.put('C','G');
        map.put('D','H');
        map.put('E','I');
        map.put('F','J');
        map.put('G','K');
        map.put('H','L');
        map.put('I','M');
        map.put('J','N');
        map.put('K','O');
        map.put('L','P');
        map.put('M','Q');
        map.put('N','R');
        map.put('O','S');
        map.put('P','T');
        map.put('Q','U');
        map.put('R','V');
        map.put('S','W');
        map.put('T','X');
        map.put('U','Y');
        map.put('V','Z');
        map.put('W','A');
        map.put('X','B');
        map.put('Y','C');
        map.put('Z','D');
        StringBuilder result = new StringBuilder();
        for(char ch :text.toCharArray()){
            if(map.containsKey(ch)){
                result.append(map.get(ch));
            }
        }
        return result.toString();

    }
}
