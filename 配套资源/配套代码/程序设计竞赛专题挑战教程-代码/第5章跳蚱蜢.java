//跳蚱蜢 lanqiaoOJ 642


//(1)set
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set; 
public class Main { 
    static String target = "087654321"; 
    public static void main(String[] args) {
        bfs();
    } 
    static Set<String> set = new HashSet<String>();
    static int[] dir = new int[] { -2, -1, 1, 2 }; 
    public static void bfs() {
        Queue<String> que = new LinkedList<String>();
        que.add("012345678");
        set.add("012345678"); 
        int ans = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int k = 0; k < size; ++k) {
                String p = que.poll();
                if(p.equals(target)) {
                    System.out.println(ans);
                    return ;
                }
                char[] cp = p.toCharArray();
                int ind = 0;
                for (int i = 0; i < cp.length; ++i) {
                    if (cp[i] == '0') {
                        ind = i;
                        break;
                    }
                } 
                for (int i = 0; i < dir.length; ++i) {
                    int nind = (ind + dir[i] + 9) % 9;
                    char[] temcp = cp.clone();
                    temcp[ind] = cp[nind];
                    temcp[nind] = cp[ind];
                    String strp = new String(temcp);
                    if (!set.contains(strp)) {
                        que.add(strp);
                        set.add(strp);
                    }
                }
            }
            ++ ans;
        } 
    } 
}


//(2)map
/*
import java.util.ArrayDeque;
import java.util.HashMap;
class node{
    String string;
    int pos;
    int step;
}
public class Main {
    static ArrayDeque<node> queue = new ArrayDeque();
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static String start = "012345678";
    static String end = "087654321";
    static int[] d = {1, 2, -1, -2};
    public static void main(String[] args) {
        bfs();
    }
    public static String swap(String str, int i, int j) {
        char[] c = str.toCharArray();
        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
        return new String(c);
    }
    public static void bfs() {
        node p = new node();
        p.string = start;
        p.pos = start.indexOf("0");
        p.step = 0;
        queue.offer(p);
        map.put(start, 1);
        while(!queue.isEmpty()) {
            node pp = new node();
            pp = queue.pop();

            if(pp.string.equals(end)) {
                System.out.println(pp.step);
                break;
            }
            for(int i = 0; i < 4; i++) {
                int pos = pp.pos + d[i];
                if(pos < 0)
                    pos += 9;
                if(pos > 8)
                    pos -= 9;

                String s = pp.string;
                String ss = swap(s, pp.pos, pos);
                if(!map.containsKey(ss)) {
                    node ppp = new node();
                    ppp.string = ss;
                    ppp.pos = pos;
                    ppp.step = pp.step + 1;
                    queue.offer(ppp);
                    map.put(ss, 1);
                }
            }
        }
    }
}

*/


