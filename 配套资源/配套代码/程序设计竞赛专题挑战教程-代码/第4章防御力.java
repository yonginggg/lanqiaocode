//防御力 2018年第九届蓝桥杯国赛 lanqiaoOJ 226

import java.util.Scanner;
 public class Main {
    static void cmp2(int[] arr){
        int w=0;
        int id=0;
        for(int i=0;i<arr.length;i++)
            if(arr[i]>w)    {
                id=i;
                w=arr[i];
            }
        arr[id]=-1;
        id++;
        System.out.println("B"+id);
    }
    static void cmp1(int[] arr)    {
        int w=Integer.MAX_VALUE;
        int id=0;
        for(int i=0;i<arr.length;i++)
            if(arr[i]<w)   {
                id=i;
                w=arr[i];
            }
        arr[id]=Integer.MAX_VALUE;
        id++;
        System.out.println("A"+id);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n1=in.nextInt();
        int n2=in.nextInt();
        int A[]=new int[n1];
        int B[]=new int[n2];
        for(int i=0;i<A.length;i++)  A[i]=in.nextInt();
        for(int i=0;i<B.length;i++)  B[i]=in.nextInt();
        char s[] = in.next().toCharArray();
        for(int i=0;i<s.length;i++)
            if(s[i]=='0')
                cmp1(A);
            else
                cmp2(B);
        System.out.println("E");
    }
}