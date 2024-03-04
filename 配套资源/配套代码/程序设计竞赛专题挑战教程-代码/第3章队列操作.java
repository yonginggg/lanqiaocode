//¶ÓÁÐ²Ù×÷   lanqiaoOJ 1519

import java.util.ArrayList;
import java.util.Scanner;
public class Main{
	public static void main(String[] arge){
	    	Scanner in=new Scanner(System.in);
	        int n=in.nextInt();
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        ArrayList<Integer> lis=new ArrayList<Integer>();
	        for(int i=1;i<=n;i++){
	        	int x=in.nextInt();
	        	if(x==1){
	        		int y=in.nextInt();
	        		list.add(y);
	        	}
	        	else if(x==2){
	        		if(list.size()>0){
	        			lis.add(list.get(0));
	        			list.remove(0);
	        		}
	        		else{
	        			for(int k:lis)
	        				System.out.println(k);
	        			System.out.println("no");
	        			return;
	        		}
	        	}
	        	else{
	        		lis.add(list.size());
	        	}
	        }
	        for(int k:lis)
				System.out.println(k);
	}
}
