import java.util.LinkedList;
import java.util.Queue;

public class CorruptedOrange994 {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int answer= orangesRotting(grid);
        System.out.println(answer);
    }
    public static int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        int fresh=0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()&&fresh>0){
            int q_len=queue.size();
            for(int i=0;i<q_len;i++){
                int[] cur=queue.poll();
                for(int[] d:directions)
                {
                    int x=cur[0]+d[0];
                    int y=cur[1]+d[1];
                    if(x<0||x>grid.length-1||y<0||y>grid[0].length-1||grid[x][y]!=1){
                        continue;
                    }
                    grid[x][y]=2;
                    queue.add(new int[]{x,y});
                    fresh--;

                }

            }
            time++;
        }
        if(fresh!=0){
            return -1;
        }else
        {
            return time;
        }
    }

}
