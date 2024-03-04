#lanqiaoOJ 610
#[分数 2018年第九届蓝桥杯C/C++大学A组，Java大学A组 ] 
#代码1：
a,b = 1,0
for i in range(0,20):  
    b += a
    a *= 2    
print("%d/%d"%(b,a/2))

#代码2：
print("%d/%d"%(2 ** 20 -1,2 ** 19))

#代码3：
print(str(2 ** 20 -1)+'/'+str(2 ** 19))

#代码4：
print("%d/%d"% (pow(2,20)-1 ,pow(2,19)))
