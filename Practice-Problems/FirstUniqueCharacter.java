import java.util.*;

class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }
}
