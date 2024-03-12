import os
import sys

# 请在此输入您的代码
n = int(input())
scores = []
for i in range(n):
    score = list(map(int,input().split()))
    scores.append([i+1]+[sum(score)]+score)

index = reversed((1,2,0))

for i in index:
    scores.sort(key=lambda x:x[i], reverse=True)
for i in range(5):
    print(scores[i][0],scores[i][1])
