class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int n = skill.length;
        long totalChemistry = 0;

        // Calculate the target sum
        int targetTeamSkill = skill[0] + skill[n - 1];

        // Iterate through half of the array, pairing players from both ends
        for (int i = 0; i < n / 2; i++) {
            int currentTeamSkill = skill[i] + skill[n - i - 1];

            // If any team's skill doesn't match the target, return -1
            if (currentTeamSkill != targetTeamSkill) {
                return -1;
            }

            // Calculate and add the chemistry of the current team
            totalChemistry += (long) skill[i] * (long) skill[n - i - 1];
        }

        return totalChemistry;
    }
}

// --------------------------------------

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> skillMap = new HashMap<>();

        // Calculate total skill and build frequency map
        for (int s : skill) {
            totalSkill += s;
            skillMap.put(s, skillMap.getOrDefault(s, 0) + 1);
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Iterate through unique skill values
        for (int currSkill : skillMap.keySet()) {
            int currFreq = skillMap.get(currSkill);
            int partnerSkill = targetSkill - currSkill;

            // Check if valid partner skill exists with matching frequency
            if (
                !skillMap.containsKey(partnerSkill) ||
                currFreq != skillMap.get(partnerSkill)
            ) {
                return -1;
            }

            // Calculate chemistry for all pairs with this skill
            totalChemistry +=
            (long) currSkill * (long) partnerSkill * (long) currFreq;
        }

        // Return half of total chemistry (as each pair is counted twice)
        return totalChemistry / 2;
    }
}