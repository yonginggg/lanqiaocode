//lanqiaoOJ 2080
//[蓝桥杯2022初赛] 求和
import java.util.*;

public class Main {
    static int a[] = new int[200010];
    static long s[] = new long[200010];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i ++) {
            a[i] = sc.nextInt();
            s[i] = s[i-1] + a[i];
        }
        long res = 0;
        for(int i = 1; i <= n; i ++) {
            res += a[i] * (s[n] - s[i]);
        }
        System.out.println(res);
    }
}
