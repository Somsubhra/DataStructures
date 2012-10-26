

/**
 *
 * @author Somsubhra(201101056)
 */
public class Heap {
    private int size;
    private int order;
    private int[] arr;
    
    public Heap(int order,int maxsize){
        this.size = 0;
        this.order = order;
        arr = new int[maxsize+1];
    }
    
    public void build(int[] data){
        for(int i=0; i<data.length; i++){
            this.add(data[i]);
        }
    }
    
    public void add(int item){
        
        if(size+1==arr.length){
            System.out.println("Error: Overflow!");
        }
        else{
            size++;
            arr[size] = item;
        }
    }
    
    public int getChild(int k,int data){
        int j = 1;
        while(data!=arr[j]){
            j++;
        }
        return arr[this.order*j+1-(this.order-k)];
        
    }
    
    public int getParent(int data){
        int j=1;
        while(data!=arr[j]){
            j++;
        }
        if(this.order%2==0 || this.order==3){
        return arr[(j+(int)(this.order/2))/this.order];}
        else{return arr[(j+(int)(this.order/2)+1)/this.order];}
    }
    
}
