//分解质因数  lanqiaoOJ 1559


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i=a; i<=b; ++i){
            fenjie(i);
            System.out.println();
        }
    }

    private static void fenjie(int a){
        System.out.print(a + "=");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=2; i<=Math.pow(a,0.5); ++i){
            if (a%i==0){
                list.add(i);
                a = a/i;
            }
            while (a%i==0){
                list.add(i);
                a = a/i;
            }
        }
        if (a >1){
            list.add(a);
        }
        for (int i=0; i<list.size(); ++i){
            if (i < list.size()-1){
                System.out.print(list.get(i) + "*");
            }
            else{
                System.out.print(list.get(i));
            }
        }
    }
}