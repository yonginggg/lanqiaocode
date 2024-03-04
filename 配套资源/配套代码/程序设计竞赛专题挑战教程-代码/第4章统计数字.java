//统计数字 lanqiaoOJ 535
import java.util.*;
public class Main{
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            int b = scanner.nextInt();
            nums[i] = b;
        }
        Arrays.sort(nums);
        int k = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] !=k ){
                System.out.println(k+" "+cnt);
                k = nums[i];
                cnt = 1;
            }else{
                cnt++;
            }
        }
        System.out.println(k+" "+cnt);
    }
}
