package codingTest;
import java.util.ArrayList;
public class Stack<T> {
	//push(): �����͸� ���ÿ� �ֱ�
	//pop(): �����͸� ���ÿ��� ������
	
	private ArrayList<T> stack = new ArrayList<T>();
	
	 public void push(T item) {
		 	stack.add(item);
	    }
	 
	 public T pop() {
		 
		 if(stack.isEmpty()) {
			 return null;
		 }
		 return stack.remove(stack.size()-1);
		 
	 }
	 
	 public boolean isEmpty() {
		 return stack.isEmpty();
	 }
	 
	 public static void main(String[] args) {
		 Stack<Integer> st = new Stack<Integer>();
		 st.push(1);
		 st.push(2);
		 System.out.println(st.pop());
		 st.push(3);
		 System.out.println(st.pop());
		 System.out.println(st.pop());
	 }
}
