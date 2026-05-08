class LPSArray {
    public static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int prefixLen = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(prefixLen)) {
                prefixLen++;
                lps[i] = prefixLen;
                i++;
            } else if (prefixLen > 0) {
                prefixLen = lps[prefixLen - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String pattern = "ababaca";
        int[] lps = computeLPS(pattern);

        System.out.print("Pattern: " + pattern + "\nLPS:     ");
        for (int val : lps) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
