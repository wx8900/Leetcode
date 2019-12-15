package oaphone.oracle;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/5/3 17:18
 */
public class AddTwoNumbers {

    public static ListNode l1 = new ListNode(2);
    public static ListNode l2 = new ListNode(5);

    public static void main(String[] args) {
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);
        while(l1.next != null) {
            System.out.println(l1.val + "");
            l1 = l1.next;
        }
        while(l2.next != null) {
            System.out.println(l2.val + "");
            l2 = l2.next;
        }
        ListNode res = addTwoNumbers(l1, l2);
        while(res != null) {
            System.out.println(res.val + "");
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = l1, ln2 = l2, head = null, node = null;
        int carry = 0, remainder = 0, sum = 0;
        head = node = new ListNode(0);

        while(ln1 != null || ln2 != null || carry != 0) {
            sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
            carry = sum / 10;
            remainder = sum % 10;
            node = node.next = new ListNode(remainder);
            ln1 = (ln1 != null ? ln1.next : null);
            ln2 = (ln2 != null ? ln2.next : null);
        }
        return head.next;
    }

    /*public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null) {
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                n1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                n2 = stack2.pop();
            }
            res.val = n1.val + n2.val;
            res = res.next;
        }
        return res;
    }*/

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
