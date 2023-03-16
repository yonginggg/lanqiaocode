import os
import sys
a,b,n = map(int, input().split())
week = a*5+b*2
i=n//week
j=n%week
days=0
if j<=a*5:
    days = i*7+ j//a+(1 if j%a!=0 else 0)
elif j>a*5:
    days = i*7+5+(j-a*5)//b+(1 if (j-a*5)%b!=0 else 0)

print(days)
