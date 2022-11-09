package leetCode;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        double left = target - 0.5;
        double right = target + 0.5;
        int l = binarySearch(nums, left);
        int r = binarySearch(nums, right);
        if(l == r) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r-1};
    }

    public int binarySearch(int[] nums, double target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int m = left + (right - left) / 2;
            if(target > nums[m]) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchRange sol = new SearchRange();
        sol.searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
