package BinaryTree;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author chenDY
 * @create 2022-04-02-13:59
 */
public class AVLTree<V extends Comparable> {

    private Node root;
    private int n;

    public Node getRoot(){
        return root;
    }

    public AVLTree(){
        root=new Node(null,null,null);
        this.n=0;
    }

    /**
     * 插入
     * @param value
     */
    public void put(V value){
        Node node = new Node(null, null, value);
        n++;
        if (root.value==null){
            root.value=value;
            return;
        }
        root.add(node);
    }



    public class Node{
        private Node left;
        private Node right;
        private V value;

        public Node(Node left,Node right,V value){
            this.left=left;
            this.right=right;
            this.value=value;
        }

        public int getHeight(){
            int i= Math.max(this.left==null?0:this.left.getHeight(),this.right==null?0:this.right.getHeight())+1;
            return i;
        }

        public int getLeftHeight(){
            if (this.left==null){
                return 0;
            }
          return  this.left.getHeight();
        }
        public int getRightHeight(){
            if (this.right==null){
                return 0;
            }
            return  this.right.getHeight();
        }
        //左转
        private void leftRotation(){
            //1.创建新的节点
            Node newNode=new Node(null,null,this.value);
            //2.新节点的左子节点
            newNode.left=this.left;
            //3.新节点的右子节点
            newNode.right=this.right.left;
            //4.this.value
            this.value=this.right.value;
            //5.this.right
            this.right=this.right.right;
            //this.left
            this.left=newNode;
        }

        //右转
        private void rightRotation(){
            //1.创建新的节点
            Node newNode = new Node(null, null, this.value);
            newNode.right=this.right;
            newNode.left=this.left.right;
            this.value=this.left.value;;
            this.left=this.left.left;
            this.right=newNode;
        }



        public void add(Node node){
            if (node==null||node.value.compareTo(this.value)==0){
                return;
            }
            if (this.value.compareTo(node.value)>0){

                if (this.left==null){
                    this.left=node;
                }else{
                    this.left.add(node);
                }
            }else{
                if (this.right==null){
                    this.right=node;
                }else{
                    this.right.add(node);
                }
            }


            //每插入一个节点,都判断一次要不要平衡
            //左转
            if (this.getRightHeight()-this.getLeftHeight()>1){
                //如果是RL型,先以右子节点为中心,向右旋转,再以当前节点向左旋转
                if (this.right.getRightHeight()<this.right.getLeftHeight()){
                    //右子节点右转
                    this.right.rightRotation();
                    //当前节点左转
                    this.leftRotation();
                }else{
                    //RR型,只需要当前节点左转
                    this.leftRotation();
                }
                return;
            }
            //右转
            if (this.getLeftHeight()-this.getRightHeight()>1){
                //如果是LR型,先以左子节点为中心,向左旋转,再以当前节点向右旋转
                if (this.left.getLeftHeight()<this.left.getRightHeight()){
                    //LR型,左子节点,左转
                    this.left.leftRotation();
                    this.rightRotation();
                }else{
                    //LL型,当前节点右转
                    this.rightRotation();
                }
            }
        }
    }
}
