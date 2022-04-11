package Normal;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-03-27-20:50
 */
public class MaoPao {

    public  static Person[] get(){
        Person person1 = new Person();
        person1.setName("rangsan");
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        person2.setName("aba");
        person3.setName("cdy");
        person4.setName("wangwu");
        Person person5 = new Person();
        person5.setName("ranyi");

        Person[] pelist=new Person[5];
        pelist[0]=person1;
        pelist[1]=person2;
        pelist[2]=person3;
        pelist[3]=person4;
        pelist[4]=person5;
        return pelist;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 7, 3, 5, 4, 6};
//        sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
        Person person1 = new Person();
        person1.setName("zhangsan");
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        person2.setName("aba");
        person3.setName("cdy");
        person4.setName("wangwu");
        Person person5 = new Person();
        person5.setName("ranyi");

        Person[] pelist=new Person[5];
        pelist[0]=person1;
        pelist[1]=person2;
        pelist[2]=person3;
        pelist[3]=person4;
        pelist[4]=person5;

        sort(pelist);
        System.out.println(Arrays.toString(pelist));
    }

    public static void sort(Comparable[] comparables){
        Comparable temp;
        for (int i=comparables.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (comparables[j].compareTo(comparables[j+1])>0){
                    temp=comparables[j];
                    comparables[j]=comparables[j+1];
                    comparables[j+1]=temp;
                }
            }
        }
    }

    public static void sort(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
