/*
	There are two possible cases
	n is odd
	let's consider n=5.
	array of numbers will be
	1 3 5 7 9
	Here, we will have the middle element as 5.
	Let's choose pair (3,7) We decrement 7 and incement 3, two times to make each one 5.
	So it takes 2 steps.
	Let's choose pair (1,9) We decrement 9 and incement 1, four times to make each one 5.
	So it takes 4 steps.
	Total steps: 2+4=6. (sum of first n/2 even numbers)
	Sum of first k EVEN numbers = k(k+1)
	ans would be n/2(n/2+1)
	n is even
	let's consider n=5.
	array of numbers will be
	1 3 5 7 9 11
	Here, we will have the middle element as (5+7)/2=6.
	Let's choose pair (5,7) We decrement 7 and incement 5, one time to make each one 6.
	So it takes 1 step.
	Let's choose pair (3,9) We decrement 9 and incement 3, three times to make each one 6.
	So it takes 3 steps.
	Let's choose pair (1,11) We decrement 11 and incement 1, five times to make each one 6.
	So it takes 5 steps.
	Total steps: 1+3+5=9. (sum of first n/2 odd numbers)
	Sum of first k ODD numbers = k*k.
	ans would be n/2*n/2
*/

class Solution {
    public int minOperations(int n) {
        return (n & 1) == 1 ? n / 2 * (n / 2 + 1) : n / 2 * n / 2 ;
    }
}