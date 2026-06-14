class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] c = s.toCharArray();

        int n = c.length;

        if(n < 2) return n;

        Set<Character> set = new HashSet<>();

        int l = 0, longest_length = 0;

        for(int r = 0; r < n; r++){

            while(set.contains(c[r])){

                set.remove(c[l]);

                l++;
            }

            set.add(c[r]);

            longest_length = Math.max(longest_length, r-l+1);

        }

        return longest_length;
    }
}