
w = [0]*40
v = int(input())
n = int(input())
dp = [[0]*(v+1) for i in range(n+1)]
for i in range(1,n+1): 
    w[i] = int(input())

def solve(n,v):
    for i in range(1,n+1): 
        for j in range(v+1):
            if(w[i]>j): 
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=max(dp[i-1][j-w[i]]+w[i],dp[i-1][j])
    return dp[n][v]

print(v-solve(n,v))