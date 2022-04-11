package Algorithm;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-04-11-9:22
 */
public class Floyd {

    //权值
    private int[][] dis;

    //前驱节点 forward[1][2]  1到2的最短路径的前驱节点
    private int[][] forward;

    //端点数组
    private  char[] vertex;


    public Floyd(char[] vertex, int[][] weight){
        this.vertex=vertex;
        this.dis=weight;
        this.forward=new int[vertex.length][vertex.length];
        //前驱节点初始设为自己
        for (int i=0;i< forward.length;i++){
            for (int j=0;j< forward.length;j++){
                forward[i][j]=i;
            }
        }
    }


    public void floyd(){
        for (int k=0;k< vertex.length;k++){
            for (int i=0;i< vertex.length;i++){
                for (int j=0;j< vertex.length;j++){
                    if (dis[i][k]+dis[k][j]<dis[i][j]){
                        dis[i][j]=dis[i][k]+dis[k][j];
                        forward[i][j]=forward[k][j];
                    }
                }
            }
        }

        System.out.println("各端点最短路径:");
        for (int i=0;i< vertex.length;i++){
            System.out.println(vertex[i]+"到各端点的最短路径为: "+ Arrays.toString(dis[i]));
        }

        System.out.println("前驱端点为:");
        for (int j=0;j< vertex.length;j++){
            for (int k=0;k< vertex.length;k++){
                System.out.print(vertex[forward[j][k]]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        final  int N=65535;
        int matrix[][]={
                {0,5,7,N,N,N,2},
                {5,0,N,9,N,N,3},
                {7,N,0,N,8,N,N},
                {N,9,N,0,N,4,N},
                {N,N,8,N,0,5,4},
                {N,N,N,4,5,0,6},
                {2,3,N,N,4,6,0}
        };
        Floyd floyd = new Floyd(vertex, matrix);
        floyd.floyd();
    }

}
