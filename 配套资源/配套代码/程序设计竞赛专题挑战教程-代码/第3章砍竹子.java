//砍竹子 2022年第十三届省赛C/C++大学B组
//lanqiaoOJ 2117

import java.util.*;
public class Main{
    static Scanner cin = new Scanner(System.in);
    static long [][] f = new long[200010][10];
    static long [] stk = new long[10];
    public static void main(String[] args){
        int n = cin.nextInt() , ans = 0;
        for(int i = 0 ; i < n ; i ++){
            long x = cin.nextLong() , top = 0;
            while(x > 1){
                stk[(int) ++ top] = x;
                x = (long) Math.sqrt(x / 2 + 1);
            }
            ans += top;
            int k = (int) top;
            for(int j = 0 ; k >= 0 ; j ++){
                f[i][j] = stk[k];
                k --;
            }
        }
        for(int j = 0 ; j < 10 ; j ++) {
            for(int i = 1 ; i < n ; i ++){
                if(f[i][j] > 0 && f[i][j] == f[i - 1][j]) ans --;
            }
        }
        System.out.println(ans);
    }
}