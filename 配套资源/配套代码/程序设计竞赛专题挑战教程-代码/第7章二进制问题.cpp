//���������� 2021���ʮ�������   
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 60;
ll r, K;
ll dp[N][N];
void init(){         //���������dp[][]
    for (int i = 0; i < N; i++ )
        for (int j = 0; j <= i; j++ )
            if (j==0) dp[i][j] = 1;
            else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
}
int nums[21];   //��nת�ɶ����ƣ���λ�浽nums�
ll solve(ll n){
    int len = 1;
    while(n){  nums[len]=n%2;  n/=2; len++; }
    len--;      //nums[1]�����λ��nums[len]�����λ
    ll ans = 0;
    int last = 0;                 //�Ѿ����˼���1
    for (int i=len; i>=1; i-- ) { //�Ӹ�λ����λ
        if (nums[i]==1){               //�����һλ��1
            ans += dp[i-1][K - last];  //����iλѡ0ʱ
            last ++ ;
            if (last > K) break; //���1���������ڹ涨������ʱ,����
        }
        if (i==1 && last == K) ans++;//���һλ,���1������ǡ�õ��ڹ涨����ʱ,�����һλ����Ҫ��*/
    }
    return ans;
}
int main(){
    cin >> r >> K;
    init();
    cout << solve(r);
    return 0;
}
