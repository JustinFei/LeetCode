class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<Integer>(), q2 = new LinkedList<Integer>();
        int n = senate.length();
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R') {
                q1.add(i);
            } else {
                q2.add(i);
            }
        }
        while(!q1.isEmpty() && !q2.isEmpty()){
            int ri = q1.poll(), di = q2.poll();
            if(ri < di) {
                q1.add(ri + n);
            } else {
                q2.add(di + n);
            }
        }
        return q1.size() > q2.size() ? "Radiant" : "Dire";
    }
}