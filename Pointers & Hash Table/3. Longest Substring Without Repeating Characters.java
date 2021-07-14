class Solution {

  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    int count = 0;
    int len = s.length();
    Set<Character> visited = new HashSet<Character>();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      while (visited.contains(c)) {
        visited.remove(s.charAt(i - count));
        count--;
      }
      count++;
      visited.add(c);
      max = Math.max(max, count);
    }
    return max;
  }
}
