package BinaryTree;

import sun.misc.Queue;

/**
 * @author chenDY
 * @create 2022-03-30-21:54
 */
public class FoldPaper {

    public static void main(String[] args) throws InterruptedException {
        FoldPaper foldPaper = new FoldPaper();
        foldPaper.foldPaper(2);
    }


    public void foldPaper(int n) throws InterruptedException {
        //创建树
        Node root=createTree(n);

        //中序遍历,打印树
        printTree(root);
    }


    private class Node{
        String item;
        Node left;
        Node right;

        public Node(Node left,Node right,String item){
            this.left=left;
            this.right=right;
            this.item=item;
        }
    }

    private Node createTree(int n) throws InterruptedException {
        Node root=null;

        for (int i=0;i<n;i++){
            if (i==0){
                root=new Node(null,null,"down");
            }else {
                Queue<Node> nodeQueue = new Queue<>();
                nodeQueue.enqueue(root);
                while(!nodeQueue.isEmpty()){
                    Node node = nodeQueue.dequeue();

                    if (node.left!=null){
                        nodeQueue.enqueue(node.left);
                    }

                    if (node.right!=null){
                        nodeQueue.enqueue(node.right);
                    }

                    if (node.left==null&&node.right==null){
                        node.left=new Node(null,null,"down");
                        node.right=new Node(null,null,"up");
                    }
                }
            }
        }
        return root;
    }


        private void printTree(Node node){
            if (node==null){
                return;
            }
           printTree(node.left);
            System.out.print(node.item+",");
            printTree(node.right);

        }
}
