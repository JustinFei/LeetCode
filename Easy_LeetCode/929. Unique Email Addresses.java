class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email: emails) {
            String[] array = email.split("@");
            set.add(array[0].split("\\+")[0].replace(".", "") + "@" + array[1]);
        }
        return set.size();
    }
}