//方阵幂次 lanqiaoOJ 1551

import java.util.Scanner;
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int q = sc.nextInt();   //q次幂
        int[][] A;
        A = new int[n][n];
        for(int i = 0;i < n; i++)
            for(int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();
        int[][] res = pow_matrix(A,q);
        for(int i = 0; i < n; i++) {          //打印
            for (int j = 0; j < n; j++)
                System.out.print(res[i][j]+" ");
            System.out.println();
        }
    }

    static int[][] pow_matrix(int[][] a, int q) {  //快速幂
        int[][] res = new int[n][n];
        for(int i = 0; i < n; i ++)
            res[i][i] = 1;
        while(q > 0) {
            if(q % 2 == 1)       res = multi(res, a);
            a = multi(a,a);
            q /= 2;
        }
       return res;
    }
    static int[][] multi(int[][] a, int[][] b) {   //矩阵乘法
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n;j++ )
                for(int k = 0; k < n; k++)
                    temp[i][j] += a[i][k]*b[k][j];
        return temp;
    }
}
