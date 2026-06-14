class Solution {
    public int[] twoSum(int[] numbers, int target) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<numbers.length; i++){

            int need = target - numbers[i];

            if(set.contains(need)) return new int[]{need,numbers[i]};

            set.add(numbers[i]);
        }
        return new int[]{-1,-1};
    }
}
