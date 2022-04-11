package BinaryTree;

/**
 * @author chenDY
 * @create 2022-03-31-18:36
 */
public class MaxPriorityQueue<T extends Comparable> {
    T[] item;
    int N;

    public MaxPriorityQueue(int capital){
        item= (T[]) new Comparable[capital+1];
        this.N=0;
    }

    public void put(T item){
        this.item[++N]=item;

        swim(N);
    }

    private void swim(int x){
        while(x>1){
            if (less(x,x/2)){
                break;
            }else{
                each(x,x/2);
                x=x/2;
            }
        }
    }

    private boolean less(int i,int j){
        return item[i].compareTo(item[j])<=0;
    }

    private void each(int i,int j){
        T temp=item[i];
        item[i]=item[j];
        item[j]=temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public T delMax(){
        T temp=item[1];
        item[1]=item[N];
        item[N]=null;
        N--;
        sink(1);
        return temp;
    }

    public void sink(int i){
        while(2*i<=N){
            int max=2*i;
            if (2*i+1<=N){
                if (less(2*i,2*i+1)){
                    max=2*i+1;
                }
            }
            if (!less(i,max)){
                break;
            }
            each(i,max);
            i=max;
        }
    }
}
