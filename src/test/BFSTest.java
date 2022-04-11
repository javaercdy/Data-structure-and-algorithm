package test;

import graph.BreadthFirstSearch;
import graph.Graph;

/**
 * @author chenDY
 * @create 2022-04-05-12:34
 */
public class BFSTest {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(4,5);
        graph.addEdge(4,3);
        graph.addEdge(5,6);
        graph.addEdge(8,9);

        BreadthFirstSearch bts = new BreadthFirstSearch(graph, 0);

        System.out.println("与0相连通的个数"+bts.getCount());
        System.out.println("是否连通"+bts.isConnected(6));
        System.out.println("是否连通"+bts.isConnected(8));

    }
}
