class Solution {
/ *
    Time Complexity: O({M}^2 \times N)O(M 
2
 ×N), where MM is the length of each word and NN is the total number of words in the input word list.
    Space Complexity: O({M}^2 \times N)O(M 
2
 ×N).
  */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> set = new HashSet<>();
        
        int res = 1;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size > 0) {
                String cur = q.poll();
                for (String s: wordList) {
                    if (!set.contains(s) && helper(cur, s)) {
                        if (s.equals(endWord)) {
                            return res;
                        } else {
                            q.offer(s);
                            set.add(s);
                        }
                    }
                }
                size--;
            }
        }
        return 0;
    }
    
    private boolean helper(String s, String r) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != r.charAt(i)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }
}