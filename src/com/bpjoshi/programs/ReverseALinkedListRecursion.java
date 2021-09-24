package com.bpjoshi.programs;

public class ReverseALinkedListRecursion {
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Node node1= new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        Node node4= new Node(4);
        Node node5= new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        print(node1);
        System.out.println();
        print(reverseList(node1));
    }

    static void print(Node n){
        Node temp=n;
        while(temp!=null){
            System.out.print(temp.getVal()+" ");
            temp=temp.getNext();
        }
    }
    /*
      -> 1->2->3->4->5
      -> 5->4
      ->
     */
    static Node reverseList(Node n){
        if(n.next==null){
            return n;
        }
        Node result=reverseList(n.next);
        n.next.next=n;
        n.next=null;
        return result;
        //return reverseList(n.next);
    }
}
