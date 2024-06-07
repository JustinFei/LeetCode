/* 
    Solution 1: Brute Force (TLE)
    Brute force all combinations, will TLE.
    Time O(N^4)
    Space O(1)
*/

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int a = 0, b = 0;
                    for (int c = i; c < j; c++) a ^= arr[c];
                    for (int c = j; c <= k; c ++) b ^= arr[c];
                    if (a == b) {
                        res++;
                    } 
                }
            }
        }

        return res;
    }
}

/* 
    Solution 2: Brute Force with prefix
    Calculate all prefix of bitwise-xor operation.
    prefix[0] = 0
    prefix[i] = A[0]^A[1]^...^A[i - 1]
    So that for each (i, j),
    we can get A[i]^A[i+1]^...^A[j] by prefix[j+1]^prefix[i]
    in O(1) time

    Time O(N^3)
    Space O(1)
    Space O(1) if changing the input
*/

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = 0;
            for (int j = i + 1; j < n; j++) {
                a ^= arr[j - 1];
                int b = 0;
                for (int k = j; k < n; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        res++;
                    } 
                }
            }
        }

        return res;
    }
}

/*
    Solution 3: Prefix XOR
    a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
    b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]

    Assume a == b, thus
    a ^ a = b ^ a, thus
    0 = b ^ a, thus
    arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] ^ arr[j] ^ arr[j + 1] ^ ... ^ arr[k] = 0
    prefix[k+1] = prefix[i]

    We only need to find out how many pair (i, k) of prefix value are equal.
    So we can calculate the prefix array first,
    then brute force count the pair.

    Because we once we determine the pair (i,k),
    j can be any number that i < j <= k,
    so we need to plus k - i - 1 to the result res.

    Time O(N^2)
    Space O(N)
    Space O(1) if changing the input
*/


class Solution {
    public int countTriplets(int[] A) {
        int n = A.length + 1, res = 0, prefix[] = new int[n];
        for (int i = 1; i < n; ++i)
            prefix[i] = A[i - 1] ^ prefix[i - 1];
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (prefix[i] == prefix[j])
                    res += j - i - 1;
        return res;
    }
}

/*
    Solution 4: Prefix XOR, O(N)
    The problem now is, given an array,
    find out the sum of index distance with A[i] = A[j].
    Let me know if there is a duplicate problem on LeetCode,
    so I can attach a link to help explain.

    Basicly, for the same value in the array,
    we need to count the frequncy and the total value at the same time.

    Time O(N)
    Space O(N)
*/

class Solution {
    public int countTriplets(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        // System.arraycopy(arr, 0, prefix, 1, arr.length);
        int size = prefix.length;
        int count = 0;

        // Performing XOR operation on the array elements
        // for (int i = 1; i < size; ++i) prefix[i] ^= prefix[i - 1];
        for (int i = 1; i < size; i++) prefix[i] = arr[i - 1] ^ prefix[i - 1];

        // Maps to store counts and totals of XOR values encountered
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating contribution of current element to the result
            count +=
            countMap.getOrDefault(prefix[i], 0) * (i - 1) -
            totalMap.getOrDefault(prefix[i], 0);

            // Updating total count of current XOR value
            totalMap.put(
                prefix[i],
                totalMap.getOrDefault(prefix[i], 0) + i
            );
            countMap.put(
                prefix[i],
                countMap.getOrDefault(prefix[i], 0) + 1
            );
        }

        return count;
    }
}

/*
    Solution 5: Prefix XOR, One Pass
    Time O(N) for one pass
    Space O(N)
*/

class Solution {
    public int countTriplets(int[] A) {
        int n = A.length, res = 0, prefix = 0, c, t;
        Map<Integer, Integer> count = new HashMap<>(), total = new HashMap<>();
        count.put(0, 1);
        for (int i = 0; i < n; ++i) {
            prefix ^= A[i];
            c = count.getOrDefault(prefix, 0);
            t = total.getOrDefault(prefix, 0);
            res += c * i - t;
            count.put(prefix, c + 1);
            total.put(prefix, t + i + 1);
        }
        return res;
    }
}