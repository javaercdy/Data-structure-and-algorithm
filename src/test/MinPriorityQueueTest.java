package test;

import BinaryTree.MinPriorityQueue;

/**
 * @author chenDY
 * @create 2022-03-31-19:34
 */
public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<String> minPriorityQueue = new MinPriorityQueue<String>(10);
        minPriorityQueue.put("D");
        minPriorityQueue.put("B");
        minPriorityQueue.put("F");
        minPriorityQueue.put("A");
        minPriorityQueue.put("E");
        minPriorityQueue.put("C");

        while(!minPriorityQueue.isEmpty()){
            System.out.print(minPriorityQueue.delMin()+",");
        }
    }
}
