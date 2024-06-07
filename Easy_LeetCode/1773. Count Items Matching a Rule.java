class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int cur = 0;
        switch(ruleKey) {
            case "type":
                cur = 0;
                break;
            case "color":
                cur = 1;
                break;
             case "name":
                cur = 2;
                break;   
        }
        for (List<String> item: items) {
            if (item.get(cur).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}