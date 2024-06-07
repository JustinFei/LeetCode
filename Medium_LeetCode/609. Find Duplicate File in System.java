public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) return res;
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] str = path.split("\\s+");
            for (int i = 1; i < str.length; i++) {
                int index = str[i].indexOf("(");
                String content = str[i].substring(index);
                String filename = str[0] + "/" + str[i].substring(0, index);
                Set<String> set = map.getOrDefault(content, new HashSet<String>());
                set.add(filename);
                map.put(content, set);
            }
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(new ArrayList<String>(entry.getValue()));
            }
        }
        return res;
    }
}