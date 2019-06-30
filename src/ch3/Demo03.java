package ch3;

/**
 * @anthor wangyul
 * @date 2019/6/26 23:58
 * 判断一个链表是否有环
 */
public class Demo03 {

    public static void main(String[] args) {
        ch3.ListNode a1 = new ch3.ListNode(1);
        ch3.ListNode a2 = new ch3.ListNode(2);
        ch3.ListNode a3 = new ch3.ListNode(3);
        ch3.ListNode a4 = new ch3.ListNode(4);
        ch3.ListNode a5 = new ch3.ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a3;
        Boolean a = Demo03.testReversePairedList(a1);
        System.out.println(a);
    }

    public static Boolean testReversePairedList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow ,fast;
        slow = fast = head;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return false;
            }
        }
        return true;
    }
}