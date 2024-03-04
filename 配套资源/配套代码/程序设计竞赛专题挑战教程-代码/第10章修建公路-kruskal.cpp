//�޽���·1  lanqiaoOJ 1124 

#include<bits/stdc++.h>
using namespace std;
const int N = 100005,M = 300006;
int n,m;
int s[N];//���鼯
struct Edge{ int from,to,dis;}e[M];     //���������ʡ�ռ�Ľṹ��������
bool cmp(Edge a,Edge b){  //��С��������
	return (a.dis<b.dis);
}
int find(int x)  { //��ѯ���鼯������x�ĸ�
	if(x!=s[x]) s[x]=find(s[x]);//·��ѹ��
	return s[x];
}
void union_set(int x,int y)   {   //�ϲ�
	s[find(y)]=find(x);
}
void kruskal(){
    long long ans=0;
    int cnt=0;
	sort(e+1,e+m+1,cmp);                //�Ա�������
	for(int i=1;i<=n;++i)  s[i]=i;    //���鼯��ʼ��
	for(int i=1;i<=m;++i){            //̰�ģ���һ����ÿ����
		if(find(e[i].from)!=find(e[i].to)){ //�ߵĶ˵�����ͬһ������
			ans+=e[i].dis; //����MST
			union_set(e[i].from,e[i].to);//�ϲ�
			++cnt;                 //ͳ��MST�еĵ���
		}
		if(cnt==n-1) break;
	}
	if(cnt!=n-1)     cout<<"-1";
	else             cout<<ans;
	return;

}

int main(){
	cin>>n>>m;
	for(int i=1;i<=m;++i)  cin>>e[i].from>>e[i].to>>e[i].dis;
    kruskal();
	return 0;
}
