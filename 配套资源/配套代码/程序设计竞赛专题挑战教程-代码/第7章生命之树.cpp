//����֮�� 2015�������ʡ��  lanqiaoOJ 131

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100010;
ll dp[N];
ll res;
vector<int> tree[N];    //���ڽӱ�����ı�
int w[N];
void dfs(int u, int fa){
    for (int i = 0; i < tree[u].size(); i ++ ){
        int son = tree[u][i];
        if (son != fa){      //��Ҫ������������
            dfs(son, u);     // ���ӽ����еݹ�
            if(dp[son]>0) dp[u] += dp[son]; //����ӽ�㼰������Ȩֵ�ʹ����㣬����뵽������Ȩֵ
        }
    }
    res = max(res, dp[u]);  //�������Ȩֵ��
}
int main(){
    int n; cin >> n;
    for (int i = 1; i <= n; i ++ )    cin >> w[i], dp[i] = w[i];
    for (int i = 0; i < n - 1; i ++ ){
        int u, v;    scanf("%d%d", &u, &v);
        tree[u].push_back(v);    tree[v].push_back(u);   //˫���
    }
    dfs(1, -1);   //��ѡһ���㿪ʼDFS������ѡ1�ŵ�
    cout << res;
    return 0;
}

