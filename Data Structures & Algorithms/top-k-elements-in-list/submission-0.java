class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> freq = new HashMap<>();

        List<List<Integer>> buckets = new ArrayList<>();

        for(int x : nums){

            freq.put(x,freq.getOrDefault(x,0)+1);
        }

        for(int i=0; i<= nums.length; i++){

            buckets.add(i,new ArrayList<>());
        }

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){

            int f = entry.getValue();

            int x = entry.getKey();

            buckets.get(f).add(x);
        }

        int[] ans = new int[k];

        int idx = 0;

        for(int f=nums.length; f>=1 && idx<k; f--){

            for(int x: buckets.get(f)){

                ans[idx++] = x;

                if(idx==k) break;
            }

        }

        return ans;
    }
}
