//回路计数 2021年第十二届省赛 lanqiaoOJ 1462

public class Main{
static boolean [][] w = new boolean [21][21];
static long[][] f = new long[1<<21][21];
    public static void main(String[] args) {
        for(int i = 1 ; i <= 21 ; i++) {
            for(int j = 1 ; j <= 21 ; j++) {
                if(gcd(i,j) == 1 ) {
                    w[i-1][j-1] = w[j-1][i-1] = true;
                }
            }
        }
     
         f[1][0]= 1;
         for(int i = 0 ; i < 1<<21 ; i++) {
             for(int j = 0 ; j < 21 ; j++) {
                 if((i>>j &1) == 1 ) {
                     for(int k = 0 ; k < 21 ; k++) {
                         if((i>> k &1 )  ==1 && w[k][j] ) {
                             f[i][j] += f [i-(1<<j)][k];
                         }
                     }
                 }
             }
         }
         long res = 0  ;
         for(int i = 0 ; i < 21 ; i++) {
             res += f[(1<<21)-1][i];
         }
         System.out.println(res);
          
 
    }
    static int gcd(int a , int b ) {//最大公约数
        return b == 0 ? a: gcd(b,a%b);
    }
      
         
}