class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        // return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
List<Integer> result = new ArrayList<>(k);
for (int i = left; i < left + k; i++) {
result.add(arr[i]);
}
return result;
    }
}
//----------------------------------------------------------------------------------------------
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
int hi = arr.length - 1;
while (hi - lo >= k) {
if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
lo++;
} else {
hi--;
}
}
List<Integer> result = new ArrayList<>(k);
for (int i = lo; i <= hi; i++) {
result.add(arr[i]);
}
return result;
    }
}