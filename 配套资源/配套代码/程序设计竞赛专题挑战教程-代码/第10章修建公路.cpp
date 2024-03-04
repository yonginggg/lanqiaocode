//�޽���·1  lanqiaoOJ  1124 
#include <bits/stdc++.h>
using namespace std;
int n,m;
const int N=100005;
typedef long long ll;
const ll INF=0x3f3f3f3f3f3f;
bool vis[N];     // =ture: ��ʾ��i�Ѿ���MST��
ll dis[N];
typedef pair<int,int> pii;
vector<pii> e[N];
priority_queue<pair<int,int>,vector<pii>,greater<pii> > q;  //���ȶ���
void prim(int s){
	memset(dis,INF,sizeof(dis));
	q.push({0,s});   //��s�㿪ʼ�������
	dis[s]=0;
	ll ans=0;
	while(!q.empty())	{
		int u=q.top().second;   //pop���༯������ĵ�u
		q.pop();
		if(vis[u]) continue;    //�����Ѿ���MST�еĵ㣬����Ȧ������
		vis[u]=1;
		ans+=dis[u];
		for(int i=0;i<e[u].size();i++){ //����u�������ھ�
			pii v=e[u][i];          //һ���ھ�
			if(!vis[v.second])
				if(v.first<dis[v.second]){
					dis[v.second]=v.first;
					q.push(pii(dis[v.second],v.second));//��չ�µ��ھӣ��Ž����ȶ���
				}
		}
	}
	for(int i=1;i<=n;i++)
		if(!vis[i]){
			cout<<"-1"<<endl;
			return ;
		}
	cout<<ans<<endl;
}
int main(){
	cin>>n>>m;
	for(int i=0;i<m;i++){
        int u,v,w;	scanf("%d%d%d",&u,&v,&w);
		e[u].push_back({w,v});  //˫���
		e[v].push_back({w,u});
	}
	prim(1);
	return 0;
}
