//�ǹ� 2019���ʮ��ʡ��  lanqiaoOJ 186

#include<bits/stdc++.h>
using namespace std;
int dp[1<<20]; //dp[v]:�õ���ζΪvʱ��Ҫ�������ǹ�������
int kw[100];   //kw[i]����i���ǹ��Ŀ�ζ
int main() {
    int n,m,k;    cin>>n>>m>>k;
    int tot = (1<<m)-1;      //tot����������m��1����ʾ����m�ֿ�ζ
    memset(dp, -1, sizeof dp);
    for (int i=0; i<n; i++){
        int tmp=0;
        for (int j=0; j<k; j++){  //����һ���ǹ���k�ֿ�ζ
            int x;  cin>>x;
            tmp|=(1<<x-1);  //״̬ѹ����������ǹ���k�ֿ�ζ��tmp��ʾ
        }
        kw[i]=tmp;   //kw[i]����i���ǹ��Ŀ�ζ
        dp[tmp]=1;   //dp[v]:�õ���ζΪvʱ��Ҫ�������ǹ�������
    }
    for (int i=0; i<=tot; i++)  //�������п�ζ���
        if (dp[i]!=-1)          //�Ѵ��ڵõ���ζi�������ǹ�������
            for (int j=0; j<n; j++)  {  //��������n���ǹ�
                int tmp = kw[j];
                if (dp[i|tmp]==-1 || dp[i|tmp]>dp[i]+1) dp[i|tmp] = dp[i]+1; //״̬ת��
            }
    cout << dp[tot];  //�õ����п�ζtot�������ǹ�������
    return 0;
}
