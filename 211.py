import os
import sys

def dfs(x,y,c,s):
    global sum, ans
    if 2*s > sum: return
    if 2*s ==sum:
        if ans>c and vis[0][0]==1: ans = c
        return 
    dir = [(1,0),(-1,0),(0,-1),(0,1)]
    vis[x][y]=1
    for u,v in dir:
        tx=x+u
        ty=y+v
        if tx>=0 and tx<=n-1 and ty>=0 and ty<=m-1:
            if vis[tx][ty]==0:
                dfs(tx,ty, c+1, s+a[x][y])
    vis[x][y]=0

m,n = map(int , input().split())
a = [list(map(int, input().split())) for i in range(n)]
# print(a)
vis = [[0]*m for i in range(n)]
# print(vis)
sum = 0
for i in range(n):
    for j in range(m):
        sum+=a[i][j]
# print(sum)
ans = 1000000
dfs(0,0,0,0)
print(ans)