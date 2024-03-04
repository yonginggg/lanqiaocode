//���� lanqiaoOJ 1050

#include <bits/stdc++.h>
using namespace std;
const int INF=0x3f3f3f3f;
double x[20],y[20];
double dis(int a,int b){
    return sqrt((x[a]-x[b])*(x[a]-x[b])+(y[a]-y[b])*(y[a]-y[b]));
}
int n;
double w[20][20],D;
int dp[1<<20][20];  //����int������doubleʡ�ռ�
void floyd(){
    for(int k=0;k<n;k++)
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                w[i][j]=min(w[i][j],w[i][k]+w[k][j]);
}
int main(){
    cin>>n>>D;
    for(int i=0;i<n;i++)   cin>>x[i]>>y[i];
    for(int i=0;i<n;i++)        //��ʼ��2����ׯ֮��ľ���
        for(int j=i+1;j<n;j++){
            w[i][j]=w[j][i]=dis(i,j);
            if(w[i][j]>D) w[i][j]=w[j][i]=INF; //�������D
        }
    floyd();
    memset(dp,0x3f,sizeof(dp));    //��ʼ�����ֵ
    dp[1][0]=0;               //��ʼ��������ֻ�е�0�������յ㶼��0
    for(int S=0;S<(1<<n);S++)//��С������չ���󼯺ϣ�������S�Ķ����Ʊ�ʾ
        for(int j=0;j<n;j++) //ö�ٵ�j
             if((S>>j&1))
                for(int k=0;k<n;k++) //ö�ٵ���j�ĵ�k��k���ڼ���S-j
                     if(((S^(1<<j))>>k&1))
                        dp[S][j]=min(dp[S][j],dp[S^(1<<j)][k]+int(5000*w[k][j])) ;
    int ans=INF;    //����ҵ�����·������̵�
    for(int i=1;i<n;i++)
        ans=min(ans,int(w[i][0]*5000)+dp[(1<<n)-1][i]); //���ϻص����ĳ���
    printf("%.2f",ans/5000.0);
}
