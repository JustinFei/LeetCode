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

//--------- O(n* 2^n) O(2^n) --------------------------

class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        // Base case: if the string is empty, return an empty list
        if (expression.length() == 0) return results;

        // Base case: if the string is a single character, treat it as a number and return it
        if (expression.length() == 1) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        // If the string has only two characters and the first character is a digit, parse it as a number
        if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        // Recursive case: iterate through each character
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Skip if the current character is a digit
            if (Character.isDigit(currentChar)) continue;

            // Split the expression into left and right parts
            List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

            // Combine results from left and right parts
            for (int leftValue : leftResults) {
                for (int rightValue : rightResults) {
                    int computedResult = 0;

                    // Perform the operation based on the current character
                    switch (currentChar) {
                        case '+':
                            computedResult = leftValue + rightValue;
                            break;
                        case '-':
                            computedResult = leftValue - rightValue;
                            break;
                        case '*':
                            computedResult = leftValue * rightValue;
                            break;
                    }

                    results.add(computedResult);
                }
            }
        }

        return results;
    }
}

// ------------ O(n * 2 ^n ) O(n^2 * 2^n) ---------------

class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        // Initialize memoization array to store results of subproblems
        List<Integer>[][] memo = new ArrayList[expression.length()][expression.length()];
        // Solve for the entire expression
        return computeResults(expression, memo, 0, expression.length() - 1);
    }

    private List<Integer> computeResults(
        String expression,
        List<Integer>[][] memo,
        int start,
        int end
    ) {
        // If result is already memoized, return it
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        List<Integer> results = new ArrayList<>();

        // Base case: single digit
        if (start == end) {
            results.add(expression.charAt(start) - '0');
            return results;
        }

        // Base case: two-digit number
        if (end - start == 1 && Character.isDigit(expression.charAt(start))) {
            int tens = expression.charAt(start) - '0';
            int ones = expression.charAt(end) - '0';
            results.add(10 * tens + ones);
            return results;
        }

        // Recursive case: split the expression at each operator
        for (int i = start; i <= end; i++) {
            char currentChar = expression.charAt(i);
            if (Character.isDigit(currentChar)) {
                continue;
            }

            List<Integer> leftResults = computeResults(
                expression,
                memo,
                start,
                i - 1
            );
            List<Integer> rightResults = computeResults(
                expression,
                memo,
                i + 1,
                end
            );

            // Combine results from left and right subexpressions
            for (int leftValue : leftResults) {
                for (int rightValue : rightResults) {
                    switch (currentChar) {
                        case '+':
                            results.add(leftValue + rightValue);
                            break;
                        case '-':
                            results.add(leftValue - rightValue);
                            break;
                        case '*':
                            results.add(leftValue * rightValue);
                            break;
                    }
                }
            }
        }

        // Memoize the result for this subproblem
        memo[start][end] = results;

        return results;
    }
}

// -------------------------------------------------------------------

class Solution {
    List<Integer>[][] dp;
    public List<Integer> diffWaysToCompute(String ep) {
        dp = new ArrayList[ep.length()][ep.length()];
        return fun(ep, 0, ep.length()-1);
    }
    private List<Integer> fun(String a, int start, int end) {
        List<Integer> ret = new ArrayList<>();
        if (dp[start][end] != null)
        return dp[start][end];
        int x = operand(a, start, end);
        if (x != -1) {
            ret.add(x);
            dp[start][end] = ret;
            return ret;
        }
        for (int i = start; i <= end; i ++ ){ 
            if (!isOp(a.charAt(i)))
            continue;
            List<Integer> left = fun(a, start, i - 1);
            List<Integer> right = fun(a, i + 1, end);
            for (int j = 0 ;j < left.size(); j++) {
                for (int k = 0 ; k < right.size(); k++) {
                    if (a.charAt(i) == '*')
                    ret.add(left.get(j)*right.get(k));
                    if (a.charAt(i) == '+')
                    ret.add(left.get(j)+right.get(k));
                    if (a.charAt(i) == '-')
                    ret.add(left.get(j)-right.get(k));
                }
            }
        }
        dp[start][end] = ret;
        return ret;
    }
    private int operand(String a, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isOp(a.charAt(i)))
            return -1;
        }
        int value = 0;
        for (int i = start; i <= end; i++)
        value = value * 10 + (a.charAt(i) - '0');
        return value;
    }
    private boolean isOp(char c) {
        return c == '*' || c == '-' || c == '+';
    }
}