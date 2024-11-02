class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence == null || sentence.length() == 0) return false;
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].charAt(arr[i].length() - 1) != arr[i + 1].charAt(0)) {
                return false;
            }
        }

        return arr[0].charAt(0) == arr[arr.length - 1].charAt(arr[arr.length - 1].length() - 1);
    }
}

// ------------------------------------------

public class Solution {

    public boolean isCircularSentence(String sentence) {
        for (int i = 0; i < sentence.length(); ++i) if (
            sentence.charAt(i) == ' ' &&
            sentence.charAt(i - 1) != sentence.charAt(i + 1)
        ) return false;
        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}

// -------------------------------------

class Solution {
    public boolean isCircularSentence(String s) {
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        int k = s.indexOf(" ");
        if (k == -1)
            return true;

        while (k != -1) {
            if (s.charAt(k - 1) != s.charAt(k + 1)) {
                return false;
            }

            k = s.indexOf(" ", k+1);
        }
        return true;
    }
}