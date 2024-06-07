class Solution {
    int n;
    Set<String> set = new HashSet<>();

    private String generate(String curr) {
        if (curr.length() == n) {
            if (!set.contains(curr)) {
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0");
        if (addZero.length() > 0) {
            return addZero;
        }

        return generate(curr + "1");
    }

    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        for (String s : nums) {
            set.add(s);
        }

        return generate("");
    }
}

// ——————————————————

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();

        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!set.contains(num)) {
                String res = Integer.toBinaryString(num);
                while (res.length() < n) {
                    res = "0" + res;
                }
                return res;
            }
        }

        return "";
    }
}

// ———————————————

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }
        
        int ans = Integer.parseInt(nums[0], 2);
        int n = nums.length;
        Random rand = new Random();
        
        while (integers.contains(ans)) {
            ans = rand.nextInt((int) Math.pow(2, n));
        }

        String s = Integer.toBinaryString(ans);
        while (s.length() < n) {
            s = "0" + s;
        }
        
        return s;
    }
}

// —————————————————————

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }
        
        return ans.toString();
    }
}
