/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return result;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) return i1.start - i2.start;
                else return i1.end - i2.end;
            }
        });
        
        Interval pre = intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end < cur.start) {
                result.add(pre);
                pre = cur;
            } else {
                Interval merged = new Interval(pre.start, Math.max(pre.end, cur.end));
                pre = merged;
            }
        }
        result.add(pre);
        return result;
    }
}
//----------------------------------------------------------
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                if (i1[0] != i2[0]) {
                    return i1[0] < i2[0] ? -1 : 1; 
                } else if (i1[1] != i2[1]) {
                    return i1[1] < i2[1] ? -1 : 1; 
                }
                return 0;
            }
        });
        int[] pre = intervals[0];
        for (int[] cur: intervals) {
            if (pre[1] < cur[0]) {
                res.add(pre);
                pre = cur;
            } else {
                pre[1] = Math.max(pre[1], cur[1]);
            }
        }
        res.add(pre);

        return res.toArray(new int[res.size()][2]);
    }
}
//------------------------
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}