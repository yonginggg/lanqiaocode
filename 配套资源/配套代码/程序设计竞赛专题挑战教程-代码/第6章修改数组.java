//修改数组 2019年第十届省赛  lanqiaoOJ 185
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
    static int max = 1000005;
    static int num[] = new int[max];
    public static int find(int x) {
        if(x == num[x]) {
            return x;
        }
        return num[x] = find(num[x]);
    }
    public static void main(String[] args)  {
     BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            int k = 0;
            String[] s = in.readLine().split(" ");
            for(int i=1;i<=1000000;i++) {
                num[i] = i;
            }
            k = Integer.parseInt(s[0]);
            k = find(k);
            num[k] = find(k+1);
            System.out.print(k);
            for(int i=1;i<n;i++) {
                k = Integer.parseInt(s[i]);
                k = find(k);
                System.out.print(" "+k);
                num[k] = find(k+1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }       
}
