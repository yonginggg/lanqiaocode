//矩阵相乘 lanqiaoOJ 1550


//矩阵相乘-lanqiao7290919273的代码

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int K=scanner.nextInt();
        int [][] arr1=new int[N][M];
        int [][] arr2=new int[M][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr1[i][j]=scanner.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                arr2[i][j]=scanner.nextInt();
            }
        }
        scanner.close();
        int a=0,b=0;
        int [][] res=new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    res[i][j]=(res[i][j]+arr1[i][k]*arr2[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int l = 0; l < K; l++) {
                System.out.print(res[i][l]+" ");
            }
            System.out.println();
        }
    }
    public static void mut_mul(int[][] a, int[][] b, int[][] c){ // c = a * b
        int[][] t = {{0, 0}, {0, 0}}; // 中间数组

        int mod = 0;
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                for(int k = 0; k < 2; k++)
                    t[i][j] = (t[i][j] + (a[i][k]*b[k][j]) % mod)%mod;

        for(int i = 0; i < 2; i++) c[i] = Arrays.copyOf(t[i], 2);
    }

}