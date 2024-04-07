def dfs(num):
    global ans
    if num==13: 
        if b[10] == b[11]*b[12]:   ans+=1
        return
    if num==4  and b[1]+b[2] != b[3]: return       #剪枝
    if num==7  and b[4]-b[5] != b[6]: return        #剪枝
    if num==10 and b[7]*b[8] != b[9]: return      #剪枝
    for i in range(1,14):
        if not vis[i]:
            b[num]=i
            vis[i]=1
            dfs(num+1)
            vis[i]=0
ans=0
b = [0]*15
vis=[0]*15
dfs(1)
print(ans)

