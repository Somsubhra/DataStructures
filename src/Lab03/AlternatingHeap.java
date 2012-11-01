package Lab03;

/**
 *
 * @author Somsubhra(201101056)
 */
public class AlternatingHeap {
    
    private int[] arr;
    private int size;
    private boolean MIN = true;
    private boolean MAX = false;
    private boolean currentLevel;
    private int maxSize;
    
    public AlternatingHeap(int maxSize){
        arr = new int[maxSize];
        this.size = 0;
        currentLevel = MIN;
        this.maxSize = maxSize;
    }
    
    public void build(int[] data){
        for(int i=0; i<data.length; i++){
            this.insert(data[i]);
        }
    }
    public void insert(int item){
        if(this.size==maxSize){
            System.out.println("Error: Overflow!");
        }else{
            
            if(arr==null){
                arr[0] = item;
                size++;
            }else{
                size++;
                arr[size-1]=item;
                changeLevel();
                if(currentLevel){
                    if(parentOf(item)>item){
                        int tmp1 = parentOf(item);
                        int tmp2 = indexOfParent(item);
                        
                        arr[indexOf(item)]=tmp1;
                        arr[tmp2] = item;
                    }
                }else{
                    if(parentOf(item)<item){
                        int tmp1 = parentOf(item);
                        int tmp2 = indexOfParent(item);
                        
                        arr[indexOf(item)]=tmp1;
                        arr[tmp2] = item;
                    }
                }
            }
        }
    }
    
    public void changeLevel(){
        for(int i=2;i<getMaxHeight();i++){
            if(this.size==Math.pow(2, i)){
                currentLevel = !(currentLevel);
            }
        }
    }
    
    private int getMaxHeight(){
        return (int) (Math.log(maxSize)/Math.log(2));
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
}
