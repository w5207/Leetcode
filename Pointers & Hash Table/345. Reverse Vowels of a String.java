class Solution {
    static String vowels = "aiueoAIUEO";
    static Set<Character> set = new HashSet<>();
    static {
        for (char c : vowels.toCharArray()) {
            set.add(c);
        }
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !set.contains(chars[left])) {
                left++;
            }
            while (left < right && !set.contains(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}