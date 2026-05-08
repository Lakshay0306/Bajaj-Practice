import java.util.*;

class SlidingWindowKDistinct {
    public static void main(String[] args) {
        String s = "aabac";
        int k = 2;

        Map<Character, Integer> freqMap = new HashMap<>();
        int lo = 0, longest = 0;

        for (int hi = 0; hi < s.length(); hi++) {
            char inChar = s.charAt(hi);
            freqMap.merge(inChar, 1, Integer::sum);

            while (freqMap.size() > k) {
                char outChar = s.charAt(lo);
                freqMap.merge(outChar, -1, Integer::sum);
                if (freqMap.get(outChar) == 0) freqMap.remove(outChar);
                lo++;
            }

            if (freqMap.size() == k) {
                longest = Math.max(longest, hi - lo + 1);
            }
        }

        System.out.println("Longest substring with " + k + " distinct chars: " + longest);
    }
}
