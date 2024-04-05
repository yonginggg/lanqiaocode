# def dfs(s,t):
#     if s == 3:                
#         print(a[0:3])   
#     else: 
#         for i in range(s,t+1):
#            a[s],a[i] = a[i],a[s]   #交换
#            dfs(s+1,t)
#            a[i],a[s] = a[s],a[i]   #恢复

# a = [1,2,3,4,5,6,7,8,9] 
# n = 4
# dfs(0,n-1)                 #前n个数的全排列

def dfs(s,t):
    if s == 3:             #递归结束，输出一个全排列    
        print(b[0:3]) 
    else: 
        for i in range(t):
            if vis[i] == False:
               vis[i] = True
               b[s]=a[i]
               dfs(s+1,t)
               vis[i] = False           

a = [1,2,3,4,5,6,7,8,9]
b = [0]*10           #记录生成的一个全排列
vis = [False]*10     #记录第i个数是否用过
n = 4
dfs(0,n)            #前n个数的全排列

