class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> lastIndex = new HashMap<>();

        for(int i=0; i<s.length(); i++){

            lastIndex.put(s.charAt(i),i);
        }

        List<Integer> ans = new ArrayList<>();

        int size = 0, end = 0;

        for(int i = 0; i < s.length(); i++){

            size++;

            end = Math.max(lastIndex.get(s.charAt(i)),end);

            if(i == end){

                ans.add(size);

                size = 0;
            }
        }

        return ans;
    }
}
