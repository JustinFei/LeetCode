public class Solution {
    public String reverseStr(String s, int k) {
        if (s== null || s.length() <= 1 || k == 1) return s;
        
        int i = 0;
        int n = s.length();
        char[] array = s.toCharArray();
        
        while (i < n) {
            if (i + k < n) {
                reverse(array, i, i + k - 1);
               
            } else {
                reverse(array, i, n - 1);
            }
            i += 2 * k;
        }
        return new String(array);
    }
    
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}