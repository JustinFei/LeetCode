class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int[] postFix = new int[n];
        postFix[n - 1] = shifts[n - 1] % 26;
        for (int i = n - 2; i >= 0; i--) {
            postFix[i] = (shifts[i] + postFix[i + 1]) % 26;
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            arr[i] = (char)((s.charAt(i) - 'a' + postFix[i]) % 26 + 'a');
        }

        return new String(arr);
    }
}

// ----------------------------------------

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder(s);
        long shift=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            ans.setCharAt(i, (char)((s.charAt(i) - 'a' + (shift + shifts[i]) % 26) % 26 + 'a'));
            shift += shifts[i];
        }
        return ans.toString();
    }
}