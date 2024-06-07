public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] array = s.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }
    
    private void reverse(char[] array, int left, int right) {
        if (left >= right) return;
        while (left < right) {
            swap(array, left++, right--);
        }
    }
    
    private void swap(char[] array, int a, int b) {
        char tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}