package Algorithm;

/**
 * @author chenDY
 * @create 2022-04-05-14:42
 */
public class DivideAndComqutor {

    public static void main(String[] args) {
        divideAndC(3,'A','B','C');
    }

    /**
     * 汉落塔--分治算法
     * @param num
     * @param a
     * @param b
     * @param c
     */
    private static void divideAndC(int num,char a,char b,char c){
        if (num==1){
            System.out.println("第1个圆盘从 "+a+" -> "+c);
        }else{
            divideAndC(num-1,a,c,b);
            System.out.println("第"+num+"个圆盘从 "+a+" -> "+c);
            divideAndC(num-1,b,a,c);
        }

    }
}
