//完全二叉树的权值 lanqiaoOJ 183
import java.util.Scanner; 
public class Main {
    static long sum[] = new long[100];     
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = (int) Math.floor(Math.log(n)/Math.log(2));    //第k个数在第i=ceil(log2(k+1))层，ceil()函数表示向上取整。
        for(int i=1;i<=n;i++) {
            long temp = in.nextLong();
            sum[(int) Math.floor(Math.log(i)/Math.log(2))] += temp;
        }
        long max = sum[0];
        int ans = 1;
        for(int i=1;i<=m;i++) {
            if(sum[i]>max) {
                max = sum[i];
                ans = i + 1;
            }
        }
        System.out.println(ans);         
    } 
}
