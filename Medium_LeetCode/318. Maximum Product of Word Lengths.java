class Solution {
    
    public int maxProduct(String[] words) {
        
        // a bit vector represents charcter that is present in the string by
        // turning the bit on at that position
        int [] vector = new int[words.length];
        
        for(int i = 0; i < words.length; ++i){
            String word = words[i];
            for(int j = 0; j < word.length(); ++j){
                vector[i] |= (1 << (word.charAt(j) - 'a'));
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < words.length; ++i){
            for(int j = i + 1; j < words.length; ++j){
                if( (vector[i] & vector[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        
        return max;
    }
}