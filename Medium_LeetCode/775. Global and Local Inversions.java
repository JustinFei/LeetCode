/*

	All local inversions are global inversions.
	If the number of global inversions is equal to the number of local inversions,
	it means that all global inversions in permutations are local inversions.
	It also means that we can not find A[i] > A[j] with i+2<=j.
	In other words, max(A[i]) < A[i+2]

	In this first solution, I traverse A and keep the current biggest number cmax.
	Then I check the condition cmax < A[i+2]

*/
class Solution {
    public boolean isIdealPermutation(int[] A) {
        int cmax = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            cmax = Math.max(cmax, A[i]);
            if (cmax > A[i + 2]) return false;
        }
        return true;
    }
}
//-----------------------------------

/*

	Basic on this idea, I tried to arrange an ideal permutation.
	Then I found that to place number i
	I could only place i at A[i-1], A[i] or A[i+1].
	So it came up to me,
	It will be easier just to check if all A[i] - i equals to -1, 0 or 1.

*/
 public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; ++i)
            if (Math.abs(A[i] - i) > 1) return false;
        return true;
    }