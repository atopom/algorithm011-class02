package com.atopom.leetcode.editor.cn;
// 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出:
// [
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
// ]
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution49 {
    /*
     * @Description: 哈希，使用排序后的字符串做key，相同的key存放在一个List下
     * @Param: [strs]
     * @Return: java.util.List<java.util.List<java.lang.String>>
     * @Author: wangyanan
     * @Date: 6:07 下午
     **/
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> keyGroup = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!keyGroup.containsKey(key)) {
                ArrayList<String> strings = new ArrayList<String>();
                strings.add(strs[i]);
                keyGroup.put(key, strings);
                continue;
            }
            keyGroup.get(key).add(strs[i]);
        }
        return new ArrayList<>(keyGroup.values());
    }

    /*
     * @Description: 哈希，使用a~z的长度为26的int数组作为生成一个唯一字符串的key，相同的key存放在一个List下
     * @Param: [strs]
     * @Return: java.util.List<java.util.List<java.lang.String>>
     * @Author: wangyanan
     * @Date: 6:08 下午
     **/
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> keyGroup = new HashMap<>();
        int[] counter = new int[26];// a~z的长度
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(counter, 0);
            for (int j = 0; j < strs[i].length(); j++) {
                counter[strs[i].charAt(j) - 'a']++;
            }
            String key = Arrays.toString(counter);
            if (!keyGroup.containsKey(key)) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                keyGroup.put(key, strings);
                continue;
            }
            keyGroup.get(key).add(strs[i]);
        }
        return new ArrayList<>(keyGroup.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> result = new Solution49().groupAnagrams(strs);
        List<List<String>> result = new Solution49().groupAnagrams2(strs);
        for (List<String> list : result) {
            for (String item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
