package BinaryTree;

/**
 * @author chenDY
 * @create 2022-03-31-21:16
 */
public class IndexMinPriorityQueue<T extends Comparable> {
    T[] items;
    int[] pq;
    int[] qp;
    //元素数量
    int N;

    public IndexMinPriorityQueue(int capital){
        items= (T[]) new Comparable[capital+1];
        pq= new int[capital + 1];
        qp=new int[capital+1];
        for (int i=0;i<capital+1;i++){
            qp[i]=-1;
        }
        this.N=0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    private void each(int i,int j){
        int temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;

        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }

    public boolean containKey(int i){
        return qp[i]!=-1;
    }

    public void put(int i,T item){
        if (containKey(i)){
            return;
        }

        items[++N]=item;

        pq[N]=i;
        qp[i]=N;

        swim(N);
    }

    private void swim(int i){
        while(i>1){
            if (!less(i,i/2)){
                break;
            }
            each(i,i/2);
            i=i/2;
        }
    }

    /**
     * 删除最小值,返回最小索引
     * @return
     */
    public int delMinIndex(){
        int minIndex = pq[1];

        //交换
        each(1,N);
        //删除qp
        qp[pq[N]]=-1;
        //pq
        pq[N]=-1;
        //删除item
        items[minIndex]=null;
        //减1
        N--;
        sink(1);
        return minIndex;
    }

    public T delByIndex(int i){

        //找出堆中位置
        int index = qp[i];

        T temp = items[index];

        each(index,N);
        qp[pq[N]]=-1;
        pq[N]=-1;

        items[index]=null;
        N--;
        sink(index);
        swim(index);
        return temp;
    }

    public void sink(int i){
        while(i*2<=N){
            int min=2*i;
            if (i*2+1<=N){
                if (!less(2*i,2*i+1)){
                    min=2*i+1;
                }
            }
            if (less(i,min)){
                break;
            }
            each(i,min);
            i=min;
        }
    }

    public  void  changeItem(int i,T t){

        //修改items
        items[i]=t;

        //找到堆中的位置
        int index = qp[i];

        sink(index);
        swim(index);
    }

}
