class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length(); i++)
            if (s.charAt(i) == 'B' && !stack.isEmpty() && stack.peek() == 'A' ||
            s.charAt(i) == 'D' && !stack.isEmpty() && stack.peek() == 'C') stack.pop();
            else stack.push(s.charAt(i));

        return stack.size();
    }
}

// ---------------------------------------

class Solution {
    public int minLength(String s) {
        char[] arr = new char[s.length()];
        int index = -1;
        for(char ch : s.toCharArray())
            if(index >= 0 &&((ch == 'B' && arr[index] == 'A') || (ch == 'D' && arr[index] == 'C'))) index--;
            else arr[++index] = ch;
        return index + 1;
    }
}