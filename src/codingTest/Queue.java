package codingTest;

import java.util.ArrayList;

public class Queue<T> {
	
		//Enqueue: ť�� �����͸� �ִ� ���, Dequeue: ť���� �����͸� ������ ���
		//FIFO(First-In, First-Out), LILO(Last-In, Last-Out) 
	    
	
//	- JAVA ArrayList Ŭ������ Ȱ���ؼ� ť�� �ٷ�� enqueue, dequeue ��� �����غ���
//	- dequeue ��� ȣ�� ��, ť�� �����Ͱ� ���� ���, null �� �����ϵ��� ��
//	- �پ��� ������ Ÿ���� �ٷ� �� �ֵ���, Java Genric Ÿ�� ������ Ȱ���غ���

		private ArrayList<T> queue = new ArrayList<T>();
	    
	    public void enqueue(T item) {
	        queue.add(item);
	    }
	    
	    public T dequeue() {
	        if (queue.isEmpty()) {
	            return null;
	        }
	        return queue.remove(0);
	    }
	    
	    public boolean isEmpty() {
	        return queue.isEmpty();
	    }
	    
	    public static void main(String[] args) {
	    	Queue<Integer> mq = new Queue<Integer>();
	        mq.enqueue(1);
	        mq.enqueue(2);
	        mq.enqueue(3);
	        System.out.println(mq.dequeue());
	        System.out.println(mq.dequeue());
	        System.out.println(mq.dequeue());        
	    }
	
}
