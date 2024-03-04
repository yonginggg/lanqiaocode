//lanqiaoOJ 755

import java.util.Scanner;
public class Main {
	static int[][] g;
	static int fx[] = {0, -2, -1, 1, 2, 2, 1, -1, -2};
	static int fy[] = {0, 1, 2, 2, 1, -1, -2, -2, -1};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x=scanner.nextInt()+2;
		int y=scanner.nextInt()+2;
		int x2=scanner.nextInt()+2;
		int y2=scanner.nextInt()+2;
		
		int [][]g=new int[40][40];
		for(int i=0;i<=8;i++){
			g[x2+fx[i]][y2+fy[i]]=1;
		}
		long [][]dp=new long[40][40];
		dp[2][1]=1;
		
		
		for(int i=2;i<40;i++){
			for(int j=2;j<40;j++){
				if(g[i][j]==1){
					continue;
					
				}
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		System.out.println(dp[x][y]);
	}

}