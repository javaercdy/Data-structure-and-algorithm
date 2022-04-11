package graph;


import link.Queue;

/**
 * @author chenDY
 * @create 2022-04-04-21:14
 */
public class Graph {

    //顶点的数量
    private final  int N;

    //邻接表
    private Queue<Integer>[] adj;

    //边的数量
    private int E;


    public Graph(int n){
        adj=new Queue[n];
        N=n;
        E=0;

        for (int i=0;i<adj.length;i++){
            adj[i]=new Queue();
        }
    }


    public int getN(){
        return N;
    }

    public int getE(){
        return E;
    }

    public void addEdge(int s,int w){
        adj[s].enqueue(w);
        adj[w].enqueue(s);
        E++;
    }

    //获取顶点v的所有临边
    public Queue<Integer> adj(int v){
        return  adj[v];
    }
}
