package codingTest;

import java.util.ArrayList;

public class Queue<T> {
	
		//Enqueue: 큐에 데이터를 넣는 기능, Dequeue: 큐에서 데이터를 꺼내는 기능
		//FIFO(First-In, First-Out), LILO(Last-In, Last-Out) 
	    
	
//	- JAVA ArrayList 클래스를 활용해서 큐를 다루는 enqueue, dequeue 기능 구현해보기
//	- dequeue 기능 호출 시, 큐에 데이터가 없을 경우, null 을 리턴하도록 함
//	- 다양한 데이터 타입을 다룰 수 있도록, Java Genric 타입 문법을 활용해보기

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
