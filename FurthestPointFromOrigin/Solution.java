class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int leftCount = 0, rightCount = 0, wildcardCount = 0;

        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'L') leftCount++;
            else if (ch == 'R') rightCount++;
            else wildcardCount++;
        }

        return Math.abs(leftCount - rightCount) + wildcardCount;
    }
}
