package link;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Iterator;

/**
 * @author chenDY
 * @create 2022-03-29-20:52
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> head;

    private int N;

    public Stack(){
        this.head=new Node<T>(null,null);
        this.N=0;
    }


    //压进栈
    public void push(T item){
        Node node = new Node<>(null, item);
        Node next = head.next;
        node.next=next;
        head.next=node;
        N++;
    }

    //出栈
    public T pop(){
        Node<T> next = head.next;
        if (next==null){
            return null;
        }
        head.next=next.next;
        N--;
        return next.item;
    }

    public boolean isEmpty(){
        return N==0;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }


    private class SIterator implements Iterator<T>{
        Node n=head;

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n=n.next;
            return (T) n.item;
        }
    }

    private class Node<T>{
        private Node<T> next;
        private T item;

        public Node(Node<T> next, T item){
            this.next=next;
            this.item=item;
        }
    }


    public boolean isMarch(String s){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String target=s.charAt(i)+"";
            if ("(".equals(target)){
                stack.push(target);
            }else if (")".equals(target)){
                String pop = stack.pop();
                if (pop==null){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return  true;
        }
        return false;

    }

    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();

        strings.push("a");
        strings.push("b");
        strings.push("c");
        strings.push("d");
        strings.push("e");

        for (String string : strings) {
            System.out.print(string);
        }

        System.out.println("***************");

        Stack<String> stack = new Stack<>();
        boolean march = stack.isMarch("((我是)(对的))");
        System.out.println(march);


    }
}
