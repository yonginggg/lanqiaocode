//�䳲 2022���ʮ����ʡ��Java��ѧA�顢�о����飬Python��ѧB�顢C��
//lanqiaoOJ 2134
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll xdir[] = {-2,-1,1,2, 1,-1};  //����
ll ydir[] = { 0, 1,1,0,-1,-1};  //����
void walk(ll d, ll q, ll &x, ll &y){
    x += xdir[d] * q;
    y += ydir[d] * q;   //���ô��Σ���������ֵ(x,y)
}
int main(){
    ll d1,p1,q1,d2,p2,q2;
    cin>>d1>>p1>>q1>>d2>>p2>>q2;
    ll x1 = 0, y1 = 0;           //�����������(x1, y1)
    walk(d1,p1,x1,y1);           //���ߵ�1������
    walk((d1 + 2) % 6, q1,x1,y1); //���ߵ�2������
    ll x2 = 0, y2 = 0;           //�����յ�����(x2, y2)
    walk(d2,p2,x2,y2);
    walk((d2 + 2) % 6, q2,x2,y2);
    ll dx = abs(x1 - x2), dy = abs(y1 - y2);
    if (dx >= dy) cout << (dx+dy)/2;     //�Ⱥ��ߣ���б����
    else          cout << dy;            //һֱб���߾�����
}
