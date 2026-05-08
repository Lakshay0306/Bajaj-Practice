import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int ans : answers) {
            freqMap.put(ans, freqMap.getOrDefault(ans, 0) + 1);
        }

        int totalRabbits = 0;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int groupSize = entry.getKey() + 1;
            int respondents = entry.getValue();

            int groups = (respondents + groupSize - 1) / groupSize;
            totalRabbits += groups * groupSize;
        }

        return totalRabbits;
    }
}
