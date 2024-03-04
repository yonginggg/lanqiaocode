//自行车停放 lanqiaoOJ 1518
 
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();   //自行车总数
		int num = sc.nextInt();  //第一辆自行车的编号
		doubleNode first = new doubleNode();  //创建双向链表
		first.data = num;
		first.prior = null;
		first.next = null;
		doubleNode xx = null,yy = null;
		doubleNode[] local = new doubleNode[100005];//存放自行车的地址
		local[num] = first;//第一辆自行车的地址
		for(int i=1;i<n;i++){//依次向双向链表中插入数据
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			xx = new doubleNode();
			xx.data = x;
			local[x] = xx;//编号为x的自行车地址
			yy = new doubleNode();
			yy = local[y]; //获取编号y的自行车地址，存入的比x早
			if(z==0){ //1.x放在y的左边（即将x插入到双向链表中结点yy的前面）
				xx.next = yy;
				if(yy.prior!=null){//yy结点不是头节点
					xx.prior = yy.prior;
					yy.prior.next = xx;
				}else{
					xx.prior = null;
				}
				yy.prior = xx; //y的前驱指针指向x
				if(yy==first){//yy是头节点，则更改头节点
					first = xx;
				}
			}//if
			if(z==1){//2.x放在y的右边（即将x插入到双向链表中y的后面）
				xx.prior = yy;
				if(yy.next!=null){//yy结点不是尾结点
					xx.next = yy.next;
					yy.next.prior = xx;
				}else{//yy是尾结点
					xx.next = null;
				}
				yy.next = xx;
			}//if
		}//for

		while(first != null){
			System.out.print(first.data+" ");
			first = first.next;
		}
	}

}
class doubleNode{//双向链表
	int data;
	doubleNode prior,next;
	public doubleNode() {}
	public doubleNode(int data, doubleNode prior, doubleNode next) {
		super();
		this.data = data;
		this.prior = prior;
		this.next = next;
	}
}
