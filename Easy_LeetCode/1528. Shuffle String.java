class Solution {
    public String restoreString(String s, int[] indices) {
        char[] array = new char[s.length()];
        int j = 0;
        for (int i: indices) {
            array[i] = s.charAt(j++);
        }
        return new String(array);
    }
}