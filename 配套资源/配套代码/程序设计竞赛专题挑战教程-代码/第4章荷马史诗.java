//荷马史诗 lanqiaoOJ 1167


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
    static int n,k;
    static long ans;
    public static void main(String[] args)throws IOException
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a,b)-> a.x==b.x?a.y-b.y:(a.x>b.x?1:-1));

        String[] line = sc.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        int t = n;
        while (t-->0)
        {
            line = sc.readLine().split(" ");
            long a = Long.parseLong(line[0]);
            heap.offer(new Node(a,0));
        }
        int d = 0;
        if ((n-1)%(k-1)!=0)
            d = k-1-(n-1)%(k-1);
        while (d-->0)
        heap.offer(new Node(0,0));
        while (heap.size()>1)
        {
            long res1=0;
            int res2 = 0;
            for (int i=1;i<=k;i++)
            {
                long a = heap.peek().x;
                int b = heap.peek().y;
                heap.poll();
                res1+=a;
                res2 = Math.max(res2,b);
            }
            heap.offer(new Node(res1,res2+1));
            ans+=res1;
        }
        System.out.println(ans);
        System.out.println(heap.peek().y);
        
    }
}
class Node {
    long x;
    int y;
    public Node(long x,int y)
    {
        this.x = x;
        this.y = y;
    }

}