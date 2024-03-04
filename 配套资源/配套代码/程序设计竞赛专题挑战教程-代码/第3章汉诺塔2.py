#汉诺塔 lanqiaoOJ 1512
st =  [[0 for i in range(30000)] for i in range(4)]
sum,m = 0,0
def move(x, y, n):
    global sum,m
    element = st[x].pop()
    st[y].append(element)
    sum +=1
    a,b ='',''    
    if x==1: a='A'
    if x==2: a='B'
    if x==3: a='C'
    if y==1: b='A'
    if y==2: b='B'
    if y==3: b='C'
    if sum == m: print('#',n,': ',a,"->",b, sep="")    

def hanoi(n,x, y, z):    
    if (n == 1): move(x,z,n)
    else:
        hanoi(n-1,x, z, y)
        move(x,z,n)
        hanoi(n-1,y, x, z)
        
n, m = map(int, input().split())
for i in range(n):  st[1].append(i)
hanoi(n,1,2,3)
print(sum)
