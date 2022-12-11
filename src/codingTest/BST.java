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
		// case1 : Node 가 하나도 없을 때
		if(this.head==null) {
			
			this.head=new Node(data);
		}else {
			//case 2 : Node 가 하나 이상 들어가 있ㅇ르 때 
			Node findNode = this.head;
			while(true) {
				//case2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때 
				if(data<findNode.value) {
					if(findNode.left !=null) {
						findNode=findNode.left;
					}else {
						findNode.left=new Node(data);
						break;
					}
					//case2-2 : 현재 Node의 오른족에 Node가 들어가야 할 때
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
	
	//예외 1 Node가 하나도 없을 때 
	if(this.head==null) {
		return false;
	
	} else {
	//예외 2 Node가 하나만 있고, 해당 Node가 삭제할 Node일 경우
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
	
	//  >> currNode에 해당 데이터를 가지고 있눈 Node, currParentNode에는 해당 데이터를 가지고 있는 Node의 부모 Node 
		
    // Case1: 삭제할 Node 가 Leaf Node 인 경우
    if (currNode.left == null && currNode.right == null) {
        if (value < currParentNode.value) {
            currParentNode.left = null;
            currNode = null;
        } else {
            currParentNode.right = null;
            currNode = null;
        }
        return true;	

    
    // Case2-1: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우 (왼쪽에 Child Node 가 있을 경우)
    } else if (currNode.left != null && currNode.right == null) {
        if (value < currParentNode.value) {
            currParentNode.left = currNode.left;
            currNode = null;
        } else {
            currParentNode.right = currNode.left;
            currNode = null;
        }
        return true;
    // Case2-2: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우 (오른쪽에 Child Node 가 있을 경우)
    } else if (currNode.left == null && currNode.right != null) {
        if (value < currParentNode.value) {
            currParentNode.left = currNode.right;
            currNode = null;
        } else {
            currParentNode.right = currNode.right;
            currNode = null;
        }
        return true;

        
    // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우 (삭제할 Node가 Parent Node 왼쪽에 있을 때)
    } else {
    	// 삭제할 Node 가 부모 Node 의 왼쪽에 있을 때
    	 if (value < currParentNode.value) {
    		 Node changeNode = currNode.right;
             Node changeParentNode = currNode.right;
             while (changeNode.left != null) {
                 changeParentNode = changeNode;
                 changeNode = changeNode.left; 
    	 }
             // >> changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서, 
             // 가장 작은 값을 가진 Node 가 들어있음 
             
             
             if (changeNode.right != null) {
                 // Case 3-1-2: changeNode 의 오른쪽 Child Node 가 있을 때
                 changeParentNode.left = changeNode.right;
             } else {
                 // Case 3-1-1: changeNode 의 Child Node 가 없을 때
                 changeParentNode.left = null;
             }
             
             // currParentNode 의 왼쪽 Child Node 에, 삭제할 Node 의 오른쪽 자식중,
             // 가장 작은 값을 가진 changeNode 를 연결
             currParentNode.left = changeNode;
             
             // parentNode 의 왼쪽 Child Node 가 현재, changeNode 이고,
             // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
             // 기존 왼쪽/오른쪽 Node 로 변경
             changeNode.right = currNode.right;
             changeNode.left = currNode.left;
             
             currNode = null;
    } else {
    	 // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우 (삭제할 Node가 Parent Node 왼쪽에 있을 때)
    	  Node changeNode = currNode.right;
          Node changeParentNode = currNode.right;
          while (changeNode.left != null) {
              changeParentNode = changeNode;
              changeNode = changeNode.left;
          }
          // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서, 
          // 가장 작은 값을 가진 Node 가 들어있음            
      
          if (changeNode.right != null) {
              // Case 3-2-2: changeNode 의 오른쪽 Child Node 가 있을 때
              changeParentNode.left = changeNode.right;
          } else {
              // Case 3-2-1: changeNode 의 Child Node 가 없을 때
              changeParentNode.left = null;
          }

          // currParentNode 의 오른쪽 Child Node 에, 삭제할 Node 의 오른쪽 자식중,
          // 가장 작은 값을 가진 changeNode 를 연결
          currParentNode.right = changeNode;
          
          // parentNode 의 왼쪽 Child Node 가 현재, changeNode 이고,
          // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
          // 기존 왼쪽/오른쪽 Node 로 변경
          changeNode.right = currNode.right;
          changeNode.left = currNode.left;
          
          currNode = null;            
  }
  return true;
}
}
}