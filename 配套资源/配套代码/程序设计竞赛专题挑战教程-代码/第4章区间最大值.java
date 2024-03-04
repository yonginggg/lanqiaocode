//区间最大值 lanqiaoOJ 1205


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[] a = new int[n];
        
        for(int i = 0;i < n;i++) {
            a[i] = scan.nextInt();
        }
        int m = (int)Math.ceil(Math.log((double)n)/Math.log(2.0));
        int[][] ST = new int[n][m];
        
        for(int i = 0;i < n;i++) {
            ST[i][0] = a[i]; 
        }
        
        for(int k = 1;k< m;k++) {
            for(int s = 0;s+(1<<k)<=n;s++) {
                ST[s][k] = Math.max(ST[s][k-1], ST[s + (1<<(k-1))][k-1]);
            }
        }
        
        for(int i = 0;i < q;i++) {
            System.out.println(getMaxValue(ST, scan.nextInt()-1, scan.nextInt()-1));
        }
        
        scan.close();
    }

    private static int getMaxValue(int[][] sT, int begin, int end) {
        int len = end - begin + 1;

        int k = (int)(Math.log((double)len)/Math.log(2.0));
        return Math.max(sT[begin][k], sT[end - (1 << k)+1][k]);
    }
}