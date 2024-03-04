//最大数   lanqiaoOJ 826 

import java.io.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static long read() throws IOException {
        int c = br.read(), sign = 1;
        long num = 0;
        while (c < '0' || c > '9') {
            if (c == '-') sign = -1;
            c = br.read();
        }
        while ('0' <= c && c <= '9') {
            num = num * 10 + c - 48;
            c = br.read();
        }
        return num * sign;
    }

    static int N = (int) 2e5 + 1;
    static int[] Log2 = new int[N];

    public static void pre() {
        for (int i = 2; i < Log2.length; i++) {
            Log2[i] = Log2[i / 2] + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        int m = (int) read(), d = (int) read(), n = 0;
        long q = 0;
        long[][] st = new long[m + 1][Log2[m] + 1];
        boolean f = false;
        for (int i = 0; i < m; i++) {
            int c = br.read();
            while (c != 'A' && c != 'Q') c = br.read();
            if (c == 'A') {
                long num = (read() + q) % d;
                st[++n][0] = num;
                for (int j = 1; (1 << j) <= n; j++) {
                    int k = n - (1 << j) + 1;
                    st[k][j] = Math.max(st[k][j - 1], st[k + (1 << (j - 1))][j - 1]);
                }
            } else {
                int l = (int) read();
                int s = Log2[l];
                q = Math.max(st[n - l + 1][s], st[n - (1 << s) + 1][s]);
                if (f) bw.write("\n");
                bw.write(q + "");
                f = true;
            }
        }
        bw.flush();
    }
}