//��λ��������  lanqiaoOJ 145

#include<bits/stdc++.h>
using namespace std;
bool check(int t){
	char s[8];	sprintf(s, "%d", t);
	//���һ��Ҫ��C++��string������һ�䣺string str = s;
	for(int i=1;i<strlen(s);i++)
		if(s[i-1]>s[i])    return false;
	return true;
}
int main(){
	int n; cin>>n;
	int ans=0;
	for(int i=1;i<=n;i++)
		if(check(i))   ans++;
	cout<<ans;
	return 0;
}


