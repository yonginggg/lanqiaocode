//������� 2019���ʮ����� lanqiaoOJ 246
#include <bits/stdc++.h>
using namespace std;
const int N=6;
const int M=6;
int row[M];   //��¼�Ϸ���һ��
bool check(int x) {    //x���ǲ���������3��1
	int num = 0;
	while (x > 0) {
		if ((x & 1) == 1)	num++;
		else  			    num = 0;
		if (num >= 3)   	return true;
		x >>= 1;
	}
	return false;
}
int dp[N][1<<M][1<<M];
int main(){
    int n,m;    cin >> n >>m;
    memset(row,0,sizeof(row));
    int state = 1<<m;
	int t = 0;
	for (int i = 0; i < state; i++) //ɸѡ�Ϸ�״̬
		if (!check(i)){
             row[t]=i;
             t++;   //��t�ֺϷ�����
        }
    memset(dp,0,sizeof(dp));
	for (int i=0;i<t;i++)  dp[0][row[i]][0] = 1;
	for(int i = 1; i < n; i++)
        for(int j=0;j<t;j++)
            for(int k=0;k<t;k++)
				for(int p=0;p<t;p++)
					if((row[j] & row[k] & row[p]) == 0)    //��3��û��3��1��һ����
						dp[i][row[j]][row[k]] += dp[i - 1][row[k]][row[p]];
	int ans = 0;	//ͳ��
	for (int i=0;i<t;i++)
		for (int j=0;j<t;j++)
			ans += dp[n - 1][row[i]][row[j]];
    cout << ans<<endl;
}
