class Solution {
   public List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26], tmp;
        int i;
        for (String b : B) {
            tmp = counter(b);
            for (i = 0; i < 26; ++i)
                count[i] = Math.max(count[i], tmp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            tmp = counter(a);
            for (i = 0; i < 26; ++i)
                if (tmp[i] < count[i])
                    break;
            if (i == 26) res.add(a);
        }
        return res;
    }

    private int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }
}

//------------------------------
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bMax = new int[26], tmp;
        int i;
        for (String b: B) {
            tmp = Count(b);
            for (i = 0; i < 26; i++) {
                bMax[i] = Math.max(tmp[i], bMax[i]);
            }
        }
        
        List<String> res = new ArrayList<>();
        search: for (String a: A) {
            tmp = Count(a);
            for (i = 0; i < 26; i++) {
                if (tmp[i] < bMax[i]) {
                    continue search;
                }
            }
            res.add(a);
        }
        return res;
    }
    
    private int[] Count(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }
}