class CombinationIterator {
    Queue<String> list;
    public CombinationIterator(String characters, int combinationLength) {
        list = new LinkedList<String>();
        generate(characters, 0, "", combinationLength);
    }
    
    private void generate(String str, int start, String word, int combinationLength) {
        if (word.length() == combinationLength) {
            list.offer(word);
            return;
        }
        
        for (int i = start; i < str.length(); i++) {
            String next = word + str.charAt(i);
            generate(str, i + 1, next, combinationLength);
        }
    }
    
    public String next() {
        return list.poll();
    }
    
    public boolean hasNext() {
        return list.size() > 0;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */