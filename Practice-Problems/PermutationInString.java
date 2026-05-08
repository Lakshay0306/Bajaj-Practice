import java.util.*;

class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] charCount = new int[26];
        int matchesNeeded = 0;

        for (char c : s1.toCharArray()) charCount[c - 'a']++;

        for (int count : charCount) {
            if (count != 0) matchesNeeded++;
        }

        int windowStart = 0;
        int currentMatches = 0;

        for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {
            int inChar = s2.charAt(windowEnd) - 'a';
            charCount[inChar]--;
            if (charCount[inChar] == 0) currentMatches++;

            if (windowEnd - windowStart + 1 > s1.length()) {
                int outChar = s2.charAt(windowStart) - 'a';
                if (charCount[outChar] == 0) currentMatches--;
                charCount[outChar]++;
                windowStart++;
            }

            if (currentMatches == matchesNeeded) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
