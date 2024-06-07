class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] arr = s.split("\\s+");
            int times = Integer.parseInt(arr[0]);
            String[] domains = arr[1].split("\\.");
            String s1 = domains[domains.length - 1];
            map.put(s1, map.getOrDefault(s1, 0) + times);
            String s2 = domains[domains.length - 2] + "." + s1;
            map.put(s2, map.getOrDefault(s2, 0) + times);
            if (domains.length == 3) {
                String s3 = domains[domains.length - 3] + "." + s2;
                map.put(s3, map.getOrDefault(s3, 0) + times);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        }
        return res;
    }
}

------------------------------------------------------------
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }
}