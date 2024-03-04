//小明的背包2  lanqiaoOJ 1175

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int n=input.nextInt();
            int m=input.nextInt();
            int w[]=new int [n+1];
            int v[]=new int [n+1];
            int dp[]=new int [m+1];
            for (int i=1;i<=n;i++)
            {
                w[i]=input.nextInt();
                v[i]=input.nextInt();
            }
            for (int i=1;i<=n;i++)
                for (int j=w[i];j<=m;j++)
                {
                    dp[j]=max(dp[j],dp[j-w[i]]+v[i]);
                }
            System.out.println(dp[m]);


        }
        static int max(int a,int b) {return a >=b ? a:b;}
 }