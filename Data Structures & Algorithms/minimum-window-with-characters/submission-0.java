class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";

        Map<Character,Integer> t_map = new HashMap<>();

        Map<Character,Integer> s_map = new HashMap<>();

        for(char c : t.toCharArray()){

            t_map.put(c,t_map.getOrDefault(c,0)+1);
        }

        int required = t_map.size();

        int l = 0, best_length = Integer.MAX_VALUE, best_start = 0, formed = 0;

        for(int r=0; r < s.length(); r++){

            char c = s.charAt(r);

            s_map.put(c,s_map.getOrDefault(c,0)+1);

            if(t_map.containsKey(c) && t_map.get(c).intValue() == s_map.get(c).intValue()){

                formed++;
            }

            while(formed == required){

                int window_length = r - l + 1;

                if(window_length < best_length){

                    best_length = window_length;

                    best_start = l;
                }

                char leftChar = s.charAt(l);

                s_map.put(leftChar,s_map.getOrDefault(leftChar,0)-1);

                if(t_map.containsKey(leftChar) && s_map.get(leftChar) < t_map.get(leftChar)){

                    formed--;
                }

                l++;

            }
        }
        return best_length == Integer.MAX_VALUE ? "" : s.substring(best_start, best_start+best_length);

    }
}
