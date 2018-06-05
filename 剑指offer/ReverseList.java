/*
反转链表

输入一个链表，反转链表后，输出链表的所有元素
 */


//找到尾部节点，然后不断将链表的最前面节点加入到尾部节点的next
public ListNode ReverseList(ListNode head){
    if (head == null || head.next == null)
        return head;
    ListNode tail = head;
    while(tail.next!=null) tail = tail.next;
    tail.next = head;
    ListNode curr = head.next;
    head.next = null;
    while(curr != tail){
        ListNode temp = curr;
        curr = curr.next;
        temp.next = tail.next;
        tail.next = temp;
    }
    return tail;
}
