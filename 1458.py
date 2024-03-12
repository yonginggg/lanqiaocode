import os
import sys

n,m = map(int,input().split())
a = [i for i in range(1,n+1)]
for i in range(m):
    p,q = map(int, input().split())
    if p ==0:
        a = sorted(a[:q], reverse=True)+a[q:]
    else:
        a = a[:q-1]+sorted(a[q-1:])

for i in a:
    print(i,end=" ")