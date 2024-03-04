//错误票据 lanqiaoOJ 205

import java.util.*;
public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<n;i++){
            String line = sc.nextLine();
            String[] splits = line.split("\\s+");
            for(int j = 0;j<splits.length;j++){
                list.add(Integer.parseInt(splits[j]));
            }
        }
        Collections.sort(list);
        int a = 0,b = 0;
        for(int i = 1;i<list.size();i++){
            if(list.get(i)-list.get(i-1)==2){
                a = list.get(i)-1;
            }
            if(list.get(i).equals(list.get(i-1))){
                b = list.get(i);
            }
        }
        System.out.println(a+" "+b);
    }
}
