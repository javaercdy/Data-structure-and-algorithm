package BinaryTree;

/**
 * @author chenDY
 * @create 2022-03-31-19:00
 */
public class MinPriorityQueue<T extends Comparable> {
    T[] item;
    int N;

    public MinPriorityQueue(int capital){
        item= (T[]) new Comparable[capital+1];
        this.N=0;
    }

    public void put(T item){
        this.item[++N]=item;
        swim(N);
    }

    private void swim(int x){
        while(x>1){
            if (!less(x,x/2)){
                break;
            }
            each(x,x/2);
            x=x/2;
        }
    }

    public boolean isEmpty(){
        return N==0;
    }

    private boolean less(int i, int j) {
        return item[i].compareTo(item[j]) <= 0;
    }

    private void each(int i,int j){
        T temp=item[i];
        item[i]=item[j];
        item[j]=temp;
    }

    public T delMin(){
        T min=item[1];
        item[1]=item[N];
        item[N--]=null;
        sink(1);
        return min;
    }

    private void sink(int x){
        int min =2*x;
        while(2*x<=N){
            if (2*x+1<=N){
                if (!less(2*x,2*x+1)){
                    min=2*x+1;
                }
            }
            if (less(x,min)){
                break;
            }
            each(x,min);
            x=min;
        }
    }
}
