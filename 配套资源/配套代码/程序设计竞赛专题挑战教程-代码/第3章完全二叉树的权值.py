#完全二叉树的权值  2019年第十届省赛C/C++A组
# lanqiaoOJ 183

p = []
for i in range(0, 33):   #32层
    p.append(2 ** i)     #每层的个数：p[]=1,2,4,8,16,... 
n = int(input())
a = input().split(" ") 
sum = [0] * 32   #记录每层的和
for i in range(0, n):
    for j in range(0, len(p)):
        if i + 1 >= p[j] and i + 1 < p[j + 1]:  #计算每层的和
            sum[j] += int(a[i]) 
maxx, mindeep = -1, -1
for i in range(0, len(sum)):
    if maxx < sum[i]:
        maxx, mindeep = sum[i], i
print(mindeep + 1)
