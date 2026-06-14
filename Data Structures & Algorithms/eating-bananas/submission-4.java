class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1) Search range for k: [1, maxPile]
        int left = 1;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }

        // 2) Binary search for the smallest k that works
        while (left < right) {
            int mid = left + (right - left) / 2; // candidate speed

            // 3) Compute how many hours this speed would take
            long hours = 0;
            for (int p : piles) {
                hours += p / mid;       // full hours
                if (p % mid != 0) {     // if leftover bananas, need one more hour
                    hours++;
                }
            }

            // 4) Check if mid is fast enough
            if (hours <= h) {
                right = mid;        // mid works -> try smaller speed
            } else {
                left = mid + 1;     // mid too slow -> need bigger speed
            }
        }

        return left;
    }
}
