//大臣的旅费  2005年第四届省赛   lanqiaoOJ 207

import java.util.*;
public class Main {
    static class edge{
        int to,w;
        public edge(int v, int w) {
            this.to = v;
            this.w = w;
        }
    }
    static int N=100005;
    static int ans,s,n;
    static ArrayList<edge> e[]=new ArrayList[N];
    static void dfs(int u,int father,int dis) {
        if(dis>ans) {
            ans=dis;
            s=u;
        }
        for(int i=0;i<e[u].size();i++) {
            edge temp=e[u].get(i);
            int v=temp.to;
            int w=temp.w;
            if(v!=father)
                dfs(v,u,dis+w);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++) 
            e[i] = new ArrayList<edge>();        
        for(int i=1;i<=n-1;i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            e[a].add(new edge(b,c));
            e[b].add(new edge(a,c));
        }
        dfs(1,-1,0);
        dfs(s,-1,0);
        System.out.println(ans*10+(ans+1)*ans/2);
    }
}
