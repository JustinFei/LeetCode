class Solution {
    public String removeDuplicateLetters(String s) {
       int n = s.length();
		int[] cnt = new int[26];
		boolean[] visited = new boolean[26]; 
		char[] res = s.toCharArray();

		for (char c: res) {
            cnt[c - 'a']++;
        }

		int end = -1;
        char sc;
		for (char c: res) {
			if (visited[c - 'a']) {
				cnt[c - 'a']--;
				continue;
			}
            
			while (end >= 0 && (sc = res[end]) >= c && cnt[sc - 'a'] > 0) {
				end--;
				visited[sc - 'a'] = false;
			}

			res[++end] = c;
			cnt[c - 'a']--;
			visited[c - 'a'] = true;
		}
		return String.valueOf(res).substring(0, end + 1);
    }
}