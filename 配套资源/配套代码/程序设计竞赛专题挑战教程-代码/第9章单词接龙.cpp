//���ʽ���  lanqiaoOJ 769
#include<bits/stdc++.h>
using namespace std;
const int N=100;
int n;
int ans = 0;
string word[N];  //�浥��
int vis[N];      //��¼ÿһ�����ʱ�ʹ���˼���
bool check(string s,string m,int k){  //�ж��Ƿ���ƴ�ӡ���substrʵ��
    int len = s.size();
    if(s.size()<k || m.size()<k) return false;
    if(s.substr(len-k,k) == m.substr(0,k)) //s�ĺ�k����m��ǰk����ͬ����ƴ��
        return true;
    return false;
}
bool check1(string s,string m,int k){  //�жϣ���ʵ��
    int lens = s.length();
    for (int i=0;i<k;i++){
        if(s[lens-k+i]!=m[i])
            return false;
    }
    return true;
}
string add(string s,string m,int k){  //ƴ�ӣ���substrʵ��
    int len = m.size();
    s = s + m.substr(k,len-k);   //ƴ�ӣ���m�ӵ�s�ϡ�
    return s;
}
string add1(string s,string m,int k){ //ƴ�ӣ���ʵ��
    int len = m.size();
    for (int i=k;i<len;i++)  s+=m[i];
    return s;
}
void dfs(string dragon){   //dragon��Ŀǰƴ�Ӻõ�����
    int len = dragon.size();
    ans = max(ans, len);
    for (int i=1;i<=n;i++){
        if (vis[i]>=2) continue;   //��Ŀ˵ÿ�����������2��
        int k = word[i].size();
        for (int j=1;j<=k;j++)   //ö��ƴ�ӳ���
            if (check(dragon,word[i],j)){
                string temp = dragon;
                temp = add(temp,word[i],j);
                vis[i]++;
                dfs(temp);
                vis[i]--;
            }
    }
}
int main(){
    cin >> n;
    for (int i=1;i<=n;i++) cin >> word[i];
    string first; cin >> first;
    dfs(first);       //��dfs�������п��ܵ�ƴ��
    cout << ans << endl;
    return 0;
}
