//修建公路1  lanqiaoOJ 1124 
import java.util.*;
import java.io.*;
class edge{
    int from,to,dis;
    public edge(int a,int b,int c){
        from=a;  to=b;  dis=c;
    }
}
public class Main{
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int read()throws IOException{
        in.nextToken();
        return(int)in.nval;
    }
    static int N = (int)3e5 + 10;
    static edge e[] = new edge[N];
    static int n,m,s[]=new int[N];
    static int find(int x){//查询并查集，返回x的根
        return s[x]==x?x:(s[x]=find(s[x])) ;
    }
    static int kruskal(){
        int ans = 0;
        for(int i = 1;i <= n;i ++)  s[i] = i;//并查集初始化
        Arrays.sort(e,1,m+1,new Comparator<edge>(){  //对边做排序
            public int compare(edge a,edge b){return a.dis - b.dis;}
        });
        for(int i = 1;i <= m;i ++){    //贪心：逐一加入每个边
            int x = find(e[i].from),y = find(e[i].to);
            if(x == y) continue;
            n--;
            ans += e[i].dis;
            s[x] = y;              //合并
        }
        return ans;
    }
    public static void main(String args[])throws IOException{
        n = read();
        m = read();
        for(int i = 1;i <= m;i++){            
            int x = read();
            int y = read();
            int z = read();
            e[i] = new edge(x,y,z);
        }
        int ans = kruskal();
        System.out.print(n==1?ans:"-1");
    }
}
