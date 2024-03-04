//点和直线关系 lanqiaoOJ 1240 

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner cin = new Scanner(System.in);

    public static long read() throws IOException {
        int c = br.read(), sign = 1;
        long num = 0;
        while (c < '0' || c > '9') {
            if (c == '-') sign = -1;
            c = br.read();
        }
        while ('0' <= c && c <= '9') {
            num = num * 10 + c - 48;
            c = br.read();
        }
        return num * sign;
    }

    public static int f(double x1,double y1,double x2,double y2,double x3, double y3) {
        if((x3 - x1) * (y2 - y1) == (x2 - x1) * (y3 - y1) && Math.min(x1 , x2) <= x3 && Math.max(y1 , y2) >= y3 && Math.max(x1 , x2) >= 3 && Math.min(y1 , y2) <= y3){
            return 0;
        }
        else {
            return (int) ((x3 - x1) * (y2-y1) - (x2- x1) * (y3-y1));
        }
    }
    public static void main(String[] args) throws IOException {
        int T = cin.nextInt();
        while(T -- > 0){
            double a1 = cin.nextDouble() , a2 = cin.nextDouble();
            double b1 = cin.nextDouble() , b2 = cin.nextDouble();
            double c1 = cin.nextDouble() , c2 = cin.nextDouble();
            int ab = f(a1,a2,b1,b2,c1,c2);
            if(Math.abs(ab) == 0) System.out.println("IN");
            else if(ab > 0) System.out.println("R");
            else System.out.println("L");
        }
    }
}