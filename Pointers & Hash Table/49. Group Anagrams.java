class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String str : strs) {
      // 1. 把异尾词全部排序：a. 先变成char array
      char[] array = str.toCharArray();
      // b. 用Arrays.sort()排序char array
      Arrays.sort(array);
      // c. 把排序后的char变成String
      String key = new String(array);
      // 2. add上面的string to value
      List<String> value = map.getOrDefault(key, new ArrayList<String>());
      value.add(str);
      // 3. 把(key,value)加进map
      map.put(key, value);
    }
    return new ArrayList<List<String>>(map.values());
  }
}
