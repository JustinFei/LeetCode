class Solution {
    public String largestTimeFromDigits(int[] A) {
        LinkedList<String> q = new LinkedList<>();
        q.add("");
        for (int n : A)
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                for (int i = 0; i <= s.length(); i++)
                    q.add(s.substring(0, i) + n + s.substring(i));
            }
        String largest = "";
        for (String s : q) {
            s = s.substring(0, 2) + ":" + s.substring(2);
            if (s.charAt(3) < '6' && s.compareTo("24:00") < 0 && s.compareTo(largest) > 0)
                largest = s;
        }
        return largest;
    }
}