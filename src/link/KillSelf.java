package link;

/**
 * @author chenDY
 * @create 2022-03-29-17:14
 */
public class KillSelf {


    public static void main(String[] args) {

         Node<Integer> pre=null;

         Node<Integer> first=null;
         int count=0;

        //1.创建41个节点的链表
        for (int i=1;i<=41;i++){

            if (i==1){
                first=new Node(null,1);
                pre=first;
                continue;
            }

            Node<Integer> newNode = new Node<>(null, i);
            pre.next=newNode;
            pre=newNode;

            if (i==41){
                pre.next=first;
            }
        }

        Node temp=first;
        pre=new Node<>(temp,null);
        //
        while(temp!=temp.next){

            count++;

            if (count==3){
                System.out.print(temp.item+",");
                count=0;
                pre.next=temp.next;
                temp=temp.next;
            }else{
                pre=temp;
                temp=temp.next;
            }
        }
        System.out.println(temp.item);
    }



    private static class Node<T>{
        private Node<T> next;
        private T item;

        public Node(Node<T> next,T item){
            this.next=next;
            this.item=item;
        }

    }
}
