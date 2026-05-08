class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int[] lps = buildLPSArray(needle);
        int textIdx = 0, patIdx = 0;

        while (textIdx < haystack.length()) {
            if (haystack.charAt(textIdx) == needle.charAt(patIdx)) {
                textIdx++;
                patIdx++;

                if (patIdx == needle.length()) {
                    return textIdx - patIdx;
                }
            } else {
                if (patIdx > 0) {
                    patIdx = lps[patIdx - 1];
                } else {
                    textIdx++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int prefixLen = 0;
        int idx = 1;

        while (idx < n) {
            if (pattern.charAt(idx) == pattern.charAt(prefixLen)) {
                prefixLen++;
                lps[idx] = prefixLen;
                idx++;
            } else if (prefixLen > 0) {
                prefixLen = lps[prefixLen - 1];
            } else {
                lps[idx] = 0;
                idx++;
            }
        }

        return lps;
    }
}
