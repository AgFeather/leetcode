/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */



//比较基础，直接按位合并两个链表即可
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null)
        return l1==null?l2:l1;
	ListNode res = null;
	if (l1.val > l2.val) {
		res = l2;
		l2 = l2.next;
	}
	else {
		res = l1;
		l1 = l1.next;
	}
    ListNode returnL = res;
	for(;l1 != null && l2 != null;) {
		if (l2.val > l1.val) {
			res.next = l1;
			res = res.next;
			l1 = l1.next;
		}
		else {
			res.next = l2;
			res = res.next;
			l2 = l2.next;
		}
	}
	if (l1 != null)
		res.next = l1;
	else
		res.next = l2;
	return returnL;
}
