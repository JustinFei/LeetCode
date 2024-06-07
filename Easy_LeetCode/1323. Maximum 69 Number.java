class Solution {
    public int maximum69Number (int num) {
        return Integer.parseInt(("" + num).replaceFirst("6", "9"));
    }
}

//--------------------------------------------
class Solution {
    public int maximum69Number (int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}