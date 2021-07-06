class Solution {

  public int openLock(String[] deadends, String target) {
    // 1. 默认开局
    if ("0000".equals(target)) {
      return 0;
    }

    int step = 0;

    // 2. 建立一个HashSet放dead将搜索效率降到O(1)
    Set<String> dead = new HashSet<String>();
    for (String deadend : deadends) {
      dead.add(deadend);
    }
    if (dead.contains("0000")) {
      return -1;
    }

    // 3. 建立visited防止重复搜索
    Set<String> visited = new HashSet<String>();
    visited.add("0000");

    // 4. BFS
    Queue<String> q = new ArrayDeque<String>();
    q.offer("0000");

    while (!q.isEmpty()) {
      step++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String status = q.poll();
        for (String nextStatus : get(status)) {
          if (!dead.contains(nextStatus) && !visited.contains(nextStatus)) {
            if (nextStatus.equals(target)) {
              return step;
            }
            q.offer(nextStatus);
            visited.add(nextStatus);
          }
        }
      }
    }
    return -1;
  }

  // 5. get(status)
  public char numPrev(char x) {
    return x == '0' ? '9' : (char) (x - 1);
  }

  public char numSucc(char x) {
    return x == '9' ? '0' : (char) (x + 1);
  }

  public List<String> get(String status) {
    List<String> ret = new ArrayList<String>();
    char[] chars = status.toCharArray();
    for (int i = 0; i < 4; i++) {
      char num = chars[i];
      chars[i] = numPrev(num);
      ret.add(new String(chars));
      chars[i] = numSucc(num);
      ret.add(new String(chars));
      chars[i] = num;
    }
    return ret;
  }
}
