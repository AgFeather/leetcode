/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */


 import java.util.*;
 class Node{
     public int value;
     public Node next;
     public Node previous;
     Node(int value){
         this.value = value;
         next = null;
         previous = null;
     }
 }

 public class Main{
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         Node head = new Node(0);
         Node temp = head;
         String s = in.nextLine();
         while(in.hasNext()){
             Node newNode = new Node(in.nextInt());
             temp.next = newNode;
             newNode.previous = temp;
             temp = newNode;
         }
         head = head.next;
         int k = temp.value;
         temp = temp.previous;
         temp.next = null;
         Node res = helper(head, k);
         temp = res;
         while(temp!=null){
             System.out.print(temp.value + " ");
             temp = temp.next;
         }


     }
     public static Node helper(Node head, int k){
     	if (head==null||head.next==null||k<2) return head;
         Node hhh = new Node(0);
         hhh.next = head;
         Node tail = hhh, prev = hhh,temp;
         int count;
         while(true){
             count =k;
             while(count>0&&tail!=null){
                 count--;
                 tail=tail.next;
             }
             if (tail==null) break;
             head=prev.next;
             while(prev.next!=tail){
                 temp=prev.next;
                 prev.next=temp.next;
                 temp.next=tail.next;
                 tail.next=temp;
             }
             tail=head;
             prev=head;
         }
         return hhh.next;

     }
 }
