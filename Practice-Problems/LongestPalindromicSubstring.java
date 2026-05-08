class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int bestStart = 0, bestEnd = 0;

        for (int center = 0; center < s.length(); center++) {
            int oddLen = expandFromCenter(s, center, center);
            int evenLen = expandFromCenter(s, center, center + 1);

            int maxLen = Math.max(oddLen, evenLen);

            if (maxLen > bestEnd - bestStart) {
                bestStart = center - (maxLen - 1) / 2;
                bestEnd = center + maxLen / 2;
            }
        }

        return s.substring(bestStart, bestEnd + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
