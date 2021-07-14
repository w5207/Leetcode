class Solution {

  public int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    int count = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      count++;
      while (sum >= target) {
        min = Math.min(count, min);
        count--;
        sum -= nums[i - count];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
