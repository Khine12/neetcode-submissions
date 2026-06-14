class Solution {
    public int characterReplacement(String s, int k) {

        char[] c = s.toCharArray();

        int[] freq = new int[26];

        int l = 0, longest = 0, max_freq = 0;

        for(int r=0; r < c.length; r++){

            int idx = c[r] - 'A';

            freq[idx]++;

            max_freq = Math.max(max_freq,freq[idx]);

            while((r-l+1)-max_freq > k){

                freq[c[l]-'A']--;
                l++;
            }

            longest = Math.max(longest,r-l+1);
        }
        return longest;
    }
}
