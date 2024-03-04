//汉诺塔 lanqiaoOJ 1512

import java.util.Scanner; import java.util.Stack;

public class Main {
    static int sum = 0;
    static Stack[] stack = new Stack[4];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        stack[1] = new Stack();
        stack[2] = new Stack();
        stack[3] = new Stack();
        for(int i = 1;i<=n;i++)
            stack[1].add(i);
        def(1,2,3,n,m);
        System.out.println(sum);
    }
    static void move(int x,int y,int n,int m) {
        char a = 0,b = 0;
        if(x==1) a='A';
        if(x==2) a='B';
        if(x==3) a='C';
        if(y==1) b='A';
        if(y==2) b='B';
        if(y==3) b='C';

        stack[y].add(stack[x].pop());
        sum++;
        if(sum == m)
            System.out.println("#" + n + ": " + a + "->" + b);
    }
    static void def(int x, int y, int z, int n, int m) {
        if(n==1)
            move(x,z,n,m);
        else {
            def(x,z,y,n-1,m);
            move(x,z,n,m);
            def(y,x,z,n-1,m);
        }
    }

}
