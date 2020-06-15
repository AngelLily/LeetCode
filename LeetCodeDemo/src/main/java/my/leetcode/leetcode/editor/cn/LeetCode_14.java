package my.leetcode.leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

import com.alibaba.fastjson.JSON;
public class LeetCode_14{
    public static void main(String[] args) {
        Solution solution = new LeetCode_14().new Solution();
        System.out.println(JSON.toJSONString(solution.longestCommonPrefix(new String[]{"flower","flow","flight" })));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int length = strs.length;
            if (length<1) return "";
            if (length == 1) return strs[0];
            String res = strs[0];
            for (String str : strs){
                if (str.isEmpty()) return "";
                while (str.indexOf(res)!=0){
                    res = res.substring(0,res.length()>str.length()?str.length():res.length()-1);
                    //res = res.substring(0,res.length()-1);
                    if (res.isEmpty()) return res;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}