package ch3;

/**
 * @anthor wangyul
 * 反转单链表 1-2-3-4-5   5-4-3-2-1
 */
public class Demo01 {

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
        // ListNode node = new Solution().reverseList(a1);
        ListNode node = Demo01.textReverseList(a1);

        while (node != null){
            System.out.print(node.val);
            node = node.next;
            System.out.print(node != null ? "->" : "");
        }
    }

    /**
     * 三个指针
     * */
    public static ListNode reverseList(ListNode head){
        if(head == null) {
            return null;
        }
        // 当前节点a
        ListNode a = head;
        // 下个节点b
        ListNode b = head.next;
        // 下下个节点c
        ListNode temp;

        // 头结点的指针先清空
        head.next = null;

        // 有可能链表只有一个节点，所以需要看b是否为null
        while(b != null){
            // 记录C节点
            temp = b.next;
            // a->b 反向
            b.next = a;

            if(temp == null){
                break;
            }
            // 移动到下一个节点
            a = b;
            b = temp;
        }
        return b == null ? a : b;
    }

    public static ListNode textReverseList(ListNode head){

        // 当前节点
        ListNode a =head;
        // 下一个节点
        ListNode b = head.next;
        // 下下个节点
        ListNode temp;

        // 头结点的指针先清空
        head.next = null;

        while(b !=null){
            temp = b.next;

            b.next = a;

            a = b;

            b = temp;
        }
        return b == null ? a : b;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

 class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = null;

        while (head != null){

            curr = new ListNode(head.val);
            curr.next = prev;
            prev = curr;
            head = head.next;
        }
        return prev;
    }

     public  ListNode reverseList2(ListNode head){
         if(head == null){
             return null;
         }
         //记录上个节点
         ListNode previous = null;
         //头插法的新头节点
         ListNode newHead = null;    
         while(head != null){
             //新建头结点
             newHead = new ListNode(head.val);
             newHead.next = previous;
             previous = newHead;
             //下一个节点
             head = head.next;   
         }
         return newHead;
     }
}