class Solution {
    public int strStr(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }

        int length = haystack.length() - needle.length();
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}