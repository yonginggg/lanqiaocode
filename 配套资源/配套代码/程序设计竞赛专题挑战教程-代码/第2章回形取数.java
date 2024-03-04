//回形取数    lanqiaoOJ 1517

import java.util.Scanner;
public class Main {
static int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] a = new int[m][n];
        for(int i=0; i<m; ++i)
            for(int j=0; j<n; ++j)
                a[i][j] = sc.nextInt();

        int x = -1, y = 0, d = 0, sum = 0;
        while(sum < m*n) {
            sum ++;
            int nx = x+dir[d][0], ny = y+dir[d][1];
            if(nx<0 || ny<0 || nx>=m || ny>=n || a[nx][ny]==-1) {
                d = (d+1)%4;
                x = x+dir[d][0];
                y = y+dir[d][1];
            }else {
                x = nx;
                y = ny;
            }
            System.out.print(a[x][y]+" ");
            a[x][y] = -1;    //标记这个坐标点已经取过
        }
    }
}
