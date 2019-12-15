package oaphone.paypal;

/**
 * Implement hashmap functions using only Array
 * put(key, value)
 * get(key)
 * <int, String>
 *
 * @author Jeff
 * @version V1.0
 * @date 8/3/19 00:45
 */
public class MyHashMap {

    private String[][] array;
    private int initVolume = 10;

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(30, "test1");
        myHashMap.put(50, "test2");
        myHashMap.put(90, "test3");
        System.out.println(myHashMap.get(50));
    }

    /**
     * array[0][0] = 10|test1, array[0][1] = 20|test2, array[0][2] = 30|test3
     *
     * @param key
     * @param value
     */
    void put(Integer key, String value) {
        if (key == null) {
            return;
        }
        if (array == null || array.length == 0) {
            array = new String[initVolume][initVolume];
        }
        int hashCode = key.hashCode();
        int fIndex = hashCode % array.length;
        if (fIndex >= array.length) {
            array = new String[fIndex * 2][0];
        }
        int sIndex = 0;
        if (array[fIndex][sIndex] == null) {
            array[fIndex][sIndex] = key.toString() + " " + value;
        } else {
            for (String i : array[fIndex]) {
                if (i != null && i.length() > 0) {
                    sIndex++;
                } else {
                    break;
                }
            }
            array[fIndex][sIndex] = key.toString() + " " + value;
        }
    }

    /**
     * @param key
     * @return
     */
    public String get(Integer key) {
        if (key != null && array != null && array.length > 0) {
            int count = 0;
            int hashCode = key.hashCode();
            int fIndex = hashCode % array.length;
            for (String i : array[fIndex]) {
                if (i != null && i.length() > 0) {
                    String[] str = i.split(" ");
                    if (Integer.valueOf(str[0]) == key.intValue()) {
                        return str[1];
                    }
                }
                count++;
            }
            if (count == array[fIndex].length) {
                return "This array doesn't contains this key!";
            }
        }
        return "key is null, array is null or empty!";
    }

}
