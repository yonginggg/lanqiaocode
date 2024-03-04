#付账问题 2018年第九届蓝桥杯C/C++大学A组，Java大学A组
#题目链接： lanqiaoOJ 174
from math import *
n, s = map(int,input().split())
a = list(map(int,input().split()))
a.sort()
avg = s/n
sum = 0
for i in range(n):
     if a[i]*(n-i) < s:
          sum += pow(a[i]-avg,2)
          s -= a[i]
     else:
          cur_avg = s/(n-i);      #更新平均出钱数
          sum += pow(cur_avg-avg,2)*(n-i)
          break
print("{:.4f}".format(sqrt(sum/(n))))
