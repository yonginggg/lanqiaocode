//lanqiaoOJ 1133
//区间修改、区间求和


import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
    static class in{
        public static BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        public static StreamTokenizer st = new StreamTokenizer(re);

        public static int nextInt() throws IOException{
            st.nextToken();
            return (int)st.nval;
        }
        public static double nextDouble() throws IOException{
            st.nextToken();
            return st.nval;
        }
    }
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int n,m;
    static long[] tree;
    static int[] num,mark;

    static void buildTree(int l, int r, int p){
        if(l==r){
            tree[p] = (long)num[l];
            return ;
        }
        int mid = (l+r)/2;
        buildTree(l, mid, p*2);
        buildTree(mid+1, r, p*2+1);
        tree[p] = tree[p*2]+tree[p*2+1];
        return ;
    }

    static void push_down(int p, int len){  
        mark[p*2] += mark[p];
        mark[p*2+1] += mark[p];
        tree[p*2] += mark[p] * (len-len/2);
        tree[p*2+1] += mark[p] * (len/2);
        mark[p] = 0;
    }

    static void updata(int l, int r, int d, int p, int cl, int cr){
        if(cl>r || cr<l){
            return ;
        }
        else if(cl>=l && cr<=r){
            tree[p] += (cr-cl+1)*d;
            if(cr>cl){
                mark[p] += d;
            }
        }
        else{
            int mid = (cr+cl)/2;
            push_down(p, cr-cl+1);
            updata(l, r, d, p*2, cl, mid);
            updata(l, r, d, p*2+1, mid+1, cr);
            tree[p] = tree[p*2] + tree[p*2+1];
        }
        return ;
    }

    static long qurey(int l, int r, int p, int cl, int cr){
        if(cl>r || cr<l){
            return 0;
        }
        else if(cl>=l && cr<=r){
            return tree[p];
        }
        else{
            int mid = (cr+cl)/2;
            push_down(p, cr-cl+1);
            return qurey(l, r, p*2, cl, mid) + qurey(l, r, p*2+1, mid+1, cr);     
        }
    }

    public static void main(String[] args) throws IOException{
        // Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        tree = new long[300005];
        num = new int[300005];
        mark = new int[300005];
        

        for(int i = 1;i <= n;++i) num[i] = in.nextInt();

        buildTree(1, n, 1);

        while(m-->0){
            int c = in.nextInt();

            if(c==1){
                int x = in.nextInt();
                int y = in.nextInt();
                int k = in.nextInt();
                updata(x, y, k, 1, 1, n);
            }
            else{
                int x = in.nextInt();
                int y = in.nextInt();
                System.out.println(qurey(x, y, 1, 1, n));
            }
        }

    }

}
