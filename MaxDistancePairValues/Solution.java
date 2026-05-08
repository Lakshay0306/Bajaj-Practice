class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0;
        int ans = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] <= nums2[ptr2]) {
                ans = Math.max(ans, ptr2 - ptr1);
                ptr2++;
            } else {
                ptr1++;
                if (ptr2 < ptr1) ptr2 = ptr1;
            }
        }

        return ans;
    }
}
