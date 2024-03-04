//排列数  2019年第十届国赛 lanqiaoOJ 240

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        int[][] dp = new int[N+1][K+1];
        dp[1][1]=1;
        dp[2][1]=2;
        for(int i=3;i<=N;i++){
            for(int j=1;j<=i&&j<=K;j++){
            dp[i][j] += dp[i - 1][j] * j;
            dp[i][j]%=123456;
            dp[i][j] += dp[i - 1][j - 1] * 2;
            dp[i][j]%=123456;
            if (j > 1){
                dp[i][j] += dp[i - 1][j - 2] * (i - j);
                dp[i][j]%=123456;
            }
            }
        }
        System.out.println(dp[N][K]);

    }
}