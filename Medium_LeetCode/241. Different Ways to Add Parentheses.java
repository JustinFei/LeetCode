class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                for (int a: diffWaysToCompute(input.substring(0, i))) {
                     for (int b: diffWaysToCompute(input.substring(i + 1))) {
                         rst.add(c == '+' ? a + b : (c == '-' ? a - b : a * b));
                     }
                }
            }
        }
        if (rst.size() == 0) {
            rst.add(Integer.parseInt(input));
        }
        map.put(input, rst);
        return rst;
    }
}