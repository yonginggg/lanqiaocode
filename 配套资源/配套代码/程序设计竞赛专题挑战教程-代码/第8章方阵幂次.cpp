//�����ݴ�  lanqiaoOJ 1551
#include<bits/stdc++.h>
using namespace std;
const int N=40;
struct matrix{ int m[N][N]; };  //�������
matrix A,B;
matrix operator * (const matrix& a, const matrix& b){ //����*Ϊ����˷���ע��const
    matrix c;
    memset(c.m, 0, sizeof(c.m));                     //����
    for(int i=0; i<N; i++)
        for(int j=0; j<N; j++)
            for(int k = 0; k<N; k++)
              c.m[i][j] += a.m[i][k] * b.m[k][j];    //��ȡģ
    return c;
}
matrix pow_matrix(matrix a, int n){                  //���������
    matrix ans;
    memset(ans.m,0,sizeof(ans.m));
    for(int i=0;i<N;i++)
        ans.m[i][i] = 1;
    while(n) {
        if(n&1) ans = ans * a;
        a = a * a;
        n>>=1;
    }
    return ans;
}
int main(){
   int s,q; cin >>s>>q;      //s��s�У�q����
   for(int i=1;i<=s;i++)
        for(int j=1;j<=s;j++)
            cin >> A.m[i][j];
    B = pow_matrix(A,q);
    for(int i=1;i<=s;i++){
        for(int j=1;j<=s;j++)  cout << B.m[i][j] << " ";
        cout << endl;
    }
	return 0;
}
