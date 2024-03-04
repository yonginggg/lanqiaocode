//垒骰子 lanqiaoOJ 132

import java.util.*;
public class Main {
    static int op[]=new int [7];
    private static int n;
    private static int m;
    private static final long mod=1000000000+7;
     
    static void init()
    {
        op[1]=4;op[4]=1;
        op[2]=5;op[5]=2;
        op[3]=6;op[6]=3;
    }
    private static long power(long i,int n)
    {
        long ans=1;
        while(n!=0)
        {
            if((n&1)==1)
                ans=(i*ans)%mod;
            i=i*i%mod;
            n>>=1;
        }
        return ans;
    }
    private static long[][] mPow(long[][] conflict,int n)
    {
        long[][] e=new long[6][6];
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
            {
                if(i==j)
                    e[i][j]=1;
                else
                    e[i][j]=0;
            }
        while(n!=0)
        {
            if((n&1)==1)
                e=mMul(e,conflict);
            conflict=mMul(conflict,conflict);
            n>>=1;
        }
        return e;
    }
    private static long[][] mMul(long[][] a,long[][] b)
    {
        long[][] ans=new long[6][6];
        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
            {
                for(int k=0;k<6;k++)
                    ans[i][j]=(ans[i][j]+a[i][k]*b[k][j])%mod;
            }
        return ans;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        init();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt())
        {
            n=sc.nextInt();
            m=sc.nextInt();
            long conflict[][]=new long[6][6];//long long->long
            for(int i=0;i<6;i++)
                for(int j=0;j<6;j++)
                    conflict[i][j]=1;
            for(int i=0;i<m;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                conflict[op[a]-1][b-1]=0;
                conflict[op[b]-1][a-1]=0;
            }
            long[][] m_n_1=mPow(conflict,n-1);
            long ans=0;
            for(int i=0;i<6;i++)
            {
                for(int j=0;j<6;j++)
                {
                    ans=(ans+m_n_1[i][j])%mod;
                }
            }
            System.out.println(ans*power(4,n)%mod);
        }
    }
}