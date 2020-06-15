package my.leetcode.leetcode.editor.cn;

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

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_42{
    public static void main(String[] args) {
        Solution solution = new LeetCode_42().new Solution();
        System.out.println(JSON.toJSONString(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1 })));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int total = 0;
            int length = height.length;
            if (length <3) return total;
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i< length; i++){
                //当前位置的比栈顶位置的高度大，则有可能能存水。否则不可，直接入栈。
                while (!stack.isEmpty()&& height[i] >height[stack.getFirst()]){

                    //栈顶出栈，获取栈顶位置的高度
                    int oldValue = height[stack.pop()];
                    //没有比栈顶更高的值。只有右边边界，没有左边边界的，存不了水。
                    if (stack.isEmpty()) break;

                    //计算能存下的高度
                    int high = Math.min(height[i], height[stack.getFirst()]) - oldValue;
                    //计算水槽长度
                    int len = i - stack.getFirst() - 1;
                    //累积存水量
                    total += high*len;
                }
                //值入栈
                stack.push(i);
            }
            return total;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public int trap1(int[] height) {
        int total = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    total += (left_max - height[left]);
                ++left;
            } else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else
                    total += (right_max - height[right]);
                --right;
            }
        }
        return total;
    }

}
