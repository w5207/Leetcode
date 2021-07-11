class Solution {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 2) {
      return n;
    }
    int fast = 2, slow = 2;
    while (fast < n) {
      if (nums[fast] != nums[slow - 2]) {
        nums[slow] = nums[fast];
        ++slow;
      }
      ++fast;
    }
    return slow;
  }
}
