#路径之谜  2016年第七届决赛   lanqiaoOJ 89


def dfs(x,y):
    if a[x]<0 or b[y]<0: return
    if x==n-1 and y==n-1:
        ok=1
        for i in range(n):
            if a[i]!=0 or b[i]!=0: ok=0; break
        if ok==1:
            for i in range(len(path)): print(path[i],end=' ')
    for d in [(1,0),(-1,0),(0,1),(0,-1)]:
        tx = x+d[0]; ty = y+d[1]
        if 0 <= tx < n and 0 <= ty < n and vis[tx][ty] == 0:
                vis[tx][ty] = 1
                path.append(tx*n + ty)      #进栈，记录路径
                a[tx] -= 1; b[ty] -= 1
                dfs(tx, ty)
                path.pop();                 #出栈，DFS回溯
                a[tx] += 1;  b[ty] += 1
                vis[tx][ty] = 0

n = int(input())
vis = [[0]*n for i in range(n)]
path = []               #用栈记录路径
path.append(0)
b = list(map(int,input().split()))
a = list(map(int,input().split()))
vis[0][0]=1
a[0] -= 1;  b[0] -= 1
dfs(0,0)
