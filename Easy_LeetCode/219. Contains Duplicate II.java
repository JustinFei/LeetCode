public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashSet<Integer> hs = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
        if(i > k) {
            hs.remove(nums[i-k-1]);
        }
        if(!hs.add(nums[i])) return true;
    }
    return false;
}
----------------------------------------------------------------
public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < nums.length; ++i){
        if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
        map.put(nums[i], i);
    }
    return false;
}