// ---------- Set ------------------- Time Complexity: O(N⋅L+N⋅L ^2)=O(N⋅L^2) ---------

class Solution {

    public List<String> removeSubfolders(String[] folder) {
        // Create a set to store all folder paths for fast lookup
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();

        // Iterate through each folder to check if it's a sub-folder
        for (String f : folder) {
            boolean isSubFolder = false;
            String prefix = f;

            // Check all prefixes of the current folder path
            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');
                if (pos == -1) break;

                // Reduce the prefix to its parent folder
                prefix = prefix.substring(0, pos);

                // If the parent folder exists in the set, mark as sub-folder
                if (folderSet.contains(prefix)) {
                    isSubFolder = true;
                    break;
                }
            }

            // If not a sub-folder, add it to the result
            if (!isSubFolder) {
                result.add(f);
            }
        }

        return result;
    }
}

// ---------- Sorting ------------------- Time complexity: O(N⋅LlogN) ---------

class Solution {

    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders alphabetically
        Arrays.sort(folder);

        // Initialize the result list and add the first folder
        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        // Iterate through each folder and check if it's a sub-folder of the last added folder in the result
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = result.get(result.size() - 1);
            lastFolder += '/';

            // Check if the current folder starts with the last added folder path
            if (!folder[i].startsWith(lastFolder)) {
                result.add(folder[i]);
            }
        }

        // Return the result containing only non-sub-folders
        return result;
    }
}

// ------------- Trie --------------------- Time complexity: O(N * L) ---------

class Solution {

    static class TrieNode {

        boolean isEndOfFolder;
        HashMap<String, TrieNode> children;

        TrieNode() {
            this.isEndOfFolder = false;
            this.children = new HashMap<>();
        }
    }

    TrieNode root;

    Solution() {
        this.root = new TrieNode();
    }

    public List<String> removeSubfolders(String[] folder) {
        // Build Trie from folder paths
        for (String path : folder) {
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");

            for (String folderName : folderNames) {
                // Skip empty folder names
                if (folderName.equals("")) continue;
                // Create new node if it doesn't exist
                if (!currentNode.children.containsKey(folderName)) {
                    currentNode.children.put(folderName, new TrieNode());
                }
                currentNode = currentNode.children.get(folderName);
            }
            // Mark the end of the folder path
            currentNode.isEndOfFolder = true;
        }

        // Check each path for subfolders
        List<String> result = new ArrayList<>();
        for (String path : folder) {
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");
            boolean isSubfolder = false;

            for (int i = 0; i < folderNames.length; i++) {
                // Skip empty folder names
                if (folderNames[i].equals("")) continue;

                TrieNode nextNode = currentNode.children.get(folderNames[i]);
                // Check if the current folder path is a subfolder of an
                // existing folder
                if (nextNode.isEndOfFolder && i != folderNames.length - 1) {
                    isSubfolder = true;
                    break; // Found a sub-folder
                }

                currentNode = nextNode;
            }
            // If not a sub-folder, add to the result
            if (!isSubfolder) result.add(path);
        }

        return result;
    }
}