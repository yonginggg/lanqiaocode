//选数 lanqiaoOJ 753

import java.util.Scanner;

public class Main {

    static int ans = 0;
    static int n,k;
    static int[] prime;
    static int[] b; // 从这里输出
    static boolean[] vis;  // 打表
    
    static boolean isPrime(int x) {
        if(x <= 1)
            return false;
        
        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x % i == 0)
                return false;
        }
        
        return true;
    }
    
    static void dsf(int start,int end) {  // 全排列
        if(start == k) {  // 递归边界
            int sum = 0;
            for(int i=0; i<k; i++)
                sum += b[i];
            if(isPrime(sum))
                ans++;
            return;
        }
        
        // 递归式
        for(int i=0; i<end; i++) {
            if(!vis[i]) {
                vis[i] = true;
                b[start] = prime[i];
                dsf(start+1,end);
                vis[i] = false;
            }
        }
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();        k = in.nextInt();
        prime = new int[n];        b = new int[n];        vis = new boolean[n];
        for(int i=0; i<n; i++)
            prime[i] = in.nextInt();
        
        // 练一下打表素数
        
        dsf(0,n);
        int jiecheng = 1;
        for(int i=1; i<=k;i++)
            jiecheng *= i;
        System.out.print(ans/jiecheng);
        

    }

}