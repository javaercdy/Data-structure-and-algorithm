package BinaryTree;

/**
 * @author chenDY
 * @create 2022-03-31-13:33
 */
public class Heap<T extends Comparable> {
    T[] item;
    int N;

    public Heap(int capital){
        item=(T[])new Comparable[capital+1];
        this.N=0;
    }

    //比较
    private boolean less(int i,int j){
       return item[i].compareTo(item[j])<=0;
    }

    //交换
    private void each(int i, int j){
        T temp=null;
        temp=item[i];
        item[i]=item[j];
        item[j]=temp;
    }


    //堆中数据大小
    public int size(){
        return N;
    }
    //插入
    public void insert(T item){
        this.item[++N]=item;
        floatUp(N);
    }

    //上浮
    private void floatUp(int n){

        while(n>1){
           if (less(n,n/2)){
                break;
           }else{
               each(n,n/2);
               n=n/2;
           }
        }
    }

    //删除 i最小为1
    public T delete(int i){
        T temp=item[i];
        item[i]=item[N];
        item[N]=null;
        N--;
        sink(i);

        return temp;
    }

    //下沉
    private void sink(int i){
        while(2*i<=N){
            int max;
            if (2*i+1<=N){
                if (less(2*i,2*i+1)){
                    max=2*i+1;
                }else {
                    max=2*i;
                }
            }else{
                max=2*i;
            }
            if (!less(i,max)){
                break;
            }
            each(i,max);
            i=max;
        }
    }
}
