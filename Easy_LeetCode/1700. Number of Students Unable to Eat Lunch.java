class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] map = new int[2];
        for (int s : students) map[s]++;
        int n = sandwiches.length;
        for (int i = 0; i < sandwiches.length; i++) {
            if (map[sandwiches[i]] != 0) map[sandwiches[i]]--;
            else return n - i;
        }
        return 0;
    }
}