
// O(n) ----------------------
class Solution {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }
}

// O(2^n) -----------------------

class Solution {
    public int subsetXORSum(int[] nums) {
        return XORSum(nums, 0, 0);
    }

    private int XORSum(int[] nums, int index, int currentXOR) {
        // Return currentXOR when all elements in nums are already considered
        if (index == nums.length) return currentXOR;

        // Calculate sum of subset xor with current element
        int withElement = XORSum(nums, index + 1, currentXOR ^ nums[index]);

        // Calculate sum of subset xor without current element
        int withoutElement = XORSum(nums, index + 1, currentXOR);

        // Return sum of xor totals
        return withElement + withoutElement;
    }
}

// O(2^n * n)------------------------------------

class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // Generate all of the subsets
        generateSubsets(nums, 0, new ArrayList<>(), subsets);

        // Compute the XOR total for each subset and add to the result
        int result = 0;
        for (List<Integer> subset : subsets) {
            int subsetXORTotal = 0;
            for (int num : subset) {
                subsetXORTotal ^= num;
            }
            result += subsetXORTotal;
        }
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
        // Base case: index reached end of nums
        // Add the current subset to subsets
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        // Generate subsets with nums[i]
        subset.add(nums[index]);
        generateSubsets(nums, index + 1, subset, subsets);
        subset.remove(subset.size() - 1);

        // Generate subsets without nums[i]
        generateSubsets(nums, index + 1, subset, subsets);
    }
}

