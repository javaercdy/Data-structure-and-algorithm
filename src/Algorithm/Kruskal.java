package Algorithm;

/**
 * @author chenDY
 * @create 2022-04-09-14:09
 */
public class Kruskal {

    //端点的个数
    private int vert;
    //边的个数
    private int edgeNum;

    private char[] data;

    private int[][] matrix;

    private static final int INF=Integer.MAX_VALUE;

    //端点对应终点数组
    private int[] ends;


    public Kruskal(char[] vertex,int[][] matrix){
        this.vert= vertex.length;
        this.edgeNum=0;
        this.ends=new int[vertex.length];

        //复制顶点
        this.data=new char[vertex.length];
        for (int i=0;i<vertex.length;i++){
            this.data[i]=vertex[i];
        }
        //复制邻接矩阵
        this.matrix=new int[vertex.length][vertex.length];
        for (int i=0;i<vertex.length;i++){
            for (int j=0;j<vertex.length;j++){
                this.matrix[i][j]=matrix[i][j];
            }
        }

        //初始化边的个数
        for (int i=0;i<vertex.length;i++){
            for (int j=i+1;j<vertex.length;j++){
                if (matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }

    //生成最小树
    public Edge[] getMinEdge(){
        Edge[] edges = this.getEdges();
        Edge[] sortEdges = sortEdges(edges);
        Edge[] minEdges = new Edge[vert - 1];
        int index=0;
        //遍历所有排好序的边
        for (Edge edge:sortEdges){
            //边的起点和终点
            int p1 = getIndex(edge.start);
            int p2 = getIndex(edge.end);

            //获取子树的终点
            int m = getEnd(p1);
            int n = getEnd(p2);

            if (m!=n){
                ends[m]=p2;
                minEdges[index++]=edge;
            }
        }
        return minEdges;
    }



    public class Edge{
        private char start;
        private char end;

        private int weight;

        public Edge(char start,char end,int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=<" + start +
                    ">, end=<" + end +
                    ">, weight=" + weight +
                    "}";
        }
    }


    //获取边的集合
    public Edge[] getEdges(){
        Edge[] edges = new Edge[edgeNum];
        int index=0;
        //生成边数组
        for (int i=0;i<vert;i++){
            for (int j=i+1;j<vert;j++){
                if (matrix[i][j]!=INF){
                   edges[index++]=new Edge(data[i],data[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //给边按照权重从小到大排序
    public Edge[]  sortEdges(Edge[] edges){
        Edge temp;
        for (int i=edges.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (edges[j].weight>edges[j+1].weight){
                    temp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=temp;
                }
            }
        }
        return edges;
    }

    //根据字符,返回字符在数组中对应的下标
    public int getIndex(char c){
        for (int i=0;i< vert;i++){
            if (data[i]==c){
                return i;
            }
        }
        return -1;
    }

    //根据字符下标,找到终点下标
    public int getEnd(int i){
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

}

