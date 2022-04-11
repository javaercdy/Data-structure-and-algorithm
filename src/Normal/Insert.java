package Normal;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-03-28-14:34
 */
public class Insert {

    public static void main(String[] args) {
        Person[] people = MaoPao.get();

        sort(people);
        System.out.println(Arrays.toString(people));

    }

    public static void sort(Comparable[] person){
        Comparable temp;
//        for (int i=1;i<person.length;i++){
//            for (int j=i;j>0;j--){
//                if (person[j].compareTo(person[j-1])<0){
//                    temp=person[j];
//                    person[j]=person[j-1];
//                    person[j-1]=temp;
//                }else{
//                    break;                }
//            }
//        }


        for (int i= person.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (person[j].compareTo(person[j+1])>0){
                    temp=person[j];
                    person[j]=person[j+1];
                    person[j+1]=person[j];
                }
            }
        }

        for (int i=0;i< person.length-1;i++){
            int minIndex=i;
            for (int j=i+1;j< person.length;j++){
                if (person[minIndex].compareTo(person[j])>0){
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                temp= person[i];
                person[i]=person[minIndex];
                person[minIndex]=temp;
            }
        }



        for (int i=1;i< person.length;i++){

            for (int j=i;j>0;j--){
                if (person[j].compareTo(person[j-1])<0){
                    temp=person[j];
                    person[j]=person[j-1];
                    person[j-1]=person[j];
                }else{
                    break;
                }
            }
        }


    }
}

