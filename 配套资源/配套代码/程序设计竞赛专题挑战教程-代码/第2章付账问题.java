//付账问题 2018年第九届蓝桥杯C/C++大学A组，Java大学A组
//题目链接： lanqiaoOJ 174 

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
public static void main(String args[]) throws FileNotFoundException {
        int n;
        long S;
        double ans=0,avg;
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        S=input.nextLong();
        long a[]=new long[n];
        for(int i=0;i<n;i++)         a[i]=input.nextLong();

        Arrays.sort(a);
        avg=(double)S/n;
        for(int i=0;i<n;i++) {
            if(S<=(n-i)*a[i]) {
                ans += (n-i)*Math.pow((double)S/(n-i)-avg,2);
                break;
            }
            ans += Math.pow(a[i]-avg,2);
            S -= a[i];
        }
        System.out.printf("%.4f\n",Math.sqrt(ans/n));
    }
}
