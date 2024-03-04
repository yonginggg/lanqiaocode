//���ֱ�߹�ϵ lanqiaoOJ 1240

#include<bits/stdc++.h>
using namespace std;
const double eps = 1e-8;        //ƫ��ֵ
int sgn(double x){              //�ж�x�Ƿ����0
    if(fabs(x) < eps)  return 0;
    else return x<0?-1:1;
}
struct Point{
    double x, y;
    void input(){ scanf("%lf%lf", &x, &y); }
    Point(){}
    Point(double x,double y):x(x),y(y){}
    Point operator + (Point B){return Point(x+B.x,y+B.y);}
    Point operator - (Point B){return Point(x-B.x,y-B.y);}
};
double Cross(Point A,Point B){return A.x*B.y - A.y*B.x;}
struct Line{
    Point p1,p2;       //���ϵ�������
    Line(){}
    Line(Point p1,Point p2):p1(p1),p2(p2){}
};
int Point_line_relation(Point p, Line v){
    		int c = sgn(Cross(p-v.p1,v.p2-v.p1));
    		if(c < 0)return 1;       //1��p��v�����
    		if(c > 0)return 2;       //2��p��v���ұ�
    		return 0;                  //0��p��v��
}
int main(){
    int t;     cin >> t;
    while(t--){
        Point a, b, c;
        a.input(); b.input(); c.input();
        Line v;
        v=Line(a,b);
        int pos=Point_line_relation(c, v);
        if(pos==1) cout<<"L"<<endl;
         if(pos==2)cout<<"R"<<endl;
         if(pos==0)cout<<"IN"<<endl;
    }
    return 0;
}
