class Solution {

    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];

        for(char task : tasks){

            count[task-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int c : count){

            if (c > 0){

                maxHeap.offer(c);
            }
        }

        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){

            time++;

            if(maxHeap.isEmpty()){

                time = cooldown.peek()[1];

            }else{

                int cnt = maxHeap.poll()-1;

                if(cnt > 0){

                    cooldown.append(new int[]{cnt, time+n});
                }
            }

            if(!cooldown.isEmpty && cooldown.peek()[0] == time){

                maxHeap.offer(cooldown.poll()[1]);
            }
        }

        return time;
    }
}
