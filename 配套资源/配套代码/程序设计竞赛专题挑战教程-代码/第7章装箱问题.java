//装箱问题  lanqiaoOJ 763


import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt(); //箱子容量V
        int n=sc.nextInt(); // 物品n个
        int a[]=new int[n+1]; //n个物品的格子体积    
        for (int i = 1; i <= n; i++) {
            a[i]=sc.nextInt();
        }
        
        int[][] dp=new int[n+1][v+1];
        dp[0][0]=0;//容积为0 的时候只能放0个物品，最大容积为0
        for (int i = 1; i <= n; i++) { //容量j能放的i个物品的最大容量
            for (int j = 1; j <= v; j++) {
                if(j<a[i])  //如果当前剩余体积不够放
                    dp[i][j]=dp[i-1][j];
                else        //当前剩余体积够放：但没有放，放了
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-a[i]]+a[i]);
            }
        }
        System.out.println(v-dp[n][v]);
    }
}