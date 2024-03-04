// 双向排序 2021年第十二届省赛C/C++大学B组、研究生组，Java大学A组、B组、C组、研究生组
// lanqiaoOJ 1458

import java.util.*;

class so{
    public int x;
    public int y;
    public so(int x,int y) {
        this.x=x;
        this.y=y;
    };
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        so [] stk=new so[m+1];
        int []res=new int[n+1];
        int top=0;//使用数组模拟栈
        while(m>0) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(x==0) {
                while(top>0&&stk[top].x==0) {y=Math.max(y,stk[top--].y);}
                while(top>=2&&stk[top-1].y<=y) {top=top-2;}
                stk[++top]=new so(x,y);
            }else if(top!=0){
                while(top>0&&stk[top].x==1) {y=Math.min(y,stk[top--].y);};
                while(top>=2&&stk[top-1].y>=y) {top=top-2;}
                stk[++top]=new so(x,y);
            }
            m--;
        }
         
        int l=1,r=n,k=n;
        for(int i=1;i<=top;i++) {
            if(stk[i].x==0) 
                while(r>stk[i].y&&l<=r)res[r--]=k--;
            else
                while(l<stk[i].y&&l<=r)res[l++]=k--;
             
            if(l>r) break;
        }
        if(top%2==1) {
            while(l<=r) res[l++]=k--;
        }else {
            while(l<=r) res[r--]=k--;
        }
        for(int i=1;i<=n;i++) {
            System.out.print(res[i]+" ");
        }
    }
}