class Solution {
    public boolean isPalindrome(String s) {

        if(s.length()==1) return true;

        s = s.replaceAll("\\s+","").toLowerCase();

        char[] c = s.toCharArray();

        int l=0, r = c.length-1;

        while(l<r){

            if(!Character.isLetterOrDigit(c[l])) l++;

            if(!Character.isLetterOrDigit(c[r])) r--;

            if(c[l] != c[r]) return false;

            l++;
            r--;
        }
        return true;
    }
}
