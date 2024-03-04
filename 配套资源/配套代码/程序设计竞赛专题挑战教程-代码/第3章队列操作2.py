#队列操作  lanqiaoOJ 1519
n = eval(input())
q = []
for i in range(n):
    s = list(map(int,input().split()))
    if s[0] == 1:
        q.append(s[1])
    elif s[0] == 2:
        if len(q) > 0:
            q.reverse()
            a = q.pop()
            print(a)
            q.reverse()
        else:
            print('no')
            break
    elif s[0] == 3:
        print(len(q))

