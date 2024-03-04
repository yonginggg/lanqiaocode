//火星人 lanqiaoOJ 572


//火星人-LOU1990521340的代码
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
          Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int count = sc.nextInt();
            int []arr = new int [n];
            for(int i = 0;i < n ;i++){
                arr[i] = sc.nextInt();
            }
            while((count--)!=0){
                nextPermuation(arr,n);
            }
            for(int i = 0; i < n;i++){
                System.out.print(arr[i]+" ");
            }
    }
     public static void nextPermuation(int []arr,int n ){
            int i = n -2;
            while(i>0&&arr[i]>arr[i+1]){
                i--;
            }
            int j = n-1;
            while(j>i&&arr[j]<arr[i]){
                j--;
            }
            swap(i,j,arr);
      
            i++;
            j = n-1;
            while(i<j){
               swap(i++,j--,arr);
           }
            
        }
        public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp; 
            
        }

}    