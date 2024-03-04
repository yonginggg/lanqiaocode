//七段码：2020年第十一届省赛  lanqiaoOJ 595

import java.util.Scanner;
 
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
 
public class Main {
     
     
    public static void main(String[] args) {
        int[][] edges = new int[7][7];
        edges[0][1] = edges[0][5] = 1;
        edges[1][0] = edges[1][2] = edges[1][6] = 1;
        edges[2][1] = edges[2][6] = edges[2][3] = 1;
        edges[3][2] = edges[3][4] = 1;
        edges[4][5] = edges[4][5] = edges[4][3] = 1;
        edges[5][4] = edges[5][6] = edges[5][0] = 1;
        edges[6][1] = edges[6][2] = edges[6][4] = edges[6][5] = 1;
        int cnt = 0;
        for (int i=0; i<=(1<<7)-1; i++) {
            if (check(i, edges)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    } 
     
    public static boolean check(int state, int[][] edges) {
        int[] pre = new int[7];
        for (int i=0; i<7; i++) {
            pre[i] = i;
        }
        for (int i=0; i<7; i++) {
            for (int j=0; j<7; j++) {
                if (edges[i][j]==1 && (state>>i&1)==1 && (state>>j&1)==1) {
                    int preI =find(i, pre);
                    int preJ = find(j, pre);
                    if (preI != preJ) {
                        pre[preI] = pre[preJ];
                    }
                }
            }
        }
        int cnt = 0;
        for (int i=0; i<7; i++) {
            if ((state>>i&1)==1 && pre[i] == i) {
                cnt++;
            }
        }
        return cnt==1;
    }
     
    public static int find(int i, int[] pre) {
        while (pre[i]!=i) {
            i = pre[i];
        }
        return i;
    }
       
}