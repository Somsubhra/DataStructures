package Lab03;
/*This is the implementation of a Min-Heap.*/

/**
 *
 * @author Somsubhra(201101056)
 */
public class BinaryHeap {
    
    private int[] arr;
    private int size;
    
    public BinaryHeap(int maxSize){
        arr = new int[maxSize];
        size = 0;
    }
    
    public void buildUpward(int[] data){
        for(int i=0; i<data.length; i++){
            arr[i] = data[i];
            size++;
        }
        for(int i=1; i<size; i++){
            int current = arr[i];
            int currentLocation = i;
            while(parentOf(arr[i])>arr[i]){
                if(arr[i]!=getRoot()){
                    int tmp = parentOf(arr[i]);
                    int tmp1 = indexOfParent(current);
                    arr[indexOfParent(arr[i])] = arr[i];
                    arr[currentLocation] = tmp;
                    currentLocation = tmp1;
                }else{
                    break;
                }
            }
        }
    }
    
    public void buildDownward(int[] data){
        for(int i=0; i<data.length; i++){
            arr[i] = data[i];
            size++;
        }
        for(int i=0; i<Math.pow(2, getHeight())-1;i++){
            heapify(arr[i]);
        }
    }
    public void build(int[] data){
        for(int i=0; i<data.length; i++){
            this.insert(data[i]);
        }
    }
    
    public void insert(int item){
        if(size==arr.length){
            System.out.println("Error:Overflow.");
        }
        else{
            if(arr==null){
                arr[0] = item;
                size++;
            }
            else{
                arr[size]=item;
                size++;
                int current=item;
                int currentLocation = size-1;
                while(parentOf(item)>item){
                    if(item!=getRoot()){
                        
                        int tmp = parentOf(item);
                        int tmp1 = indexOfParent(current);
                        arr[indexOfParent(item)]=item;
                        arr[currentLocation] = tmp;
                        currentLocation = tmp1;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }
    
    public void alter(int newData, int oldData){
        arr[indexOf(oldData)] = newData;
        if(newData>oldData){
            heapify(newData);
        }else{
            //upwards
            int current=newData;
            int currentLocation = indexOf(newData);
             while(parentOf(newData)>newData){
                    if(newData!=getRoot()){
                        
                        int tmp = parentOf(newData);
                        int tmp1 = indexOfParent(current);
                        arr[indexOfParent(newData)]=newData;
                        arr[currentLocation] = tmp;
                        currentLocation = tmp1;
                    }
                    else{
                        break;
                    }
                }
        }
    }
   
    public int getRoot(){
        return arr[0];
    }
    
    public int leftChildOf(int data){
        
        return arr[indexOfLeftChild(data)];
    }
    
    private int indexOfLeftChild(int data){
        int j=0;
        while(data!=arr[j]){
            j++;
        }
        return 2*j+1;
    }
    
    public int rightChildOf(int data){

        return arr[indexOfRightChild(data)];
    }
    
    private int indexOfRightChild(int data){
        int j=0;
        while(data!=arr[j]){
            j++;
        }
        return 2*j+2;
    }
    
    public int parentOf(int data){
           
        return arr[indexOfParent(data)];
    }
    
    private int indexOf(int data){
        int j=0;
        while(data!=arr[j]){
            j++;
        }
        return j;
    }
    
    private int indexOfParent(int data){
        int j=0;
        while(data!=arr[j]){
            j++;
        }
        return (j-1)/2;
    }
            
    public void display(){
        for(int i=0; i<size; i++){
            System.out.println(arr[i]);
        }
        System.out.println("\n");
    }
    
    public int getHeight(){
        int x = (int) (Math.log(size)/Math.log(2));
        return x;
    }
    
    public int deleteRoot(){
        int deletedRoot = getRoot();
        arr[0] = arr[size-1];
        size--;
        heapify(getRoot());
        
        return deletedRoot;
    }
    
    public void heapify(int node){
        int current = node;
        while(true){
            
            if(hasLeftChild(current) && hasRightChild(current)){
                if(current>leftChildOf(current) || current>rightChildOf(current)){
                if(leftChildOf(current)>rightChildOf(current)){
                    int tmp1 = current;
                    int tmp2 = rightChildOf(current);
                    int tmp3 = indexOf(current);
                    int tmp4 = indexOfRightChild(current);
                    arr[tmp3] = tmp2;
                    arr[tmp4] = tmp1;
                }else{
                    int tmp1 = current;
                    int tmp2 = leftChildOf(current);
                    int tmp3 = indexOf(current);
                    int tmp4 = indexOfLeftChild(current);
                    arr[tmp3] = tmp2;
                    arr[tmp4] = tmp1;
                }
            }else{break;}}
            //Never possible in a heap.
            /*if(!hasLeftChild(current) && hasRightChild(current)){
                if(current>rightChildOf(current)){
                    int tmp1 = current;
                    int tmp2 = rightChildOf(current);
                    int tmp3 = indexOf(current);
                    int tmp4 = indexOfRightChild(current);
                    arr[tmp3] = tmp2;
                    arr[tmp4] = tmp1;
                }else{
                    break;
                }
            }*/
            
            if(hasLeftChild(current) && !hasRightChild(current)){
                if(current>leftChildOf(current)){
                    int tmp1 = current;
                    int tmp2 = leftChildOf(current);
                    int tmp3 = indexOf(current);
                    int tmp4 = indexOfLeftChild(current);
                    arr[tmp3] = tmp2;
                    arr[tmp4] = tmp1;
                }else{
                    break;
                }
            }
            
            if(!hasLeftChild(current) && !hasRightChild(current)){
                break;
            }
        }
        
    }
    
    public boolean hasLeftChild(int data){
        return indexOfLeftChild(data)<size;
    }
    
    public boolean hasRightChild(int data){
        return indexOfRightChild(data)<size;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getMinimumElement(){
        int min = deleteRoot();
        return min;
    }
    
    
}
