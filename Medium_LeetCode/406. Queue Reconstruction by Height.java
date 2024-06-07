class Solution {
       public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        int n = people.length;
        return res.toArray(new int[n][2]);
    }
}
//-----------------------
Input:
[[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]

Output:
[[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]

After sorting : 
[[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]

Now iterating over the sorted array and inserting people in the output array at indices equal to there k-values. 
Insert [7, 0] at index 0   ->      [[7, 0]]
Insert [7, 1] at index 1   ->      [[7, 0], [7, 1]]
Insert [6, 1] at index 1   ->      [[7, 0], [6, 1], [7, 1]]
Insert [5, 0] at index 0   ->      [[5, 0], [7, 0], [6, 1], [7, 1]]
Insert [5, 2] at index 2   ->      [[5, 0], [7, 0], [5, 2], [6, 1], [7, 1]]
Insert [4, 4] at index 4   ->      [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]

//--------------
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y) -> x[0]!=y[0] ? x[0]-y[0] : x[1]-y[1]);
        for(int[] person: people) queue.offer(person);
        int[][] result = new int[people.length][];
        while(!queue.isEmpty()) {
            int[] person = queue.poll();
            for(int i=0, aheadCount = 0;i<result.length;i++) {
                if(aheadCount == person[1] && result[i] == null) {
                    result[i] = person;
                    break;
                }
                if(result[i] == null || result[i][0] == person[0]) aheadCount++;
            }
        }
        return result;
    }
}