//������ 2016����߽�ʡ��  lanqiaoOJ 120
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 105;
ll x[N],a[N],b[N];
ll gcd_sub(ll a,ll b){
    if(a<b)   swap(a,b);
    if(b==1)  return a;
    return gcd_sub(b,a/b);
}
int main(){
    int n; cin >>n;
    ll cnt=0;
    for(int i=0;i<n;i++)  cin>>x[i];
    sort(x,x+n);         //����
    for(int i=1;i<n;i++){
        ll d = __gcd(x[i],x[0]);
        a[cnt] = x[i]/d;
        b[cnt] = x[0]/d;   //Լ��,�÷���a / ��ĸb
        cnt++;
    }
    ll up = a[0], down = b[0];
    for(int i=1;i<cnt;i++){
        up= gcd_sub(up,a[i]);        //�����
        down = gcd_sub(down,b[i]);   //���ĸ
    }
    cout<<up<<'/'<<down<<endl;
    return 0;
}
