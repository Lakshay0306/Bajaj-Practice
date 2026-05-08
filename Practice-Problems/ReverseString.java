class ReverseString {
    public void reverseString(char[] s) {
        int lo = 0, hi = s.length - 1;

        while (lo < hi) {
            s[lo] ^= s[hi];
            s[hi] ^= s[lo];
            s[lo] ^= s[hi];
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        char[] test = "algorithm".toCharArray();
        new ReverseString().reverseString(test);
        System.out.println("Reversed: " + new String(test));
    }
}
