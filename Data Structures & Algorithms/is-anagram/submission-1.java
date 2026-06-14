class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!= t.length()) return false;

        Map<Character,Integer> string_1 = new HashMap<>();

        for(char s_char : s.toCharArray()){

            if(!string_1.containsKey(s_char)){

                string_1.put(s_char,1);
            }
            else{
                string_1.put(s_char, string_1.get(s_char)+1);
            }
        }

        for(char t_char : t.toCharArray()){

            if(string_1.containsKey(t_char) && string_1.get(t_char)>0){

                string_1.put(t_char, string_1.get(t_char)-1);
            }
            else if(string_1.containsKey(t_char) && string_1.get(t_char)==0){

                string_1.remove(t_char);

            }
            else if(!string_1.containsKey(t_char)){

                return false;
            }
        }
        return string_1.isEmpty();

    }
}
