class Solution {
    private String generate(int a, int b, int c, String aa, String bb, String cc) {
        // this condition determines: a >= b
        if (a < b)  return generate(b, a, c, bb, aa, cc);

        // this condition determines: b >= c
        if (b < c)  return generate(a, c, b, aa, cc, bb);

         // with the two conditions above, we can confirm: a >= b >= c

        // Case 1
        if (b == 0) return aa.repeat(Math.min(2, a));

        // Case 2
        int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0; 
        return aa.repeat(use_a) + bb.repeat(use_b) +
            generate(a - use_a, b - use_b, c, aa, bb, cc);    
    }

    public String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }
}

// --------------------------------------

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        
        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;
        
        for(int i = 0; i < totalLength; i++) {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0))  {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;  
            } else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0) || (continuousC == 2 && b > 0)) {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0) || (continuousA == 2 && c > 0)) {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;  
            }
        }
        return sb.toString();
    }
}

// ----------------------------------

class Solution {

    static class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);

        if (a > 0) heap.add(new Pair('a', a));
        if (b > 0) heap.add(new Pair('b', b));
        if (c > 0) heap.add(new Pair('c', c));
        
        StringBuilder result = new StringBuilder();
        Pair lastUsed = null;

        while (!heap.isEmpty()) {
            Pair current = heap.poll();
            if (lastUsed == null || current.ch != lastUsed.ch) {
                int addCount = Math.min(2, current.count);
                for (int i = 0; i < addCount; i++) {
                    result.append(current.ch);
                }
                current.count -= addCount;
                if (current.count > 0) {
                    heap.add(current);
                }
                lastUsed = current;
            } else {
                if (heap.isEmpty()) break;
                Pair second = heap.poll();
                result.append(second.ch);
                second.count -= 1;
                if (second.count > 0) {
                    heap.add(second);
                }
                
                heap.add(current);
                lastUsed = second;
            }
        }
        
        return result.toString();
    }
}