package BinaryTree;

/**
 * @author chenDY
 * @create 2022-04-04-13:59
 */
public class RBTree<K extends Comparable,V> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private Node root;
    private int N;

    public Node getRoot(){
        return root;
    }


    public RBTree(){
        root=null;
        this.N=0;
    }


    /*是否为红色*/
    private boolean isRed(Node node){
        if (node!=null){
            return node.color==RED;
        }
        return false;
    }
    /*是否为黑色*/
    private boolean isBlack(Node node){
        if (node!=null){
            return node.color==BLACK;
        }
        return  false;
    }
    /*设为红色*/
    private void setRed(Node node){
        if (node!=null){
            node.color=RED;
        }
    }
    /*设为黑色*/
    private void setBlack(Node node){
        if (node!=null){
            node.color=BLACK;
        }
    }

    /*返回父亲节点*/
    private Node parentOf(Node node){
        if (node!=null){
            return node.parent;
        }
        return null;
    }

    /*中序遍历*/
    public void midErgodic(){
        midErgodic(root);
    }

    private void midErgodic(Node node){
        if (node==null){
            return;
        }
        midErgodic(node.left);
        System.out.println(node.value);
        midErgodic(node.right);
    }

    /*左旋转*/
    private void leftRotation(Node node){
        if (node==null){
            return;
        }
        //1.获取父节点
        Node parent = parentOf(node);
        //2.获取右子节点的左子节点
        Node right = node.right;
        Node rleft = node.right.left;
        //3.旋转
        node.parent=right;

        right.left=node;

        node.right=rleft;
        if (rleft!=null){
            rleft.parent=node;
        }

        right.parent=parent;
        if (parent!=null){
            if(parent.left==node){
                parent.left=right;
            }else{
                parent.right=right;
            }
        }else{
            this.root=right;
        }
    }
    /*右旋转*/
    private void rightRotation(Node node){
        if (node==null){
            return;
        }

        Node parent = parentOf(node);
        Node left = node.left;
        Node lright = node.left.right;
        //旋转
        node.parent=left;
        left.right=node;

        node.right=lright;
        if (lright!=null){
            lright.parent=node.right;
        }

        left.parent=parent;
        if (parent!=null){
            if (parent.left==node){
                parent.left=left;
            }else{
                parent.right=left;
            }
        }else{
            this.root=left;
        }

    }

    public void insert(K key,V value){
        Node node = new Node(null, null, null, RED, key, value);

        insert(node);
    }

    private void insert(Node node){
        Node x=root;
        Node parent=null;
        while(x!=null){
            parent=x;
            int cmp = x.key.compareTo(node.key);
            if (cmp>0){
                x=x.left;
            }else if (cmp==0){
                x.value=node.value;
                return;
            }else {
                x=x.right;
            }
        }
        node.setParent(parent);

        if (parent!=null){
            int cmp = parent.key.compareTo(node.key);
            if (cmp>0){
                parent.left=node;
            }else{
                parent.right=node;
            }
        }else{
            this.root=node;
        }


        //调整
        insertFixup(node);
    }

    /*RBT平衡调整*/
    private void insertFixup(Node node){
        this.root.color=BLACK;

        Node parent = parentOf(node);
        Node gParent = parentOf(parent);
        //parent 为空,或者为黑,都不用调整
        if (parent!=null&&isRed(parent)){
            //gParent为空,只有两种可能,要么插入的节点为根节点,那么parent为空,进不来
            // 要么再第二层,那次是根节点一定为黑色,也进不来
            //一旦能进来,说明gParent必不为空
            Node uncle=null;
            if (gParent.left==parent){
                //1.插入在gParent的左子树           --->L
                uncle=gParent.right;

                //1.1叔叔节点为红节点,只变色,不旋转
                if (uncle!=null&&isRed(uncle)){
                    node.setColor(BLACK);
                    parent.setColor(BLACK);
                    uncle.setColor(BLACK);
                    gParent.setColor(RED);
                    insertFixup(gParent);
                    return;
                }else{
                 //1.2叔叔节点为null,或者为黑节点

                    //1.2.1插入的节点在parent的左子节点      L(LL型)
                    if (parent.left==node){
                        //先变色,后旋转
                        node.setColor(BLACK);
                        parent.setColor(BLACK);
                        uncle.setColor(BLACK);
                        gParent.setColor(RED);
                        rightRotation(gParent);
                        return;
                    }else{
                    //1.2.2.插入的节点在parent的右子节点     R(LR型)
                       //先旋转成LL,再变色,在旋转
                       leftRotation(parent);
                       insertFixup(parent);
                       return;
                    }
                }
            }else{
                //2.插入在gParent的右子树           --->R
                uncle=gParent.left;
                //2.1叔叔节点为红节点,只变色,不旋转
                if (uncle!=null&&isRed(uncle)){
                    node.setColor(BLACK);
                    uncle.setColor(BLACK);
                    parent.setColor(BLACK);
                    gParent.setColor(RED);
                    insertFixup(gParent);
                    return;
                }else{
                //2.2叔叔节点为null,或者为黑节点

                    //2.2.1插入的节点在parent的右子节点      R(RR型)
                    if (parent.right==node){
                        node.setColor(BLACK);
                        parent.setColor(BLACK);
                        gParent.setColor(RED);
                        leftRotation(gParent);
                        return;
                    }else {
                    //2.2.1插入的节点在parent的右子节点      L(RL型)
                        rightRotation(parent);
                        insertFixup(parent);
                        return;
                    }
                }
            }
        }
    }


    public class Node{
        private Node left;
        private Node right;
        private Node parent;
        private boolean color;
        private K key;
        private V value;

        public Node(Node left,Node right,Node parent,boolean color,K key,V value){
            this.left=left;
            this.right=right;
            this.parent=parent;
            this.color=color;
            this.key=key;
            this.value=value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
