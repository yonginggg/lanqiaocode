//统计子矩阵   lanqiaoOJ 2109


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 
    static int n;
 
    static int m;
 
    static int k;
 
    static int datas[][];
 
    static int preSum[][];
 
    public static long query(int x1,int x2,int y1,int y2){
        long sum = preSum[x2][y2];
        long A = preSum[x1-1][y1-1];
        long B = preSum[x2][y1-1];
        long C = preSum[x1-1][y2];
        return sum - B - C + A;
    }
 
    public static void main(String[] args) {
        MyInput sc = new MyInput();
        n = sc.parseInt();
        m = sc.parseInt();
        k = sc.parseInt();
        datas = new int[n+1][m+1];
        preSum = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                datas[i][j] = sc.parseInt();
                preSum[i][j] = datas[i][j]+preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1];
            }
        }
        long ans = 0;
        // 开始模拟搜索
        for (int x = 1; x <= n ; x++) {
            for (int y = 1; y <= m ; y++) {
                // 右边界
                int right = m;
                // 暴力向下
                for (int x2 = x; x2 <= n ; x2++) {
                    // 缩小右边界
                    while ( query(x,x2,y,right) > k ) right--;
                    // 找不到
                    if ( right < y ){
                        break;
                    }
                    ans += right-y+1;
                }
            }
        }
        System.out.println(ans);
    }
 
    static class MyInput{
        StringTokenizer tokenizer;
        BufferedReader sc;
        public MyInput(){
            tokenizer = new StringTokenizer("");
            sc = new BufferedReader(new InputStreamReader(System.in));
        }
        private String next(){
            while (!tokenizer.hasMoreTokens()){
                try {
                    tokenizer = new StringTokenizer(sc.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
 
        public int parseInt(){
            return Integer.valueOf(next());
        }
        public long parseLong(){
            return Long.valueOf(next());
        }
    }
}