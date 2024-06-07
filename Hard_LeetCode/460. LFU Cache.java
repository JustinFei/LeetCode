class LFUCache {
    // key: original key, value: frequency and original value.
    private Map<Integer, Pair<Integer, Integer>> cache;
    // key: frequency, value: All keys that have the same frequency.
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minf;
    private int capacity;

    private void insert(int key, int frequency, int value) {
        cache.put(key, new Pair<>(frequency, value));
        frequencies.computeIfAbsent(frequency, v -> new LinkedHashSet<Integer>()).add(key);
        // frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        // frequencies.get(frequency).add(key);
    }

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minf = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if (frequencyAndValue == null) {
            return -1;
        }
        int frequency = frequencyAndValue.getKey();
        Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if (minf == frequency && keys.isEmpty()) {
            minf++;
        }
        int value = frequencyAndValue.getValue();
        insert(key, frequency + 1, value);   
        return value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if (frequencyAndValue != null) {
            cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
            get(key);
            return;
        }

        if (capacity == cache.size()) {
            Set<Integer> keys = frequencies.get(minf);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
        }
        minf = 1;
        insert(key, 1, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */