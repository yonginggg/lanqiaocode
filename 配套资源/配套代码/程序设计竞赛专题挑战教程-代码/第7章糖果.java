//糖果 2019年第十届省赛  lanqiaoOJ 186

import java.util.Scanner;
public class Main {
    public static int[] dp = new int[1<<20];
    public static int[] kw = new int[125];
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt(),m=cin.nextInt(),k=cin.nextInt();
        int temp;
        for(int i=0;i<n;i++)
            for(int j=0;j<k;j++)  {
                temp = cin.nextInt();
                kw[i] |= 1<<(temp-1);
            }
        int inf = 0x3f3f3f3f;
        int tot = (1<<m) -1;
        for(int i=0;i<=tot;i++)
            dp[i] = inf;
        dp[0] = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<=tot;j++) {
                if(dp[j] == inf)    continue;
                dp[j|kw[i]] = Math.min(dp[j|kw[i]], dp[j]+1);
            }
        if(dp[tot] != inf)   System.out.println(dp[tot]);
        else    System.out.println("-1");
    }
}
