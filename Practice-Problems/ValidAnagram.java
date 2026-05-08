import java.util.*;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charFreq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
            charFreq[t.charAt(i) - 'a']--;
        }

        for (int count : charFreq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();
        System.out.println(solver.isAnagram("anagram", "nagaram"));
        System.out.println(solver.isAnagram("rat", "car"));
    }
}
