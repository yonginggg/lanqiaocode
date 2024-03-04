//一元三次方程求解 lanqiaoOJ 764
import java.util.*;
public class Main{     // 暴力枚举
    public static void main(String[] args){
        Scanner rd =new Scanner(System.in);
        double a = rd.nextDouble();
        double b = rd.nextDouble();
        double c = rd.nextDouble();
        double d = rd.nextDouble();
        for(double i=-100;i<=100;i+=0.01)
            if(Math.abs(a*i*i*i+b*i*i+c*i+d) < 0.000001)
                System.out.printf("%.2f ",i);
        }
}
