import java.util.Arrays;

public class PotionsAndSpells2300 {
    public static void main(String[] args) {

        int[] spells={5,1,3};
        int[] potions={1,2,3,4,5};
        long success=7;
        int[] ans=successfulPairs(spells,potions,success);
        for(int i:ans)
        {
            System.out.println(i);
        }
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans=new int[spells.length];

        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++)
        {

            long spell=spells[i];
            int min=0,max=potions.length-1;
            while (min <= max) {
              int mid =min+(max-min)/2;

              if (  spell * potions[ mid] >= success) {

                  max=mid-1;
              } else  {
                   min=mid+1;
              }


          }
          ans[i]=  potions.length-  min;
      }
        return ans;
    }

}
