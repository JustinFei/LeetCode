// O(n) O(n)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int minValue = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt();
        int n = arr.length;
        
        if (maxValue - minValue == 0) {
            return true;
        }
        
        if ((maxValue - minValue) % (n - 1) != 0) {
            return false;
        }
        
        int diff = (maxValue - minValue) / (n - 1);
        Set<Integer> numberSet = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            if ((arr[i] - minValue) % diff != 0) {
                return false;
            }
            numberSet.add(arr[i]);
        }
        
        return numberSet.size() == n;
    }
}

// ------------------------------------------------------
// O(nlong) O(1)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        
        return true;
    }
}