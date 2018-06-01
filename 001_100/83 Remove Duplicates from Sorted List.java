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
思路很清晰，使用一个set记录所有曾经出现的node.val。遍历list，如果set.add失败表示节点值
重复，进行删除节点操作
 */
 public ListNode deleteDuplicates(ListNode head){
     if(head == null)
         return null;
     ListNode temp = head;
     ListNode pre = head;
     Map<Integer, Integer> map = new HashMap<>();
     Set<Integer> set = new HashSet<>();
     set.add(temp.val);
     temp = temp.next;
     while(temp!=null){
         if (set.add(temp.val)) {
             temp = temp.next;
             pre = pre.next;
         }else{
             pre.next = temp.next;
             temp = temp.next;
         }
     }
     return head;
 }


 /*
 没有认真审题，给定的事已经排序好的list，所以只需要比较相邻的两个节点的值是否相等即可
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
