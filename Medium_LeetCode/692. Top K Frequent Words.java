class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }


        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2) {
                if (p1.getValue() == p2.getValue()) {
                    return p1.getKey().compareTo(p2.getKey());
                } 

                return -Integer.compare(p1.getValue(), p2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Pair<String, Integer>(entry.getKey(), entry.getValue()));
        }

        List<String> res = new ArrayList<>();
        while (k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }
}