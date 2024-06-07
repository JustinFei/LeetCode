class Solution {
    public String reversePrefix(String word, char ch) {
        if (word == null || word.length() < 2) return word;
        char[] a = word.toCharArray();
        int s = 0, e = 0;
        for (; e < a.length; e++)
            if (a[e] == ch) 
                break;
        if (e == a.length) return word;
        char tmp;
        while (s < e) {
            tmp = a[s];
            a[s] = a[e];
            a[e] = tmp;
            s++;
            e--;
        }

        return new String(a);
    }
}