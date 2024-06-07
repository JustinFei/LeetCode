class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> tm = new TreeMap<>();
        for (int i : hand) tm.put(i, tm.getOrDefault(i , 0) + 1);

        for (int k : tm.keySet()) {
            if (tm.get(k) > 0) {
                for (int i = groupSize - 1; i>= 0; i--) {
                    if (tm.getOrDefault(k + i, 0) < tm.get(k)) return false;
                    tm.put(k + i, tm.get(k + i) - tm.get(k));
                }
            }
        }

        return true;
    }
}

// --------------------------------------------------------------------

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
       int len = hand.length;
       boolean[] visited = new boolean[len];
       for(int i = 0;i < len;i++){
           if(visited[i]) continue;
           visited[i] = true;
           int j = i + 1;
           int count = 1;
           int num = hand[i] + 1;
           for(count = 1; j < len && count < groupSize;j++){
               if(visited[j]) continue;
               if(hand[j] > num) break;
               if(hand[j] == num ) {
                   num++;
                   visited[j] = true;
                   count++;
               }
           }
           if(count < groupSize) return false;
       }
       return true;
    }
}