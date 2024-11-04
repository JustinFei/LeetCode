class Solution {

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder("");

        // pos tracks our position in the input string
        int pos = 0;

        // Process until we reach end of string
        while (pos < word.length()) {
            int count = 0;

            char cur = word.charAt(pos);

            // Count consecutive occurrences (maximum 9)
            while (
                pos < word.length() &&
                count < 9 &&
                word.charAt(pos) == cur
            ) {
                count++;
                pos++;
            }

            // Append count followed by character to result
            sb.append(count).append(cur);
        }

        return sb.toString();
    }
}