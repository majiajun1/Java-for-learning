/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

import java.util.ArrayList;
import java.util.Arrays;

public class Gas134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {  //not finished

        ArrayList<Integer> list = new ArrayList<>();//possible entry
        for (int i = 0; i < gas.length; i++) {

            if(gas[i]>=cost[i]) list.add(i);

        }



        return 1;
    }
}
