package systemdesign.lru;

public class LRUTest {

    public static void main(String[] str) {
        LRUCache cache = new LRUCache( 2);

        cache.put(1, 1);
        cache.put(2, 2);
        int result = cache.get(1);       // returns 1
        System.out.println("get(1) : " + result);
        cache.put(3, 3);    // evicts key 2
        result = cache.get(2);       // returns -1 (not found)
        System.out.println("get(2) : " + result);
        cache.put(4, 4);    // evicts key 1
        result = cache.get(1);       // returns -1 (not found)
        System.out.println("get(1) : " + result);
        result = cache.get(3);       // returns 3
        System.out.println("get(3) : " + result);
        result = cache.get(4);       // returns 4
        System.out.println("get(4) : " + result);

    }
}
