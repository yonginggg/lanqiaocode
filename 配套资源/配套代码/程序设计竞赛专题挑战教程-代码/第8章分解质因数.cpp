//�ֽ�������  lanqiaoOJ 1559 


#include<bits/stdc++.h>
using namespace std;
int p[20];  //p[]��¼���ӣ�p[1]����С���ӡ�һ��int���������������10����
int c[40];  //c[i]��¼��i�����ӵĸ�����һ�����ӵĸ��������30����
int factor(int n){
    int m = 0;
    for(int i = 2; i <= sqrt(n); i++)
        if(n%i == 0){
           p[++m] = i, c[m] = 0;
           while(n%i == 0)            //��n���ظ�������ȥ��
              n/=i, c[m]++;
        }
    if(n>1)                           //û�б�������������
       p[++m] = n, c[m] = 1;
    return m;                         //��m������
}
int main(){
    int a,b;   cin>>a>>b;
    for(int i=a;i<=b;i++){
        int m = factor(i);
        cout<<i<<"=";
        for(int j=1;j<=m;j++){ //��j������
            for(int k=1;k<=c[j];k++){    //��j�����ӵĸ���
                cout <<p[j];
                if(k<c[j]) cout <<"*";
            }
            if(j<m) cout <<"*";
        }
        cout<<endl;
    }
    return 0;
}
