package my.leetcode.leetcode.editor.cn;

//给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。 
//
// 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。 
//
// 返回一对观光景点能取得的最高分。 
//
// 
//
// 示例： 
//
// 输入：[8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 50000 
// 1 <= A[i] <= 1000 
// 
// Related Topics 数组

import com.alibaba.fastjson.JSON;
public class LeetCode_1014{
    public static void main(String[] args) {
        Solution solution = new LeetCode_1014().new Solution();
        System.out.println(JSON.toJSONString(solution.maxScoreSightseeingPair(new int[]{8,1,5,2,6})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int maxValue = A[0];
            int res = maxValue;
            for (int i =1;i<A.length;i++){
                res = Math.max(res,maxValue+A[i]-i);
                maxValue = Math.max(maxValue,A[i]+i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}