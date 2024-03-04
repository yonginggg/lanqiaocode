//import java.util.Scanner; 

public class Main {

    // f[i] = i位数里各个数位共出现的次数
    static long[] f = new long[20];
    // 10的i次幂
    static long[] ten = new long[20];
    // cnt[i] = 数位i出现次数
    static long[] cntB = new long[20];

    public static void solve(long x, long[] cnt) {
        // 存储数字的每一位
        int[] num = new int[20];
        int len = 0;
        while(x > 0) {
            num[++len] = (int)(x%10);
            x /= 10;
        }
        // 不断按位分离计算
        for(int i = len; i >= 1; i--) {
            // 计算后面i-1位每个数位出现次数
            for(int j = 0; j <= 9; j++) {
                cnt[j] += num[i] * f[i-1];
            }
            // 计算最高位上 小于最高位的数位出现次数
            for(int j = 0; j < num[i]; j++) {
                cnt[j] += ten[i-1];
            }
            // 加上首位的数位的出现次数
            long topNum = 0;
            for(int j = i-1; j >= 1; j--) {
                topNum = topNum*10+num[j];
            }
            cnt[num[i]] += topNum+1;
            // 减去前导0的出现次数
            cnt[0] -= ten[i-1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long b = sc.nextLong();
        // 先计算出f
        ten[0] = 1;
        for(int i = 1; i <= 15; i++) {
            f[i] = f[i-1] * 10 + ten[i-1];
            ten[i] = ten[i-1] * 10;
        }
        solve(b, cntB);
        for (int i = 0; i <= 9; i++) {
            System.out.print(cntB[i] + " ");
        }
    }
}