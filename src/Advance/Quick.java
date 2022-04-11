package Advance;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-03-28-20:24
 */
public class Quick {

    public static void main(String[] args) {
        int[]a={9,6,8,5,3,5,2,7,1,4};
        sort(a,0, a.length-1);
        System.out.println(Arrays.toString(a));
    }


    static void sort(int[] a,int left,int right){
        if (left>=right){
            return;
        }
        int begin=left;
        int end=right;

        int pivot=a[begin];

        while(begin<end){

            while(begin<end&&a[end]>=pivot){
                end--;
            }
            if (begin==end){
                a[begin]=pivot;
                break;
            }
            if (a[end]<pivot){
                a[begin++]=a[end];
            }
            while(begin<end&&a[begin]<=pivot){
                begin++;
            }
            if (begin==end){
                a[begin]=pivot;
                break;
            }
            if (a[begin]>pivot){
                a[end--]=a[begin];
            }
        }
            sort(a,left,begin-1);
            sort(a,begin+1,right);
    }
}

//
//    static void sort2(int[] a,int left,int right){
//        if (left>=right){
//            return;
//        }
//        int begin=left;
//        int end=right;
//
//        int pivot=a[begin];
//
//        while(begin<end){
//
//            while(begin<end&&a[end]>=pivot){
//                end--;
//            }
//            if (begin==end){
//                a[begin]=pivot;
//                break;
//            }
//            if (a[end]<pivot){
//                a[begin++]=a[end];
//            }
//            while (begin<end&&a[begin]<=pivot){
//                begin++;
//            }
//            if (begin==end){
//                a[begin]=pivot;
//                break;
//            }
//            if (a[begin]>pivot){
//                a[end--]=a[begin];
//            }
//        }
//
//        sort2(a,left,begin-1);
//        sort2(a,begin+1,right);
//
//    }
//}
