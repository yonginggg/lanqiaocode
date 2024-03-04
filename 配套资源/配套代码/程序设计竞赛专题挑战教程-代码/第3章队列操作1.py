#队列操作  lanqiaoOJ 1519
from queue import *
q = Queue()
n = eval(input())
for i in range(n):
    s = list(map(int,input().split()))
    if s[0] == 1:
        q.put(s[1])  
    elif s[0] == 2:
        if not q.empty():
            a = q.get()
            print(a)
        else:
            print('no')
            break
    elif s[0] == 3:
        print(q.qsize())
