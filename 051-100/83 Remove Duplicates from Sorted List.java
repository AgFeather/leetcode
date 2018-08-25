/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */


 /*
 没有认真审题，给定的事已经排序好的list，所以只需要比较相邻的两个节点的值是否相等即可
 快慢指针
  */
 public ListNode deleteDuplicates(ListNode head){
     if (head == null)
        return null;
     ListNode curr = head.next;
     ListNode prev = head;
     while(curr != null){
        if (prev.val == curr.val)
            prev.next = curr.next;
        else
            prev = prev.next;
         curr = curr.next;
     }
     return head;
 }
