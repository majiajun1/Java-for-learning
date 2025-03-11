import java.util.*;

public class MeiTuan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> mapY = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> mapX = new HashMap<>();
        ArrayList<int[]> listpoint = new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            listpoint.add(new int[]{x,y});
            if(mapX.containsKey(x)){
                ArrayList<Integer> list = mapX.get(x);
                list.add(y);

            }else {
                mapX.put(x,new ArrayList<>());
                ArrayList<Integer> list = mapX.get(x);
                list.add(y);}

            if(mapY.containsKey(y)){
                ArrayList<Integer> list = mapY.get(y);
                list.add(x);
            }else {
                mapY.put(y,new ArrayList<>());
                ArrayList<Integer> list = mapY.get(y);
                list.add(x);
            }

        }
        //遍历每一只棋子
        for(int i=0;i<listpoint.size();i++){
            int x=listpoint.get(i)[0];
            int y=listpoint.get(i)[1];
            int sum=0;
            int left=0;
            int right=0;
            int up=0;
            int down=0;
            if(mapX.containsKey(x)){  //拿到这一行的
                ArrayList<Integer> list = mapX.get(x);
                Collections.sort(list);
                for(int ytemp:list)
                {
                                    if(left>=2) {
                    sum++;
                }
                if(right>=2) {
                    sum++;
                }
                if(left>=2&&right>=2) {
                    break;
                }
                    if(ytemp>y)
                        right++;
                    else if(ytemp<y) {
                        left++;
                    }
                }
                ArrayList<Integer> list2 = mapY.get(y);
                Collections.sort(list2);
                for(int xtemp:list2)
                {
                                    if(up>=2)
                {
                    sum++;
                }
                if(down>=2)
                {
                    sum++;
                }
                if(up>=2&&down>=2) {
                    break;
                }
                    if(xtemp>x)
                    {
                        up++;
                    }else if(xtemp<x) {
                        down++;
                    }
                }


                System.out.println(sum);
            }
        }




        }
    }

