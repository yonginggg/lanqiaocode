//四阶幻方 2015年第六届决赛  lanqiaoOJ 689

import java.util.*;
public class Main{
    static int a[][] = new int[4][4];
    static int res, n = 4;
     
    public static void main(String[] args){
        a[0][0] = 1;
        dfs(0, 1);
        System.out.println(res);
    }
     
    static boolean check(){
        int sum3 = 0, sum4 = 0;
        for(int i = 0; i < n; i ++){
            int sum1 = 0, sum2 = 0;
            sum3 += a[i][i];
            sum4 += a[3-i][i];
            for(int j = 0; j < n; j ++){
                sum1 += a[i][j];
                sum2 += a[j][i];
            }
             
            if(sum1 != 34 || sum2 != 34) return false;
        }
        if(sum3 != 34 || sum4 != 34) return false;
        return true;
    }
    static boolean st[] = new boolean[20];
    static void dfs(int x, int y){
        if(y == 3){
            int c = 34-a[x][0]-a[x][1]-a[x][2];
            if( c > 16 || c < 2 || st[c]) return ;
            a[x][y] = c;
            st[c] = true;
            dfs(x+1, 0);
            st[c] = false;
            return ;
        }else if(x == 3){
            int c = 34-a[0][y]-a[1][y]-a[2][y];
            if( c > 16 || c < 2 || st[c]) return ;
            a[x][y] = c;
            st[c] = true;
            dfs(x, y+1);
            st[c] = false;
            return ;
        }
         
        if(x == 4){
            if(check()) res ++;
            return ;
        }
        for(int i = 2; i <= 16; i ++){
             
            if(st[i]) continue;
            a[x][y] = i;
            st[i] = true;
            dfs(x, y+1);
            st[i] = false;
        }
    }
}