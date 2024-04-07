def dfs(k):                   #深搜到第k个
    if k == 4:
        for i in range (4):
            if vis[i]==1:
                print(a[i],end='')
        print()
    else:
        vis[k] = 0            #不选第k个
        dfs(k + 1)            #继续搜下一个
        vis[k] = 1            #选第k个
        dfs(k + 1)            #继续搜下一个

vis = [0]*10
a=[1,2,3,4,5,6,7,8,9,10]  
dfs(0) 
