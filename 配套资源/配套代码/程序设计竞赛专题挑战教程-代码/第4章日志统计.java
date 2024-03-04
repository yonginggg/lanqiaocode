//日志统计 2018年第九届省赛C/C++大学A组  lanqiaoOJ 179
/*暴力法。
重点在于所有帖子的排序。下面的Java代码，36~38行的排序，先按所有帖子的id排序，然后对同一个id，对它的点赞时间排序。经过排序之后，所有帖子按id被分开，同一个id的帖子又按时间排序，容易统计是否为热帖。
在主程序中，暴力遍历所有排序后的帖子即可：第16~20行，对某个id的所有点赞贴，看是否存在某个[T, T+D)内达到了k个赞。
算法的时间复杂度，第16行的for循环是O(n)的。前面的排序是O(nlogn)的。总复杂度O(nlogn)。*/


import java.util.*;
public class Main{
    public static void main(String args[])    {
        int n,d,k;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        d=sc.nextInt();
        k=sc.nextInt();
        post arr[]=new post[n];
        for(int i=0;i<n;i++)
            arr[i]=new post(sc.nextInt(),sc.nextInt());
        Arrays.sort(arr);
        int curid = arr[0].id;
        int added = 0;
        for(int i=0;i<n;i++){
            if(i+k-1<n && arr[i+k-1].id==curid 
                       && arr[i+k-1].ts-arr[i].ts<d && added==0){
                System.out.println(curid);
                added=1;
            }
            else if(arr[i].id != curid){
                curid = arr[i].id;
                added = 0;
                i = i-1;
            }
        }
    }
}
class post implements Comparable<post>{
    int ts,id;
    post(int a,int b)    {
        ts=a;
        id=b;
    }
    public int compareTo(post o) {
        if(id==o.id)   return ts-o.ts;
        else           return id-o.id;
    }
}

