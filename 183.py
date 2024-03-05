import math

n = int(input())
c = int(math.log(n,2))+1   #一共有c层

a = [0]+list(map(int, input().split())) #a[1]~a[n]
s = [0] * (c+1)   #记录每层的和，s[1]~s[c]

for i in range(1,c+1):            #第1层到第c层
    s[i] = sum(a[2**(i-1): 2**i-1 +1])#注意切片范围

print(s.index(max(s)))
