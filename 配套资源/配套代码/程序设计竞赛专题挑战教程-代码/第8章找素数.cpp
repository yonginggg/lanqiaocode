//������ lanqiaoOJ 1558

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 1000005;
bool seg_prime[N];
bool vis[N];
ll prime[N]; //��[a,b]�ڵ�����
ll seg_sieve(ll a,ll b) {
    for(ll i=0;i<=sqrt(b);++i) vis[i]=true;
    for(ll i=0;i<=b-a;++i) seg_prime[i]=true;
    for(ll i=2;i<=sqrt(b);++i)
        if(vis[i]) {                  //i������
            for(ll j=i*i;j<=sqrt(b);j+=i)//ɸѡ[2,sqrt(b)]�ڵ�����
                vis[j] = false;
             for(ll j=max(2LL,(a+i-1)/i)*i;j<=b;j+=i)//ɸѡ[a,b]�ڵ�����
                seg_prime[j-a] = false;
        }
    ll num=0;
    for(ll i=0;i<=b-a;++i)  //ͳ��[a,b]����������
        if(seg_prime[i])  prime[num++]=i+a; //��[a,b]�ڵ�����
    return num;
}
int main(){
    ll a,b; cin >>a>>b;
    cout <<seg_sieve(a,b);
    return 0;
}
