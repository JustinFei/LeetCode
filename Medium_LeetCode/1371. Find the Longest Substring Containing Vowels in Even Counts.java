/* 
	cur records the count of "aeiou"
	cur & 1 = the records of a % 2
	cur & 2 = the records of e % 2
	cur & 4 = the records of i % 2
	cur & 8 = the records of o % 2
	cur & 16 = the records of u % 2
	seen note the index of first occurrence of cur

	Note that we don't really need the exact count number,
	we only need to know if it's odd or even.

	If it's one of aeiou,
	'aeiou'.find(c) can find the index of vowel,
	cur ^= 1 << 'aeiou'.find(c) will toggle the count of vowel.

	But for no vowel characters,
	'aeiou'.find(c) will return -1,
	that's reason that we do 1 << ('aeiou'.find(c) + 1) >> 1.

	Hope this explain enough.

	Complexity
	Time O(N), Space O(1) 
*/

class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0 , cur = 0, n = s.length();
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1 ) >> 1;
            seen.putIfAbsent(cur, i);
            res = Math.max(res, i - seen.get(cur));
        }
        return res;
    }
}