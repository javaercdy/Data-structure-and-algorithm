package Algorithm;

/**
 * @author chenDY
 * @create 2022-04-05-14:12
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[]arr={1,2,3,5,7,9,100};
        int i = binarySearch(arr, 1);
        System.out.println("index="+i);
        int j = binarySearch(arr, 101);
        System.out.println("index="+j);
    }

    /**
     * 二分算法非递归
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;

        while (left<=right){
            int mid = (left+right)/2;
            if (arr[mid]>target){
                right=mid-1;
            }else if (arr[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
