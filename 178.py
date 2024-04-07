from queue import Queue

def bfs(x,y):
    global flag
    q = Queue()
    q.put((x,y))
    vis[x][y]=1
    while not q.empty():
        x,y = q.get()
        if mp[x][y+1]=='#' and mp[x][y-1]=='#' and mp[x+1][y]=='#' and mp[x-1][y]=='#':flag = 1
        for u,v in ((0,1),(0,-1),(1,0),(-1,0)): #扩展4个方向
            nx = x+u
            ny = y+v
            if vis[nx][ny]==0 and mp[nx][ny]=="#":
                q.put((nx,ny))
                vis[nx][ny]=1

n = int(input())
mp = [list(input()) for i in range(n)]
# print(mp)
vis = [[0]*n for i in range(n)]
# print(vis)
ans = 0
for i in range(n):
    for j in range(n):
        if vis[i][j]==0 and mp[i][j]=='#':
            flag = 0
            bfs(i,j)
            if flag==0: ans+=1

print(ans)