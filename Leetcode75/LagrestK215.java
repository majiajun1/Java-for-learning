import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LagrestK215 {

    public static void main(String[] args) {
        int[]  nums={3,2,1,4,5,6,4};
        int k=2;
//        System.out.println(findKthLargest(nums,k));
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        //Collections.sort();
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    /*重点是底层实现
    //Collection sort用的是list sort
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
    //而list.sort又是用的Arrays.sort 只不过是先转成arrays了
    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
     arrays.sort有多种重载方法 所以不一样
       最后实际上调用的是
       基本类型使用 双轴快速排序（效率高但不稳定）。
        对象类型使用 TimSort（效率高且稳定）。
     */

    public static int findKthLargest2(int[] nums, int k) {
        //试试堆排序
        heapSort(nums);
        return nums[nums.length-k];
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

         //依次将堆顶元素与末尾元素交换，并调整堆
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // 调整堆函数
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 当前节点
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 找出最大值的位置
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前节点，交换并递归调整
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
