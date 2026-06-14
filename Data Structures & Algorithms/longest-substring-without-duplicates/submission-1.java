class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] c = s.toCharArray();

        int n = c.length;

        if(n < 2) return n;

        Set<Character> set = new HashSet<>();

        int l = 0, length = 1 , longest_length = 1;

        set.add(c[l]);

        for(int r = 1; r < n; r++){

            if(c[r] != c[r-1] && !set.contains(c[r])){

                set.add(c[r]);

                length++;

                longest_length = Math.max(longest_length,length);
            }
            else if(c[r] != c[r-1] && set.contains(c[r])){

                continue;
            }
            else{
                set.clear();

                l = r;

                set.add(c[r]);

                length = 1;
            }

        }

        return longest_length;
    }
}
