package oaphone.walmart.video0724;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 7/24/19 16:01
 */
public interface Traverse {
    //if referenceNode is ‘E’ then return node ‘B’
    public Node getParent(Node referenceNode);

    //if referenceNode is ‘E’ then print “EBA”
    public void printPath(Node referenceNode);
}
