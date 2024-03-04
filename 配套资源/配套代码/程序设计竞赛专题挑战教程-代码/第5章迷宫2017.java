//迷宫  2017年第八届蓝桥杯省赛C/C++大学A组，Java大学A组  lanqiaoOJ 641



import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    static char[][] arr;
    static int[][] vis;
    static int ans=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new char[10][10];
        for(int i = 0;i<arr.length;i++) {
            String s = sc.next();
            arr[i] = s.toCharArray();
        }
        for(int i = 0;i<arr.length;i++) {
            for(int j = 0;j<arr[0].length;j++) {
                vis = new int[10][10];
                dfs(i,j);
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int x,int y) {
        if(x<=-1 || y>=10 ||x>=10 || y<=-1) {
            ans++;
            return;
        }
        if(vis[y][x]==1) {
            return;
        }
        vis[y][x]=1;
        if(arr[y][x]=='U') {
            dfs(x,y-1);
        }
        if(arr[y][x]=='D') {
            dfs(x,y+1);
        }
        if(arr[y][x]=='L') {
            dfs(x-1,y);
        }
        if(arr[y][x]=='R') {
            dfs(x+1,y);
        }
    }
}