

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class StockSpanner901 {
    public static void main(String[] args) {

    StockSpanner901 s = new StockSpanner901();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));
    }

    static  ArrayDeque<Integer> index;
    static ArrayDeque<Integer> stockprice;
    static int day;




     public StockSpanner901() {
         index = new ArrayDeque<>();
         stockprice = new ArrayDeque<>();
         day = 0;
    }


    public static int next(int price) {
         int ans=1;
         while(!stockprice.isEmpty()&&price>=stockprice.peek())
         {
             stockprice.pop();
             index.pop();
         }
         if (!index.isEmpty()) {
            ans = day - index.peek();
        } else {
            ans = day + 1; // 栈为空时跨度为当前天数加 1
        }

         stockprice.push(price);
         index.push(day);
         day++;

         return ans;

    }
}
