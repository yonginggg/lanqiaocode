//迷宫 2019年第十届省赛 lanqiaoOJ 602

//注意本题是填空题。下面代码直接提交到oj，“答案错误”。自己运行得到答案后，再把答案提交到OJ。


import java.util.*;

public class Main {
    public static String[] strs = new String[30];
    public static int[][] vis = new int[100][100];
    public static int[][] dir = new int[][] {{1,0},{0,-1},{0,1},{-1,0}};

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        for (int n = 0;n < 30;n++)
             strs[n] = cin.next();
        bfs();
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0,0,0,'a',null));
        vis[0][0] = 1;
        Node ansNode = null;
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (top.x == strs.length - 1 && top.y == strs[0].length() - 1) {
                ansNode = top;
                break;
            }
            for (int n = 0;n < dir.length;n++) {
                int dx = top.x + dir[n][0];
                int dy = top.y + dir[n][1];
                if (dx >= 0 && dx < strs.length && dy >= 0 && dy < strs[0].length() && vis[dx][dy] == 0 && strs[dx].charAt(dy) == '0') {
                    vis[dx][dy] = 1;
                    char ch = 'D';
                    if (n == 0)  ch = 'D';
                    if (n == 1)  ch = 'L';
                    if (n == 2)  ch = 'R';
                    if (n == 3)  ch = 'U';
                    queue.add(new Node(dx, dy,top.step + 1,ch,top));
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        while (ansNode.pre != null) {
            stack.add(ansNode.ch);
            ansNode = ansNode.pre;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
class Node {
    public int x;
    public int y;
    public char ch;
    public int step;
    public Node pre;
    public Node(int x, int y, int step,char ch,Node pre) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.pre = pre;
        this.ch = ch;
    }
}
