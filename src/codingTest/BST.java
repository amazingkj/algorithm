package codingTest;

public class BST {
	Node head = null;
	public class Node { 
		Node left;
		Node right;
		int value;
		
		public Node (int data) {
			this.value=data;
			this.left=null;
			this.right=null;
		}
	}
	
	
	public boolean insertNode(int data) {
		// case1 : Node �� �ϳ��� ���� ��
		if(this.head==null) {
			
			this.head=new Node(data);
		}else {
			//case 2 : Node �� �ϳ� �̻� �� �֤��� �� 
			Node findNode = this.head;
			while(true) {
				//case2-1 : ���� Node�� ���ʿ� Node�� ���� �� �� 
				if(data<findNode.value) {
					if(findNode.left !=null) {
						findNode=findNode.left;
					}else {
						findNode.left=new Node(data);
						break;
					}
					//case2-2 : ���� Node�� �������� Node�� ���� �� ��
				}else {
					if(findNode.right != null) {
						findNode =findNode.right;
					}else {
						findNode.right = new Node(data);
						break;
					}
				}	
			}
		}
		return true;
	}



public static void main(String[] args) {
	BST myTree=new BST();
	myTree.insertNode(2);
	myTree.insertNode(3);
	myTree.insertNode(4);
	myTree.insertNode(5);
}
}
