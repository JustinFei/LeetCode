public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}
//---------------------------------
public int strStr(String haystack, String needle) {

if(needle.length()>haystack.length()) return -1;

if(needle.length()==haystack.length()) return needle.equals(haystack) ?  0:-1;


String buf;

int len = needle.length();

for(int i=0; i<=haystack.length()-len; i++){
    buf = haystack.substring(i,i+len);
    if(buf.equals(needle)){
        return i;
    }
}

return -1;
}
//-------------------------------
class Solution {
    char[] hArray;
    char[] nArray;
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        
        hArray = haystack.toCharArray();
        nArray = needle.toCharArray();
        int res = -1;
        for (int i = 0; i <= hArray.length - nArray.length; i++) {
            if (hArray[i] == nArray[0]) {
                res = valid(i);
                if (res != -1) {
                    return res;
                }
            }
        }
        return res;
    }
    
    private int valid(int start) {
        for (int i = 0, j = start; i < nArray.length; i++, j++) {
            if (hArray[j] != nArray[i]) {
                return -1;
            }
        }
        return start;
    }
}