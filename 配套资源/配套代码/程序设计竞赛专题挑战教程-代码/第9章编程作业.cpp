//�����ҵ lanqiaoOJ 1433

#include<bits/stdc++.h>
using namespace std;
const int N=1e6+9;
char v[N];     // �����ַ���
int slen,plen,s[N],p[N],pre[29],Next[N];
bool check(int a,int b,int j) {
	if(a<0||b<0) return a==b;			//��д��ĸ
	return a==b||(b==0&&a>j);			//Сд��ĸ
}
void inits(){  //ת��ĸ��s
    scanf("%s",v+1);
    slen = strlen(v+1);
	memset(pre,0,sizeof(pre));
	for(int i=1;i<=slen;i++)				//Ԥ����s��
		if(v[i]>='A'&&v[i]<='Z')  s[i]=-v[i];  //��д��ĸ��Ϊ����
        else{
			if(pre[v[i]-'a'+1]>0) s[i]=i-pre[v[i]-'a'+1];
            else s[i]=0;
            pre[v[i]-'a'+1]=i;
        }
}
void initp(){                     //ת��ģʽ��P
	scanf("%s",v+1);  plen=strlen(v+1);
	memset(pre,0,sizeof(pre));
	for(int i=1;i<=plen;i++)				//Ԥ����t��
		if(v[i]>='A'&&v[i]<='Z') p[i]=-v[i];
		else{
            if(pre[v[i]-'a'+1]>0)   p[i]= i-pre[v[i]-'a'+1];
            else p[i]=0;
            pre[v[i]-'a'+1]=i;
		}
}
void getNext(){    //Next[]ģ��
	Next[0]=Next[1]=0;
	for(int i=1;i<plen;i++) {
	    int j = Next[i];
		while(j&&!check(p[i+1],p[j+1],j))
            j=Next[j];
		if(check(p[i+1],p[j+1],j))
		    Next[i+1] = j+1;
		else  Next[i+1] = 0;
	}
}
void kmp() {      //kmpģ��
	int ans=0;
	int j=0;
	for(int i=0;i<slen;i++) {
		while(j&&!check(s[i+1],p[j+1],j))
            j=Next[j];
		if(check(s[i+1],p[j+1],j))
            j++;
		if(j==plen)
            ans++,j=Next[j];  //�ҵ�һ��ƥ�䣬��������һ��
	}
	cout<<ans<<endl;
}
int main() {
	int Q; cin>>Q;
	while(Q--){ inits();  initp();  getNext();  kmp();}
	return 0;
}
