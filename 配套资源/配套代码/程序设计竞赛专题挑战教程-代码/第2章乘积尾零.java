//lanqiaoOJ 612 
//乘积尾零 2018年第九届蓝桥杯省赛C/C++大学A组

import java.math.BigInteger;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = 100;
        int cnt2 = 0, cnt5 = 0;
        while(n > 0) {
            n--;
            int x = cin.nextInt();
            while(x % 2 == 0) {
                x /= 2;
                cnt2 ++;
            }
            while(x % 5 == 0) {
                x /=5;
                cnt5 ++;
            }
        }
        System.out.println(Math.min(cnt2,  cnt5));
}
}