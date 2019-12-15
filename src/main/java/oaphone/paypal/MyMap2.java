package oaphone.paypal;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 8/4/19 02:30
 */
public class MyMap2<K, V> {

    public static void main(String[] args) {
        MyMap2<String, String> myMap = new MyMap2<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        /*assertNotNull(myMap);
        assertEquals(4, myMap.size());
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney", myMap.get("Australia"));*/
    }

    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16
    private int size = 0;

    public MyMap2() {
        this(INITIAL_CAPACITY);
    }

    public MyMap2(int capacity) {
        this.buckets = new Entry[capacity];
    }

    /**
     Since different keys can be mapped to the same index, there is a chance of collision. If the number of collisions
     is very high, the worst case runtime is O(n), where n is the number of keys. However, we generally assume a good
     implementation that keeps collisions to a minimum, in which case the lookup time is O(1).
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();
        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key.hashCode();
    }

    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];
        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        // getters, equals, hashCode and toString
    }
}
