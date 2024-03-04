//小朋友排队lanqiaoOJ 222


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N=1000005;
    static int tree[]=new int[N];
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        int H[]=new int[N];
        int k[]=new int[N];
        for(int i=1;i<=n;i++) { //正序处理
            H[i]=cin.nextInt()+1;
            k[i] = sum(N - 1) - sum(H[i]);
            update(H[i], 1);
        }
        Arrays.fill(tree, 0);
        for(int i=n;i>0;i--) {  //倒序处理
            k[i] += sum(H[i] - 1);
            update(H[i],1);
        }
        long unhappy=0;
        for(int i=1;i<=n;i++) {
            unhappy += (long)k[i] * (k[i] + 1 ) / 2;
        }
        System.out.println(unhappy);
    }
    static int lowbit(int x) {
        return x&-x;
    }
    static int sum(int x) {
        int sum=0;
        while(x>0) {
            sum+=tree[x];
            x-=lowbit(x);
        }
        return sum;
    }
    static void update(int x,int d) {
        while(x<1000005) {
            tree[x]+=d;
            x +=lowbit(x);
        }
    }
}
