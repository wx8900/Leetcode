package oaphone.jpmorgan;

/**
 * @Description LeetCode 61. Rotate List
 * @Author Jeff
 * @Date 2019/3/26 18:13
 * @Version V1.0
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {
    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        // 测试ListNode的写法，要学会
        ListNode dummy = new ListNode(1);
        dummy.next = new ListNode(2);
        ListNode head = dummy.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);

        System.out.println(rotateList.rotateRight(dummy, 2));
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++) {
            //Get the total length
            fast = fast.next;
            System.out.println("fast : " + fast.val);
        }

        for (int j = i - n % i; j > 0; j--) {
            //Get the i-n%i th node
            slow = slow.next;
            System.out.println("slow : " + slow.val);
        }
        //Do the rotation
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}