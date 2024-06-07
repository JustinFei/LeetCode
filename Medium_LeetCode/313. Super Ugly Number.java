class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int p: primes) {
            q.offer(new int[]{p, p , 0});
        }
        int[] nums = new int[n];
        int i = 1;
        nums[0] = 1;
        
        int cur, prime, index;
        int[] entry;
        
        while (i < n) {
            entry = q.poll();
            cur = entry[0]; 
            prime = entry[1];
            index = entry[2];
            
            if (cur != nums[i - 1]) {
                nums[i] = cur;
                i++;
            }
            
            q.offer(new int[]{prime * nums[index + 1], prime, index + 1});
        }
        return nums[n - 1];
    }
}

//----------------
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        int [] cur = new int[primes.length];
        
        for(int i = 1; i < n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                if (primes[j] * res[cur[j]] == res[i-1]) {
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j]*res[cur[j]]);
            }
        }
        return res[n-1];
    }
}