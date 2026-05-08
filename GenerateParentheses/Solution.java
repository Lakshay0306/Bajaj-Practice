import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generate(answer, new StringBuilder(), n, n);
        return answer;
    }

    private void generate(List<String> answer, StringBuilder sb, int openRemaining, int closeRemaining) {
        if (openRemaining == 0 && closeRemaining == 0) {
            answer.add(sb.toString());
            return;
        }

        if (openRemaining > 0) {
            sb.append('(');
            generate(answer, sb, openRemaining - 1, closeRemaining);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeRemaining > openRemaining) {
            sb.append(')');
            generate(answer, sb, openRemaining, closeRemaining - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
