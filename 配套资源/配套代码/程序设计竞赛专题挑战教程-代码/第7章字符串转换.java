//编辑距离， 字符串转换 lanqiaoOJ 1507
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i = 1 ; i <= s1.length() ; i++ ){  //记得初始化数据
            dp[i][0] = i ;
        }
        for(int i = 1 ; i <= s2.length() ; i++ ){
            dp[0][i] = i ;
        }
        for (int i = 1; i <=s1.length(); i++) {
            for (int j =1; j <=s2.length(); j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1]+1,dp[i-1][j]+1),dp[i][j-1]+1);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}