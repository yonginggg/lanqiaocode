//青蛙过河 2022年第十三届蓝桥杯省赛 C/C++大学A组，Java大学A组、C组，Python大学C组
//lanqiaoOJ 2097
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.IOException;
 
public class Main {
 
    public static void main(String[] args) { new Main().run(); }
     
    void run() {
        int n = nextInt(), x = nextInt() << 1;
        int[] H = new int[n + 1], S = new int[n + 1];
        long[] V = new long[n + 1];
        for (int i = 1; i < n; ++i) H[i] = nextInt();
        int mid, ans = 1, right = n;
        V[0] = Long.MAX_VALUE;
        while (ans < right) {
            mid = ans + right >> 1;
            int l = 0, r = 0;
            for (int i = 1; i <= n; ++i) {
                while (l <= r && S[l] < i - mid) ++l;
                if (H[i] > 0) {
                    int Hk = 0;
                    while (l <= r && Hk < H[i])
                        if (V[l] <= H[i] - Hk) Hk += V[l++];
                        else {V[l] -= H[i] - Hk; Hk = H[i];}
                    if (Hk > 0) { S[++r] = i; V[r] = Hk; }
                }
            }
            long cnt = 0;
            while (l <= r)cnt += V[l++];
            if (cnt >= x) right = mid; else ans = mid + 1;
        }
        System.out.println(ans);
    }
     
    StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
     
    int nextInt() {
        try {
            in.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int)in.nval;
    }
}
