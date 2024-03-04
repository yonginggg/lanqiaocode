//单词接龙  lanqiaoOJ 769 

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner cin = new Scanner(System.in);
    static int n, ans;
    static int[] vis = new int[101];
    static String[] arr = new String[101];
    static String start = "";

    public static void dfs(String head) {
        int siz = head.length();
        ans = Math.max(ans, siz);
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 2) continue;
            for (int j = 1; j < head.length() && j < arr[i].length(); j++) {
                String headsub = head.substring(head.length() - j);
                String tailsub = arr[i].substring(0, j);
                if (headsub.equals(tailsub)) {
                    vis[i]++;
                    dfs(head + arr[i].substring(j));
                    vis[i]--;

                }
            }
        }
    }

    public static void main(String[] args) {
        n = cin.nextInt();
        for (int i = 1; i <= n; i++) arr[i] = cin.next();
        start = cin.next();
        for (int i = 1; i <= n; i++) {
            if (arr[i].charAt(0) == start.charAt(0)) {
                vis[i]++;
                dfs(arr[i]);
                vis[i]--;
            }
        }
        System.out.println(ans);
    }
}