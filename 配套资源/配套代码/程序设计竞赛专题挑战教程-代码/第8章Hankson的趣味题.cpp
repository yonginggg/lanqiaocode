// lanqiaoOJ题号520

#include<bits/stdc++.h>
using namespace std;
int lcm(int a, int b){ return a / __gcd(a, b) * b;}
int main() {
    int n; scanf("%d",&n);
    while(n--) {
        int a0,a1,b0,b1;
        cin >>a0>>a1>>b0>>b1;
        int ans=0;
        for(int x=1;x <= sqrt(b1);x++){
            if(b1%x == 0){        //优化
                if(__gcd(x,a0)==a1 && lcm(x,b0)==b1)  ans++;
                int y = b1/x;       //另外一个因子
                if(x==y) continue;
                if(__gcd(y,a0)==a1 && lcm(y,b0)==b1)  ans++;
            }
        }
        cout << ans <<endl;
    }
    return 0;
}