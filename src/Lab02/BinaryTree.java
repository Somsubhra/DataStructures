package Lab02;
import java.util.Stack;
/**
 * 
 * @author Somsubhra(201101056)
 */

public class BinaryTree{
	Node root;
	
	public BinaryTree(){
		this.root = null;
	}
	
	public void insert(int data){
		Node newNode = new Node();
		newNode.data = data;
		if(root==null){
			root = newNode;	
		}else{
			Node current=root;
			Node parent;
			while(true){
				parent = current;
				if(data < current.data){
					current = current.leftChild;
					if(current==null){
						parent.leftChild = newNode;
						return;
					}	
				}else{
					current = current.rightChild;
					if(current==null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.leftChild);
			localRoot.displayNode();
			inOrder(localRoot.rightChild);
		}
	}

	public void preOrder(Node localRoot){
		if(localRoot!=null){
			localRoot.displayNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	public void postOrder(Node localRoot){
		if(localRoot!=null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.displayNode();
		}
	}

	
	public void levelOrder(Node localRoot){
            Queue<Node> q = new Queue<>();
            Node x = localRoot;
            Node y = null;
            if(x==null){
                return;
            }
            q.enqueue(x);
            while(!(q.isEmpty())){
                y = q.dequeue();
                if(y.leftChild!=null){
                    q.enqueue(y.leftChild);
                }
                if(y.rightChild!=null){
                    q.enqueue(y.rightChild);
                }
                y.displayNode();
            }
	}

	public void zigzagOrder(Node localRoot){
            Stack<Node> currentLevel = new Stack<>();
            Stack<Node> nextLevel = new Stack<>();
            boolean leftToRight = true;
            currentLevel.push(localRoot);
            
            while(!currentLevel.isEmpty()){
                Node currentNode = currentLevel.pop();
                if(currentNode!=null){
                    currentNode.displayNode();
                    if(leftToRight){
                        nextLevel.push(currentNode.leftChild);
                        nextLevel.push(currentNode.rightChild);
                    }else{
                        nextLevel.push(currentNode.rightChild);
                        nextLevel.push(currentNode.leftChild);
                    }
                }
                if(currentLevel.isEmpty()){
                    leftToRight = !leftToRight;
                    Stack<Node> tmp = currentLevel;
                    currentLevel = nextLevel;
                    nextLevel = tmp;
                }
            }
	}
}
