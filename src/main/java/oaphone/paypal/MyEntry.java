package oaphone.paypal;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 8/4/19 02:43
 */
public class MyEntry<K, V> {
    private final K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
