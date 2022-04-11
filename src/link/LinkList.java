package link;

import java.util.Iterator;

/**
 * @author chenDY
 * @create 2022-03-29-14:57
 */
public class LinkList<T>  implements Iterable<T>{


    private Node head;

    private int N;



    public LinkList(){
        this.head=new Node(null,null);
        this.N=0;
    }

    public void add(T temp){
        Node pre=head;
        while(pre.next!=null){
            pre=pre.next;
        }
        Node node = new Node(null, temp);
        pre.next=node;
        N++;
    }

    @Override
    public Iterator iterator() {
        return new LinkIterator();
    }



    private class LinkIterator<T> implements Iterator<T>{
        private Node<T> n;

       public LinkIterator(){
           this.n=head;
       }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n=n.next;
            return n.temp;
        }
    }


    private class Node<T>{

//        private Node<T> pre;
        private Node<T> next;
        private  T temp;

        public Node(Node<T> next,T temp){
//            this.pre=pre;
            this.next=next;
            this.temp=temp;
        }

//        public Node<T> getPre() {
//            return pre;
//        }
//
//        public void setPre(Node<T> pre) {
//            this.pre = pre;
//        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getTemp() {
            return temp;
        }

        public void setTemp(T temp) {
            this.temp = temp;
        }
    }


    void reserve(){
        if (head.next!=null){
            reserve(head.next);
        }
    }

    Node<T> reserve(Node<T> curr){
        if (curr.next==null){
            head.next=curr;
            return curr;
        }

        Node<T> pre = reserve(curr.next);

        pre.next=curr;

        curr.next=null;

        return curr;
    }

}
