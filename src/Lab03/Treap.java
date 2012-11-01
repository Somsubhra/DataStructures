package Lab03;
/**
 *
 * @author Somsubhra(201101056)
 */
public class Treap<T extends Comparable>{
  
    private TreapNode<T> root;
    private int size;
    
    public Treap(){
        root = null;
        
        size = 0;
        
    }
    
    public void add(T element, int priority){
        TreapNode<T> newNode= new TreapNode<T>(element,priority);
        
        if(root==null){
            root = newNode;
        }
        else{
            add(newNode,root);
        }
        size++;
    }
    
    private void add(TreapNode<T> node, TreapNode<T> root){
        if(node.value.compareTo(root.value)<0){
            //insert in left tree
            if(root.left==null){
                root.left = node;
                node.parent = root;
            }else{
                add(node,root.left);
            }
            if(root.priority>root.left.priority){
                rotateRight(root);
            }
        }else{
            //insert in right tree
            if(root.right==null){
                root.right = node;
                node.parent = root;
            }
            else{
                add(node,root.right);
            }
            if(root.priority>root.right.priority){
                rotateLeft(root);
            }
        }
    
    }
    
    private void rotateLeft(TreapNode<T> node){
        if(node.right!=null){
            TreapNode<T> A = node;
            TreapNode<T> B = node.right;
            
            TreapNode<T> temp = B.left;
            B.left = A;
            TreapNode<T> oldParent = A.parent;
            A.parent = B;
            
            A.right = temp;
            if(temp!=null){
                temp.parent = A;
            }
            B.parent = oldParent;
            
            if(oldParent==null){
                root = B;
            }else{
                if(oldParent.left ==A){
                    oldParent.left = B;
                }else{
                    oldParent.right = B;
                }
            }
        }
    }
    
    
    private void rotateRight(TreapNode<T> node)
    {
        /* check that there is a left node */
        if (node.left != null)
        {
            TreapNode<T> A = node.left;
            TreapNode<T> B = node;
            
            /* we want A's right to point to B */
            TreapNode<T> temp = A.right;
            A.right = B;
            TreapNode<T> oldParent = B.parent;
            B.parent = A;
            
            /* then we want B's left to point to what was A's right */
            B.left = temp;
            if (temp != null)
            {
                temp.parent = B;
            }
            
            /* update the parent */
            A.parent = oldParent;
            if (oldParent == null)
            {
                /* root */
                root = A;
            }
            else
            {
                /* find out whether we were the left or right child of parent */
                if (B == oldParent.left)
                {
                    oldParent.left = A;
                }
                else
                {
                    oldParent.right = A;
                }
            }
        }
    }
    
    private TreapNode<T> getNode(T value, TreapNode<T> root)
    {
        if (root == null)
        {
            return null;
        }
        
        int comp = value.compareTo(root.value);
        if (comp == 0)
        {
            return root;
        }
        else if (comp < 0)
        {
            return getNode(value, root.left);
        }
        else
        {
            return getNode(value, root.right);
        }
    }
    
    public boolean contains(T element)
    {
        TreapNode<T> node = getNode(element, root);
        return node != null;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void display(){
        levelOrder(root);
    }
    
    public void levelOrder(TreapNode localRoot){
            Queue<TreapNode> q = new Queue<TreapNode>();
            TreapNode x = localRoot;
            TreapNode y = null;
            if(x==null){
                return;
            }
            q.enqueue(x);
            while(!(q.isEmpty())){
                y = q.dequeue();
                if(y.left!=null){
                    q.enqueue(y.left);
                }
                if(y.right!=null){
                    q.enqueue(y.right);
                }
                y.displayNode();
            }
    }
}
