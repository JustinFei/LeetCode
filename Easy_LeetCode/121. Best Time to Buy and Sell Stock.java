public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        int low = prices[0];
        int ans = 0;
        for(int i =1; i<n;i++){
            if(prices[i]< low) low = prices[i];
            else if(prices[i]-low>ans) ans = prices[i] - low;
        }
        return ans;
    }
}

//---------------------
public class Solution {
	public int maxProfit(int[] prices) {
	    int maxCur = 0, maxSoFar = 0;
	    for(int i = 1; i < prices.length; i++) {
	        maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
	        maxSoFar = Math.max(maxCur, maxSoFar);
	    }
	    return maxSoFar;
	}
}
