package com.atopom.leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution42 {
    public int trap(int[] height) {

        int result = 0;

        int maxLeftHeight = 0;
        int maxRightHeight = 0;
        int left = 1;
        int right = height.length - 2;

        for (int i = 1; i < height.length - 1; i++) {

            if (height[left - 1] < height[right + 1]) {
                maxLeftHeight = Math.max(maxLeftHeight, height[left - 1]);
                int minHeight = maxLeftHeight;
                if (height[left] < minHeight) {
                    result += minHeight - height[left];
                }

                left++;
            } else {
                maxRightHeight = Math.max(maxRightHeight, height[right + 1]);
                int minHeight = maxRightHeight;
                if (height[right] < minHeight) {
                    result += minHeight - height[right];
                }

                right--;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int maxArea = new Solution42().trap(height);
        System.out.println(maxArea);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
