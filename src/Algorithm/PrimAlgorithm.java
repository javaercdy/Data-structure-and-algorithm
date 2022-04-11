package Algorithm;

import graph.Graph;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-04-09-9:13
 */
public class PrimAlgorithm {

    public static void main(String[] args) {
        char[] data={'A','B','C','D','E','F','G'};
        int[][] weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};

        MGraph graph = new MGraph(7);
        MinTreeBuilder minTreeBuilder = new MinTreeBuilder();
        MGraph builderGraph = minTreeBuilder.createGraph(graph, data, weight);
        MGraph minTree = minTreeBuilder.creatPrimMinTree(builderGraph, 0);
        for (int[] array: minTree.weight){
            System.out.println(Arrays.toString(array));
        }

    }
}

class MinTreeBuilder {


    public MGraph createGraph(MGraph graph, char[] data, int[][] weight) {
        for (int i = 0; i < data.length; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < data.length; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
        return graph;
    }

    /**
     * 从图graph的顶点v开始寻找
     *
     * @param graph
     * @param v
     */
    public MGraph creatPrimMinTree(MGraph graph, int v) {
        //标记数组  1:已标记   -1:未标记
        int[] mark = new int[graph.vert];
        mark[v] = 1;
        //标记起点和最小权路径的终点
        int h1 = -1;
        int h2 = -1;
        MGraph minGraph = new MGraph(graph.vert);
        minGraph.data=graph.data;

        for (int i = 1; i < graph.vert; i++) {
            int minWeight = 10000;
            for (int j = 0; j < graph.vert; j++) {
                if (mark[j] == 1) {
                    for (int k = 0; k < graph.vert; k++) {
                        if (mark[k] == 0 && graph.weight[j][k] < minWeight) {
                            h1 = j;
                            h2 = k;
                            minWeight = graph.weight[j][k];
                        }
                    }
                }
            }
            mark[h1] = 1;
            mark[h2] = 1;
            minGraph.weight[h1][h2] = minWeight;
            minGraph.weight[h2][h1]=minWeight;
            System.out.println("顶点<" + graph.data[h1] + ">到顶点<" + graph.data[h2] + ">,权值为:" + minWeight);
        }
        return minGraph;
    }
}

    class MGraph {
     int vert;
     char[] data;
     int[][] weight;


    public MGraph(int n) {
        vert = n;
        data = new char[n];
        weight = new int[n][n];
    }
}
