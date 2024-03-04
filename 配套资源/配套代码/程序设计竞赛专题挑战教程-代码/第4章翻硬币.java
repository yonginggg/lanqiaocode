//lanqiaoOJ 209
import java.math.BigInteger;
import java.util.*;
public class Main{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        char a[]=s1.toCharArray();
        char b[]=s2.toCharArray();

        int ans=0;
        for(int i=0;i<a.length;i++)
            if(a[i] != b[i]) {
                if(a[i+1]=='*') a[i+1]='o';
                else            a[i+1]='*';
        //java也有三目运算符，把上面2行换成：
               //a[i+1] = (a[i+1]=='*') ? 'o': '*'; 
                ans ++;
            }
        System.out.println(ans);
    }
}
