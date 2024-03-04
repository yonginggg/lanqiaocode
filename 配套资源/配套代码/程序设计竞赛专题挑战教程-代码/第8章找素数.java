//找素数   lanqiaoOJ 1558 

import java.util.*;

public class Main {
    public static final int MAX=1000005;
    public static boolean isprime[]=new boolean[MAX];
    public static boolean primelist[]=new boolean[MAX];
    
    public static int seg_sieve(long a,long b) {
        for(long i=0;i*i<=b;i++) {//此处要用long定义i，否则 i*i会越界
            isprime[(int) i]=true;            
        }
        for(int i=0;i<=b-a;i++) {
            primelist[i]=true;
        }
        for(long i=2;i*i<=b;i++) {
            if(isprime[(int) i]) {                  //i是素数
                for(long j=i*i;j*j<=b;j+=i)//筛选[2,sqrt(b)]内的素数
                    isprime[(int) j] = false;
                 for(long j=Math.max(2,(a+i-1)/i)*i;j<=b;j+=i)//筛选[a,b]内的素数
                     primelist[(int) (j-a)] = false;
            }
        }
        int k=0;
        for(int i=0;i<=b-a;++i) {
            if(primelist[i]) k++;
        }
        return k;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = seg_sieve(a,b);        
        
        System.out.println(k);
    }
}