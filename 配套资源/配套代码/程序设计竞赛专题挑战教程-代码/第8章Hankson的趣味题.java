//Hankson 的趣味题  lanqiaoOJ  520 

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner cin = new Scanner(System.in);
    public static int gcd(int a , int b) {
        return b > 0 ? gcd(b , a % b) : a;
    }
    public static int lcm(int a , int b){
        return a / gcd(a , b) * b;
    }
    public static void main(String[] args) {
        int T = cin.nextInt();
        while(T -- > 0){
            int a0 = cin.nextInt() , a1 = cin.nextInt() , b0 = cin.nextInt() , b1 = cin.nextInt();
            int ans = 0;
            for(int x = 1 ; x * x <= b1 ; x ++){
                if(b1 % x == 0) {
                    if(gcd(x , a0) == a1 && lcm(x , b0) == b1) ans ++ ;
                    int y = b1 / x;
                    if(x == y) continue ;
                    if(gcd(y , a0) == a1 && lcm(y , b0) == b1) ans ++;
                }
            }
            System.out.println(ans);
        }
    }
}