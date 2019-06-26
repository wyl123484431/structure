package ch3;

/**
 * 单链表两两反转
 * <p>
 * 已知一个链表：a->b->c->d->e
 * 每两个元素进行反转：b->a->d->c->e
 */
public class Demo02 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode node = Demo02.testReversePairedList(a1);
        //ListNode node = a1;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            System.out.print(node != null ? "->" : "");
        }
    }

    public static ListNode reversePairedList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 当前节点A
        ListNode a = head;
        // 下个节点B
        ListNode b = head.next;
        // 下下个节点C
        ListNode temp;
        // 上一组的尾指针，在下一组反转后需要改变
        ListNode previous = null;
        ListNode newHead = b == null ? a : b;
        while (b != null) {
            // 记录C节点
            temp = b.next;
            // a->b 反向
            b.next = a;
            a.next = temp;
            if (previous != null) {
                previous.next = b;
            }
            if (temp == null) {
                break;
            }
            previous = a;
            // 移动到下一组
            a = temp;
            b = temp.next;
        }
        return newHead;
    }

    public static ListNode testReversePairedList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head.next;
        ListNode temp;
        ListNode previous = null;
        ListNode newHead = b == null ? a : b;

        while (b != null){
            temp = b.next;
            b.next = a;
            a.next =temp;
            if ( previous !=null){
                previous.next = b;

            }
            if (temp ==null){
                break;
            }

            previous = a;
            a = temp;
            b = temp.next;

        }
        return newHead;

    }
}
