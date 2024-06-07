class Solution {
    private int i = 0;
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[') {
                i++;
                String str = decodeString(s);
                for (int k = 0; k < num; k++) {
                    sb.append(str);
                }
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
//---------------------------------------------------------------------------
public class Solution {
    public String decodeString(String s) {
       if (s == null || s.length() == 0) return s;
        int i = 0;
        String res = "";
        Deque<Integer> cntDeque = new LinkedList<>();
        Deque<String> stringDeque = new LinkedList<>();
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))){
                int cnt = 0;
                while(Character.isDigit(s.charAt(i))) {
                    cnt = cnt * 10 + (s.charAt(i) - '0');
                    i++;
                }
                cntDeque.offerFirst(cnt);
            } else if (s.charAt(i) == '[') {
                stringDeque.offerFirst(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder tmp = new StringBuilder(stringDeque.pollFirst());
                int repeat = cntDeque.pollFirst();
                for (int j = 0; j < repeat; j++) {
                    tmp.append(res);
                }
                res = tmp.toString();
                i++;
            } else {
                res += s.charAt(i++);
            }
        }
        return res;
    }
}