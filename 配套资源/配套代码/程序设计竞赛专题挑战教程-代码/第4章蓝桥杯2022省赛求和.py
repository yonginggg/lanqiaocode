# lanqiaoOJ 2080
# 2022省赛 求和
n = int(input())
a=[int(i) for i in input().split()]          #注意：读入a时，范围是a[0]~a[n-1]
sum = [0] * n                                #定义前缀和
sum[0] = a[0]
for i in range(1,n): sum[i] = a[i]+sum[i-1]  #计算前缀和sum[]
s = 0
for i in range(0,n-1):  s += sum[i]*a[i+1]   #计算和s
print(s)
