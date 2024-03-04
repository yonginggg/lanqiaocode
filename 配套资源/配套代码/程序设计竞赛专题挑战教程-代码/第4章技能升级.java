//技能升级 2022年第十三届省赛C/C++大学C组，Java研究生组，Python大学B组、研究生组

//lanqiaoOJ 2129


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
    static StringTokenizer tokenizer = new StringTokenizer("");
    static int maxn = (int) (1e5 + 5);
    static int[] array = new int[maxn];
    static int[] facts = new int[maxn];
    static int n, m;
 
    // 二分枚举最后一次攻击力最高能加多少，并且要注意最后的计算不能把等于这个值的直接加在答案里
    public static void main(String[] args) {
        n = nextInt(); m = nextInt();
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
            facts[i] = nextInt();
        }
        long ans = 0L;
        // 二分最后一次技能最多提升了多少攻击力
        int l = 0, r = (int) 1e6;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        int x = l;
        for (int i = 0; i < n; i++) {
            if (array[i] >= x) {
                int cnt = (array[i] - x) / facts[i] + 1;
                int last = array[i] - (cnt - 1) * facts[i];
                if (last == x) {
                    cnt--;
                    last += facts[i];
                }
                ans += (long) (array[i] + last) * cnt >> 1;
                m -= cnt;
            }
        }
        ans += (long) m * x;
        System.out.println(ans);
    }
 
    // 最后一次加攻击力不能到 x
    public static boolean check(int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] < x) continue;
            cnt += (array[i] - x) / facts[i] + 1;
            if (cnt >= m) return true;
        }
        return false;
    }
 
    public static String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }
 
    public static int nextInt() { return Integer.parseInt(next()); }
 
    public static long nextLong() { return Long.parseLong(next()); }
}
