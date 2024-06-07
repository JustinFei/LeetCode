public class Solution {
    public int pivotInteger(int n) {
        int leftValue = 1;
        int rightValue = n;
        int sumLeft = leftValue;
        int sumRight = rightValue;

        if (n == 1) return n;

        // Iterate until the pointers meet
        while (leftValue < rightValue) {
            // Adjust sums and pointers based on comparison
            if (sumLeft < sumRight) {
                sumLeft += ++leftValue;
            } else {
                sumRight += --rightValue;
            }

            // Check for pivot condition
            if (sumLeft == sumRight && leftValue + 1 == rightValue - 1) {
                return leftValue + 1;
            }
        }

        return -1; // Return -1 if no pivot is found
    }
}

// --------------------------
/*
    1 + 2... + x = x + (x + 1)... + n
    (1 + 2... + x) * 2 = 1 + 2 + ... + n + x
    x * (x + 1) = n (n + 1) / 2 + x
    x^2 + x = n (n + 1) / 2 + x
    x^2 = n (n + 1) / 2
    x = n (n + 1) / 2
*/
public class Solution {
    public int pivotInteger(int n) {
        double x = Math.sqrt(n * (n + 1) / 2);
        return x % 1 == 0 ? (int)x : -1;
    }
}