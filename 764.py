# # 暴力
# a,b,c,d = map(float, input().split())
# i = -100
# while(i<=100):
#     i = round(i,2)
#     if(round(a*i**3+b*i**2+c*i+d,2) == 0.00):
#         print("{:.2f}".format(i), end=" ")
#     i+=0.01

# 二分法
def y(i):
    return round(a*i**3+b*i**2+c*i+d,2)
a,b,c,d = map(float, input().split())
for i in range(-100,100):
    left,right = i,i+1
    y1, y2 = y(left),y(right)
    if y1==0.00:
        print("{:.2f}".format(left),end=" ")
    if y1*y2<0:
        for i in range(100):
            mid = (left+right)/2
            if y(mid)*y(right)<0:left=mid
            else:right=mid
        print("{:.2f}".format(right),end=" ")