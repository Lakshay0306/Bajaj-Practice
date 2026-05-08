import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int bricksUsed = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];

            if (climb <= 0) continue;

            minHeap.offer(climb);

            if (minHeap.size() > ladders) {
                bricksUsed += minHeap.poll();
                if (bricksUsed > bricks) return i;
            }
        }

        return heights.length - 1;
    }
}
