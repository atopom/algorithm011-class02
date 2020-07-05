package com.atopom.leetcode.editor.cn;
// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
// 因为 nums[0] + nums[1] = 2 + 7 = 9
// 所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    /*
     * @Description: 暴力解法：双重for
     * @Param: [nums, target]
     * @Return: int[]
     * @Author: wangyanan
     * @Date: 4:31 下午
     **/
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return result;
    }

    /*
     * @Description: 哈希解法：两遍for
     * @Param: [nums, target]
     * @Return: int[]
     * @Author: wangyanan
     * @Date: 4:27 下午
     **/
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            return result;
        }
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            aMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (aMap.containsKey(b)) {
                return new int[]{i, aMap.get(b)};
            }
        }
        return result;
    }

    /*
     * @Description: 哈希解法：一遍for
     * @Param: [nums, target]
     * @Return: int[]
     * @Author: wangyanan
     * @Date: 4:19 下午
     **/
    public int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            return result;
        }
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (aMap.containsKey(b)) {
                return new int[]{aMap.get(b), i};
            }
            aMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
//        int[] result = new Solution1().twoSum1(nums, 9);
//        int[] result = new Solution1().twoSum2(nums, 9);
        int[] result = new Solution1().twoSum3(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
