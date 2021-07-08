/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

  public ListNode[] rehashing(ListNode[] hashTable) {
    // write your code here
    if (hashTable.length <= 0) {
      return hashTable;
    }
    int newcapacity = 2 * hashTable.length;
    ListNode[] newTable = new ListNode[newcapacity];
    for (int i = 0; i < hashTable.length; i++) {
      while (hashTable[i] != null) {
        // 如果你直接计算-4 % 3，你会得到-1，你可以应用函数：a % b = (a % b + b) % b得到一个非负整数。
        int newindex =
          (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
        if (newTable[newindex] == null) {
          newTable[newindex] = new ListNode(hashTable[i].val);
        } else {
          ListNode dummy = newTable[newindex];
          while (dummy.next != null) {
            dummy = dummy.next;
          }
          dummy.next = new ListNode(hashTable[i].val);
        }
        hashTable[i] = hashTable[i].next;
      }
    }
    return newTable;
  }
}
