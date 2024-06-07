class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> rootSet = new HashSet<>();
        for (String root: dictionary) rootSet.add(root);

        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (String word: sentence.split("\\s+")) {
            // prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) break;
            }

            if (sb.length() > 0) sb.append(" ");
            sb.append(prefix);
        }

        return sb.toString();
    }
}

// ----------------------------------------------------

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root : dictionary) {
            trie.add(root);
        }

        StringBuilder sb = new StringBuilder();
        String find;
        for (String word : sentence.split("\\s+")) {
            if (sb.length() > 0) sb.append(" ");
            find = trie.find(word);
            
            sb.append(find != null ? find : word);
        }

        return sb.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode () {
        children = new TrieNode[26];
    }

    void add (String root) {
        TrieNode cur = this;
        for (char letter: root.toCharArray()) {
            if (cur.children[letter - 'a'] == null) {
                cur.children[letter - 'a'] = new TrieNode();
            }
            cur = cur.children[letter - 'a'];
        }
        cur.word = root;
    }

    String find (String word) {
        TrieNode cur = this;
        for (char letter : word.toCharArray()) {
            if (cur.children[letter - 'a'] == null || cur.word != null) break;
            cur = cur.children[letter - 'a'];
        }
        return cur.word;
    }
}