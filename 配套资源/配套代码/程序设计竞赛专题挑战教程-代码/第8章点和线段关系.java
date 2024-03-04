//lanqiaoOJ 1242 
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

    public static double f(double x1,double y1,double x2,double y2) {
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public static void main(String[] args) throws IOException {
        int n = cin.nextInt();
       for(int i = 0 ; i < n ; i ++){
           double x1 = cin.nextDouble() , y1 = cin.nextDouble();
           double x2 = cin.nextDouble() , y2 = cin.nextDouble();
           double x3 = cin.nextDouble() , y3 = cin.nextDouble();
           if(f(x1,y1,x3,y3)+f(x2,y2,x3,y3)==f(x1,y1,x2,y2)) System.out.println("Yes");
           else System.out.println("No");
       }
       cin.close();
    }

}