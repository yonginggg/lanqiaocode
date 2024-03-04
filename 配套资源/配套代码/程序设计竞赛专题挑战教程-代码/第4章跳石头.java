//跳石头 lanqiaoOJ 364
 import java.util.*;
public class Main {
       static int n = 0, m = 0, len = 0;
       static int[] stone = new int[50005];
       public static boolean check(int d) {
 			int num = 0;
 			int pos = 0;
			for (int i = 1; i <= n; i++) {
				if (stone[i] - pos < d)
					num++;
				else
					pos = stone[i];
			}
			if(num <= m) return true;   
            else return false;
    }
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		len = in.nextInt();
		n = in.nextInt();
		m = in.nextInt();
		for (int i = 1; i <= n; i++)
			stone[i] = in.nextInt();
		int left = 0, right = len, mid,ans = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (check(mid)) {
				ans = mid;
				left = mid + 1;
			}
			else
				right = mid - 1;
		}
		System.out.println(ans);
    }
}