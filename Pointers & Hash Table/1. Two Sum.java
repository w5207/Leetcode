class Solution {

  public int[] twoSum(int[] nums, int target) {
    if (nums == null) {
      return null;
    }
    Integer[] indexArray = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      indexArray[i] = i;
    }
    Arrays.sort(indexArray, (i1, i2) -> Integer.compare(nums[i1], nums[i2]));
    int left = 0;
    int right = indexArray.length - 1;

    while (left < right) {
      if (nums[indexArray[left]] + nums[indexArray[right]] == target) {
        return new int[] { indexArray[left], indexArray[right] };
      }
      if (nums[indexArray[left]] + nums[indexArray[right]] < target) {
        left++;
      } else {
        right--;
      }
    }
    return null;
  }
}
