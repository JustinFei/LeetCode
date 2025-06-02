class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int res = 1;
        int up = 0, down = 0, peak = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                peak = ++up;
                down = 0;
                res += 1 + up;
            } else if (ratings[i - 1] == ratings[i])  {
                peak = up = down = 0;
                res += 1;
            } else {
                up = 0;
                down++;
                res += 1 + down + (peak >= down ? -1 : 0);
            }
        }

        return res;
    }
}
// ---------------------------------------------------

public class Solution {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
}


// ---------------------------------------------------


class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];        
        Arrays.fill(candies, 1);// Give each child 1 candy 

        for (int i = 1; i < candies.length; i++){// Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = (candies[i - 1] + 1);
            }
        }

        for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
            }
        }

        int sum = 0;        
        for (int candy : candies)  {
            sum += candy; 
        }

        return sum;
    }
}