//С�����ַ���  lanqiaoOJ 1203

#include<bits/stdc++.h>
using namespace std;
const int N = 1e6+5;
int Next[N];
void getNext(string p){               //����Next[1]~Next[plen]
    Next[0]=0; Next[1]=0;
    for(int i=1; i < p.size(); i++){  //��i�����ӿ��ɺ�׺������չ
        int j = Next[i];              //j�ĺ��ƣ�jָ��ǰ׺��Ӱw�ĺ�һ���ַ�
        while(j && p[i] != p[j])      //��Ӱ�ĺ�һ���ַ�����ͬ
            j = Next[j];              //����j
        if(p[i]==p[j])   Next[i+1] = j+1;
        else             Next[i+1] = 0;
    }
}
int kmp(string s, string p) {         //��s����p
    int ans=0;
    int slen=s.size(), plen=p.size();
    int j=0;
    for(int i=0; i<slen; i++) {     //ƥ��S��P��ÿ���ַ�
        while(j && s[i]!=p[j])      //ʧ���ˡ�ע��j==0�����(1)
             j=Next[j];             //j������Next[j]λ��
        if(s[i]==p[j]) {            //��ǰλ�õ��ַ�ƥ�䣬����
            j++;
            ans=max(ans,j);         //ȥ����һ�䣬����������������KMP
        }
        if(j == plen) {             //j����P��ĩβ���ҵ���һ��ƥ��
            //���ƥ�䣬��S�е������i+1-plen��ĩβ��i��������Ҫ���Դ�ӡ��
            // printf("at location=%d, %s\n", i+1-plen,&s[i+1-plen]);
           return ans;
        }
    }
    return ans;  //����p��s�г��ֵ��ǰ׺
}
int main(){
    string s, t;
    cin >> s >> t;
    getNext(t);                       //Ԥ����Next[]����
    cout<<kmp(s, t);
    return 0;
}

