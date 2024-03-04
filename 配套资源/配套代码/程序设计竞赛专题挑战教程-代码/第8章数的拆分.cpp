//���Ĳ��    lanqiaoOJ 2090 

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 4000;
int prime[N+1],visit[N+1];
 int cnt = 0;
int E_sieve()  {

    for(int i = 2; i <= N; i++){  //���Ż��İ���ɸ
        if(!visit[i]) prime[++cnt] = i;
        for(int j = i*i; j <= N; j += i)   visit[j] = 1;
    }
}
void solve(){
    ll a;   scanf("%lld",&a); //���ﲻ����cin����̫��
    for(int i = 1; i <= cnt; i++){
        int c = 0;
        while(a % prime[i] == 0) a/=prime[i], c++;
        if(c==1){ cout << "no\n"; return; }
    }
    ll k = sqrt(a);
    if(k * k == a){ cout << "yes\n"; return;}//���n�Ƿ�Ϊƽ����
    k = pow(a, 1/3);
    if(k*k*k == a){ cout << "yes\n"; return;}//���n�Ƿ�Ϊ������
    cout << "no\n";
}
int main(){
    E_sieve(); //Ԥ��������
    int T;   cin >> T;
    while(T--)   solve();
}

/*  ��������ǶԵģ�

#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 2e5 + 10;

bool not_prime[4010];
int prime[4010], tot;
void init(int n)
{
    for(int i = 2; i <= n; i++)if(!not_prime[i])
    {
        prime[++tot] = i;
        for(int j = i + i; j <= n; j += i)
            not_prime[j] = 1;
    }
}
//�ж�ƽ����
inline bool square_number(ll x)
{
  ll y = sqrt(x);
  while(y * y <= x)//��ƽ�����ھ�������Ҫ���жϼ���
  {
    if(y * y == x)return true;
    y += 1;
  }
  return false;
}
//�ж�������
inline bool cubic_number(ll x)
{
  ll y = pow(x, 1.0 / 3);
  while(y * y * y <= x)//���������ھ�������Ҫ���жϼ���
  {
    if(y * y * y == x)return true;
    y += 1;
  }
  return false;
}

int main()
{
  //Ԥ����4000���ڵ�����
  init(4000);
  int T;
  cin >> T;
  while(T--)
  {
    ll a;
    cin >> a;
    //������ƽ������������
    if(square_number(a) || cubic_number(a))
    {
      cout<<"yes"<<endl;
      continue;
    }
    bool flag = true;
    for(int i = 1; i <= tot; i++)if(a % prime[i] == 0)
    {
      int mi = 0;
      while(a % prime[i] == 0)a /= prime[i], mi++;
      //�ݴα������1
      if(mi == 1){flag = false; break;}
    }
    //ʣ��Ĳ����ٴ��ж�ƽ������������
    if(flag && (square_number(a) || cubic_number(a)))
      cout<<"yes"<<endl;
    else
      cout<<"no"<<endl;
  }
    return 0;
}


*/




