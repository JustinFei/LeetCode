public class Solution {
    public int integerReplacement(int n) {
       if(n==Integer.MAX_VALUE) return 32;
       int count = 0;
       while(n > 1){
          if(n % 2 == 0) n >>>= 1;
           else{
              if((n + 1) % 4 == 0 && (n - 1 != 2)) n++;
              else n--;
            }
            count++;
        }
    return count;
    }
}