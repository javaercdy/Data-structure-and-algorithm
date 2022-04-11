package graph;


import link.Queue;

/**
 * @author chenDY
 * @create 2022-04-04-21:36
 */
public class DepthFirstSearch {

    //与顶点V相连通的端点总数
    private int count;

    //是否与V连同的端点数组
    private boolean[] mark;

    public DepthFirstSearch(Graph g,int v){
        mark =new boolean[g.getN()];
        count=0;

        dfs(g,v);
    }

    /**
     * 深度优先搜索
     * @param g
     * @param v
     */
    private void dfs(Graph g,int v){
        mark[v]=true;
        count++;

        for (Integer w : g.adj(v)) {
            if (!isMark(w)){
                dfs(g,w);
            }
        }
    }


    private boolean isMark(int v){
        return mark[v];
    }


    public int getCount(){
        return count;
    }

    public boolean isConnected(int w){
        return  isMark(w);
    }

}
