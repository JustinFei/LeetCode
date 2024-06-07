class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(S.toCharArray(), 0, res);
        return res;
    }
    
    private void helper(char[] array, int index, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));
        } else {
            helper(array, index + 1, res);
            if (!Character.isDigit(array[index])) {
                array[index] = Character.isUpperCase(array[index]) ? Character.toLowerCase(array[index]) : Character.toUpperCase(array[index]);
                helper(array, index + 1, res);
                // array[index] = Character.isUpperCase(array[index]) ? Character.toLowerCase(array[index]) : Character.toUpperCase(array[index]);
            }
            
        }
    }
}