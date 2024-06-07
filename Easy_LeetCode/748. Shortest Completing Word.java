class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        licensePlate = licensePlate.toLowerCase();
        String res = "";
        int min = 1000;
        
        for(int i = 0; i < licensePlate.length(); i++){
            char s = licensePlate.charAt(i);
            if(Character.isLetter(s))
                count[s - 'a']++;
        }
        
        for(String word: words){
           int[] dummy = new int[26];
            boolean flag = true;
            
            System.arraycopy(count, 0, dummy, 0, 26);
            
            for(int j = 0; j < word.length(); j++){
                char s = word.charAt(j);
                dummy[s - 'a']--;
            }
            
            for(int j = 0; j < 26; j++){
                if(dummy[j] > 0) flag = false;
            }
            
            if(flag){
                if(word.length() < min){
                    res = word;
                    min = res.length();
                } 
            }
        }
        return res;
    }
}