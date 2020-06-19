package my.leetcode.leetcode.editor.cn;

//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和
//最接近 target （最接近表示两者之差的绝对值最小）。 
//
// 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。 
//
// 请注意，答案不一定是 arr 中的数字。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,9,3], target = 10
//输出：3
//解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
// 
//
// 示例 2： 
//
// 输入：arr = [2,3,5], target = 10
//输出：5
// 
//
// 示例 3： 
//
// 输入：arr = [60864,25176,27249,21296,20204], target = 56803
//输出：11361
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i], target <= 10^5 
// 
// Related Topics 数组 二分查找

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class LeetCode_1300{
    public static void main(String[] args) {
        Solution solution = new LeetCode_1300().new Solution();
        System.out.println(JSON.toJSONString(solution.findBestValue(new int[]{15,1,1,1,1,1,1,1,1,1,1,1},50)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int minT = Integer.MAX_VALUE;
        public int findBestValue(int[] arr, int target) {

            int length = arr.length;
            //排序
            Arrays.sort(arr);
            int res = arr[length-1];
            int sumValue = 0;
            int avg = target / length;
            if (arr[length-1]<avg) return arr[length-1];
            if (arr[0]>target) return avg;

            for (int i=0;i<length;i++){
                int temp = (target - sumValue) / (length - i);
                res = culc(arr,target,temp,i,sumValue,res);
                res = culc(arr,target,temp+1,i,sumValue,res);
                res = culc(arr,target,temp-1,i,sumValue,res);
                sumValue = sumValue +arr[i];
            }
            return res;
        }

        int culc(int[] arr,int target,int r,int index,int sumValue,int curR){
            if (r <= arr[index]&&(index<1||r > arr[index-1])){
                int t = Math.abs(target -  r * (arr.length - index) - sumValue);
                if (minT == t && curR>r) {
                    return r;
                }
                if (minT>t) {
                    minT = t;
                    return r;
                }
            }
            return curR;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}