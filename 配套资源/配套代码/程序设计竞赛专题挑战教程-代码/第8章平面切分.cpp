//ƽ���з� 2020���ʮһ��ʡ��  lanqiaoOJ 503

#include<bits/stdc++.h>
using namespace std;
const int N = 1005;
double A[N], B[N];
int main(){
	int n;	cin>>n;
	pair<double, double> p;
	set<pair<double, double>> s;  //����set�Զ�ȥ�ع���ɸѡ���ر�
	for(int i = 0; i < n; i++){
		cin >> p.first >> p.second ;
		s.insert(p);
	}
	int i = 0;  //��ȥ�غ��ֱ�����ݷŻ�A,B����
	set<pair<double, double> >::iterator it = s.begin();
	while(it != s.end()){
		A[i] = it -> first;
		B[i] = it -> second;
		it++, i++;
	}
	long long ans = 2;  //��ʼ�����ֻ��һ��ֱ��ʱ��������ƽ��
	for(int i = 1; i < s.size(); i++){    //���±�1��ʼ��Ҳ���ǵڶ���ֱ��
		set<pair< double,  double> > pos;  //��¼��i��ֱ������ǰ�Ľ���
		for(int j = 0; j <= i-1; j++){
			double a1 = A[i], b1 = B[i];
			double a2 = A[j], b2 = B[j];
			if(a1 == a2) continue;    //ƽ�����޽��㣬����
			p.first = (b2-b1)/(a1-a2);  //�����x����
			p.second = a1*(b2-b1)/(a1-a2) + b1; //�����y����
			pos.insert(p);
		}
		ans += pos.size() + 1;  //����ǰֱ�ߵĽ�����+1
	}
	printf("%d\n", ans);
	return 0;
}
