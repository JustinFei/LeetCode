public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        
        for(int i=0;i<len1;i++) set1.add(nums1[i]);
        
        for(int j=0;j<len2;j++){
            if(set1.contains(nums2[j])) set2.add(nums2[j]);
        }
        
        int[] result = new int[set2.size()];
        int k=0;
        for(int num: set2) result[k++]=num;
        return result;
     }
}

// ----------------------------------------------------

 class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set<Integer> set = new HashSet<>(Arrays.asList(array));
        Set<Integer> set1 = new HashSet<>(Arrays.asList(Arrays.stream(nums1).boxed().toArray(Integer[]::new)));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(Arrays.stream(nums2).boxed().toArray(Integer[]::new)));
        List<Integer> res = new ArrayList<>();
        for (int n : set1) 
            if (set2.contains(n))
                res.add(n);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}