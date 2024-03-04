#爬树的甲壳虫  2022年第十三届省赛 C/C++大学A组、研究生组，Java研究生组，Python研究生组
#lanqiaoOJ 2085

def mod_inverse(b,mod):
    return pow(b,mod-2,mod)
MOD = 998244353
n = int(input())
a = []
for i in range(n): a.append(list(map(int,input().split())))
res = 0
for i in range(n):
    res = (res+1) * a[i][1] * mod_inverse(a[i][1]-a[i][0], MOD)
    res = (res+MOD) % MOD
print(res)
