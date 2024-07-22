class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i][0] = i;
            c[i][1] = heights[i];
        }

        Arrays.sort(c, (a , b) -> -Integer.compare(a[1], b[1]));
        String[] res = new String[n];
        for (int i = 0; i < n; i++) res[i] = names[c[i][0]];
        
        return res;
    }
}

// -----------------------------------------------------

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        // Create an array of indices
        Integer[] sortedIndices = new Integer[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedIndices[i] = i;
        }

        // Sort indices based on heights in descending order
        Arrays.sort(sortedIndices, (a, b) -> heights[b] - heights[a]);

        // Apply the sorted indices to rearrange names
        String[] sortedNames = new String[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedNames[i] = names[sortedIndices[i]];
        }

        return sortedNames;
    }
}

// ---------------------------------------------------------

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        // Create a TreeMap to store height-name pairs (automatically sorted by height)
        TreeMap<Integer, String> heightToNameMap = new TreeMap<>();

        // Populate the map with height as key and name as value
        for (int i = 0; i < numberOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        String[] sortedNames = new String[numberOfPeople];

        // Index for filling sortedNames array from end to start
        int currentIndex = numberOfPeople - 1;

        // Iterate through the map (sorted by height in ascending order)
        // and fill the sortedNames array from end to start
        for (int height : heightToNameMap.keySet()) {
            sortedNames[currentIndex] = heightToNameMap.get(height);
            currentIndex--;
        }

        return sortedNames;
    }
}

// ------------------------------------------------

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        // Create a map to store height-name pairs
        Map<Integer, String> heightToNameMap = new HashMap<>();

        // Populate the map with height as key and name as value
        for (int i = 0; i < numberOfPeople; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] sortedNames = new String[numberOfPeople];

        // Populate sortedNames array in descending order of height
        for (int i = numberOfPeople - 1; i >= 0; i--) {
            sortedNames[numberOfPeople - i - 1] = heightToNameMap.get(
                heights[i]
            );
        }

        return sortedNames;
    }
}