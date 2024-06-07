class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0, zeros = 0;;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
            else zeros++;
        }

        StringBuilder sb = new StringBuilder();

        ones--;
        while (ones > 0) {
            sb.append('1');
            ones--;
        }

        while (zeros > 0) {
            sb.append('0');
            zeros--;
        }
        sb.append('1');
        return sb.toString();
    }
}