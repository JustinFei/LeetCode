class StockSpanner {
    List<Integer> span;
    List<Integer> stocks;
    public StockSpanner() {
        span = new ArrayList<>();
        stocks = new ArrayList<>();
    }
    
    public int next(int price) {
        int count = 1;
        int i = stocks.size() - 1;
        while (i >= 0 && price >= stocks.get(i)) {
            count += span.get(i);
            i -= span.get(i);
        }
        span.add(count);
        stocks.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */