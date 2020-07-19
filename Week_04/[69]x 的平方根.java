package com.atopom.leetcode.editor.cn;
// 实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
// 输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
// 输出: 2
// 说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 


//leetcode submit region begin(Prohibit modification and deletion)
class Solution69 {
    /**
     * @Description: 二分查找
     * @Param: [x]
     * @Return: int
     * @Author: wangyanan
     * @Date: 07:20
     **/
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long left = 1, right = x / 2;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        System.out.println(solution69.mySqrt(0));
        System.out.println(solution69.mySqrt(1));
        System.out.println(solution69.mySqrt(9));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
