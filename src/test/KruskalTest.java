package test;

import Algorithm.Kruskal;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-04-09-15:31
 */
public class KruskalTest {

    private static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int matrix[][]={
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        Kruskal kruskal = new Kruskal(vertex, matrix);
        Kruskal.Edge[] minEdge = kruskal.getMinEdge();
        System.out.println("最小生成树为");
        for (Kruskal.Edge edge : minEdge) {
            System.out.println(edge);
        }
    }
}
