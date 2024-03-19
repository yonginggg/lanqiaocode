def check(d):
    num = 0
    for i in range(n):
        num+= (h[i]//d)*(w[i]//d)
    if num>=k :return True
    else: return False

n,k = map(int, input().split())
h = [0]*(n+1)
w = [0]*(n+1)
for i in range(n):
    h[i],w[i] = map(int, input().split())

left, right = 1, 100010
while left<right:
    mid = (left+right)//2
    if check(mid):left=mid+1
    else: right=mid

print(left-1)