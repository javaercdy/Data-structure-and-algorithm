package Advance;

import Normal.MaoPao;
import Normal.Person;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-03-28-15:58
 */
public class Shell {

    public static void main(String[] args) {
        Person[] people = MaoPao.get();

        sort(people);

        System.out.println(Arrays.toString(people));


    }

    public static void sort(Comparable[] person){
        Comparable temp;

        int h=1;
        while(h< person.length/2){
            h=h*2+1;
        }
        while(h>=1){

            for (int i=h;i< person.length;i++){
                for (int j=i;j>=h;j-=h){
                    if (person[j].compareTo(person[j-h])<0){
                        temp=person[j];
                        person[j]=person[j-h];
                        person[j-h]=temp;
                    }else {
                        break;
                    }
                }
            }
            h=h/2;
        }
    }
}
