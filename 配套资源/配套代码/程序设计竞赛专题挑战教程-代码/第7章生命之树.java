//生命之树 2015年第六届省赛  lanqiaoOJ 131
import java.io.*;
import java.util.*;
 
class DFS
{
    static final int N = 100005, M = N*2;
     
    int[] e = new int[M], ne = new int[M], h = new int[N], w = new int[N];
    int idx = 1;
    long res;
     
    public void add(int a, int b)
    {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }
     
    public long dfs(int u, int f)
    {
        long sum = w[u];
        for(int i = h[u]; i != 0; i = ne[i])
        {
            int j = e[i];
            if(j == f) continue;
             
            long d = dfs(j, u);
            if(d > 0)
            {
                sum += d;
            }
        }
        res = Math.max(res, sum);
        return sum;
    }
     
    public void slove()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i <= n; i++)
        {
            w[i] = in.nextInt();
        }
         
        for(int i = 0; i < n-1; i++)
        {
            int a, b;
            a = in.nextInt();
            b = in.nextInt();
            add(a, b);
            add(b, a);
        }
         
        dfs(1,-1);
         
        System.out.print(res + "\n");
    }
}
 
 
class BFS
{
    static final int N = 100005, M = N*2;
     
    int[] e = new int[M], ne = new int[M], h = new int[N], r = new int[N], st = new int[N];
    long[] w = new long[N];
    int idx = 1;
    long res = 0;
     
    Queue<Integer> q = new LinkedList<Integer>();
     
    public void add(int a, int b)
    {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
        r[b]++; //入度加 1
    }
     
    public void bfs()
    {
        while(!q.isEmpty())
        {
            int f = q.poll();
            st[f] = 1;
            for(int i = h[f]; i != 0; i = ne[i])
            {
                int j = e[i];
                if(st[j] == 0)
                {
                    if(w[f] > 0)
                        w[j] += w[f];
                    r[j] --;
                    if(r[j] == 0)
                    {
                        q.add(j);
                    }
                }
            }
            res = Math.max(res, w[f]);
        }
    }
     
    public void slove()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
         
        for(int i = 1; i <= n; i++)
        {
            w[i] = in.nextLong();
        }
         
     
        for(int i = 0; i < n-1; i++)
        {
            int a, b;
            a = in.nextInt();
            b = in.nextInt();
         
            if(a > b)
                add(a, b);
            else
                add(b, a);
        }
         
        for(int i = 1; i <= n; i++)
        {
            if(r[i] == 0)
            {
                q.add(i);
            }
        }
         
        bfs();
        System.out.print(res + "\n");
    }
}
 
 
public class Main {
     
    public static void main(String args[]) throws Exception
    {
//      DFS dfs1 = new DFS();
//      dfs1.slove();
        BFS bfs1 = new BFS();
        bfs1.slove();
    }
}
 