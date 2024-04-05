# 【题目描述】 给出一张图，输出从起点到终点的所有路径。
# 【输入描述】 第一行是整数n，m，分别是行数和列数。后面n行，每行m个符号。’@’是起点，’*’
# 是终点，’•’能走，’#’是墙壁不能走。在每一步，都按左-上-右-下的顺序搜索。在样例中，左上角
# 坐标(0, 0)，起点坐标(1, 1)，终点坐标(0, 2)。1<n, m <7。
# 【输出描述】输出所有的路径。坐标(i, j)用ij表示，例如坐标(0, 2)表示为02。从左到右是i，从上到下是j。
# 【输入样例】                                                 
# 5 3
# .#.
# #@.
# *..
# ...
# #.#
# 【输出样例】
# from 11 to 02
# 1: 11->21->22->12->02
# 2: 11->21->22->12->13->03->02
# 3: 11->21->22->23->13->03->02
# 4: 11->21->22->23->13->12->02
# 5: 11->12->02
# 6: 11->12->22->23->13->03->02
# 7: 11->12->13->03->02
import sys
import os

def dfs(x, y):
    global num
    for i in range(0,4):
        dir = [(-1, 0), (0, -1),(1, 0),  (0, 1)]         #左、上、右、下 
        nx,ny = x + dir[i][0]  ,y + dir[i][1]            #新坐标
        if nx<0 or nx>=hx or ny<0 or ny>wy:  continue    #不在地图内
        if mp[nx][ny]=='*':
            num+=1
            print("%d: %s->%d%d"%(num,p[x][y],nx,ny))    #打印路径
            continue                                     #不退出，继续找下一个路径
        if mp[nx][ny]=='.':
            mp[nx][ny]='#'                 #保存现场。这个点在这次更深的dfs中不能再用
            p[nx][ny]=p[x][y]+'->'+str(nx)+str(ny)       #记录路径
            dfs(nx,ny)
            mp[nx][ny]='.'                 #恢复现场。回溯之后，这个点可以再次用


num = 0
wy,hx = map(int, input().split())          #Wy行，Hx列。用num统计路径数量 
a =['']*10                   
for i in range(wy):  a[i]=list(input())    #读迷宫
mp = [[' '] * (10) for i in range(10)]     #二维矩阵mp[][]表示迷宫
for x in range(hx):
    for y in range(wy):
        mp[x][y] = a[y][x]                 
        if mp[x][y]=='@': sx=x; sy=y        #起点
        if mp[x][y]=='*': tx=x; ty=y        #终点
print("from %d%d to %d%d"%(sx,sy,tx,ty))
p = [[' '] * (10) for i in range(10)]       #记录从起点到点path[i][j]的路径
p[sx][sy] = str(sx)+str(sy)
dfs(sx,sy)                                  #搜索并输出所有的路径
                              
