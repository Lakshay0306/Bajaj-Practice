import java.util.*;

class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLen = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);

            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= windowStart) {
                windowStart = lastSeen.get(ch) + 1;
            }

            lastSeen.put(ch, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }

        return maxLen;
    }
}
