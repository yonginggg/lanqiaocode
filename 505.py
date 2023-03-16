n = int(input())
w = [list(map(int , input().split())) for i in range(n)]
# print(w)
for i in range(1,n):
    for j in range(0,i+1):
        # print(j)    
        if j==0:
            w[i][j] +=w[i-1][j]
        elif j==i:
            w[i][j] +=w[i-1][j-1]
        else:
            w[i][j] +=max(w[i-1][j-1:j+1])

if n%2 ==1:
    print(w[-1][n//2])
else:
    print(max(w[-1][n // 2 - 1], w[-1][n // 2]))