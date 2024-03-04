ten=[0]*15 
dp=[0]*15
ten[0]=1
cnt=[0]*15
for i in range(1,15):
    dp[i]=dp[i-1]*10+ten[i-1]
    ten[i]=ten[i-1]*10
def solve(x):
    num=tuple(map(int,str(x)))
    num=num[::-1]
    for i in range(len(num)-1,-1,-1):
        for j in range(10):     cnt[j] += dp[i]*num[i]
        for j in range(num[i]): cnt[j] += ten[i]
        num2 = 0
        for j in range(i-1,-1,-1): num2 = num2*10+num[j]
        cnt[num[i]] += num2+1
        cnt[0] -= ten[i]
b=int(input())
solve(b)
for i in range(10):  print(cnt[i],end=' ')
