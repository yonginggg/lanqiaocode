//外卖店优先级 2019年第十届蓝桥省赛C/C++大学A组
//lanqiaoOJ 184

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
 
public class Main {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();
 
        //这里的map的key表示外卖店的id号，value的list表示对应的外卖店有订单的时刻
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //把输入的信息存到map中
        for (int i = 1; i <= m ; i++) {
            int ts = scanner.nextInt();
            int id = scanner.nextInt();
            if (map.containsKey(id)){
                map.get(id).add(ts);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(ts);
                map.put(id, list);
            }
        }
        //该变量为在优先队列的外卖店个数
        int result = 0;
 
        for (Integer who :
                map.keySet()) {
            //某外卖店有订单的所有时刻
            ArrayList<Integer> orders = map.get(who);
            //创建一个数组，他的下标为某时刻有的订单数
            int[] count = new int[t + 1];
            //填充一下count数组
            for (int i = 0; i < orders.size(); i++) {
                Integer time = orders.get(i);
                count[time]+=1;
            }
            int priority = 0;//该外卖店的优先级
            boolean flag = false;
            for (int i = 1; i < count.length; i++) {
                if (count[i] == 0){//说明i时刻该外卖店没有订单
                    if (priority!=0){//优先级不为0，不需要扣优先级
                        priority--;
                    }
                    if (priority<=3){ //移出优先队列
                        flag = false;
                    }
                }else {//有订单
                    priority += count[i]*2;
                    if (priority>5){//加入优先队列
                        flag = true;
                    }
                }
            }
            if (flag){
                result++;
            }
        }
        System.out.println(result);
        scanner.close();
    }
}   