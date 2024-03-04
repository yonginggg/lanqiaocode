#小明的衣服  lanqiaoOJ 1228

import queue
q = queue.PriorityQueue()

n = int(input())
a = list(map(int, input().split()))

for i in range(len(a)):  q.put(a[i])

sum = 0
while q.qsize()>1:
    t = q.get() + q.get()
    sum += t
    q.put(t)

print(sum)