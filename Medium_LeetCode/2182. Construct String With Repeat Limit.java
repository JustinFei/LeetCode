class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> -Character.compare(a, b));

        for (char c : map.keySet()) maxHeap.offer(c);

        StringBuilder res = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = map.get(c);

            int use = Math.min(count, repeatLimit);
            while (use-- > 0) res.append(c);

            map.put(c, count - repeatLimit);

            if (map.get(c) > 0 && !maxHeap.isEmpty()) {
                char nextCh = maxHeap.poll();
                res.append(nextCh);
                map.put(nextCh, map.get(nextCh) - 1);
                if (map.get(nextCh) > 0) maxHeap.offer(nextCh);
                maxHeap.offer(c);
            }
        }

        return res.toString();
    }
}