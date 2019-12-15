package oaphone.walmart;

/**
 * This class implement a LinkedList
 *
 * @author Jeff
 * @version V1.0
 * @date 7/23/19 16:23
 */
public class ImpelementLinkedList {

    class LinkedNode {
        int value;
        LinkedNode prev;
        public LinkedNode(int val){
            this.value = val;
        }

        public int getValue() {
            return value;
        }
    }

    LinkedNode head = null;

    void add(LinkedNode e){
        LinkedNode newNode = new LinkedNode(e.getValue());
        if(head == null) {
            head = new LinkedNode(newNode.getValue());
        }
        head.prev = newNode;
    }

    void remove(LinkedNode e) throws Exception {
        if(e == null) {
            throw new Exception("input element is null");
        }

        if(head != null) {
            LinkedNode cur = head;
            while(cur.getValue() != e.getValue()) {
                cur = cur.prev;
            }
            if(cur.getValue() == e.getValue()) {
                LinkedNode temp = cur.prev;
                //cur.prev = node.next;
                //node.prev = temp;
            }
        }
    }

}
