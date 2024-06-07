class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, new java.util.Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length()-s2.length();
            }
        });
        // Arrays.sort(words, ((a, b) -> a.length() - b.length()));
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length - 1; i++) {
            int j = i+1; // Start comparison with the next word
            while (j < words.length) {
                int index = words[j++].indexOf(words[i]);
                if (index != -1) { // If not -1, means it is a substring. Add to list and break inner loop
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}