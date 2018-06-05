/*
输入一个链表，输出该链表中导数第k个节点
 */


//先统计链表长度，然后找到目标节点
public ListNode FindKthToTail(ListNode head,int k) {
    ListNode temp = head;
    while(temp != null){
        length++;
        temp = temp.next;
    }
    if (length < k)
        return null;
    temp = head;
    for (int i = 0; i<length-k;i++ ) {
        temp = temp.next;
    }
    return temp;
}
