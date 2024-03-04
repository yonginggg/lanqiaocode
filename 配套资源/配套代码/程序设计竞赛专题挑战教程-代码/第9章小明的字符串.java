//小明的字符串  lanqiaoOJ 1203

import java.util.Scanner;

public class Main {
//https://www.lanqiao.cn/courses/5194/learning/?id=497974
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        String t=scanner.next();
        getNext(t);
        KMP(s, t);
        System.out.println(max);
    }
    static int next[]=new int [100005];
    static int max=0;
    public static void getNext(String a) {
        int len=a.length();
        int k=-1;
        int j=0;
        next[0]=-1;
        while(j<len-1){
            if(k==-1 || a.charAt(j)==a.charAt(k)){
                j++;
                k++;
                next[j]=k;
                max=Math.max(max, next[j]);
            }else{
                k=next[k];
                max=Math.max(max, k);
            }
        }
    }
    
    static int KMP(String a,String b){
        int alen=a.length();
        int blen=b.length();
        int i=0;
        int j=-1;
        while(i<alen && j<blen){
            if(j==-1 || a.charAt(i)==b.charAt(j)){
                i++;j++;
            }else
                j=next[j];
            max=Math.max(max, j);
        }
        if(j==blen){
            return i-j;
        }else
            return -1;
    }
}