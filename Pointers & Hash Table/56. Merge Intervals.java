class Solution {

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return intervals;
    }
    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    List<int[]> result = new ArrayList<>();
    int[] curr = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (curr[1] >= interval[0]) {
        curr[1] = Math.max(curr[1], interval[1]);
      } else {
        result.add(curr);
        curr = interval;
      }
    }
    result.add(curr);
    return result.toArray(new int[0][]);
  }
}
