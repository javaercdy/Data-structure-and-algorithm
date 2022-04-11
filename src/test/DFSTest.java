package test;

import graph.DepthFirstSearch;
import graph.Graph;

/**
 * @author chenDY
 * @create 2022-04-05-12:26
 */
public class DFSTest {
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


        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        System.out.println("与0相连通的端点数:"+depthFirstSearch.getCount());
        System.out.println("是否与0连同:"+depthFirstSearch.isConnected(8));
        System.out.println("是否与0连同:"+depthFirstSearch.isConnected(6));

    }
}
