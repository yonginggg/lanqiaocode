//砝码称重  2021年第十一届省赛 lanqiaoOJ 1447

import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[100005];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
 
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>(set);
            for(int k:list){
                set.add(k+a[i]);
                set.add(Math.abs(k-a[i]));
            }
        }
        set.remove((Object)0);
        System.out.println(set.size());
    }
 
}