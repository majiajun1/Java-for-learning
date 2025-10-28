/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gas134 {
    public static void main(String[] args) {
        int[] gas= {1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        canCompleteCircuit(gas,cost);

    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {  //not finished
        int n = gas.length;
        int total = 0;   // 全局差值
        int tank = 0;    // 当前候选起点的油量
        int start = 0;   // 候选起点

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            // 如果当前 tank 不能到达 i+1，则任何在 [start, i] 的点都不可能
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? (start % n) : -1;






    }
}
