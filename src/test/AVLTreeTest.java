package test;

import BinaryTree.AVLTree;
import BinaryTree.AVLTreeDisabled;

/**
 * @author chenDY
 * @create 2022-04-01-16:25
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<Integer>();

        avlTree.put(8);
        avlTree.put(5);
        avlTree.put(10);
        avlTree.put(9);
        avlTree.put(11);
        avlTree.put(12);
        avlTree.put(13);


        System.out.println("树的高度为:"+avlTree.getRoot().getHeight());
        System.out.println("树的左子树的高度为:"+avlTree.getRoot().getLeftHeight());
        System.out.println("树的右子树的高度为:"+avlTree.getRoot().getRightHeight());
    }

}
