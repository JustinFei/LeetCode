class Solution {
     public List<List<Integer>> findWinners(int[][] matches){
        Map<Integer, Integer> losses = new TreeMap<>();
        for(int[] m : matches){
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> r = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : losses.keySet())
            if(losses.get(player) <= 1)
                r.get(losses.get(player)).add(player);

        /*
            Replacing TreeMap with HashMap and then adding:
            Collections.sort(r.get(0));
            Collections.sort(r.get(1));
            improved runtime from 612ms to 89ms, and memory usage from 151 MB to 91 MB.
        */
        return r;
    }
}