//½×³Ë¼ÆËã  lanqiaoOJ 1515

import java.math.BigInteger;
import java.util.*;
public class Main {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            BigInteger s = new BigInteger("1");
            for(int i = n; i >= 1; i--)
                s = s.multiply(new BigInteger(String.valueOf(i)));
            System.out.println(s);
        }
     }
}