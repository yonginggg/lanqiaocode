//蓝桥王国 lanqiaoOJ 1122 

//蓝桥王国-lanqiao3329093591的代码

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] head, next, ver, vis;
    static long[] w, d;
    static int n, m, tot = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        head = new int[m + 1];
        next = new int[m + 1];
        ver = new int[m + 1];
        w = new long[m + 1];
        vis = new int[n + 1];
        d = new long[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            add(a, b, c);
        }

        dij(1);
        for (int i = 1; i <= n; i++) {
            if (d[i] == Long.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(d[i] + " ");
            }
        }
    }

    private static void dij(int s) {
        // TODO Auto-generated method stub
        for (int i = 1; i <= n; i++) {
            d[i] = Long.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        d[s] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (vis[x] == 1) {
                continue;
            }
            for (int i = head[x]; i > 0; i = next[i]) {
                int j = ver[i];
                if (d[j] > d[x] + w[i]) {
                    d[j] = d[x] + w[i];
                    queue.add(j);
                }
            }
        }
    }

    private static void add(int a, int b, long c) {
        // TODO Auto-generated method stub
        ver[++tot] = b;
        w[tot] = c;
        next[tot] = head[a];
        head[a] = tot;
    }

}