//���в���  lanqiaoOJ 1519 

#include <bits/stdc++.h>
using namespace std;
#define MAXQSIZE 100003        //�Զ�����д�С
struct myqueue{
    int data[MAXQSIZE];        //���侲̬�ռ�
    int head;                  //��ͷ��ָ���ͷ��Ԫ��
    int rear;                  //��β��ָ����һ�����Է�Ԫ�صĿ�λ��
    bool init(){               //��ʼ��
        head = rear = 0;
        return true;
    }
    int size(){ return (rear - head + MAXQSIZE) % MAXQSIZE;}//���ض��г���
    bool empty(){             //�ж϶����Ƿ�Ϊ��
        if(size()==0) return true;
        else          return false;
    }
    bool push(int e){        //��β������Ԫ�ء��µ�rearָ����һ���յ�λ��
         if((rear + 1) % MAXQSIZE == head ) return false; //������
         data[rear] = e;
         rear = (rear + 1) % MAXQSIZE;
         return true;
    }
    bool pop(int &e){        //ɾ����ͷԪ�أ���������
         if(head == rear) return false;   //���п�
         e = data[head];
         head = (head + 1) % MAXQSIZE;
         return true;
    }
    int front(){ return data[head];}   //���ض��ף����ǲ�ɾ��
}Q;
int main(){
	Q.init();                    //��ʼ������
	int n;  cin>>n;
	for(int i=0;i<n;i++)	{
		int num;  cin>>num;
		switch(num){
			case 1:
				int element;  cin>>element;
                Q.push(element);
				break;
			case 2:
                if(!Q.empty()){
					cout<<Q.front()<<endl;
					int tmp;
					Q.pop(tmp);
				}
				else{ cout<<"no"<<endl;	return 0;}
				break;
			case 3:
			    cout<<Q.size()<<endl;
				break;
		}
	}
	return 0;
}
