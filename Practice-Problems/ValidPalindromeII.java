class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;

        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return checkPalindrome(s, lo + 1, hi) || checkPalindrome(s, lo, hi - 1);
            }
            lo++;
            hi--;
        }

        return true;
    }

    private boolean checkPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII solver = new ValidPalindromeII();
        System.out.println(solver.validPalindrome("abca"));
        System.out.println(solver.validPalindrome("abc"));
    }
}
