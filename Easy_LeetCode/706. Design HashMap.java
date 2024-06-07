class MyHashMap {
    int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
         map = new int[1000001];
        Arrays.fill(map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//-----------------------------------------------------
class MyHashMap {
    final ListNode[] nodes = new ListNode[10_000];

    public void put(int key, int value){
        int i = idx(key);
        if(nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode prev = find(nodes[i], key);
        if(prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    public int get(int key){
        int i = idx(key);
        if(nodes[i] == null)
            return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key){
        int i = idx(key);
        if(nodes[i] != null){
            ListNode prev = find(nodes[i], key);
            if(prev.next != null)
                prev.next = prev.next.next;
        }
    }

    int idx(int key){return Integer.hashCode(key) % nodes.length;}

    ListNode find(ListNode bucket, int key){
        ListNode node = bucket, prev = null;
        for(; node != null && node.key != key; node = node.next)
            prev = node;
        return prev;
    }

    class ListNode{
        int key, val;
        ListNode next;

        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */