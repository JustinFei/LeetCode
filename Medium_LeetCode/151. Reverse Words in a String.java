public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        char[] array = s.toCharArray();
        swap(array, 0, array.length - 1);
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) start = i;
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) swap(array, start, i);
        }
        return new String(array);
    }
    
    private void swap(char[] array, int a, int b) {
        while (a < b) {
            char tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
            a++;
            b--;
        }
    }
}