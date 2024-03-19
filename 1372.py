n, S = map(int, input().split())
a = list(map(int, input().split()))
sum = 0
ans = 1e8
i,j = 0,0
while(i<len(a)):
    if sum<S:
        sum+=a[i]
        i+=1
    else:
        ans = min(i-j, ans)
        sum-=a[j]
        j+=1
if ans ==1e8: print(0)
else: print(ans)