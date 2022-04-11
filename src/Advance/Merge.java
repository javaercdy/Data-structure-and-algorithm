package Advance;

import Normal.MaoPao;
import Normal.Person;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-03-28-17:22
 */
public class Merge {

    private static int[] assit;


    public static void main(String[] args) {
        int[] a={1,3,5,2,9,7,6,8};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    static void sort(int[] arr){
        int lo=0;
        int high=arr.length-1;
        assit=new int[arr.length];

        sort(arr,lo,high);

    }


    static void sort(int[] arr,int lo,int high){
        if (lo>=high){
            return;
        }

        int mid=lo+(high-lo)/2;

        sort(arr,lo,mid);
        sort(arr,mid+1,high);

        merge(arr,lo,mid,high);


    }

    static void merge(int[] arr,int lo,int mid,int high){
        int p1=lo;
        int p2=mid+1;

        int p3=lo;

        while (p1<=mid&&p2<=high){
            if (arr[p1]<arr[p2]){
                assit[p3++]=arr[p1++];
            }else{
                assit[p3++]=arr[p2++];
            }
        }

        while(p1<=mid){
            assit[p3++]=arr[p1++];
        }

        while(p2<=high){
            assit[p3++]=arr[p2++];
        }

        for (int i=lo;i<=high;i++){
            arr[i]=assit[i];
        }

    }

}
