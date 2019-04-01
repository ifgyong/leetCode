package leetCodeJava;

public class ListNode {
	
	 int val;
     ListNode next;
     ListNode(int x) { val = x; }
	 
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode newNode = new ListNode();
         ListNode top = newNode;
         	
         while (l1 != null || l2 != null) {
			int x = l1 != null? l1.val:0;
			int y = l2 != null? l2.val:0;
			newNode.val += x+y;
			l1= l1 != null? l1.next:null;
			l2 = l2 != null? l2.next:null;
			
			ListNode sub = new ListNode(newNode.val/10);
			newNode.val = newNode.val % 10;
			
			
			if (l1 == null && l2 == null) {
				if (sub.val == 0) {
					newNode.next = null;
				} else {
					newNode.next = sub;
					newNode = sub;
				}
			} else {
				newNode.next = sub;
				newNode = sub;
			}
		}
	return top;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
