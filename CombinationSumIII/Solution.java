import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), k, n, 1, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> current,
                           int k, int target, int start, int currentSum) {
        if (current.size() == k) {
            if (currentSum == target) {
                results.add(new ArrayList<>(current));
            }
            return;
        }

        for (int num = start; num <= 9; num++) {
            if (currentSum + num > target) break;

            current.add(num);
            backtrack(results, current, k, target, num + 1, currentSum + num);
            current.remove(current.size() - 1);
        }
    }
}
