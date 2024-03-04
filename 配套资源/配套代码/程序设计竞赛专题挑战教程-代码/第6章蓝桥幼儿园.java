//蓝桥幼儿园  lanqiaoOJ 1135

import java.util.Scanner;
public class Main {
    static int[]s;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = new int[n+1];
        for(int i=1;i<n+1;i++){
            s[i] = i;
        }
        while(m-->0){
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(op==1)mre(x,y);
            if(op==2){
                if(find(x)==find(y)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int x) {
     if(x!=s[x]){
         s[x] = find(s[x]);
     }
     return s[x];
    }
    private static void mre(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y)s[x] = s[y];
    }
}