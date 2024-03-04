//第几个幸运数字  lanqiaoOJ 613

//(1）暴力搜。
public class Main{
    public static void main(String[] args) {
        int count=0;
        long n=59084709587505L;
        for(int i=0;Math.pow(3,i)<n;i++){
            for(int j=0;Math.pow(5,j)<n;j++){
                for(int k=0;Math.pow(7,k)<n;k++){
                    if(Math.pow(3,i)*Math.pow(5,j)*Math.pow(7,k)<n){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

----------------------------------------------------------------
//(2）优先队列+set去重
import java.util.*; 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        long n = 59084709587505L ; 
        int x=0,y=0,z=0 ; 
        long t=n ; 
        while(t%3==0) {t/=3;++x;}
        while(t%5==0) {t/=5;++y;}
        while(t%7==0) {t/=7;++z;}
        int mx=Math.max(x,y) ; 
        mx = Math.max(mx, z) ; 
        PriorityQueue<Long> q = new PriorityQueue<Long>() ; 
        Set<Long> st = new HashSet<Long>() ; 
        long[] num = {3,5,7} ; 
        for(int i=0 ; i<3 ;  ++i) {q.add(num[i]) ; st.add(num[i]);}
        int cnt=0 ; 
        while(q.isEmpty()==false) {
            long h = q.poll() ;
            ++cnt ; 
            if(h==n)    break ;
            for(int i=0 ; i<3 ; ++i) {
                t = h*num[i] ; 
                if(t>n)  continue ; 
                if(st.contains(t)==false) {
                    q.add(t) ;
                    st.add(t) ; 
                }
            }
        }
        System.out.println(cnt);
    }
}
