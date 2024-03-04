#汉诺塔 hlanqiaoOJ 1512

def hanoi(x, y, z, n):
    global sum
    if (n == 1):
        sum += 1
        if (sum == m):  print(f"#{n}: {x}->{z}")
    else:
        hanoi(x, z, y, n-1)
        sum += 1
        if sum == m:    print(f"#{n}: {x}->{z}")
        hanoi(y, x, z, n-1)
n, m = map(int, input().split())
sum = 0
hanoi('A', 'B', 'C', n)
print(sum)
