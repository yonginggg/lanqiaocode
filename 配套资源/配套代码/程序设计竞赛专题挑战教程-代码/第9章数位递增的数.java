//数位递增的数  lanqiaoOJ 145

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int count = 0;
        int num = scan.nextInt();
        for (int i = 1; i <= num; i++) {
            if (CheckNum(i))
                count++;
        }
        System.out.println(count);
        scan.close();
    }
    public static boolean CheckNum(int num)
    {
        char[] chars = String.valueOf(num).toCharArray();
        for (int j = 0; j < chars.length - 1; j++) {
            if (chars[j] <= chars[j + 1])
                continue;
            else
                return false;
        }
        return true;
    }
}