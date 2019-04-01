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
    public ListNode swapPairs(ListNode head) {
    	ListNode pro = new ListNode(0);
    	if (head == null | head.next == null) {
			return head;
		}
    	pro.next = head.next;
    	ListNode tail = new  ListNode(0);
    	tail.next = head;
    	while (true) {
			ListNode l_head = tail.next;
			ListNode l_second = l_head.next;
			l_head.next = l_second.next;
			l_second.next = l_head;
			tail.next = l_second;
			tail = l_head;
			if (tail == null || tail.next == null || tail.next.next == null) {
				break;
			}
		}
        return pro.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1= new ListNode(10);
		ListNode l2= new ListNode(1);
		ListNode l3= new ListNode(2);
		ListNode l4= new ListNode(3);
		ListNode l5= new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode new_Node = new ListNode().swapPairs(l1);
		while (new_Node != null) {
			System.out.println(new_Node.val);
			new_Node = new_Node.next;
		}
	}

}
