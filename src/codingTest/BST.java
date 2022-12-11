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
	  myTree.insertNode(10);
      myTree.insertNode(15);
      myTree.insertNode(13);
      myTree.insertNode(11);
      myTree.insertNode(14);
      myTree.insertNode(18);
      myTree.insertNode(16);
      myTree.insertNode(19);
      myTree.insertNode(17);
      myTree.insertNode(7);
      myTree.insertNode(8);
      myTree.insertNode(6);
      System.out.println(myTree.delete(15));
      System.out.println("HEAD: " + myTree.head.value);
      System.out.println("HEAD LEFT: " + myTree.head.left.value);
      System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
      System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

      System.out.println("HEAD RIGHT: " + myTree.head.right.value);
      System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
      System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

      System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
      System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
}

public boolean delete(int value) {
	boolean searched =false;
	
	Node currParentNode = this.head;
	Node currNode = this.head;
	
	//���� 1 Node�� �ϳ��� ���� �� 
	if(this.head==null) {
		return false;
	
	} else {
	//���� 2 Node�� �ϳ��� �ְ�, �ش� Node�� ������ Node�� ���
		if(this.head.value ==value && this.head.left==null && this.head.right==null) {
				this.head=null;
				return true;
		}
		
		while(currNode !=null) {
			if(currNode.value==value) {
				searched =true;
				break;
				
			}else if(value <currNode.value) {
				currParentNode=currNode;
				currNode=currNode.left;
				
			}else {
				currParentNode=currNode;
				currNode=currNode.right;
				
			}
		}
		
		
		if(searched == false) {
			return false;
		}
	}
	
	//  >> currNode�� �ش� �����͸� ������ �ִ� Node, currParentNode���� �ش� �����͸� ������ �ִ� Node�� �θ� Node 
		
    // Case1: ������ Node �� Leaf Node �� ���
    if (currNode.left == null && currNode.right == null) {
        if (value < currParentNode.value) {
            currParentNode.left = null;
            currNode = null;
        } else {
            currParentNode.right = null;
            currNode = null;
        }
        return true;	

    
    // Case2-1: ������ Node �� Child Node�� �� �� ������ ���� ��� (���ʿ� Child Node �� ���� ���)
    } else if (currNode.left != null && currNode.right == null) {
        if (value < currParentNode.value) {
            currParentNode.left = currNode.left;
            currNode = null;
        } else {
            currParentNode.right = currNode.left;
            currNode = null;
        }
        return true;
    // Case2-2: ������ Node �� Child Node�� �� �� ������ ���� ��� (�����ʿ� Child Node �� ���� ���)
    } else if (currNode.left == null && currNode.right != null) {
        if (value < currParentNode.value) {
            currParentNode.left = currNode.right;
            currNode = null;
        } else {
            currParentNode.right = currNode.right;
            currNode = null;
        }
        return true;

        
    // Case3-1: ������ Node�� Child Node�� �� �� ������ ���� ��� (������ Node�� Parent Node ���ʿ� ���� ��)
    } else {
    	// ������ Node �� �θ� Node �� ���ʿ� ���� ��
    	 if (value < currParentNode.value) {
    		 Node changeNode = currNode.right;
             Node changeParentNode = currNode.right;
             while (changeNode.left != null) {
                 changeParentNode = changeNode;
                 changeNode = changeNode.left; 
    	 }
             // >> changeNode ���� ������ Node �� ������ Node �߿���, 
             // ���� ���� ���� ���� Node �� ������� 
             
             
             if (changeNode.right != null) {
                 // Case 3-1-2: changeNode �� ������ Child Node �� ���� ��
                 changeParentNode.left = changeNode.right;
             } else {
                 // Case 3-1-1: changeNode �� Child Node �� ���� ��
                 changeParentNode.left = null;
             }
             
             // currParentNode �� ���� Child Node ��, ������ Node �� ������ �ڽ���,
             // ���� ���� ���� ���� changeNode �� ����
             currParentNode.left = changeNode;
             
             // parentNode �� ���� Child Node �� ����, changeNode �̰�,
             // changeNode �� ����/������ Child Node �� ���, ������ currNode ��
             // ���� ����/������ Node �� ����
             changeNode.right = currNode.right;
             changeNode.left = currNode.left;
             
             currNode = null;
    } else {
    	 // Case3-1: ������ Node�� Child Node�� �� �� ������ ���� ��� (������ Node�� Parent Node ���ʿ� ���� ��)
    	  Node changeNode = currNode.right;
          Node changeParentNode = currNode.right;
          while (changeNode.left != null) {
              changeParentNode = changeNode;
              changeNode = changeNode.left;
          }
          // ������� ����Ǹ�, changeNode ���� ������ Node �� ������ Node �߿���, 
          // ���� ���� ���� ���� Node �� �������            
      
          if (changeNode.right != null) {
              // Case 3-2-2: changeNode �� ������ Child Node �� ���� ��
              changeParentNode.left = changeNode.right;
          } else {
              // Case 3-2-1: changeNode �� Child Node �� ���� ��
              changeParentNode.left = null;
          }

          // currParentNode �� ������ Child Node ��, ������ Node �� ������ �ڽ���,
          // ���� ���� ���� ���� changeNode �� ����
          currParentNode.right = changeNode;
          
          // parentNode �� ���� Child Node �� ����, changeNode �̰�,
          // changeNode �� ����/������ Child Node �� ���, ������ currNode ��
          // ���� ����/������ Node �� ����
          changeNode.right = currNode.right;
          changeNode.left = currNode.left;
          
          currNode = null;            
  }
  return true;
}
}
}