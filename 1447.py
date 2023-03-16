n = int(input())
w = list(map(int, input().split()))
ans = set()
ans.add(0)
for i in w:
    for j in list(ans):
        #ans.add(i)为啥？
        ans.add(i+j)
        ans.add(abs(i-j))

print(len(ans)-1)