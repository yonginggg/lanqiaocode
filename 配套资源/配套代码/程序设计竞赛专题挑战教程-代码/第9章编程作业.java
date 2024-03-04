//lanqiaoOJ 1433
import java.util.*;

public class Main {
    static int T, n, m, ans;
    static int[] match = new int[2000005];
    static int[] t = new int[30];
    static int[] a = new int[1000005];
    static int[] b = new int[1000005];
    static int[] s = new int[2000005];
    static void init1(String s) {
        Arrays.fill(t , -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (t[ch - 'a' + 1] == -1)  a[n] = 0;
                else a[n] = n - t[ch - 'a' + 1];
                t[ch - 'a' + 1] = n;
                n ++;
            } else a[n++] = -(ch - 'A' + 1);
        }
    }
    static void init2(String s) {
        Arrays.fill(t , -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (t[ch - 'a' + 1] == -1)
                    b[m] = 0;
                else
                    b[m] = m - t[ch - 'a' + 1];
                t[ch - 'a' + 1] = m;
                ++m;
            } else b[m++] = -(ch - 'A' + 1);
        }
    }
    static boolean check(int x, int y, int len) {
        if (x < 0 || y < 0) return x == y;
        return x == y || (y == 0 && x > len);
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        T = cin.nextInt();
        cin.nextLine();
        while (T -- > 0) {
            n = m = ans = 0;
            for (int i = 0; i <= m + n; i++) match[i] = 0;
            String str;
            str = cin.nextLine();
            init1(str);
            str = cin.nextLine();
            init2(str);
            for (int i = 0; i < m; ++i) s[i] = b[i];
            s[m] = 100;
            for (int i = 0; i < n; ++i)
                s[m + i + 1] = a[i];
            for (int i = 1; i <= n + m; ++i) {
                int j = match[i - 1];
                while (j > 0 && !check(s[i], s[j], j)) j = match[j - 1];
                if (check(s[i], s[j], j)) ++j;
                match[i] = j;
            }
            for (int i = m + 1; i <= n + m; ++i) if (match[i] == m) ans++;
            System.out.println(ans);
        }
    }
}