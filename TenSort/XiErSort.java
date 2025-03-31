public class XiErSort {

         public static void main(String[] args) {
         int[] arr={14,1,3,5,6,2,8};
          Sort(arr);
         for(int i:arr)
         {
             System.out.print(i+" ");
        }

    }

    public static  void Sort(int[] arr)
    {
        int gap=arr.length/2;

        while(gap>0)
        {
           for(int i=gap;i<arr.length;i++){
            int cur=arr[i];
            int index=i-gap;
            while(index>=0 && arr[index]>cur){
                arr[index+gap]=arr[index];
                index-=gap;
            }
            arr[index+gap]=cur;



        }
           gap=gap/2;
        }
    }



}
