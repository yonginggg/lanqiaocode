//����ƴ�� 2022���ʮ����ʡ��Java��ѧC�飬Python��ѧA�顢C�顢�о�����
//lanqiaoOJ 2238

//User: root [fzl]�Ĵ���

#include<bits/stdc++.h>
using namespace std;
int a[3][2];
int main(){
    int T;    cin >> T;
    while(T--)    {
        for(int i = 0; i < 3; i++)
            cin >> a[i][0] >> a[i][1];
        int ans = 8;
        for(int i = 0; i < 3; i++)               //��1��
            for(int j = 0; j < 3; j++)
                if(i != j)                       //��2��
                    for(int k = 0; k < 3; k++)
                        if(k != i && k != j)     //��3��
                            for(int ii = 0; ii <= 1; ii++){ //��1���к������ְڷ�
                                for(int jj = 0; jj <= 1; jj++){ //��2��������
                                    for(int kk = 0; kk <= 1; kk++){ //��3��������
                                        if(a[i][ii] == a[j][jj] + a[k][kk]){
                                            ans = min(ans, 6);
                                            if(a[j][1-jj] == a[k][1-kk])
                                                ans = min(ans, 4);
                                        }
                                        if(a[i][ii] == a[j][jj] || a[j][jj] == a[k][kk])
                                            ans = min(ans, 6);
                                        if(a[i][ii] == a[j][jj] && a[j][jj] == a[k][kk])
                                            ans = min(ans, 4);
                                    }
                                }
                            }
        cout<<ans<<endl;
    }
    return 0;
}
