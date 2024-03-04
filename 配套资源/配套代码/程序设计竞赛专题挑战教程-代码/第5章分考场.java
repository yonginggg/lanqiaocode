//分考场  2017年第八届决赛   lanqiaoOJ 109

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class Main {
    static InputReader in = new InputReader(new BufferedInputStream(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m, cnt = 0;
    static int[][] adj = new int[105][105];  
    static int[][] room = new int[105][105]; 
    static int[] len = new int[105]; // 存放每个考场的人数
    static int res = Integer.MAX_VALUE;
     
    static void dfs(int u, int total) {
        if (total >= res) {
            return ;
        }
        if (u == n+1) {
            res = Math.min(res, total);
            return ;
        }
         
        // 遍历所有的考场, 哪个考场可以放下当前学生, 则填进去
        int i;
        for (i = 0; i < total; i++) {
            boolean flag = true;
            for (int j = 0; j < len[i]; j++) {
                int v = room[i][j];
                if (adj[u][v] == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                room[i][len[i]++] = u;
                dfs(u+1, total);
                len[i]--; // 回溯
            }
        }
         
        // 如果均不能放, 则重新建立一个考场
        if (i == total) {
            // 均有关，开辟新考场
            room[total][len[total]++] = u;
            dfs(u+1, total+1);
            len[total]--; 
        }
    }
     
    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
         
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            adj[a][b] = -1;
            adj[b][a] = -1;
        }
         
        dfs(1, 0);
        out.println(res);
        out.flush();
        out.close();
    }
     
    static class InputReader {
        static BufferedReader br;
        static StringTokenizer st;
         
        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            st = null;
        }
         
        public String next() {
            while(st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
         
        public String readLine() {
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return s;
        }
         
        public int nextInt() {
            return Integer.parseInt(next());
        }
         
        public Double nextDouble() {
            return Double.parseDouble(next());
        }
         
        public Long nextLong() {
            return Long.parseLong(next());
        }
    }
}
 