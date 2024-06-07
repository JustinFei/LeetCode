class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode: barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int l = barcodes.length;
        int[] res = new int[l];
        int i = 0;
        int time = 0;
        for (Map.Entry<Integer, Integer> e: list) {
            time = e.getValue();
            while (time-- > 0) {
                res[i] = e.getKey();
                i += 2;
                if (i >= l) {
                    i = 1;
                }
            }
        }
        return res;
    }
}