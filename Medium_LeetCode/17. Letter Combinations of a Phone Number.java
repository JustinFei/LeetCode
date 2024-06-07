class Solution {
    private static final String[] LETTERS = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
public List<String> letterCombinations(String digits) { 
  return (digits.length() == 0) ? Arrays.asList()
                                : permute(digits, new StringBuilder(), new ArrayList<>(), 0); 
} 
private List<String> permute(String digits, StringBuilder result, List<String> results, int i) {
  if (i == digits.length()) results.add(result.toString());
  else for (char c : LETTERS[Character.digit(digits.charAt(i), 10)].toCharArray()) {
         result.append(c);
         permute(digits, result, results, i + 1);
         result.deleteCharAt(result.length() - 1);
       }
  return results;
}
}