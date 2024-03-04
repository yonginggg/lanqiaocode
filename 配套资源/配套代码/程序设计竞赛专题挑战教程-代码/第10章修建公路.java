//修建公路1  lanqiaoOJ 1124 

import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static List<int[]>[] edges=new ArrayList[100001];
	static PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {return o1[1]-o2[1];	}
	});
	static int[] dis;
	static int[] vis;
	static long ans;
	static int MAX=Integer.MAX_VALUE;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer st=new StreamTokenizer(br);
	static int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	public static void main(String[] args) throws IOException {
			N=nextInt();
			M=nextInt();
			dis=new int[N+1];
			vis=new int[N+1];
			for (int j = 1; j <= N; j++) {
				if(edges[j]==null) {
					edges[j]=new ArrayList<>();
				}else {
					edges[j].clear();
				}
			}
			int a,b,c=0;
			for (int j = 1; j <= M; j++) {
				a=nextInt();
				b=nextInt();
				c=nextInt();
				edges[a].add(new int[] {b,c});
				edges[b].add(new int[] {a,c});
			}

			Arrays.fill(dis, MAX);
			prim();
			if(ans==-1) System.out.println("-1");
			else System.out.println(ans);
			Arrays.fill(vis,0);
			pq.clear();		
	}
	private static void prim() {
		int count = 0;
		ans = 0;
		pq.add(new int[] {1,0});
		dis[1]=0;
		while(!pq.isEmpty()) {
			int[] point=pq.poll();
			if (vis[point[0]] == 1) continue;
			vis[point[0]] = 1;
			if (point[1] != 0) {
				ans += point[1];
				count++;
			}
			for (int i = 0; i < edges[point[0]].size(); i++) {
				int[] next=edges[point[0]].get(i);
				if(next[1]<dis[next[0]]) {
					dis[next[0]]=next[1];
					pq.add(new int[] {next[0],dis[next[0]]});
				}
				
			}
		}
		if (count != N - 1) ans = -1;		
	}

}