//二进制问题 2021年第十二届决赛    
 
import java.util.*;
public class Main
{
    static int N = 65, M = 55;

    static long f[][] = new long[N][M];
    static int num[] = new int[N];
    static int cnt;

    static void init() {
        for(int i = 0; i < N; i ++ )
            f[i][0] = 1;
        for(int i = 1; i < N; i ++ ) {
            for(int j = 1; j < M; j ++ ) {
                f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();

        init();

        while(n != 0) {
            num[cnt ++ ] = (int) (n & 1);
            n >>= 1;
        }

        long res = 0;
        int last = 0;
        for(int i = cnt - 1; i >= 0; i -- ) {
            if(num[i] == 1) {
                res += f[i][k - last];
                last ++ ;
            }
            if(last == k) {
                res ++ ;
                break;
            }
        }
        
        System.out.println(res);
    }
}
