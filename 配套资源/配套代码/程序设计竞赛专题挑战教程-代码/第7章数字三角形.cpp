//����������  2020���ʮһ��ʡ��  lanqiaoOJ 505

#include <bits/stdc++.h>
using namespace std;
const int N = 101;
int a[N][N], dp[N][N];
int main(){
    int n;   cin>>n;
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= i; j++)
            cin>>a[i][j];
    dp[1][1] = a[1][1];
    for(int i = 2; i <= n; i++)
        for(int j = 1; j <= i; j++)
            dp[i][j] = max(dp[i-1][j] + a[i][j], dp[i-1][j-1] + a[i][j]);
    if(n & 1) cout<<dp[n][n/2 + 1];              //��������
    else cout<<max(dp[n][n/2], dp[n][n/2 + 1]);  //ż��
    return 0;
}

