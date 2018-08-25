/*
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */


/*
需要复习！！！
这道题的特殊之处在于重复节点并不保留，可以用递归的方法解决。
注意递归在链表问题中的应用
 */
public ListNode deleteDuplication(ListNode pHead){
    if (pHead == null || pHead.next == null) return pHead;
    if (pHead.val == pHead.next.val){
        ListNode pNode = pHead.next;
        while(pNode != null && pNode.val == pHead.val) {pNode = pNode.next;}
        return deleteDuplication(pNode);
    }else {
        pHead.next = deleteDuplication(pHead.next);
        return pHead;
    }
}
