import java.util.HashMap;
import java.util.Map;

public class IntToRoman12 {
    public static void main(String[] args) {
        int num=3749;
        System.out.println(intToRoman2(num));
    }

    public static String intToRoman(int num) {
        Map<Integer,String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        while (num!=0)
        {
            if(num>=1000)
            {
                num=num-1000;
                builder.append(map.get(1000));

            }
            else if (num>=900)
            {
                num=num-900;
                builder.append(map.get(900));
            }
            else if (num>=500)
            {
                num=num-500;
                builder.append(map.get(500));
            }
            else if(num>=400)
            {
                num=num-400;
                builder.append(map.get(400));
            }
            else if (num>=100)
            {
                num=num-100;
                builder.append(map.get(100));
            }
            else if(num>=90)
            {
                num=num-90;
                builder.append(map.get(90));
            }
            else if(num>=50)
            {
                num=num-50;
                builder.append(map.get(50));
            }
            else if (num>=40)
            {
                num=num-40;
                builder.append(map.get(40));
            }
            else if (num>=10)
            {
                num=num-10;
                builder.append(map.get(10));

            }
            else if (num>=9)
            {
                num=num-9;
                builder.append(map.get(9));
            }
            else if(num>=5)
            {
                num=num-5;
                builder.append(map.get(5));
            }
            else if(num>=4)
            {
                num=num-4;
                builder.append(map.get(4));
            }
            else if (num>=1)
            {
                num=num-1;
                builder.append(map.get(1));
            }

        }
        return builder.toString();

    }
    public static String intToRoman2(int num) { //更快
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < values.length; i++) {
        while (num >= values[i]) {
            num -= values[i];
            builder.append(symbols[i]);
        }
    }

    return builder.toString();
}

}
