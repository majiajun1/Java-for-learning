package YuXin;

import java.io.FilterOutputStream;
import java.util.Scanner;

public class TiThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int row=sc.nextInt();
            int col=sc.nextInt();
            char[][] a=new char[row][col];
            sc.nextLine();
            for(int j=0;j<row;j++){
               String curLine= sc.nextLine();
               a[j]=curLine.toCharArray();
            }
            char[][] b=new char[col][col];
            for(int j=0;j<col;j++) {
                String curLine = sc.nextLine();
                b[j] = curLine.toCharArray();
            }

            boolean flag=false;
            for(int j=0;j<=row-col;j++) {
                for(int k=0;k<=row-col;k++) {
                    boolean match=true;
                    for(int x=0;x<col;x++) {
                        for(int y=0;y<col;y++) {
                            if(a[j+x][k+y]!=b[x][y]) {
                                match=false;
                                break;
                            }
                        }
                        if(!match)
                        {
                            break;
                        }
                    }
                    if(match)
                    {
                        flag=true;
                        break;
                    }

                }
                if(flag) break;
            }
            System.out.println(flag ? "Yes" : "No");
         }

    }


}
