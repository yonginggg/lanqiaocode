def check(d):
    num = 0
    pos = 0
    for i in range(n):
        if (stone[i]-pos<d): num+=1
        else: pos = stone[i]
    if num<=m: return True
    else: return False

l,n,m = map(int, input().split())
stone = []
for i in range(n):stone.append(int(input()))

left, right = 0, l
while(left<right):
    mid = (left+right+1)//2
    if check(mid): left=mid
    else: right = mid-1
print(left)
