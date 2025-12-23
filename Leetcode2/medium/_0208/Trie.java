package medium._0208;


class Trie {

    private Trie[] links;
    private boolean isEnd;
    private char nodeCh;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        nodeCh = '/';
        links = new Trie[26];
    }
    public Trie(char _nodeCh) {
        isEnd = false;
        nodeCh = _nodeCh;
        links = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(char ch: word.toCharArray()) {
            if(node.links[ch - 'a'] == null) {
                node.links[ch - 'a'] = new Trie(ch);
            }
            node = node.links[ch - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for(char ch: word.toCharArray()) {
            if(node.links[ch - 'a'] != null) {
                node = node.links[ch - 'a'];
                if(node.nodeCh != ch) {
                    return false;
                }
            }else {
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char ch: prefix.toCharArray()) {
            if(node.links[ch - 'a'] != null) {
                node = node.links[ch - 'a'];
                if(node.nodeCh != ch) {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
    }
}

