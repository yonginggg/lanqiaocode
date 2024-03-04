//选数异或  2022年第十三届蓝桥杯省赛 C/C++大学A组、C组、研究生组，Java大学C组
//lanqiaoOJ 2081


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Read{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StreamTokenizer st = new StreamTokenizer(bf);
    static int status;
    String nextLine() throws IOException{
        return bf.readLine();
    }
    String next() throws IOException {
        status = st.nextToken();
        return st.sval;
    }
    int nextInt() throws IOException {
        status = st.nextToken();
        return (int)st.nval;
    }
    long nextLong() throws IOException{
        status = st.nextToken();
        return (long)st.nval;
    }
    double nextDouble() throws IOException {
        status = st.nextToken();
        return st.nval;
    }
}
public class Main {
    static Read r = new Read();
    public static void main(String[] args) throws IOException {
        int n = r.nextInt();
        int m = r.nextInt();
        int x = r.nextInt();
        long[] arr = new long[n+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = r.nextLong();
        }
        HashMap<Long, Integer> map = new HashMap<>();
        int[] dp = new int[n+1];
        dp[n] = Integer.MAX_VALUE;
        map.put(arr[n], n);
        for (int i = arr.length-2; i > 0; i--) {
            long t = arr[i]^x;
            Integer tt = map.get(t);
            if(tt==null)dp[i] = dp[i+1];
            else dp[i] = Math.min(dp[i+1], tt);
            map.put(arr[i],i);
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for (int i = 0; i < m; i++) {
            int l = r.nextInt();
            int rr = r.nextInt();
            if(rr>=dp[l])pw.println("yes");
            else pw.println("no");
        }
        pw.close();
    }
}