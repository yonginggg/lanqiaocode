//ˢ��ͳ��  2022���ʮ�������ű�ʡ�� C/C++��ѧB��
//lanqiaoOJ 2098


#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main(){
    ll a,b,n; cin>>a>>b>>n;
    ll week = a*5+b*2;     //ÿ������
    ll days = (n/week)*7;  //����
    n %= week;             //����
    if(n<=a*5) days += n/a+(n%a?1:0);  //����һ��������
    else{                  //����������
        days += 5, n -= a*5;
        days += n/b+(n%b?1:0);
    }
    cout<<days;
    return 0;
}
