//平方和  2019年第十届蓝桥杯省赛C/C++大学A组
//lanqiaoOJ  599 
public class Main{
public static void main(String[] args) {
        long sum=0;
        for(int i=1;i<=2019;i++) {
            String s = String.valueOf(i);
            if(s.contains("2") || s.contains("0") || s.contains("1") || s.contains("9"))
                sum += i*i;
        }
        System.out.println(sum);
}
}