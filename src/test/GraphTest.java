package test;

import graph.Graph;
import link.Queue;

/**
 * @author chenDY
 * @create 2022-04-05-12:16
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(4,5);

        System.out.println("边的数量"+graph.getE());
        System.out.println("端点的数量"+graph.getN());

        Queue<Integer> adj = graph.adj(0);

        for (Integer w:adj){
            System.out.println(w);
        }

    }
}
