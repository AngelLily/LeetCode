package my.leetcode.leetcode.editor.cn;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1{
    public static void main(String[] args) {
        Solution solution = new LeetCode_1().new Solution();
        int[] nums = new int[]{12,345,7,21,3};
        int target = 15;
        System.out.println(JSON.toJSONString(solution.twoSum(nums,target)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            Map<Integer,Integer> map = new HashMap<>();
            for (int i =0;i<nums.length;i++){
                int v = nums[i];
                int s = target - v;
                if (map.containsKey(s)){
                    res[0] = map.get(s);
                    res[1] = i;
                    return res;
                }
                map.put(v,i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}