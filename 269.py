from itertools import *

a = input()
b = sorted(a)

cnt = 0
for i in permutations(b,len(b)):
    if a==''.join(i):
        print(cnt)
        break
    cnt+=1

