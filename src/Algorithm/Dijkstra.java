package Algorithm;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-04-09-19:30
 */
public class Dijkstra {


    public static void main(String[] args) {

        char[] vert={'A','B','C','D','E','F','G'};
        final int N=65536;
        int[][] matrix=new int[][]{
                {N,5,7,N,N,N,2},
                {5,N,N,9,N,N,3},
                {7,N,N,N,8,N,N},
                {N,9,N,N,N,4,N},
                {N,N,8,N,N,5,4},
                {N,N,N,4,5,N,6},
                {2,3,N,N,4,6,N},
        };
        Graph graph = new Graph(vert, matrix);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph,2);
    }


    public void dijkstra(Graph graph,int index){
       VisitedVertex vertex = graph.initVisVertex(index);
       graph.updateVisitedVertex(index);
       for (int i=0;i<vertex.getAlready_arr().length-1;i++){
           int minDisIndex = vertex.getMinDisIndex();
           graph.updateVisitedVertex(minDisIndex);
       }

       System.out.println("起点为: "+index+" 到各点的最小路径情况");
       System.out.println("顶点记录数组:");
       for (int i : vertex.getAlready_arr()) {
           System.out.print(i+",");
       }
       System.out.println();
       System.out.println("各端点的前驱节点为:");
       for (int i=0;i<vertex.getPre_visited().length;i++){
           System.out.print(i+"("+vertex.getPre_visited()[i]+") ");
       }
       System.out.println();
       System.out.println("到各端点最短路径为:");
       for (int i=0;i<vertex.getDis().length;i++){
           System.out.print(i+"("+vertex.getDis()[i]+") ");
       }

   }
}

class Graph{
    //端点数
    private int num;
    //端点集合
    private char[] vert;
    //邻接矩阵
    private int[][] matrix;
    //记录端点数组对象
    private  VisitedVertex vv;

    final int N=65535;


    public Graph(char[] vert,int[][] matrix){
        this.num= vert.length;
        this.vert=vert;
        this.matrix=matrix;
        vv=null;
    }

    public VisitedVertex initVisVertex(int index){
        return vv=new VisitedVertex(num,index);
    }


    public void updateVisitedVertex(int index){
        for (int i=0;i<matrix[index].length;i++){
            //N代表不连同,起点到index的距离+index到i的距离<起点到i的距离,则更新最短路径
            if (matrix[index][i]!=N&&vv.getDis()[index]+matrix[index][i]<vv.getDis()[i]){
                //修改路径长度
                vv.getDis()[i]=vv.getDis()[index]+matrix[index][i];
                vv.getPre_visited()[i]=index;
            }
        }
        //更新index为已记录;
        vv.getAlready_arr()[index]=1;
    }
}

class VisitedVertex{
    //顶点是否记录数组
    private int[] already_arr;
    //下标对应的顶点的前驱节点
    private int[] pre_visited;
    //起始节点到各节点的最短距离
    private int[] dis;

    final int N=65535;


    public VisitedVertex(int num,int index){
        this.already_arr=new int[num];
        this.pre_visited=new int[num];
        this.dis=new int[num];
        //初始化距离
        Arrays.fill(dis,N);
        dis[index]=0;
    }

    //找未记录中的距离最小下标
    public int getMinDisIndex(){
        int min=65535;
        int minIndex=-1;
        for (int i=0;i<dis.length;i++){
            //在未记录的端点中,寻找最小的
            if (already_arr[i]==0&&dis[i]<min){
                min=dis[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public int[] getAlready_arr() {
        return already_arr;
    }

    public void setAlready_arr(int[] already_arr) {
        this.already_arr = already_arr;
    }

    public int[] getPre_visited() {
        return pre_visited;
    }

    public void setPre_visited(int[] pre_visited) {
        this.pre_visited = pre_visited;
    }

    public int[] getDis() {
        return dis;
    }

    public void setDis(int[] dis) {
        this.dis = dis;
    }

    public int getN() {
        return N;
    }
}
