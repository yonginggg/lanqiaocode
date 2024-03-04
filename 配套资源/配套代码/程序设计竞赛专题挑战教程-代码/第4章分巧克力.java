//分巧克力 2017年第八届蓝桥杯省赛C/C++大学A组     lanqiaoOJ 99

import java.util.Scanner;
public class Main {
    private static int maxn = 100000;
    public static void main(String[] args) {
        int n,k;
        int[] h = new int[maxn];
        int[] w = new int[maxn];
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        int ans = 0;
        int right = maxn + 1;
        int left = 1;
        while (left<=right){
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += (h[i] / mid) * (w[i] / mid);
            }
            if (cnt >= k){
                left = mid + 1;
                ans = mid; 
            }else
                right = mid - 1;
        }
        System.out.println(ans);
    }
}