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
        ListNode node = new Solution().reverseList(a1);
        //ListNode node = a1;
        while (node != null){
            System.out.print(node.val);
            node = node.next;
            System.out.print(node != null ? "->" : "");
        }
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

        // 下一结点
        ListNode prev =null;
        // 新建头结点
        ListNode curr = null;
        while (head != null){
            curr = new ListNode(head.val);
            // 下一个结点为 null
            curr.next = prev;
            // 当前的结点为新建结点的前一个结点
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