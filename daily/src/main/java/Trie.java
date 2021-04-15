class Trie {
    int p = 0;
    int position = 1;
    int trie[][];
    boolean ends[];
    /** Initialize your data structure here. */
    public Trie() {
        trie = new int[100000][26];
        ends = new boolean[100000];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        p = 0;
        for (int i = 0; i < word.length(); i++) {
            int n = word.charAt(i) - 'a';
            if (trie[p][n] == 0) {
                trie[p][n] = position++;

            }
            p = trie[p][n];
        }
        ends[p]=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        p = 0;
        for (int i = 0; i < word.length(); i++) {
            if (trie[p][word.charAt(i)-'a']==0){
                return false;
            }
            p = trie[p][word.charAt(i)-'a'];
        }
        return ends[p];
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (trie[p][prefix.charAt(i)-'a']==0){
                return false;
            }
            p = trie[p][prefix.charAt(i)-'a'];
        }
        return true;
    }
}