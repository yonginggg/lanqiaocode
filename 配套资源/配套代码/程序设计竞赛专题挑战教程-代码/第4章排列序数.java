//排列序数 lanqiaoOJ 269
 
import java.util.Scanner;
public class T1815{
        //i表示第i个字母(从0起),n表示暂未确定字母的长度
    public static int f(String s,int i,int n) {
        if(n == 1) return 0;
        int ans = 0,cnt = 0;
        //统计第i个字母前有多少字母被占用
        for(int j = 0;j<i;j++)
            if(s.charAt(i)>s.charAt(j))
                cnt++;
        ans = (s.charAt(i) - 'a'-cnt)*factor(n-1) + f(s,i+1,n-1);
        return ans;
    }
    //求阶乘
    public static int factor(int n) {
        if(n == 1 || n == 0) return 1;
        else 
            return n*factor(n-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String s = in.next();
            System.out.println(f(s,0,s.length()));
        }
        in.close();
    }
}
