//����ƴ�� 2022���ʮ����ʡ��Java��ѧC�飬Python��ѧA�顢C�顢�о�����
//lanqiaoOJ 2238

import java.util.*;
import java.io.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int _t = 1; _t <= T; _t++)
        {
            int[][] a = new int[3][2];
            int ans = 8;
            for(int i = 0; i < 3; i++)
            {
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }
            //ö�ٵ�һ�������±�Ϊi���ڶ��������±�Ϊj�������������±�Ϊk
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)if(i != j)
                    for(int k = 0; k < 3; k++)if(i != k && j != k)
            //ö���������ε�������
            for(int ii = 0; ii <= 1; ii++)
                for(int jj = 0; jj <= 1; jj++)
                    for(int kk = 0; kk <= 1; kk++)
            {
                if(a[i][ii] == a[j][jj])//6���ߵ����1
                    ans = Math.min(ans, 6);
                if(a[i][ii] == a[j][jj] && a[i][ii] == a[k][kk])//4���ߵ����1
                    ans = Math.min(ans, 4);
                //ö�ٽ�����a[i][ii] �� a[j][jj] + a[k][kk]�Ĺ�ϵ
                if(a[i][ii] == a[j][jj] + a[k][kk])
                {
                    ans = Math.min(ans, 6);     //6���ߵ����2
                    if(a[j][1 - jj] == a[k][1 - kk])    //4���ߵ����2
                        ans = Math.min(ans, 4);
                }
            }
            System.out.println(ans);
        }
    }
}