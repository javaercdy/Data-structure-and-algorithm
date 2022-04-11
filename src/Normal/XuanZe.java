package Normal;

import Normal.MaoPao;
import Normal.Person;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-03-27-21:43
 */
public class XuanZe {

    public static void main(String[] args) {
        MaoPao maoPao = new MaoPao();
        Person[] people = maoPao.get();
        sort(people);
        System.out.println(Arrays.toString(people));

    }


    public static void sort(Comparable[] person){
        Comparable temp;
        for (int i=0;i<person.length-1;i++){
            int minIndex=i;
            for (int j=i+1;j< person.length;j++){
                if (person[minIndex].compareTo(person[j])>0){
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                temp=person[i];
                person[i]=person[minIndex];
                person[minIndex]=temp;
            }
        }

    }
}
