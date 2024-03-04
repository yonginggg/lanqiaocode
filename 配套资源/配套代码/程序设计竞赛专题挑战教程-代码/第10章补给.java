//补给 lanqiaoOJ 1050 

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner cin = new Scanner(System.in);
    static int INF = 0x3f3f3f3f;
    static double[] x = new double[20];
    static double[] y = new double[20];
    static int n;
    static double D;
    static double[][] w = new double[20][20];
    static int[][] dp = new int[1 << 20][20];

    public static double dis(int a, int b) {
        return Math.sqrt((x[a] - x[b]) * (x[a] - x[b]) + (y[a] - y[b]) * (y[a] - y[b]));
    }

    public static void floyd() {
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    w[i][j] = Math.min(w[i][j], w[i][k] + w[k][j]);
    }

    public static void main(String[] args) {
        n = cin.nextInt();
        D = cin.nextDouble();
        for (int i = 0; i < n; i++) {
            x[i] = cin.nextDouble();
            y[i] = cin.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                w[i][j] = w[j][i] = dis(i, j);
                if (w[i][j] > D) w[i][j] = w[j][i] = INF;
            }
        }
        floyd();
        for (int i = 0; i < (1 << 20); i++)for(int j = 0 ; j < 20 ; j ++) dp[i][j] = INF;
        dp[1][0] = 0;
        for (int S = 0; S < (1 << n); S++) {
            for (int j = 0; j < n; j++) {
                if ((S >> j & 1) != 0) {
                    for (int k = 0; k < n; k++) {
                        if (((S ^ (1 << j)) >> k & 1) != 0)
                            dp[S][j] = Math.min(dp[S][j], dp[S ^ (1 << j)][k] + (int) (5000 * w[k][j]));
                    }
                }
            }
        }
        int ans =  INF;
        for (int i = 1; i < n; i++)
            ans = Math.min(ans, (int) (w[i][0] * 5000) + dp[(1 << n) - 1][i]);
        System.out.printf("%.2f%n", ans / 5000.0);
    }
}