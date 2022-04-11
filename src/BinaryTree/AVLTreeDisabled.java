package BinaryTree;

import sun.misc.Queue;

/**
 * @author chenDY
 * @create 2022-04-01-15:26
 */
public class AVLTreeDisabled<K extends Comparable,V> {

    private Node root;

    private int n;

    public Node getRoot(){
        return root;
    }

    public int getMaxHeight(){
       return getMaxHeight(root);
    }

    private int getMaxHeight(Node x){
        if (x==null){
            return 0;
        }
        return Math.max(x.left==null?0:getMaxHeight(x.left),x.right==null?0:getMaxHeight(x.right))+1;
    }

    public int getLeftHeight(Node x){
        return getMaxHeight(x.left);
    }
    public int getRightHeight(Node x){
        return getMaxHeight(x.right);
    }


    public void put(K key,V value){
        //插入
        root =put(root,key,value);
        //左旋转
        if (getRightHeight(root)-getLeftHeight(root)>1){
            if (getRightHeight(root.right)<getLeftHeight(root.right)){
                rightRotation(root.right);
                leftRotation(root);
            }else{
                leftRotation(root);
            }
            return;
        }
        if (getLeftHeight(root)-getRightHeight(root)>1){
            if (getLeftHeight(root.left)<getRightHeight(root.left)){
                leftRotation(root.left);
                rightRotation(root);
            }else {
                rightRotation(root);
            }
        }

    }


    private void leftRotation(Node x){
        //1.创造新节点
        Node newNode = new Node(null, null, x.key, x.value);
        //2.左子节点作为新的左子节点
        newNode.left=x.left;
        //3.左子节点的右子节点作为新的右子节点
        newNode.right=x.left.right;
        //4.当前节点等于右子节点的值
        x.key=x.right.key;
        x.value=x.right.value;
        //5.当前节点的右子节点为右子节点的右子节点
        x.right=x.right.right;
        //6.当前节点的左子节点为新节点
        x.left=newNode;
    }
    private void rightRotation(Node x){
        //1.创建新节点
        Node node = new Node(null, null, x.key, x.value);
        //2.新的右子节点等于当前右子节点
        node.right=x.right;
        //3.新的左子节点等于当前左子节点的右子节点
        node.right=x.left.right;
        //4.当前的值等于左子节点的值
        x.key=x.left.key;;
        x.value=x.left.value;;
        //5.当前的左子节点等于左子节点的左子节点
        x.left=x.left.left;
        //6.当前的右子节点等于新节点
        x.right=node;
    }

    public Node put(Node x ,K key,V value){
        if (x==null){
            n++;
            return new Node(null,null,key,value);
        }
        if (key.compareTo(x.key)>0){
            x.right=put(x.right,key,value);
        }else if (key.compareTo(x.key)<0){
            x.left=put(x.left,key,value);
        }else{
            x.value=value;
        }
        return x;
    }

    public V get(K key){
        return get(root,key);
    }

    private V get(Node x,K key){
        if (x==null){
            return null;
        }
        if (key.compareTo(x.key)>0){
            return get(x.right,key);
        }else if (key.compareTo(x.key)<0){
            return get(x.left,key);
        }else{
            return x.value;
        }
    }


    public void delete(K key){
        delete(root,key);
    }

    private Node delete(Node x,K key){
        if (x==null){
            return null;
        }

        if (key.compareTo(x.key)>0){
            x.right=delete(x.right,key);
        }else if (key.compareTo(x.key)<0){
            x.left=delete(x.left,key);
        }else{

            if (x.left==null){
                return x.right;
            }
            if (x.right==null){
                return x.left;
            }
            //保存原节点最小值
            Node minNode=x.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }

            //删除原源节点
            Node pre=x.right;
            while (pre.left!=null){
                if (pre.left.left==null){
                    pre.left=pre.left.right;
                    break;
                }else{
                    pre=pre.left;
                }
            }

            //最小值节点代替key节点,完成删除
            minNode.left=x.left;
            minNode.right=x.right;
            x=minNode;
        }

        return x;
    }


    public K getMinKey(){
        if (root==null){
            return null;
        }
        Node minNode=root;
        while(minNode.left!=null){
            minNode=minNode.left;
        }
        return minNode.key;
    }


    public K getMaxKey(){
        return getMaxNode(root).key;
    }

    private Node getMaxNode(Node x){
        if (x==null){
            return null;
        }
        if (x.right!=null){
            return  getMaxNode(x.right);
        }
        return x;
    }



    //前序遍历
    public Queue keyQueuePre(){
        Queue<K> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    private void preErgodic(Node x, Queue keys){
        if (x==null){
            return ;
        }
        keys.enqueue(x.key);

        if (x.left!=null){
            preErgodic(x.left,keys);
        }

        if (x.right!=null){
            preErgodic(x.right,keys);
        }
    }

    //中序遍历
    public Queue keyQueueMid(){
        Queue<K> keys= new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    private void midErgodic(Node x,Queue keys){
        if (x==null){
            return;
        }

        if (x.left!=null){
            midErgodic(x.left,keys);
        }

        keys.enqueue(x.key);

        if (x.right!=null){
            midErgodic(x.right,keys);
        }
    }

    //后序遍历
    public Queue keyQueueAfter(){
        Queue<K> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    private void afterErgodic(Node x,Queue keys){

        if (x==null){
            return;
        }

        if (x.left!=null){
            afterErgodic(x.left,keys);
        }

        if (x.right!=null){
            afterErgodic(x.right,keys);
        }
        keys.enqueue(x.key);
    }


    public Queue keyQueueLayer() throws InterruptedException {
        Queue<K> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        if (root==null){
            return keys;
        }

        nodes.enqueue(root);

        while(!nodes.isEmpty()){

            Node node = nodes.dequeue();
            keys.enqueue(node.key);

            if (node.left!=null){
                nodes.enqueue(node.left);
            }

            if (node.right!=null){
                nodes.enqueue(node.right);
            }

        }

        return keys;
    }

    public int getMaxDepth(){
        if (root==null){
            return 0;
        }
        return   getMaxDepth(root);
    }

    private int getMaxDepth(Node x){

        int max=0;
        int maxL=0;
        int maxR=0;


        if (x.left!=null){
            maxL=getMaxDepth(x.left);
        }

        if (x.right!=null){
            maxR=getMaxDepth(x.right);
        }

        max=maxL>maxR?maxL+1:maxR+1;

        return max;
    }

    private class Node{
        private Node left;
        private Node right;
        private K key;
        private V value;


        public Node(Node left,Node right,K key,V value){
            this.left=left;
            this.right=right;
            this.key=key;
            this.value=value;
        }

    }



}
