//路径之谜  2016年第七届决赛  lanqiaoOJ 89

import java.util.Scanner;
 
public class Main {
     
    static int[][] next= {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean flag=false;
     
    static void dfs(boolean[][] book,int[] row,int[] col,int x,int y,int deep,int[] ans)
    {
         
        if(x==book.length-1&&y==book[0].length-1)
        {
            for(int i=0;i<row.length;i++)
            {
                if(row[i]!=0||col[i]!=0)
                {
                    return;
                }
            }
            System.out.printf("0 ");
            for(int i=0;i<deep;i++)
            {
                System.out.printf("%d ",ans[i]);
            }
            flag=true;
            return;
        }
        if(flag)
            return;
         
        for(int i=0;i<next.length;i++)
        {
            int tx=x+next[i][0];
            int ty=y+next[i][1];
            if(tx<0||ty<0||tx>=book.length||ty>=book[0].length||book[tx][ty])
                continue;
             
            if(col[tx]==0||row[ty]==0)
            {
                continue;
            }
            book[tx][ty]=true;
            ans[deep]=tx*book.length+ty;
            row[ty]--;
            col[tx]--;
            dfs(book,row,col,tx,ty,deep+1,ans);
            row[ty]++;
            col[tx]++;
            book[tx][ty]=false;
        }
         
    }
     
    public static void main(String[] args) {
         
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] row=new int[n];
        int[] col=new int[n];
        for(int i=0;i<row.length;i++)
        {
            row[i]=in.nextInt();
        }
        for(int i=0;i<col.length;i++)
        {
            col[i]=in.nextInt();
        }
         
        col[0]--;
        row[0]--;
        boolean[][] book=new boolean[n][n];
        book[0][0]=true;
        dfs(book,row,col,0,0,0,new int[n*n]);
         
    }
}