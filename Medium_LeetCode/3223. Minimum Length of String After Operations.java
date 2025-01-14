class Solution {
    public int minimumLength(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        int res = 0;
        for (int a: arr) {
            // while (a >= 3) a -= a / 3 * 2;
            // if (a == 0) continue;
            // else if (a % 2 == 0) res += 2; // If frequency is even, add 2 characters
            // else a += 1; // If frequency is odd, add 1 character

            res += (a == 0 ? 0 : (a % 2 == 0 ? 2 : 1));
        }

        return res;
    }
}

// -------------------------------------------------

class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(byte c: s.getBytes()) freq[c - 'a']++;
        int res = 0;
        for(int i: freq) {
            if (i == 0) continue;
            res += (i & 1 ^ 1) << 1 | i & 1;
        }
        return res;
    }
}