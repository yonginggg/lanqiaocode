// 

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N=15;
ll ten[N],dp[N];
ll cnt[N];                      //cnt[i]，统计数字“i”出现了多少次
int num[N];                     //把一个数字按位分解
void init(){                    //预计算dp[]
    ten[0] = 1;                 //ten[i]: 10的i次方
    for(int i=1;i<=N;i++){
        dp[i]  = i*ten[i-1];    //或者用递推：dp[i] = dp[i-1]*10+ten[i-1];
        ten[i] = 10*ten[i-1];
    }
}
void solve(ll x){
    int len = 0;                //数字x有多少位
    while(x){                   //分解x，num[i]是x的第i位数字
        num[++len] = x%10;
        x=x/10;
    }
    for(int i=len;i>=1;i--){                            //从高到低处理x的每一位
        for(int j=0;j<=9;j++)      cnt[j] += dp[i-1]*num[i];
        for(int j=0;j<num[i];j++)  cnt[j] += ten[i-1];  //特判最高位比num[i]小的数字
        ll num2 = 0;
        for(int j=i-1;j>=1;j--)    num2 = num2*10+num[j];
        cnt[num[i]] += num2+1;                          //特判最高位的数字num[i]
        cnt[0] -= ten[i-1];                             //特判前导0
    }
}
int main(){
    init();
    ll b;  cin >> b;
    solve(b);
    for(int i=0;i<=9;i++)  cout << cnt[i] <<" ";   //打印每个数码出现的次数
}