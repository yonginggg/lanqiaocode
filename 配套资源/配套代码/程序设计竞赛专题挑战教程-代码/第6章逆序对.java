//逆序对 lanqiaoOJ 1506

import java.util.Scanner;

public class Main {
    static int N=10010;
    static int[] tree=new int[N];
    static int[] a=new int[N];
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for (int i = 1; i <=n; i++) {
            a[i]=sc.nextInt();
        }
        int res=0;
        for (int i = 1; i <=n; i++) {
            int y=a[i];
            res+=query(n)-query(y);
            add(y,1);
        }
        System.out.println(res);
    }
    static int lowbit(int x){
        return x&-x;
    }
    static void add(int x,int v){
        for (int i = x; i <=n; i+=lowbit(i)) {
            tree[i]+=v;
        }
    }
    static int query(int x){
        int res=0;
        for (int i = x; i >0; i-=lowbit(i)) {
            res+=tree[i];
        }
        return res;
    }
}