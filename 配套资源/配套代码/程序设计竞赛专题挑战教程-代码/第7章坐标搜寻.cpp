//������Ѱ  lanqiaoOJ 1546
#include <bits/stdc++.h>
using namespace std;
double x[20],y[20],dp[1<<16][21];
double dist(int a,int b) {   //�������������֮��ľ���
    return sqrt((x[a]-x[b])*(x[a]-x[b])+(y[a]-y[b])*(y[a]-y[b]));
}
int main(){
    memset(dp,0x7f,sizeof(dp));    //��ʼ�����ֵ
    int n; cin>>n;
    x[0]=0; y[0]=0;      //�����(0,0)
    for(int i=1;i<=n;i++) scanf("%lf%lf",&x[i],&y[i]);   //��n����
    n = n+1;   //��n+1����

    dp[1][0]=0;                //��ʼ��������ֻ�е�0�������յ㶼��0
    for(int S=1; S<(1<<n); S++) //��С������չ���󼯺ϣ�������S�Ķ����Ʊ�ʾ
        for(int j=0; j<n; j++)     //ö�ٵ�j
            for(int k=0; k<n; k++)  //ö�ٵ���j�ĵ�k��k���ڼ���S-j
                if( ((S>>j) & 1) && ((S^(1<<j)) >> k & 1) )
                     dp[S][j] = min(dp[S][j],dp[S^(1<<j)][k] + dist(k,j));

    double ans = dp[(1<<n)-1][0];   //����ҵ�����·������̵�
    for(int i=1;i<n;i++){
        double p = dp[(1<<n)-1][i];
        if(ans>p) ans=p;
    }
    printf("%.2f\n",ans);
    return 0;
}
