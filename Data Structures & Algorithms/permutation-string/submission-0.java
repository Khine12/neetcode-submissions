class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;

        char[] c2 = s2.toCharArray();

        char[] c1 = s1.toCharArray();

        int[] freq_2 = new int[26];

        int[] freq_1 = new int[26];

        int l=0, n = c1.length;

        for(char c: c1){

            freq_1[c-'a']++;
        }

        for(int r=0; r < c2.length; r++){

            freq_2[c2[r]-'a']++;

            if ((r-l+1) >n){

                freq_2[c2[l]-'a']--;
                l++;
            }
            if((r-l+1) == n){

                if(Arrays.equals(freq_1,freq_2)) return true;
            }
        }
        return false;
    }
}
