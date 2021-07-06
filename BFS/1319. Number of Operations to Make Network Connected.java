class Solution {

  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] connection : connections) {
      Set<Integer> set0 = graph.getOrDefault(connection[0], new HashSet<>());
      set0.add(connection[1]);
      graph.put(connection[0], set0);

      Set<Integer> set1 = graph.getOrDefault(connection[1], new HashSet<>());
      set1.add(connection[0]);
      graph.put(connection[1], set1);
    }

    // group为相连通的node合集，单独一个不与任何node连通的node也属于一个group，需要移动的边的数量=group-1
    Set<Integer> visited = new HashSet<>();
    int groupcount = 0;

    for (int i = 0; i < n; ++i) {
      if (visited.contains(i)) {
        continue;
      }
      groupcount++;
      visited.add(i);

      Queue<Integer> queue = new ArrayDeque<>();
      queue.offer(i);
      while (!queue.isEmpty()) {
        int node = queue.poll();

        Set<Integer> nextset = graph.get(node);
        if (null == nextset) continue;
        for (int next : nextset) {
          if (!visited.contains(next)) {
            queue.offer(next);
            visited.add(next);
          }
        }
      }
    }

    return groupcount - 1;
  }
}
