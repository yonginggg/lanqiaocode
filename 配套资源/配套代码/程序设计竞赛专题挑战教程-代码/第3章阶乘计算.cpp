//�׳˼���   lanqiaoOJ 1515
#include <bits/stdc++.h>
using namespace std;
const int N = 10000;
int a[N] = {0};                    //������ע���̬����Ҫ������ȫ��
int main(){
    int n;   cin >> n;
    a[0] = 1;
    for(int i=1;i<= n;i++){        //ģ�����n!
        int carry = 0;             //��λ
        for(int j=0;j< N;j++){     //���������
            a[j] = a[j] * i + carry;
            carry = a[j] / 10;
            a[j] = a[j] % 10;
        }
    }
    int last;                      //�����λ�����ǵ�һ��������0�����λ
    for(int i=N-1;i>=0;i--){
        if (a[i] != 0){
            last = i;
            break;
        }
    }
    for(int i=last; i>=0;i--) cout << a[i];     //�����λ��ʼ��ӡ
    return 0;
}
