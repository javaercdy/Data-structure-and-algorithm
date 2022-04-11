package test;

import BinaryTree.MaxPriorityQueue;

/**
 * @author chenDY
 * @create 2022-03-31-18:55
 */
public class MaxPriorityQueueTest {

    public static void main(String[] args) {
        MaxPriorityQueue<String> maxPriorityQueue = new MaxPriorityQueue<String>(10);

        maxPriorityQueue.put("F");
        maxPriorityQueue.put("B");
        maxPriorityQueue.put("D");
        maxPriorityQueue.put("E");
        maxPriorityQueue.put("C");
        maxPriorityQueue.put("G");
        maxPriorityQueue.put("A");
        while(!maxPriorityQueue.isEmpty()){
            System.out.print(maxPriorityQueue.delMax()+",");
        }

    }
}
