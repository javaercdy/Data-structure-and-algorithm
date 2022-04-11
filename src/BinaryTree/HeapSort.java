package BinaryTree;

import java.beans.beancontext.BeanContextChild;

/**
 * @author chenDY
 * @create 2022-03-31-14:57
 */
public class HeapSort {


    public  void sort(Comparable[] source){
        //构建普通堆
        Comparable[] heap =new Comparable[source.length+1];
        createHeap(source,heap);

        //对堆排序
        //N:最后一个下标
        int N= heap.length-1;
        while(N>1){
            //1.交换节点
            each(heap,1, N);
            //2.减少N
            N--;
            //3.下沉顶端节点
            sink(heap,1,N);
        }
        //拷贝到source中
        System.arraycopy(heap,1,source,0,source.length);
    }


    public  void  createHeap(Comparable[] source,Comparable[] heap){

        System.arraycopy(source,0,heap,1,source.length);
        for (int i=(heap.length)/2;i>0;i--){
            sink(heap,i,heap.length-1);
        }

    }

    private void sink(Comparable[] heap,int target,int range){
        while(target*2<=range){
            int max;

            if (target*2+1<=range){
                if (less(heap,target*2,target*2+1)){
                    max=target*2+1;
                }else{
                    max=target*2;
                }
            }else{
                max=target*2;
            }
            if (!less(heap,target,max)){
                break;
            }
            each(heap,target,max);
            target=max;
        }
    }


    private boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<=0;
    }

    private void each(Comparable[] heap,int i,int j){
        Comparable temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }




}
