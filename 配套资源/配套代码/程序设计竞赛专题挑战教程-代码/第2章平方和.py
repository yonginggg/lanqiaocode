#平方和  2019年第十届蓝桥杯省赛C/C++大学A组
#lanqiaoOJ 599

sum = 0
for i in range(1,2020):
    s = str(i)
    if '2' in s or '0' in s or '1' in s or '9' in s:   sum += i*i
print(sum)
