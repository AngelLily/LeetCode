package my.leetcode.leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15{
      public static void main(String[] args) {
           Solution solution = new LeetCode_15().new Solution();
           System.out.println(JSON.toJSONString(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> res ;

        //排序减少时间复杂度。这个排序很重要。
        Arrays.sort(nums);
        int length = nums.length;

        for(int i = 0;i<length;i++){
            //第一个数重复则重新找
            int v1 = nums[i];
            //最小值大于0 退出
            if (v1>0) break;
            if (i>0 && v1 == nums[i-1]) continue;

            //设置游标 j。 因为i不断增大，所以j只会越来越小才能满足题意。
            int j = length-1;
            int v2 = nums[j];
            //最大值小于0 退出
            if (v2<0) break;

            for (int k = i+1;k<length;k++){
                int v3 = nums[k];
                //排查第三个重复数
                if (k>i+1 && v3 == nums[k-1]) continue;
                //v1+v2+v3>0 则减小j，即减小v3
                while (v1+v2+v3>0&&j>k) v2=nums[--j];
                //j == k了 第i个数没有结果，k再增大也没用了。
                if (j == k) break;
                if (v1+v3+v2==0){
                    res = new ArrayList<>();
                    res.add(v1);res.add(v3);res.add(v2);
                    resList.add(res);
                }
            }

        }
        return resList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}