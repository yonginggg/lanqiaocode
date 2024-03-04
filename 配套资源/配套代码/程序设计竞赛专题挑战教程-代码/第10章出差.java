//出差 lanqiaoOJ 2194 

import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner cin = new Scanner(System.in);
    static int INF = 0x3f3f3f3f;
    static int M = 20010;
    static int[] t = new int[M];
    static int[] dist = new int[M];
    static int[] ea = new int[M];
    static int[] eb = new int[M];
    static int[] ec = new int[M];


    public static void main(String[] args) {
        int n = cin.nextInt(), m = cin.nextInt();
        for (int i = 1; i <= n; i++) t[i] = cin.nextInt();
        for (int i = 1; i <= m; i++) {
            int a = cin.nextInt(), b = cin.nextInt(), c = cin.nextInt();
            ea[i] = a;
            eb[i] = b;
            ec[i + m] = ec[i] = c;
            ea[i + m] = b;
            eb[i + m] = a;
        }
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= 2 * m; i++) {
                int u = ea[i], v = eb[i];
                int res = t[v];
                if (v == n) res = 0;
                dist[v] = Math.min(dist[v], dist[u] + ec[i] + res);
            }
        }
        System.out.println(dist[n]);
    }
}