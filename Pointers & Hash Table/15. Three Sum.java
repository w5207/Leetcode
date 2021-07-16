class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null) {
      return null;
    }
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        if (nums[left] + nums[right] + nums[i] == 0) {
          result.add(Arrays.asList(nums[left], nums[right], nums[i]));
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (nums[left] + nums[right] + nums[i] < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
}
