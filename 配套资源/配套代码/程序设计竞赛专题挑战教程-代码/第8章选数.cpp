//ѡ��  lanqiaoOJ 753
#include<bits/stdc++.h>
using namespace std;
int n,m,b[25],a, cnt, c[25];
bool is_prime(int n){
     if(n <= 1)   return false;         //1��������
     for(long long i=2; i <= sqrt(n); i++)
         if(n % i == 0)  return false;  //����������������
     return true;                       //����˼����n=2ʱ����true��
}
void dfs(int dep,int e){
    if(dep==m) {
        if(is_prime(a)){
            cnt++;
            return ;
        }
        return ;
    }
    for(int i=e;i<=n;i++)//����
      if(c[i]==0)  {
         c[i]=1;
         a+=b[i];//���
         dfs(dep+1,i+1);
         a-=b[i];//����
         c[i]=0;
     }
}
int main(){
    cin>>n>>m;
    for(int i=1;i<=n;i++)   cin>>b[i];
    dfs(0,1);
    cout<<cnt;
  return 0;
}
