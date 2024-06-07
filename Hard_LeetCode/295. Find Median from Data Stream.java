class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
        this.even = true;  
    }
    
    public void addNum(int num) {
        if (even) {
            large.add(num);
            small.add(large.poll());
        } else {
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (small.peek() == null) {
            return 0.0;
        } else if (large.peek() == null) {
            return (double) small.peek();
        }
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return (double) small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */