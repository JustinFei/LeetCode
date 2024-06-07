public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}
// ---------------------
public class Solution {
    publib int countPrimes(int n) {
     if( n <=2) {
            return 0;
        }

        int c= 1;

        boolean isNotPrime[] = new boolean[n+1];


        for(int i=3;i*i<=n;i=i+2) {

            if(isNotPrime[i]) {

                continue;
            }

            for(int j= i*i ;j<=n;j=j+2*i) {
                isNotPrime[j] = true;
            } 

        }

        for(int i =3;i<n;i=i+2){


            if(!isNotPrime[i]) {
                c++;
            }
        }
        return c;

    }
}
---------------------------------------------
public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        for(int i = 0; i < n; i++) {
            isPrime[i] = true;
        }
        int count = 0;
        for (int i = 2; i*i < n; i++) {
            if (isPrime[i]) {
                for(int j = i*i; j < n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}