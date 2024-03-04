//一元三次方程求解 lanqiaoOJ 764

#include <bits/stdc++.h>
using namespace std;
double a,b,c,d;
double y(double x){ return a*x*x*x+b*x*x+c*x+d;}
int main(){
    scanf("%lf%lf%lf%lf",&a,&b,&c,&d);  //输入
    for (int i=-100;i<100;i++){ //题目说“根与根之差的绝对值≥1”，分为200个小区间
        double left = i, right =i+1;
        double y1 = y(left), y2 = y(right);
        if(y1 == 0) printf("%.2lf ",left); //判断左端点。一个小坑
        if(y1*y2 < 0){                     //小区间内有根
           for(int j = 0; j<100; j++){     //在小区间内二分
                double mid=(left+right)/2;
                if(y(mid)*y(right) <= 0)
                   left = mid;
                else
                   right = mid;
            }
            printf("%.2lf ",right);
        }
    }
    return 0;
}
