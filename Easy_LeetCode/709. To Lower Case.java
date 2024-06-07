class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
// ----------------------
class Solution {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 32;
            }
        }
        return new String(arr);
    }
}
