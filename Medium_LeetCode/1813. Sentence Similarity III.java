class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] array1 = sentence1.split(" "), array2 = sentence2.split(" ");
        int i = 0, n1 = array1.length, n2 = array2.length;
        if (n1 > n2) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        while (i < n1 && array1[i].equals(array2[i])) i++;
        while (i < n1 && array1[i].equals(array2[n2 - n1 + i])) i++;
        return i == n1;
    }
}

// -------------------------------------------------------

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> dq1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> dq2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())) {
            dq1.poll();
            dq2.poll();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }
}