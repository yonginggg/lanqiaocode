//�߾��ȼӷ�  lanqiaoOJ 1516 

#include <bits/stdc++.h>
using namespace std;
string add(string a,string b){
    string s;   //����
    int c = 0;  //��λ
    for(int i=a.size()-1,j=b.size()-1;i>=0||j>=0||c>0;i--,j--){
        if(i>=0)   c += a[i]-'0';
        if(j>=0)   c += b[j]-'0';
        s += (c%10)+'0';  //ע��s�����λ��ǰ����λ�ں�
        c /= 10;
    }
    reverse(s.begin(),s.end()); //����������λ��ǰ����λ�ں�
    return s;
}
int main(){
    string a,b;  cin>>a>>b;   //���ַ�����ʽ��������a��b
    cout<<add(a,b);
    return 0;
}
