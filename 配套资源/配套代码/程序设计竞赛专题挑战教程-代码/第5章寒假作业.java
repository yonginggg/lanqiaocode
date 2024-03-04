//寒假作业 2016年第七届省赛C/C++A组  lanqiaoOJ 1388

public class Main {
    static int[] vis = new int[13];//用来表示是否用过
    static int[] b = new int[13];//用来存放数字
    static int ans = 0;
     
    public static void main(String[] args) {
        dfs(0);
        System.out.println(ans);
    }
     
    static void dfs(int step) {
        if (step>=3 && b[0]+b[1]!=b[2]) return;
        if (step>=6 && b[3]-b[4]!=b[5]) return;
        if (step>=9 && b[6]*b[7]!=b[8]) return;
        if (step>=12 && b[9]==b[10]*b[11]){
            ans++;
            return;
        }
         
        for (int i = 0; i < 13; i++) {
            if (vis[i] == 0) {
                b[step] = i + 1;
                vis[i] = 1;
                dfs(step + 1);//递归运行下一步
                vis[i] = 0;
            }
        }
    }
}
