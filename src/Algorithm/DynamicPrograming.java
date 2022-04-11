package Algorithm;

import java.util.WeakHashMap;

/**
 * @author chenDY
 * @create 2022-04-05-17:00
 */
public class DynamicPrograming {

    public static void main(String[] args) {
        int[] w ={1,4,3,6,7};
        int[] v={1500,3000,2000,4000,6000};
        int bag=4;
        int i = dynamicPr(w, v, 10);
        System.out.println("最大价值为:"+i);

    }

    /**
     * 动态规划--背包问题
     * @param w
     * @param v
     * @param bag
     * @return
     */
    private static int dynamicPr(int[] w,int[] v,int bag){
        int[][] val=new int[w.length+1][bag+1];
        int[][] path=new int[w.length+1][bag+1];
        //第一列置为0
        for (int i=0;i<val.length;i++){
            val[i][0]=0;
        }
        //第一行置为0
        for (int j=0;j<val[0].length;j++){
            val[0][j]=0;
        }

        for (int i=1;i< val.length;i++){
            for (int j=1;j<val[i].length;j++){
                if (w[i-1]>j){
                    val[i][j]=val[i-1][j];
                }else{
//                    val[i][j]=Math.max(val[i-1][j],v[i-1]+val[i-1][j-w[i-1]]);
                    if (val[i-1][j]<v[i-1]+val[i-1][j-w[i-1]]){
                        val[i][j]=v[i-1]+val[i-1][j-w[i-1]];
                        //只有选择了当前物品,才将其置为1;
                        path[i][j]=1;
                    }else{
                        val[i][j]=val[i-1][j];
                    }
                }
            }
        }
        int i=path.length-1; //行的最大下标
        int j=path[0].length-1;//列的最大下标

        while(i>0&&j>0){
            if (path[i][j]==1){
                System.out.println("第"+i+"个商品放入了背包");
                j-=w[i-1];
            }
            i--;
        }
        return val[w.length][bag];
    }
}
