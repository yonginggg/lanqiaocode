//带分数 lanqiaoOJ 208

import java.util.Scanner;
public class Main {
    static int n;
    static int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    static int bit = 0;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int tmp = n;
        while (tmp > 0) {
            bit++;      // n的位数
            tmp /= 10;
        }
        f(0);
        System.out.println(cnt);
    }
    static void f(int r) {
        if (r >= 8) {
            for(int i=1; i<=bit; i++) {  //决定第一个数的位数
                int a = 0;
                for(int k=0; k<i; k++)
                    a = a*10+num[k];
                if(a>n) break;

                int b = 0;
                for(int j=i; j<9; j++) {
                    b = b*10 +num[j];
                    int c = 0;
                    for(int k=j+1; k<9; k++) {
                        c = c*10+num[k];
                    }
                    if((n-a)*c==b) cnt++;
                }
            }
            return;
        }
        for (int i = r; i <= 8; i++) {
            swap(r, i);
            f(r + 1);
            swap(r, i);
        }
    }
    static void swap(int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
