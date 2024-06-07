public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}

// ---------------------------------------

class Solution {
         public int leastInterval(char[] tasks, int n) {
            if (n == 0) {
                return tasks.length;
            }
            int[] f = new int[26];
            for (char c : tasks) {
                f[c - 'A']++;
            }
            int max = 0;
            int count = 0;
            for (int i : f) {
                if (i > max) {
                    max = i;
                    count = 1;
                } else if (i == max) {
                    count++;
                }

            }
            return Math.max(tasks.length, (max - 1) * (n + 1) + count);
            // (max-1)*n su pauze između + max sami taskovi -1 + count (ako je count 1,
            // -1+1=0)
        }
    }