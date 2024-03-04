//��������µ����·����  //lanqiaoOJ  1366 
#include<bits/stdc++.h>
using namespace std;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const int N = 5e3+10;
struct edge{
    int to;    long long w;
    edge(int tt,long long ww) {to = tt; w = ww;}
};
long long dist[N];
int inq[N];
vector<edge> e[N];
void spfa(int s){
    memset(dist,0x3f,sizeof(dist));
    dist[s] = 0;    //��㵽�Լ��ľ�����0
    queue<int> q;
    q.push(s);      //��s��ʼ��s������
    inq[s] = 1;  //����ڶ�����
    while(!q.empty()) {
        int u = q.front();
        q.pop();
        inq[u] = 0;   //u�Ѿ����ڶ�����
        if(dist[u] == INF)     continue;
        for(int i = 0;i < e[u].size();i++) { //����u���ھ�
            int v = e[u][i].to;
            long long w = e[u][i].w;
            if(dist[v] > dist[u]+w) { //u�ĵ�i���ھ�v�������u����s����
                dist[v] = dist[u]+w;  //�����ھ�v��s�ľ���
                if(!inq[v]) {   //�ھ�v����״̬�ˣ���v���ڶ����У��Ž�����
                    q.push(v);
                    inq[v] = 1;
                }
            }
        }
    }
}

int main(){
    int n,m,s;cin>>n>>m>>s;
    for(int i = 1;i <= m;i++)    {
        int u,v; long long w;
        cin>>u>>v>>w;
        e[u].push_back(edge(v,w));
    }
    spfa(s);
    for(int i = 1;i <= n;i++) {
        if(dist[i]==INF)  cout << -1;
        else              cout << dist[i];
        if(i != n)        cout << " ";
        else              cout << endl;
    }
    return 0;
}
