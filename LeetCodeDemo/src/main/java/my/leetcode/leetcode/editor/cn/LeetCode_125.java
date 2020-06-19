package my.leetcode.leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

import com.alibaba.fastjson.JSON;
public class LeetCode_125{
    public static void main(String[] args) {
        Solution solution = new LeetCode_125().new Solution();
        System.out.println(JSON.toJSONString(solution.isPalindrome(".,")));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPalindrome(String s) {
            if (s.isEmpty()) return true;
            int head = 0;
            int tail = s.length()-1;
            while (head<tail){
                while (head<s.length() && !Character.isLetterOrDigit(s.charAt(head))) head++;
                while (tail>0 && !Character.isLetterOrDigit(s.charAt(tail))) tail--;
                if (head<tail && Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail)) ) return false;
                head++;
                tail--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}