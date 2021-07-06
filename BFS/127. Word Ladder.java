class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      // 1. 建立一个HashMap放所有的intermediate states
      int L = beginWord.length();
      Map<String, List<String>> allComboDict = new HashMap<>();
      
      // 2. Save the intermediate states in a dictionary with key as the intermediate word and value              as the list of words which have the same intermediate words
      wordList.forEach(
          word -> {
              for (int i = 0; i < L; i++) {
                  String newWord = word.substring(0,i) + "*" + word.substring(i+1,L);
                  List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                  transformations.add(word);
                  allComboDict.put(newWord, transformations);
              }
          }
      );
      
      // 3. Q放wordsList和level
      Queue<Pair<String, Integer>> Q = new ArrayDeque<>();
      Q.offer(new Pair(beginWord, 1));
      
      // 4. 为防止重复，建一个HashMap表示visited
      Map<String, Boolean> visited = new HashMap<>();
      visited.put(beginWord, true);
      
      // 5. BFS
      while(!Q.isEmpty()) {
          Pair<String, Integer> node = Q.poll();
          String word = node.getKey();
          int level = node.getValue();
          
          for (int i = 0; i < L; i++) {
              String newWord = word.substring(0,i) + "*" + word.substring(i+1,L);
              
              for (String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                  // .equals(content comparison)/==(address comparison)
                  if (adjacentWord.equals(endWord)) {
                      return level+1;
                  }
                  if (!visited.containsKey(adjacentWord)) {
                      visited.put(adjacentWord, true);
                      Q.offer(new Pair(adjacentWord, level+1));
                  }
              }
          }
      }
      
      return 0;
  }
}