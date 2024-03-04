//矩形拼接 2022年第十三届省赛Java大学C组，Python大学A组、C组、研究生组
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
            //枚举第一个矩形下标为i，第二个矩形下标为j，第三个矩形下标为k
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)if(i != j)
                    for(int k = 0; k < 3; k++)if(i != k && j != k)
            //枚举三个矩形的两条边
            for(int ii = 0; ii <= 1; ii++)
                for(int jj = 0; jj <= 1; jj++)
                    for(int kk = 0; kk <= 1; kk++)
            {
                if(a[i][ii] == a[j][jj])//6条边的情况1
                    ans = Math.min(ans, 6);
                if(a[i][ii] == a[j][jj] && a[i][ii] == a[k][kk])//4条边的情况1
                    ans = Math.min(ans, 4);
                //枚举仅考虑a[i][ii] 与 a[j][jj] + a[k][kk]的关系
                if(a[i][ii] == a[j][jj] + a[k][kk])
                {
                    ans = Math.min(ans, 6);     //6条边的情况2
                    if(a[j][1 - jj] == a[k][1 - kk])    //4条边的情况2
                        ans = Math.min(ans, 4);
                }
            }
            System.out.println(ans);
        }
    }
}