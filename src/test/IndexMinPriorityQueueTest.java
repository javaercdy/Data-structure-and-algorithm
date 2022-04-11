package test;

import BinaryTree.IndexMinPriorityQueue;

/**
 * @author chenDY
 * @create 2022-03-31-22:35
 */
public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> indexMinPriorityQueue = new IndexMinPriorityQueue<String>(10);
        indexMinPriorityQueue.put(1,"D");
        indexMinPriorityQueue.put(2,"B");
        indexMinPriorityQueue.put(3,"C");
        indexMinPriorityQueue.put(4,"A");
        indexMinPriorityQueue.put(5,"F");

//        String s = indexMinPriorityQueue.delByIndex(3);
//        System.out.println(s);
//        indexMinPriorityQueue.changeItem(2,"G");

        while (!indexMinPriorityQueue.isEmpty()){
            System.out.print(indexMinPriorityQueue.delMinIndex()+",");
        }
    }
}
