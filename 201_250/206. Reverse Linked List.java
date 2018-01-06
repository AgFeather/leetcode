//Reverse a singly linked list.

//iterative method
    public ListNode reverseList(ListNode head) {
        if (head == null||head.next == null) {
			return head;
		}
        ListNode last = head;
		for (;last.next!=null ;last = last.next ) {

		}
		ListNode headTemp = head;
		ListNode lastTemp = last;
		while(headTemp!=last){
			ListNode temp = last.next;
			last.next = headTemp;
			ListNode temp2 = headTemp.next;
			headTemp.next = temp;
			headTemp = temp2;
		}
		return headTemp;
    }
    
    
    
    //recursive method
  class Solution {
    public ListNode reverseList(ListNode head){
		if (head == null||head.next == null) {
			return head;
		}
		ListNode last = head;
		for (;last.next!=null ;last = last.next ) {

		}
		recursiveReverse(head,last);
		return last;
	}
	public void recursiveReverse(ListNode head,ListNode last){
		if (head == last) {
			return;
		}
		ListNode temp = last.next;
		last.next = head;
		ListNode temp2 = head.next;
		head.next = temp;
		recursiveReverse(temp2,last);
	}
}
