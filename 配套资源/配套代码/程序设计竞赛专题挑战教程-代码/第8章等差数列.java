//2019年第十届省赛真题
//等差数列  lanqiaoOJ 192

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long[] a = new long[N];
        long[] b = new long[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextLong();
        }

        Arrays.sort(a);

        if(a[0]==a[1]){
            System.out.println(N);
            return;
        }

        for (int i = 0, j = 1; j < N; i++, j++) {
            b[i] = a[j] - a[i];
        }

        Arrays.sort(b);

        long min = b[1];

        long ans = ((a[N - 1] - a[0]) / min) + 1;

        System.out.println(ans);

    }
}