//快速幂 lanqiaoOJ 1514

//有快速幂库函数，直接用。注意变量都用大数
import java.math.*;
import java.util.*;
public class Main {
	public static void main(String [] args) {
        Scanner in=new Scanner(System.in);
        BigInteger a=in.nextBigInteger();
   	BigInteger n=in.nextBigInteger();
      	BigInteger p=in.nextBigInteger();
       	System.out.println(a.modPow(n,p));
    }
}

/*
自己写也行。不过代码比较冗长。
import java.math.*;
import java.util.*;
public class Main {
	static BigInteger fastPow(BigInteger a,BigInteger n,BigInteger p) {		
		BigInteger ans = BigInteger.ONE;
		BigInteger two = BigInteger.valueOf(2);
    	while(!n.equals(BigInteger.ZERO)) {
    		if((n.mod(two)).equals(BigInteger.ONE))
                ans=ans.multiply(a).mod(p);
    		a = a.multiply(a).mod(p);
    		n = n.divide(two);
    	}
    	return ans;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        BigInteger a=in.nextBigInteger();
        BigInteger b=in.nextBigInteger();
        BigInteger p=in.nextBigInteger();
        System.out.println(fastPow(a,b,p));
    }
}
*/