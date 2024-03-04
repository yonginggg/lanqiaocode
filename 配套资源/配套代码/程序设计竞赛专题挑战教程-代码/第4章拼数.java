//拼数 lanqiaoOJ 782

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        String[] s = new String[n];
        String ans = "";
        for(int i = 0; i < n; i++)
            s[i] = nums[i] + "";
        for(int i = 0; i < n - 1; i++)  //交换排序
            for(int j = i + 1; j < n; j++) 
                if((s[j] + s[i]).compareTo(s[i] + s[j]) < 0) {
                    String temp = s[j];
                    s[j] = s[i];
                    s[i] = temp;
                }
        for(int i = n - 1; i >= 0; i--) 
            ans += s[i];
        System.out.println(ans);
    }
}
