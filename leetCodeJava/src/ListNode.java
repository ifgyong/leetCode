/**
 * Created by Yong on 2019/10/30.
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        this.val = x;
    }
    public static ListNode listNode(int[] a){
        if (a.length > 0){

            ListNode head = new ListNode(a[0]);
            ListNode next = head;
            for (int i = 1; i <a.length ; i++) {
                next.next = new ListNode(a[i]);
                next = next.next;
            }
            return head;
        }else {
            return null;
        }
    }
}
