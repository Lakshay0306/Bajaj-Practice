import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] waitDays = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int today = 0; today < n; today++) {
            while (!stack.isEmpty() && temperatures[today] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                waitDays[prevDay] = today - prevDay;
            }
            stack.push(today);
        }

        return waitDays;
    }
}
