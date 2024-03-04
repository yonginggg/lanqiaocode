//刷题统计  2022年第十三届蓝桥杯省赛 C/C++大学B组
//lanqiaoOJ 2098


import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input=new Scanner(System.in);
        long a=input.nextLong();
        long b=input.nextLong();
        long n=input.nextLong();
        long k=n/(5*a+2*b)*7;
        long m=n%(5*a+2*b);
        long p;
        if(m<=5*a){
            if(m%a==0){
                p=m/a;
            }else {
                p=m/a+1;
            }
        }else {
            if((m-5*a)==0){
                p=5+(m-5*a)/b;
            }else {
                p=6+(m-5*a)/b;
            }
        }
        System.out.println(k+p);
    }
}