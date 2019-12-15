package onsite.standardcharteredbank;

/**
 * reverse singly-linked list
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/11/25 23:07
 *
 *  时间复杂度为O(N)
 *  空间复杂度为O(1)
 */
public class ReversedLinkedList {

    public static Node reverse(Node head) {
        //排除单表和单节点情况
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;   //前一个结点
        Node cur = head;    //头结点
        while (cur != null) {
            Node tmp = cur.next; //保留下一个结点
            cur.next = prev;     //指针反转
            prev = cur;   //前结点后移
            cur = tmp;    //当前结点后移
        }
        return prev;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node res = reverse(node1);

        System.out.println("链表翻转之后：");
        for (int i = 0; i < 5; i++) {
            System.out.print(res.getVal() + " ");
            res = res.next;
        }

    }

}
