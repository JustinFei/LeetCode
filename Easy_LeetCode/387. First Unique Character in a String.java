public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}

//-----------mine-----------
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() <= 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c: array) {
            Integer i = map.get(c);
            if(i == null) {
                map.put(c, 1);
            } else {
                map.put(c, i + 1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]).equals(1)) return i;
        }
        return -1;
    }
}