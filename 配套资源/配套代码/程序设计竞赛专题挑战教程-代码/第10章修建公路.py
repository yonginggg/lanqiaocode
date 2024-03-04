# 修建公路1  lanqiaoOJ  1124

from heapq import *
def prim():
    ans, cnt = 0, 0
    dis = [float('inf') for _ in range(n + 1)]
    dis[1] = 0
    q = []
    vis = [False for _ in range(n + 1)]   # =ture: 表示点i已经在MST中
    heappush(q, (0, 1))  #从s点开始处理队列
    while q and cnt < n:
        w, u = heappop(q)    #pop出距集合最近的点u
        if not vis[u]:
            vis[u] = True
            ans += w            
            cnt += 1
            for v,w in e[u]:      #遍历点u的邻居v，边长为w   while i:      #检查点u的所有邻居
                if dis[v] > w:
                    dis[v] = w
                    heappush(q, [dis[v], v])  #扩展新的邻居，放进优先队列
    if cnt != n:    print('-1')
    else:           print(ans)        
n, m = map(int,input().split())
e = [[] for i in range(n + 1)]
for i in range(m):
    u, v, w = map(int,input().split())
    e[u].append((v,w))   #u的邻居是v，边长w         
    e[v].append((u,w))   #双向边
prim()

