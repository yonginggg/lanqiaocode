//最长不下降子序列   2022年第十三届蓝桥杯省赛 C/C++大学A组，Java大学C组，Python大学A组、B组


//lanqiaoOJ 2088 



import java.io.*;
import java.util.Arrays;

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

    static int N = (int) 1e5 + 1;
    static int n , k;
    static int[]a = new int[N] ;
    static int[]b = new int[N];
    static int[]tree = new int[4 * N];
    static int[]dp = new int[N];

    public static int ls(int p) {return p << 1;}
    public static int rs(int p) {return p << 1 | 1;}
    public static void push_up(int p) {tree[p] = Math.max(tree[ls(p)], tree[rs(p)]);}
    public static void build(int p, int pl, int pr){
        tree[p]=0;
        if (pl==pr)   return;
        int mid=(pl+pr)/2;
        build(ls(p), pl, mid);
        build(rs(p), mid+1, pr);
    }
    public static void update(int p, int pl, int pr, int x, int v){   //把第x个叶子结点的值更新为v
        if (pl==pr){
            tree[p]=Math.max(tree[p], v);        //如果v更大，更新为v
            return;
        }
        int mid=(pl+pr)/2;
        if (x<=mid)  update(ls(p), pl,    mid, x, v);
        else         update(rs(p), mid+1, pr,  x, v);
        push_up(p);
    }
    public static int query(int p, int pl, int pr, int L, int R){
        if (L<=pl && pr<=R)     return tree[p];
        int res=0;
        int mid=(pl+pr)/2;
        if (L<=mid)   res=Math.max(res, query(ls(p), pl, mid, L, R));
        if (R > mid)  res=Math.max(res, query(rs(p), mid+1, pr, L, R));
        return res;
    }
    public static int get(int x){
        int l = 1 , r = n , res = n;
        while(l <= r){
            int mid = l + r >> 1;
            if(x >= b[mid]) {
                res = mid; l = mid + 1;
            }
            else r = mid - 1;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        n = (int) read();
        k = (int) read();
        for(int i = 1 ; i <= n ; i ++) {
            a[i] = (int)read();
            b[i] = a[i];
        }
        if(n == k) {
            System.out.println(n);
            return ;
        }
        Arrays.sort(b , 1 , n + 1);
        for(int i = 1 ; i <= n ; i ++) a[i] = get(a[i]);
        build(1 , 1 , N);
        for(int i = 1 ; i <= n ; i ++){
            dp[i] = query(1 , 1 , N , 1 , a[i]) + 1;
            update(1 , 1 , N , a[i] , dp[i]);
        }
        int ans = 0;
        build(1 , 1 , N);
        for(int i = n ; i > k ; i --){
            ans = Math.max(ans , dp[i - k] + k - 1 + query(1 , 1 , N , a[i - k] , N) + 1);
            int tmp = query(1, 1, N, a[i], N)+1;
            ans = Math.max(ans, tmp + k);
            update(1, 1, N, a[i], tmp);
        }
        System.out.println(ans);
    }

}

