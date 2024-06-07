public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        char[] array = new char[n * 2];
        generateParenthesis(array, 0, n, n, res);
        return res;
    }
    
    private void generateParenthesis(char[] array, int index, int left, int right, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));
            return;
        }
        if (left > 0) {
            array[index] = '(';
            generateParenthesis(array, index + 1, left - 1, right, res);
        }
        
        if (right > left) {
            array[index] = ')';
            generateParenthesis(array, index + 1, left, right - 1, res);
        }
    }
}