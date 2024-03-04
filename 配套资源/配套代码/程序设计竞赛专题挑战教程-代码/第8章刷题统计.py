#刷题统计  2022年第十三届蓝桥杯省赛 C/C++大学B组
#lanqiaoOJ 2098

a,b,n = map(int,input().split())
week = a*5+b*2
days = (n//week)*7                     #注意是//不是/
n %= week      
if n <= a*5: days += n//a+(1 if n%a>0 else 0)   #三目运算
else:
    days += 5
    n -= a*5
    days += n//b+(1 if n%b>0 else 0)
print(days)
