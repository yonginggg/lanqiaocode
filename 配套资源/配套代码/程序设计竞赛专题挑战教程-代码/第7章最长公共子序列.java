//最长公共子序列   lanqiaoOJ 1189

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[m+1];
        for(int i=1;i<n+1;i++) a[i] = sc.nextInt();
        for(int i=1;i<m+1;i++) b[i] = sc.nextInt();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(a[i]==b[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);

    }
}