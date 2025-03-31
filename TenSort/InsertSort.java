public class InsertSort {
    public static void main(String[] args) {
         int[] arr={14,1,3,5,6,2,8};
         insertSort(arr);
         for(int i:arr)
         {
             System.out.print(i+" ");
        }

    }

    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int cur=arr[i];
            int index=i-1;
            while(index>=0 && arr[index]>cur){
                arr[index+1]=arr[index];
                index--;
            }
            arr[index+1]=cur;



        }
    }



}
