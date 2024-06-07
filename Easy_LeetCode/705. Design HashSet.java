class MyHashSet {
 boolean[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new boolean[100];// start with 100 elements for fast initialization
    }
    
    public void add(int key) {
        if(key>=arr.length) {
            extend(key);
        } 
        arr[key]=true;
    }
    
    public void remove(int key) {
        if(key>=arr.length) {
            return;
        }
        arr[key]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key>=arr.length) {
            return false;
        }
        return arr[key]==true;
    }
    
    public void extend(int key){
        arr= Arrays.copyOf(arr, key+2);  // extend array to one more item than necessary, we need "key" items. 
									     // we give "key+1" items to reduce collisions.
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */