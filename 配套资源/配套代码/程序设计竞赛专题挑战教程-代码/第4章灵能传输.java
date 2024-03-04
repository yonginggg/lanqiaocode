//灵能传输  lanqiaoOJ 196
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner cinScanner = new Scanner(System.in);
        int T;
        T = cinScanner.nextInt();
        while(T!=0) {
            T--;
            long in0=0,inn=0;
            long n;
            long s0,sn;
            n = cinScanner.nextLong();
            long[] a = new long[(int)n+2];
            long[] s = new long[(int)n+1];
            long[] vis = new long[(int)n+2];
            long[] ans = new long[(int)n+2];
            for(int i=0;i<n;i++)   {
                a[i]=cinScanner.nextLong();
                s[i+1]=a[i];
                s[i+1]+=s[i];
            }
            s0 = s[0];
            sn = s[(int)n];
            if(s0>sn) {
                long t = s0;
                s0 = sn;
                sn = t;
            }
            Arrays.sort(s);
            for(int i=0;i<=(int)n;i++)  
                if(s[i]==s0){
                    in0 = i;
                    break;
                }
            for(int i=(int)n;i>=0;i--)  
                if(s[i]==sn)   {
                    inn = i;
                    break;
                }
            int l = 0;
            int r = (int)n;
            for(int i=(int)in0 ;i>=0;i-=2)  {
                ans[l++]=s[i];
                vis[i]=1;
            }
            for(int i=(int)inn;i<=n;i+=2) {
                ans[r--]=s[i];
                vis[i]=1;
            }
            for(int i=0;i<=n;i++)
                if(vis[i]==0)
                    ans[l++]=s[i];
            long res = 0;
            for(int i=1;i<=n;i++)
                res = Math.max(Math.abs((ans[i]-ans[i-1])), res);
            System.out.println(res);
        }
    }
}
