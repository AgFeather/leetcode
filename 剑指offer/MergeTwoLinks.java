/*
合并两个排序后的链表


输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode resHead = null;
        if (list1.val < list2.val) {
            resHead = list1;
            list1 = list1.next;
        }else{
            resHead = list2;
            list2 = list2.next;
        }
        ListNode temp = resHead;
        while(list1!=null && list2!=null){
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }else{
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1!=null)
            temp.next = list1;
        else
            temp.next = list2;
        return resHead;

    }
}
