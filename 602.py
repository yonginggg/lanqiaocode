from queue import Queue
def print_path(x,y):
    if x==1 and y==1:  return   #回溯到了起点，递归结束，返回
    if pre[x][y]=='D': print_path(x-1,y);  #回溯，往上 U
    if pre[x][y]=='L': print_path(x,  y+1);#回溯，往右 R
    if pre[x][y]=='R': print_path(x,  y-1);
    if pre[x][y]=='U': print_path(x+1,y);
    print(pre[x][y],end="")         #最后打印终点


mp = []
for i in range(30): mp.append(input())
for i in range(len(mp)):
    mp[i] = '1'+mp[i]+'1'
mp = ['1'*52]+mp+['1'*52]
# print(mp)
vis = [list(map(int, list(i))) for i in mp] #记录迷宫的状态
k = ('D','L','R','U')               #方向 
dir = ((1,0),(0,-1),(0,1),(-1,0))
# print(vis)
pre = [[(-1, -1)] * (52) for i in range( 32)]  # 用于保存前一个点
# print(pre)
print(pre[0][0])
#下面是bfs:
vis[1][1] = 1               #起点是(1,1)

q = Queue()
q.put((1, 1))

while q.qsize() !=0:
    x,y =q.get()
    if x==30 and y==50:  print_path(30,50); exit  #打印路径，退出
    for i in range(4):
        nx = x + dir[i][0]
        ny = y + dir[i][1]
        if vis[nx][ny] != 1:     #把访问过的点变成墙，后面不再访问
            vis[nx][ny] = 1
            pre[nx][ny] = k[i]
            q.put((nx, ny))
