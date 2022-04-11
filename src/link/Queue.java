package link;

import java.util.Iterator;

/**
 * @author chenDY
 * @create 2022-04-04-21:46
 */
public class Queue<T> implements Iterable<Integer>{

    private Node head;

    private int N;

    public Queue(){
        this.head=new Node(null,null);
        this.N=0;
    }

    public void enqueue(T value){
        Node node = new Node(null, value);

        Node x = head;
        while (x.next != null) {
            x = x.next;
        }
        x.next = node;
        N++;
    }

    public T dequeue(){
        Node first = head.next;
        if (first==null){
            return null;
        }
        head.next=first.next;
        N--;
        return first.value;
    }

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Integer>{
        private Node temp=head;

        @Override
        public boolean hasNext() {
            return  temp.next!=null;
        }

        @Override
        public Integer next() {
            temp=temp.next;
            return (Integer) temp.value;
        }
    }


    public class Node{
        private Node next;
        private T value;


        public Node(Node next,T value){
            this.next=next;
            this.value=value;
        }
    }
    public boolean isEmpty(){
        return N==0;
    }
}
