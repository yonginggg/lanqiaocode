//笨小猴   lanqiaoOJ 527

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] c = str.toCharArray();
        int []length = new int[26];
        int max = -1, min = 101;
        for(int i = 0; i < c.length; i++)
            length[c[i] - 'a']++;
        for(int i = 0; i < 26; i++) {
            if(length[i] == 0)
                continue;
            if(length[i] > max)
                max = length[i];
            if(length[i] < min)
                min = length[i];
        }
        if(c.length == max)
            min = 0;
        boolean ans = is_prime(max - min);
        if(ans) {
            System.out.println("Lucky Word");
            System.out.println(max - min);
        }else {
            System.out.println("No Answer");
            System.out.println(0);
        }
    }
    
    static boolean is_prime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}