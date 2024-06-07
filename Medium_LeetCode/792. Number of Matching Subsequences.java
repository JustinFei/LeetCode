class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int res = 0;
        for (char c: s.toCharArray()) {
            map.putIfAbsent(c, new LinkedList<String>());
        }
        
        for (String word: words) {
            char c = word.charAt(0);
            if (map.containsKey(c)) {
                map.get(c).offer(word);
            }
        }
        
        for (char c: s.toCharArray()) {
            Queue<String> q = map.get(c);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (str.length() == 1) {
                    res++;
                } else {
                    if (map.containsKey(str.charAt(1))) {
                        map.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }
        
        return res;
    }
}