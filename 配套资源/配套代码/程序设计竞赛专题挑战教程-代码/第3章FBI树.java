//FBI 树  lanqiaoOJ 571 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        char[] arr = str.toCharArray();
        Node head = new Node();
        head.val = isType(arr);
        creatTree(arr,head);
        dfs(head);
    }

    private static void creatTree(char[] arr, Node head){
        //说明已经是叶子结点了
        if (arr.length == 1){
            head = new Node();
            head.val = isType(arr);
            return;
        }

        //否则，对一个点去构造左子树  ， 右子树
        char[] leftArr = new char[arr.length/2];
        head.left = new Node();
        System.arraycopy(arr,0,leftArr,0,arr.length/2);
        creatTree(leftArr,head.left);
        head.left.val = isType(leftArr);


        char[] rightArr = new char[arr.length/2];
        head.right = new Node();
        System.arraycopy(arr,arr.length/2,rightArr,0,arr.length/2);
        creatTree(rightArr,head.right);
        head.right.val = isType(rightArr);
    }

    private static void dfs(Node head){
        if (head == null){
            return;
        }
        dfs(head.left);
        dfs(head.right);
        System.out.print(head.val);
    }

    private static char isType(char[] arr){
        int one = 0;
        int zero = 0;
        for (int i=0; i<arr.length; ++i){
            if (arr[i] == '1'){
                one++;
            }
            else{
                zero++;
            }
        }
        if (one == 0) {
            return 'B';
        }
        if (zero == 0){
            return 'I';
        }
        return 'F';
    }
}

class Node{
    char val;
    Node left;
    Node right;
}
