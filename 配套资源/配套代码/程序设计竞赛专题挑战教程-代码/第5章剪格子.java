//剪格子   lanqiaoOJ 211

import java.util.Scanner;
public class Main {
    static int[][]nums;
    static int sum;
    static int ans=10000;
    static boolean[][]vis;
    static int m;
    static int n;
    static int[][] dis = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        nums = new int[n][m];
        vis = new boolean[n][m];
        sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j] = sc.nextInt();
                sum += nums[i][j];
            }
        }
        dfs(0,0,0,0);
        System.out.println(ans==10000?0:ans);
        sc.close();

    }
    static void dfs(int x,int y,int c,int s) {
        if(2*s==sum){
            if(c<ans&&vis[0][0]) ans = c;
            return;
        }
        if(2*s>sum)return;
        vis[x][y] = true;
        for(int i=0;i<dis.length;i++){
            if(x+dis[i][0]>=0&&x+dis[i][0]<n&&y+dis[i][1]>=0&&y+dis[i][1]<m&&!vis[x+dis[i][0]][y+dis[i][1]]){
                dfs(x+dis[i][0],y+dis[i][1],c+1,s+nums[x][y]);
            }
        }
        vis[x][y] = false;
    }
}