import os
import sys

# 请在此输入您的代码
n = int(input())
a = []
for i in range(n):
    k = list(map(int,input().split()))
    for j in k:
        a.append(j)

a.sort()
for i in range(a[0],a[-1]):
    if i not in a: m = i
    if a.count(i)==2: n = i

print(m, n)