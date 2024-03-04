//合根植物  2017年第八届决赛  lanqiaoOJ 110

import java.util.*;
public class Main {
    static int[] s ;
    public static int find_set(int x) {
        if (s[x]!=x)
            return s[x]=find_set(s[x]);
        return x ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int m = sc.nextInt() ;
        s = new int[n*m+10] ;
        for(int i=1 ; i<=n*m ; i++)
            s[i]=i ;
        int k = sc.nextInt() ;
        for(int i=0 ; i<k ; ++i) {
            int a = sc.nextInt() ;
            int b = sc.nextInt() ;
            int pa = find_set(a) ;
            int pb = find_set(b) ;
            if (pa != pb)
                s[pa] = pb ;
        }
        int cnt=0 ;
        for(int i=1 ; i<=n*m ; ++i)
            if (s[i]==i)
                cnt++;
        System.out.println(cnt);
    }
}
