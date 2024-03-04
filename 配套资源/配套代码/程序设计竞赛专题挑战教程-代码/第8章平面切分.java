//平面切分 2020年第十一届省赛  lanqiaoOJ 503

import java.util.Scanner;

public class Main {
    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        double[] c=new double[n-1];
        int count=1;
        for(int i=0;i<n;i++) {
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
            if(i==0) {count++;continue;}
            int flag=0;
            for(int e=0;e<i;e++) {if(a[e]==a[i]&&b[e]==b[i]) flag=1;}
            if(flag==1) {i--;n--;continue;}
            int f=0;
            for(int j=0;j<i;j++) {
                if(a[i]==a[j]) {f++;continue;}
            c[j-f]=(double)(b[i]-b[j])/(double)(a[j]-a[i]);
            flag=0;
            for(int k=0;k<j-f;k++) {if(c[k]==c[j-f])flag=1;}
            if(flag==0)count++;
            }
            count++;
        }
        sc.close();
        System.out.println(count);
    }
}