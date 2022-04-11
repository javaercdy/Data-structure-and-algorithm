package graph;

import link.Queue;

/**
 * @author chenDY
 * @create 2022-04-04-21:36
 */
public class BreadthFirstSearch {

    //相通的端点个数
    private int count;
    private Queue<Integer> waitSearch;

    //是否搜索过
    private boolean[] mark;

    public BreadthFirstSearch(Graph g,int s){
        mark=new boolean[g.getN()];
        count=0;
        this.waitSearch=new Queue();
        bfs(g,s);
    }

    /**
     * 广度优先搜索
     * @param g
     * @param s
     */
    private void bfs(Graph g,int s){
        mark[s]=true;
        waitSearch.enqueue(s);
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            for (Integer w : g.adj(wait)) {
                if (!isMark(w)){
                    mark[w]=true;
                    waitSearch.enqueue(w);
                }
            }
            count++;
        }
    }


    private boolean isMark(int s){
        return mark[s];
    }

    public int getCount(){
        return  count;
    }

    public boolean isConnected(int w){
        return isMark(w);
    }

}
