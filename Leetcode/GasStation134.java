public class GasStation134 {
    public static void main(String[] args) {
        int[]  gas={1,2,3,4,5};
        int[]  cost={3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));

    }

    public static   int canCompleteCircuit2(int[] gas, int[] cost) { //too slow
        int realgas=0;
        for (int i = 0; i < gas.length; i++) {
            int index=i;
            realgas=gas[i];

            while (realgas>=cost[index])
            {
                realgas-=cost[index];
                index++;
                 if(index==gas.length)
                {
                    index=0;
                }
                 if(index==i)
                {
                    return index;
                }
                realgas+=gas[index];


            }


        }
        return -1;
    }


    public static   int canCompleteCircuit(int[] gas, int[] cost) { //too slow

        int cursum=0;
        int totalsum=0;
        int start=0;
        for (int i = 0; i < gas.length; i++) {
            cursum+=(gas[i]-cost[i]);
            totalsum+=(gas[i]-cost[i]);
            if(cursum<0)  //局部推全局
            {
                start=i+1;
                cursum=0;
            }
        }
        if(totalsum<0) return -1;
        return start;

    }
}
