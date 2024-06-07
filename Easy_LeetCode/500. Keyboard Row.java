public class Solution {
    public String[] findWords(String[] words) {
        String[] array = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for(char c: array[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> list = new LinkedList<>();
        for(String s: words) {
            if (s.equals("")) continue;
            int index = map.get(s.toUpperCase().charAt(0));
            for (char c: s.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1) list.add(s);
        }
        return list.toArray(new String[0]);
    }
}