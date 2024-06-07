class Solution {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }
        
        char[] arr = S.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (!Character.isLetter(arr[l])) {
                l++;
            } else if (!Character.isLetter(arr[r])) {
                r--;
            } else {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(arr);
    }
}