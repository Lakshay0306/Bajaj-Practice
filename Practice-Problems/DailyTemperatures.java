import java.util.*;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> monoStack = new ArrayDeque<>();

        for (int day = 0; day < n; day++) {
            while (!monoStack.isEmpty() && temperatures[day] > temperatures[monoStack.peek()]) {
                int prevDay = monoStack.pop();
                result[prevDay] = day - prevDay;
            }
            monoStack.push(day);
        }

        return result;
    }
}
