public String longestCommonPrefix(String[] strs) {
    if (strs == null) return null;
    if (strs.length == 0) return "";

    Arrays.sort(strs);
    char[] first = strs[0].toCharArray();
    char[] last  = strs[strs.length - 1].toCharArray();

    int i = 0, len = Math.min(first.length, last.length);
    while (i < len && first[i] == last[i]) i++;
    return strs[0].substring(0, i);
}
//-----------------------------------
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}