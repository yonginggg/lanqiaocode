#青蛙过河 2022年第十三届蓝桥杯省赛 C/C++大学A组，Java大学A组、C组，Python大学C组
#lanqiaoOJ 2097


def check(mid):
    for i in range(mid, n):
        if sum[i] - sum[i-mid] < 2 * x: return False
    return True 
 
n, x = map(int, input().split())
h = list(map(int, input().split()))
sum = [0, h[0]]
for i in range(1, len(h)):
    sum.append(h[i] + sum[i])
L = 0
R = 100000
while L <= R:
    mid = (L + R) // 2
    if check(mid):   R = mid - 1
    else:            L = mid + 1
print(L)
