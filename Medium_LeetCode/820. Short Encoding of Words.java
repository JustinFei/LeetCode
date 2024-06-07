class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int res = 0;
        for (String s: set) {
            res += (s.length() + 1);
        }
        return res;
    }
}
//----------------------------------------------
class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> next = new HashMap<>();
        int depth;
    }
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new  ArrayList<TrieNode>();
        for (String w : new HashSet<>(Arrays.asList(words))) {
            TrieNode cur = root;
            for (int i = w.length() - 1; i >= 0; --i) {
                char j = w.charAt(i);
                if (!cur.next.containsKey(j)) cur.next.put(j, new TrieNode());
                cur = cur.next.get(j);
            }
            cur.depth = w.length() + 1;
            leaves.add(cur);
        }
        int res = 0;
        for (TrieNode leaf : leaves) if (leaf.next.isEmpty()) res += leaf.depth;
        return res;
    }
}