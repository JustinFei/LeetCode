class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
    for (int i = 0; i < s.length(); i++){
        switch(s.charAt(i)) {
            case 'z': 
                count[0]++;
                break;
            case 'w': 
                count[2]++;
                break;
            case 'x': 
                count[6]++;
                break;
            case 's':  // 7 - 6
                count[7]++;
                break;
            case 'g': 
                count[8]++;
                break;
            case 'u': 
                count[4]++;
                break;
            case 'f':  //5-4
                count[5]++;
                break;
            case 'h': //3-8
                count[3]++;
                break;
            case 'i': //9-8-5-6
                count[9]++;
                break;
            case 'o': //1-0-2-4
                count[1]++;
                break;
        }
    }
    count[7] -= count[6];
    count[5] -= count[4];
    count[3] -= count[8];
    count[9] = count[9] - count[8] - count[5] - count[6];
    count[1] = count[1] - count[0] - count[2] - count[4];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= 9; i++){
        for (int j = 0; j < count[i]; j++){
            sb.append(i);
        }
    }
    return sb.toString();
    }
}

//------------------------------------------
class Solution {
    static String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static char[] ids = {'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i'};
    static int[] order = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
    public String originalDigits(String s) {
        int[] dCount = new int[10], lCount = new int[26];
        for (char c : s.toCharArray()) lCount[c - 'a']++;
        for (int d : order) {
            dCount[d] = lCount[ids[d] - 'a'];
            for (char c : digits[d].toCharArray()) lCount[c - 'a'] -= dCount[d];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < dCount[i]; ++j) ans.append(i);
        }
        return ans.toString();
    }
}