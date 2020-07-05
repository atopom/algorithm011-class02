package com.atopom.leetcode.editor.cn;
// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
// 输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
// 输出: false
//
// 说明: 
// 你可以假设字符串只包含小写字母。
//
// 进阶: 
// 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution242 {
    /*
     * @Description: 对两字符串进行排序后，在比较
     * @Param: [s, t]
     * @Return: boolean
     * @Author: wangyanan
     * @Date: 5:41 下午
     **/
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equalsIgnoreCase(String.valueOf(tChars));
    }

    /*
     * @Description: 数组计数器的方式，a～z一共26个英文字母，创建一个26长度的数组计数器，遍历字符串s用来给字母对应数组下标+1，字符串t用来给字母对应数组下标-1，最终数组都是0，就是字母异位词
     * @Param: [s, t]
     * @Return: boolean
     * @Author: wangyanan
     * @Date: 5:15 下午
     **/
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];// a~z的长度
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean anagram = new Solution242().isAnagram("nl", "cx");
//        boolean anagram = new Solution242().isAnagram("anagram", "nagaram");
//        boolean anagram = new Solution242().isAnagram2("nl", "cx");
        boolean anagram = new Solution242().isAnagram2("anagram", "nagaram");
        System.out.println(anagram);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
