//发现环  2017年第八届决赛   lanqiaoOJ 108
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
     
    static int n;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] vis;
    static int[] pre;       //前驱结点
    static int[] ans;       //环路上的点
    static int count = 0;   //回路中点的数量
    static int flag = 0;    //是否找到回路
     
     
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
         
        vis = new int[n+1];
        pre = new int[n+1];
        ans = new int[n+1];
         
        for(int i = 1; i <= n; i++)
            list.add(new ArrayList<Integer>());
         
        //存储邻接矩阵
        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.get(x-1).add(y);
            list.get(y-1).add(x);
        }
         
        vis[1] = 1;
        dfs(1, 0);
         
        Arrays.sort(ans, 0, count);
        for(int i = 0; i < count - 1; i++)
            System.out.printf("%d ", ans[i]);
        System.out.println(ans[count - 1]);
    }
     
    public static void dfs(int cur, int father) {
         
        for(int i = 0; i < list.get(cur - 1).size(); i++) {
            //获取邻接点
            int son = list.get(cur - 1).get(i);
            //跳过父节点
            if(son == father)
                continue;
            //将当前结点设为邻接点的前驱结点
            pre[son] = cur;
             
            //该邻接点已被访问过则找到环
            if(vis[son] == 1) {
                 
                //找到环上所有结点
                int tmp = son;
                do {    
                    ans[count++] = tmp;
                    tmp = pre[tmp];
                     
                }while(tmp != son);
                 
                flag = 1;
                return;
            }
             
            vis[son] = 1;
            dfs(son, cur);
            if(flag == 1)
                return;
        }
    }
     
}
 