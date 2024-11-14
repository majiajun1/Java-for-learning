import java.util.ArrayList;
import java.util.*;
public class Difference2215 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {2, 4, 6};


        List<List<Integer>> ans = findDifference(nums,nums2);
        System.out.println(ans);

    }
    public static  List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        for(int num :set1)  //hashset的性质就是不重复的
        {
            if(!set2.contains(num) )
            {

                list1.add(num);
            }
        }
         for(int num : set2)  //hashset的性质就是不重复的
        {
            if(!set1.contains(num))
            {

                 list2.add(num);
            }
        }
         List<List<Integer>> ans = new ArrayList<>();
         ans.add(list1);
         ans.add(list2);


        return ans;
    }

        public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) { // 更慢了
        // 初始化Set
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        // 计算在 nums1 中但不在 nums2 中的元素
        HashSet<Integer> uniqueInNums1 = new HashSet<>(set1);
        uniqueInNums1.removeAll(set2);

        // 计算在 nums2 中但不在 nums1 中的元素
        HashSet<Integer> uniqueInNums2 = new HashSet<>(set2);
        uniqueInNums2.removeAll(set1);

        // 转换为 List
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(uniqueInNums1));
        ans.add(new ArrayList<>(uniqueInNums2));

        return ans;
    }
}
