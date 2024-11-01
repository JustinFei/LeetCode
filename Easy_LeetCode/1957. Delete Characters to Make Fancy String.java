class Solution {
    public String makeFancyString(String s) {
        if (s == null || s.length() <= 2) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) 
            if (s.charAt(i) != s.charAt(i - 2) || s.charAt(i) != s.charAt(i - 1))
                sb.append(s.charAt(i));


        return sb.toString();
    }
}

// -----------------------

class Solution {
    public String makeFancyString(String s) {
        return IntStream.range(0, s.length())
            .filter(i -> i < 2 || (s.charAt(i) != s.charAt(i - 1) || s.charAt(i) != s.charAt(i - 2)))
            .mapToObj(i -> String.valueOf(s.charAt(i)))
            .collect(Collectors.joining());
    }
}