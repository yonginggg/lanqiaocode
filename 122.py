import os
import sys
from math import *

try:
    n = int(input())
    i=int(sqrt(n))
    for a in range(i+1):
        j=int(sqrt(n-a*a))
        for b in range(a, j+1):
            k=int(sqrt(n-a*a-b*b))
            for c in range(b, k+1):
                l=n-a*a-b*b-c*c
                d = int (sqrt(l))
                if d*d == l and d>=c:
                    print(a,b,c,d,end=" ")
                    exit(0)

except Exception as e: pass
