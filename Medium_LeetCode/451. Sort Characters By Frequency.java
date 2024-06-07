public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
                        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
                
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) 
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}

// -----------------------

class Solution {
    static class Node {
        int n;
        char c;
        Node(int n, char c) {
            this.n = n;
            this.c = c;
        }
    }
    public String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<Node>(11, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.n == b.n) {
                    return 0;
                }
                return a.n < b.n ? 1 : -1;
            }
        });
        for (char c: array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
       
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.offer(new Node(entry.getValue(), entry.getKey()));
        }
        int i = 0;
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            int n = node.n;
            while (n > 0) {
                array[i++] = node.c;
                n--;
            }
        }
    
        return String.valueOf(array);
    }
}