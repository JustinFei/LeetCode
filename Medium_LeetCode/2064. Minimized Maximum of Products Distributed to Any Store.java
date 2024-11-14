/* 

	Binary search the products distributed to every store.
	The search range it between left = 1 and right = 100000.
	We can also use right = max(A), no big difference.

	For a products to distributed,
	we needs ceil(A[i] / mid) store,
	I use (a + mid - 1) / mid to calculate this.

	We sum up the stores we needs and check whether we have that enough stores.
	If we have enough stores,
	mid is big enough.
	then change right = mid

	If we have no enough stores,
	mid is too small,
	then change left = mid + 1

*/

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100000;
        while (left < right) {
            int mid = left + (right - left) / 2, sum = 0;
            for (int a : quantities) 
                sum += (a + mid - 1) / mid; // ceil(quantities[i] / mid)
            if (sum > n) // Which means we need more stores.
                left = mid + 1;
            else 
                right = mid;
        }
        return left;
    }
}