package oaphone.walmart.video0724;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 7/24/19 16:01
 */

import systemdesign.trie.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 *    A
 *   B  C
 * D  E
 */
public class TraversalImpl implements Traverse {
    Node treeNode = new Node();
    Trie result;
    Map<String, Node> map = new HashMap();

    //if referenceNode is ‘E’ then return node ‘B’
    @Override
    public Node getParent(Node referenceNode) {
        if(referenceNode == null) {
            return null;
        }
        Map map = traveralNode(treeNode);

        /*if(referenceNode == ){

        }
        */
        return null;
    }

    private Map<String, Node> traveralNode(Node root){
        map.put(root.value, root);
        traveralNode(root.leftChild);
        traveralNode(root.rightChild);
        return map;
    }

    //if referenceNode is ‘E’ then print “EBA”
    @Override
    public void printPath(Node referenceNode) {
        if (map.containsKey(referenceNode.value)) {
            //result = traveralNode(treeNode);
            //traveralNode();
        }
        System.out.println(result);

    }
}
