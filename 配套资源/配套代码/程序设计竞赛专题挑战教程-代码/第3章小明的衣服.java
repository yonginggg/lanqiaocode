//小明的衣服  lanqiaoOJ 1228

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws Exception{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int)in.nval;
        long[] a = new long[100010];
        for(int i=1;i<=n;i++) {
            in.nextToken();
            a[i] = (long)in.nval;
        }
        
        PriorityQueue<Long> Q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            Q.add(a[i]);
        }
        Long ans = 0L;
        while(Q.size()>1) {
            Long a1 = Q.poll();
            Long b = Q.poll();
            Long c = a1+b;
            ans+=c;
            Q.add(c);
        }
        System.out.println(ans);
    }
}