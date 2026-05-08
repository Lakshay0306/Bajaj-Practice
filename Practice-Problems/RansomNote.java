class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterBank = new int[26];

        for (char ch : magazine.toCharArray()) {
            letterBank[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (letterBank[ch - 'a'] <= 0) return false;
            letterBank[ch - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote solver = new RansomNote();
        System.out.println(solver.canConstruct("aa", "aab"));
        System.out.println(solver.canConstruct("aa", "ab"));
    }
}
