public class ChooseSort {
    public static void main(String[] args) {
        int[] arr={2,4,1,2,5,6,2,8};
        sort(arr);
        for(int i:arr)
        {
            System.out.print (i+" ");
        }

    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int cur=arr[i];
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<cur){
                    cur=arr[j];
                    index=j;
                }
            }
            if(index!=i){
                 swap(arr,i,index);
            }

        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
