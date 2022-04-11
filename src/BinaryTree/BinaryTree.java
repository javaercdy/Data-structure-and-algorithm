package BinaryTree;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import sun.misc.Queue;


/**
 * @author chenDY
 * @create 2022-03-30-11:04
 */
public class BinaryTree<K extends Comparable<K>,V> {

    private Node root;

    private int n;


    public BinaryTree(){
        this.root=null;
        this.n=0;
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

    public void put(K key,V value){
        root =put(root,key,value);
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

    private void preErgodic(Node x,Queue keys){
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





    public static void main(String[] args) throws InterruptedException {
        BinaryTree<Integer, String> tree = new BinaryTree<Integer, String>();
//
        tree.put(10,"张三");
        tree.put(3,"李四");
        tree.put(2,"王五");
        tree.put(1,"抵达");
        tree.put(8,"萨达1");
        tree.put(9,"萨达2");
        tree.put(6,"萨达3");
        tree.put(7,"萨达4");
//        //前序遍历 10,3,2,1,8,7,9
//        Queue queue = tree.keyQueuePre();
//        System.out.print("前序遍历:");
//        while (!queue.isEmpty()){
//            System.out.print(queue.dequeue()+".");
//        }

        //中序遍历: 1,2,3,6,7,8,9,10
//        Queue queue = tree.keyQueueMid();
//        System.out.print("中序遍历:");
//        while (!queue.isEmpty()){
//            System.out.print(queue.dequeue()+".");
//        }
        //后序遍历 :1,2,7,6,9,8,3,10
//        Queue keys = tree.keyQueueAfter();
//        System.out.println("后序遍历:");
//        while(!keys.isEmpty()){
//            System.out.print(keys.dequeue()+",");
//        }

//        //层序遍历 :103281697
//        Queue keys = tree.keyQueueLayer();
//        System.out.println("层序遍历:");
//        while(!keys.isEmpty()){
//            System.out.print(keys.dequeue()+",");
//        }
        //获取最大深度
        int maxDepth = tree.getMaxDepth();
        System.out.println(maxDepth);


//
//        System.out.println(tree.get(3));
//        System.out.println(tree.get(7));
//        tree.delete(3);
//        System.out.println(tree.get(3));
//        System.out.println(tree.get(7));


//        System.out.println(tree.get(8));
//
//        Integer minKey = tree.getMinKey();
//        System.out.println(minKey);
//        System.out.println(tree.getMaxKey());
    }

}
