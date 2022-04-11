package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenDY
 * @create 2022-04-11-11:58
 */
public class HorseChess {

    //棋盘
    private int[][] chessBoard;

    //行值
    private int Y;
    //列值
    private int X;
    //当前为第几步
    private int step;

    //是否走过
    private boolean[] visited;

//    //是否全部走完
//    private boolean finish;


    public static void main(String[] args) {

        HorseChess horseChess = new HorseChess(8, 8);
        System.out.println("骑士开始周游~~~");
        long start = System.currentTimeMillis();
        horseChess.horseChess(4,2);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("周游完成,消耗时间为:"+time+"毫秒");

        System.out.println("棋盘步骤为:");
        for (int i=0;i<6;i++){
            System.out.println(Arrays.toString(horseChess.chessBoard[i]));
        }
    }

    public HorseChess(int raw,int column){
        visited=new boolean[raw*column];
        this.step=0;
        this.chessBoard=new int[raw][column];
        Y=raw;
        X=column;
    }

    //起始坐标
    public void horseChess(int raw,int column){
        Point point = new Point(column - 1, raw - 1);
        horseChess(chessBoard,point);
    }

    //回溯算法
    public void horseChess(int[][] chessBoard,Point point){
        visited[point.y*X+ point.x]=true;
        chessBoard[point.y][point.x]=++step;
        ArrayList<Point> nextList = nextList(point);
        //给他的下一步集合排序,升序,优先选最小的
        sort(nextList);
        while (!nextList.isEmpty()){
            Point next = nextList.remove(0);
            //下一步的集合中,没有被访问过的点才继续.
            //这里一定是,出队的时候再检查一遍,因为上一个next如果走到底部了,那么这个list里的剩下的全部,由原先未被标记变为已被标记.
            // 就可以不执行horseChess了.不会导致重复调用
            if (!visited[next.y*X+next.x]){
                horseChess(chessBoard,next);
            }
        }

        if (step!=X*Y){
            visited[point.y*X+ point.x]=false;
            chessBoard[point.y][point.x]=0;
            step--;
        }

    }

    public void sort(ArrayList<Point> pList){
        pList.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int s1 = nextList(o1).size();
                int s2 = nextList(o2).size();
                if (s1<s2){
                    return -1;
                }else if (s1==s2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    }

    //获取下一步的落点集合
    public ArrayList<Point> nextList(Point point){
        ArrayList<Point> pList = new ArrayList();

        if (point.x-2>=0&&point.y-1>=0){
            Point next= new Point(point.x - 2, point.y - 1);
            pList.add(next);
        }
        if (point.x-1>=0&&point.y-2>=0){
            Point next = new Point(point.x - 1, point.y - 2);
            pList.add(next);
        }
        if (point.x+1<X&&point.y-2>=0){
            Point next= new Point(point.x + 1, point.y - 2);
            pList.add(next);
        }
        if (point.x+2<X&&point.y-1>=0){
            Point next = new Point(point.x+2, point.y - 1);
            pList.add(next);
        }
        if (point.x-2>=0&&point.y+1<Y){
            Point next= new Point(point.x - 2, point.y + 1);
            pList.add(next);
        }
        if (point.x-1>=0&&point.y+2<Y){
            Point next = new Point(point.x - 1, point.y +2);
            pList.add(next);
        }
        if (point.x+1<X&&point.y+2<Y){
            Point next= new Point(point.x+1,point.y + 2);
            pList.add(next);
        }
        if (point.x+2<X&&point.y+1<Y){
            Point next = new Point(point.x + 2, point.y + 1);
            pList.add(next);
        }
        return pList;
    }

    public class Point{
        //列值下标
        private int x;
        //行值下标
        private int y;

        public  Point(int x,int y){
            this.x=x;
            this.y=y;
        }


    }


}
