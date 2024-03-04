//最大比例 2016年第七届省赛  lanqiaoOJ 120


import java.util.*;
public class Main {
    static int N = 105;
    static long[] x = new long[N], a = new long[N], b = new long[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i)
                x[i] = sc.nextLong();
            Arrays.sort(x, 0, n);
            int cnt = 0;
            for (int i = 1; i < n; ++i) {
                if (x[i] == x[i - 1])    continue;
                long d = gcd(x[0], x[i]);
                a[cnt] = x[i] / d;
                b[cnt] = x[0] / d;
                cnt++;
            }
            long up = a[0], down = b[0];
            for (int i = 1; i < cnt; ++i) {
                up = gcd_sub(up, a[i]);
                down = gcd_sub(down, b[i]);
            }
            System.out.println(up + "/" + down);
        }
    }

    private static long gcd(long a, long b) {
        if (a == 0 || b == 0)  return 0;
        return a % b == 0 ? b : gcd(b, a % b);
    }
    public static long gcd_sub(long a, long b) {
        if (a == b)  return a;
        return a > b ? gcd_sub(b, a / b) : gcd_sub(b, a);
    }
}