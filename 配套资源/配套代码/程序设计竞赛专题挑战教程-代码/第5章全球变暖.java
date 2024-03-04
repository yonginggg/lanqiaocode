//全球变暖 2018年第九届蓝桥杯省赛C/C++大学A组、B组，Java大学A组、B组
//lanqiaoOJ 178
import java.util.*;
public class Main{
    static class node{
        int x,y;
        node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static char mp[][];
    static int vis[][];
    static int flag ;
    static int[][] d = {{0,1}, {0,-1}, {1,0}, {-1,0}}; //四个方向
    static void bfs(int x,int y) {
        Queue<node> que=new LinkedList<node>();
        que.add(new node(x,y));
        vis[x][y] = 1;

        while(!que.isEmpty()) {
            node t = que.remove();
            int tx=t.x, ty=t.y;
            if( mp[tx][ty+1]=='#' && mp[tx][ty-1]=='#' &&
                mp[tx+1][ty]=='#' && mp[tx-1][ty]=='#'   )
                flag = 1; //上下左右都是陆地，不会淹没
            for(int i=0;i<4;i++) {
                int nx = tx + d[i][0], ny = ty + d[i][1];
                  if(vis[nx][ny]==0 && mp[nx][ny]=='#'){
                    vis[nx][ny]=1;
                    que.add(new node(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args){
        int n,ans=0;
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        mp = new char[n][n];
        vis = new int[n][n];
        for(int i=0;i<n;i++)
            mp[i]=sc.next().toCharArray();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(mp[i][j]=='#' && vis[i][j]==0){
                    flag = 0;
                    bfs(i,j);
                    if(flag == 0)
                        ans ++;
                }
        System.out.println(ans);
    }
}
