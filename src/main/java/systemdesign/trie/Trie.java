package systemdesign.trie;

// 08/29/2018

public class Trie {

    public static void main(String[] args) {
        // call method name: ["Trie","insert","search","search","startsWith","insert","search"]
        // method parameter: [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
        String[] str = {"insert","search","search","insert","search","startswith"};
        Trie[] children = new Trie[100];
        Trie trie = new Trie(children, 1, false);
        for (String s : str) {
            trie.insert(s);
            System.out.println(trie.search(s));
            System.out.println(trie.startsWith(s));
        }
    }

    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
        TrieNode(char c){
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie(Trie[] children, int num, boolean isEnd) {
        root = new TrieNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = ch[i] - 'a';
            if (node.children[pos] == null) {
                node.children[pos] = new TrieNode(ch[i]);
            }
            node = node.children[pos];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = ch[i] - 'a';
            if (node.children[pos] == null) {
                return false;
            }
            node = node.children[pos];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] ch = prefix.toCharArray();
        for (int i = 0; i < prefix.length(); i++) {
            int pos = ch[i] - 'a';
            if (node.children[pos] == null) {
                return false;
            }
            node = node.children[pos];
        }
        return true;
    }
}