//����//lanqiaoOJ  2194 

#include<bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int M = 20010;       //˫��ߵ��������
int t[M];
int dist[M];                    //dist[i]: ��㵽��i������·
struct edge{int a,b,c;}e[M];    //�ֿ�����Ҳ�У�int a[M],b[M],c[M];
int main(){
    int n,m; cin>>n>>m;
    for(int i=1;i<=n;i++) cin>>t[i];
    for(int i=1;i<=m;i++){
        int a,b,c;  cin >>a>>b>>c;
        e[i].a=a;   e[i].b=b;   e[i].c=c;    //˫��ߣ�a->b
        e[m+i].a=b; e[m+i].b=a; e[m+i].c=c;  //˫���: b->a
    }
    //���濪ʼbellman-ford
    memset(dist,INF,sizeof(dist));//��ʼ��Ϊ�����
    dist[1]=0;               //�����1�����Լ�����Ϊ0
    for(int k=1;k<=n;k++){  //һ����n�ֲ���
        for(int i=1;i<=2*m;i++){  //���ÿ����
            int u=e[i].a,v=e[i].b;  //u��һ���ھ���v
            int res = t[v];       //����ʱ��
            if(v==n) res = 0;     //�յ㲻�ø���
            dist[v]=min(dist[v],dist[u]+e[i].c+res);  //uͨ��v�����ľ�����̣�����
        }
    }
    cout<<dist[n];
    return 0;
}
