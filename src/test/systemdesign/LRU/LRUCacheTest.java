package systemdesign.lru;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* LRUCache Tester. 
* 
* @author Jeff
* @since <pre>四月 6, 2019 $time</pre> 
* @version 1.0 
*/ 
public class LRUCacheTest { 

    @Before
    public void before() throws Exception {
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
    } 

    @After
    public void after() throws Exception { 
    
    }

    @Test
    public void testMethod() throws Exception {
        /*int result = cache.get(1);       // returns 1
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
        System.out.println("get(4) : " + result);*/
    }

    /** 
    * 
    * Method: deleteNode(Node node) 
    * 
    */ 
    @Test
    public void testDeleteNode() throws Exception { 
    //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: addToHead(Node node) 
    * 
    */ 
    @Test
    public void testAddToHead() throws Exception { 
    //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: get(int key) 
    * 
    */ 
    @Test
    public void testGet() throws Exception { 
    //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: put(int key, int value) 
    * 
    */ 
    @Test
    public void testPut() throws Exception { 
    //TODO: Test goes here... 
    } 

        
    } 
