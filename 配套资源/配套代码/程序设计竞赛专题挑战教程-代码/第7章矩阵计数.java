//矩阵计数 2019年第十届国赛 lanqiaoOJ 246

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int state=1<<m;
		for (int i = 0; i < state; i++) {//筛选符合条件状态
			if (!check(i))
				list.add(i);
		}
		int[][][] dp = new int[n][state][state];
		for (int i : list)
			dp[0][i][0] = 1;

		for (int i = 1; i < n; i++)
			for (int j : list)
				for (int k :list)
					for (int p : list)
						if ((j & k & p) == 0)
							dp[i][j][k] += dp[i - 1][k][p];
		int ans = 0;
		for (int i : list)
			for (int j : list)
				ans += dp[n - 1][i][j];
		System.out.println(ans);
	}
	static boolean check(int x) {
		int num = 0;
		while (x > 0) {
			if ((x & 1) == 1)
				num++;
			else
				num = 0;
			if (num == 3)
				return true;
			x >>= 1;
		}
		return false;
	}
}
