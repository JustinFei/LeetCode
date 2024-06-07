class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> hash = new HashSet<>();
        for (int n: candies) {
            hash.add(n);
        }
        int max = candies.length / 2;
        if (hash.size() < max) max = hash.size();
        
        return max;
        
    }
}