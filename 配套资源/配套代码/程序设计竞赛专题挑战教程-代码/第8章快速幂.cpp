//������
//lanqiaoOJ 1514

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;                      //�������ýϴ��long long
ll fastPow(ll a, ll n, ll mod){
    ll ans = 1;
    a %= mod;                             //��Ҫ����ֹ�����ans*aԽ��
    while(n) {
        if(n & 1)   ans = (ans*a) % mod;   //ȡģ
        a = a*a % mod;                     //ȡģ
        n >>= 1;
    }
    return ans;
}
int main(){
    ll b,p,k;    cin>>b>>p>>k;
    cout << fastPow(b,p,k);
    return 0;
}
