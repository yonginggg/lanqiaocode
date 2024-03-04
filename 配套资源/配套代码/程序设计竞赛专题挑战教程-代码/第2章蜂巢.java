//蜂巢 2022年第十三届省赛Java大学A组、研究生组，Python大学B组、C组
 
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] a1 = new long [3];
        long[] a2 = new long [3];
        for(int i = 0; i < 3; i++)
            a1[i] = in.nextLong();
        for(int i = 0; i < 3; i++)
            a2[i] = in.nextLong();
        long d1=a1[0],p1=a1[1],q1=a1[2];
        long[] xy1 = walk(d1, p1, 0, 0);
        xy1 = walk((d1 + 2) %6, q1 , xy1[0], xy1[1]);

        long d2=a2[0],p2=a2[1],q2=a2[2];
        long[] xy2 = walk(d2, p2, 0, 0);
        xy2 = walk((d2 + 2) %6, q2 , xy2[0], xy2[1]);

        long ans = 0;
        long dx = Math.abs(xy1[0]-xy2[0]);
        long dy = Math.abs(xy1[1]-xy2[1]);
        if (dx >= dy) ans = (dx+dy)/2;     //先横走，再斜着走
        else          ans =  dy;              //一直斜着走就行了
        System.out.println(ans);

    }
    static long[] walk(long d, long q, long x, long y) {  //返回新坐标
        if(d == 0)   x -= 2*q;
        if(d == 1) { x -= q; y += q;   }
        if(d == 2) { x += q; y += q;   }
        if(d == 3) { x += 2*d;    }
        if(d == 4) { x += q; y -= q;   }
        if(d == 5) { x -= q; y -= q;   }
        long [] ret = new long [2];
        ret[0] = x;
        ret[1] = y;
        return ret; //返回新坐标
    }
}
