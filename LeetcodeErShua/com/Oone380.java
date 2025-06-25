/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Oone380 {

    public static void main(String[] args) {


    }

    class RandomizedSet {

        HashSet<Integer> set;

        public RandomizedSet() {
            set = new HashSet<>();

        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            }else
            {
                set.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                return true;
            }else
            {
                return false;
            }
        }

        public int getRandom() {
            Random rand = new Random();
            Integer[] arr = set.toArray(new Integer[set.size()]);
            return arr[rand.nextInt(arr.length)];
        }
    }

}
