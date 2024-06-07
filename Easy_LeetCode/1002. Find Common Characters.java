class Solution {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> cur = new HashMap<>();
            for (char c : A[i].toCharArray()) {
                Integer n = map.get(c);
                if (n != null && n > 0) {
                    cur.put(c, cur.getOrDefault(c, 0) + 1);
                    map.put(c, n - 1);
                } 
            }
            map = cur;
        }
         Set<Map.Entry<Character,Integer>> s = map.entrySet(); 
        List<String> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> it: s) {
            for (int i = 0; i < it.getValue(); i++) {
                list.add(it.getKey() + "");
            }
        }
        return list;
    }
}
// --------------------
class Solution {
    public List<String> commonChars(String[] A) {
        int[] last = count(A[0]);
        for (int i = 1; i < A.length; i++) {
            last = intersection(last, count(A[i]));
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    private int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    private int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) t[c - 'a']++;
        return t;
    }
}