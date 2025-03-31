public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 2, 1, 10 };
        BubbleSort(arr);
        for(int i:arr)
        {
            System.out.print (i);
            System.out.print(" ");
        }

    }
    public static void BubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {

            for(int j = 0; j < arr.length - 1 ; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
