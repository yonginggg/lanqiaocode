//数的拆分    lanqiaoOJ 2090 

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner cin = new Scanner(System.in);
    static int cnt = 0 , N = 4000;
    static int[]prime = new int[4001];
    static int[]vis = new int[4001];
    public static void init(){
        for(int i = 2; i <= N; i++){
            if(0 == vis[i]) prime[++cnt] = i;
            for(int j = i*i; j <= N; j += i)   vis[j] = 1;
        }
    }
    public static boolean square_number(long x)
    {
        long y = (long) Math.sqrt(x);
        while(y * y <= x)//开平方存在精度误差，需要多判断几步
        {
            if(y * y == x)return true;
            y += 1;
        }
        return false;
    }
    public static boolean cubic_number(long x)
    {
        long y = (long) Math.pow(x, 1.0 / 3);
        while(y * y * y <= x)//开立方存在精度误差，需要多判断几步
        {
            if(y * y * y == x)return true;
            y += 1;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        init();
        int T = cin.nextInt();
        while(T -- > 0){
            long a = cin.nextLong();
            if(square_number(a) || cubic_number(a)) {
                System.out.println("yes");
                continue;
            }
            boolean flag = true;
            for(int i = 1 ; i <= cnt ; i ++) if(a % prime[i] == 0){
                int mi = 0;
                while(a % prime[i] == 0) {a /= prime[i] ; mi ++;}
                if(mi == 1) {
                    flag = false;
                    break;
                }
            }
            if(flag && (square_number(a) || cubic_number(a))) System.out.println("yes");
            else System.out.println("no");
        }
    }

}