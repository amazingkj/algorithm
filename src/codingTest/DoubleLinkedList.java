package codingTest;

public class DoubleLinkedList<T> {
	public Node<T> head = null;
	public Node<T> tail = null;
	
	//doubleLinkedList 기본형 정의
	public class Node<T> {
		T data;
		Node<T> prev=null;
		Node<T> next=null;
		
		public Node(T data) {
			this.data=data;
		}
	}
	//doubleLinkedList 뒤에 데이터를 추가할 경우 정의
	public void addNode(T data) {
		//첫번째 데이터 입력 시
		if(this.head==null) {
			this.head=new Node<T>(data);
			this.tail=this.head;
		//중간 데이터 입력 시	
		}else {
			
			Node<T> node = this.head;
			//다음 값이 있으면 node의 다음 값을 node에 대입하고
			while(node.next!=null) {
				node=node.next;
			}
			node.next=new Node<T>(data);
			node.next.prev=node;
			this.tail=node.next;
		}
	}
	
	
	public void printAll() {
		if(this.head != null) {
			Node<T>node=this.head;
			System.out.println(node.data);
			
			while(node.next!=null) {
				node = node.next;
				System.out.println(node.data);
				}
		}
	}
	
	//앞에서부터 검색하기
	public T searchFromHead(T isData) {
		if(this.head==null) {
			return null;
			
		}else {
			Node<T> node =this.head;
			
			while(node!=null) {
				if(node.data==isData) {
					return node.data;
					
				}else {
					node = node.next;
				}
			}
			return null;
		}
	}
	
	//뒤에서부터 검색하기
	public T searchFromTail(T isData) {
		if(this.head==null) {
			return null;
			
		}else {
			Node<T> node=this.tail;
			while(node!=null) {
				if(node.data==isData) {
					return node.data;
				} else {
					node = node.prev;
				}
			}
			return null;
		}
	}	
	
	//임의 노드 앞에 노드를 추가하는 메서드 추가하기 
	public boolean insertToFront(T existedData, T addData) {
		//데이터가 없을 경우
		if(this.head==null) {
			this.head =new Node<T>(addData);
			this.tail=this.head;
			return true;
		//내가 찾는 데이터가 head 에 있을 경우	
		}else if (this.head.data==existedData) {
			Node<T> newHead = new Node<T>(addData);
			newHead.next = this.head;
			this.head = newHead;
			return true;
	
		}else {
			Node<T> node =this.head;
			while(node!=null) {
				if(node.data==existedData) {
					Node<T> nodePrev=node.prev;
					
					nodePrev.next=new Node<T>(addData);
					nodePrev.next.next=node;
					
					nodePrev.next.prev=nodePrev;
					node.prev= nodePrev.next;
					return true;
				}else {
					node=node.next;
				}
			}
		}
		return false;
		
	}
	
	
	
		
	public static void main(String[] args) {
		DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();
		MyLinkedList.addNode(1);
		MyLinkedList.addNode(2);
		MyLinkedList.addNode(3);
		MyLinkedList.addNode(4);
		MyLinkedList.addNode(5);
		MyLinkedList.printAll();
		System.out.println("===================");
		
		MyLinkedList.insertToFront(3, 2);
		MyLinkedList.printAll();
		
		System.out.println("===================");
		MyLinkedList.insertToFront(1, 0);
		MyLinkedList.printAll();
		
	}

}
