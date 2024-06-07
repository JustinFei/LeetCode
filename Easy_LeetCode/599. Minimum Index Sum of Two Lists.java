public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        int min = Integer.MAX_VALUE;
        List<String> res = new LinkedList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index != null && i + index <= min) {
                if (i + index < min) {
                    res = new LinkedList<>();
                    min = i + index;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}