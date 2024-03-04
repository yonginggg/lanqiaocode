//坐标搜寻  lanqiaoOJ 1546

import java.io.*;
import java.util.*;
public class Main{
    static int n;
    static double[][] a = new double[20][3];
    static double[][] f = new double[20][1<<15];
    public static void main (String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(double[] arr:f){
            Arrays.fill(arr,0x3f3f3f3f);
        }
        for(int i=1;i<=n;i++){
            String[] line = br.readLine().split(" ");
            a[i][1]=Double.parseDouble(line[0]);//第i个点的横坐标
            a[i][2]=Double.parseDouble(line[1]);//第i个点的纵坐标
            f[i][1<<(i-1)]=dis(i,0);//边界情况
        }
        
        for(int j=1;j<(1<<n);j++){
            for(int i=1;i<=n;i++){
                if((j&(1<<(i-1)))==0){
                    continue;
                }
                for(int k=1;k<=n;k++){
                    if(i==k) continue;//不存在
                    if((j&(1<<(k-1)))==0){ 
                        continue;
                    }
                    f[i][j]=Math.min(f[i][j],f[k][j-(1<<(i-1))]+dis(i,k));
                }
            }
            
        }
        //最后状态为1111111   1-n
        double res=0x3f3f3f;
        for(int i=1;i<=n;i++){
            res=Math.min(res,f[i][(1<<n)-1]);
        }
        System.out.println(String.format("%.2f",res));
    }
        //第x个点到第y个点之间的距离
        static double dis(int x,int y){
            return Math.sqrt((a[x][1]-a[y][1])*(a[x][1]-a[y][1])+(a[x][2]-a[y][2])*(a[x][2]-a[y][2]));
        }
}