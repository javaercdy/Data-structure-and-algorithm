package BinaryTree;

import java.util.Arrays;

/**
 * @author chenDY
 * @create 2022-03-31-14:08
 */
public class HeapTest {

    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(7);

        heap.insert("1");
        heap.insert("2");
        heap.insert("3");
        heap.insert("4");
        heap.insert("5");
        heap.insert("6");
        heap.insert("7");

        System.out.print(Arrays.toString(heap.item));

        System.out.println(heap.size());
        heap.delete(1);
        System.out.println(heap.size());
        System.out.println(Arrays.toString(heap.item));
    }
}
