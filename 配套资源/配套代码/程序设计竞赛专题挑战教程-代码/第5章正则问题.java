//正则问题 2017年第八届省赛C/C++A组   
//lanqiaoOJ 106
import java.util.Scanner;
 public class Main {
    static String s;
    static int pos;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();   
        System.out.println(dfs());
    }
    public static int dfs() {
        int ans = 0;
        int temp = 0;
        int len = s.length();
        while (pos < len) {
            if(s.charAt(pos) == '(') {
                pos++;
                temp += dfs();
            } else if(s.charAt(pos) == 'x') {
                temp++;
                pos++;
            }else if(s.charAt(pos) == '|') {
                ans = Math.max(ans,temp);
                temp = 0;
                pos++;
            } else if(s.charAt(pos) == ')') {
                pos++;
                return Math.max(temp,ans);
            }
        }
        return Math.max(ans,temp);
    }
}
