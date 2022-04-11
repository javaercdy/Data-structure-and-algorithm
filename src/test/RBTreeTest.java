package test;

import BinaryTree.RBTree;
import utils.TreeOperation;

import java.util.Scanner;

/**
 * @author chenDY
 * @create 2022-04-04-14:58
 */
public class RBTreeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RBTree<String, Object> rbTree = new RBTree<String, Object>();

        while(true){
            System.out.println("请输入key: ");
            String key = scanner.next();
            System.out.println();
            rbTree.insert(key,null);

            TreeOperation.show(rbTree.getRoot());
        }
//        RBTree<String, Integer> rbTree = new RBTree<String, Integer>();
//        rbTree.insert("1",1);
//        rbTree.insert("2",1);
//        rbTree.insert("3",1);
//        rbTree.insert("4",1);
//        rbTree.insert("5",1);
//        rbTree.insert("6",1);
//        rbTree.insert("7",1);
//        TreeOperation.show(rbTree.getRoot());
    }
}
