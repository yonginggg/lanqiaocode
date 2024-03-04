
//四平方和  2016年第七届省赛  lanqiaoOJ 122

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i1=0;i1*i1<=n;i1++) 
            for (int i2=i1;i2*i2<=n;i2++) 
                for (int i3=i2;i3*i3<=n;i3++) 
                    for (int i4=i3;i4*i4<=n;i4++) 
                        if (i1*i1+i2*i2+i3*i3+i4*i4==n) {
                            System.out.printf("%d %d %d %d\n",i1,i2,i3,i4);
                            return;
                        }    
        in.close();
    }
}