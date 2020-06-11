package my.leetcode.leetcode.editor.cn;

//根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_739{
    public static void main(String[] args) {
        Solution solution = new LeetCode_739().new Solution();
        int [] T = new int[]{31,33,45,75,32,42,67,94,55};
        System.out.println(JSON.toJSONString(solution.dailyTemperatures2(T)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 嵌套循环
         */
        public int[] dailyTemperatures1(int[] T) {
            int length = T.length;
            int[] res = new int[length];
            for (int i = 0; i< length; i++){
                int x = 0;
                for (int j =i+1 ; j<length;j++){
                    if (T[i]<T[j]) {
                        res[i] = j-i;
                        break;
                    }
                }
            }
            return res;
        }


        /**
         *  利用stack
         */
        public int[] dailyTemperatures2(int[] T) {
            int length = T.length;
            int[] res = new int[length];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i =0; i<length;i++){
                while (!stack.isEmpty() && T[i]>T[stack.getFirst()]){
                    Integer f = stack.pollFirst();
                    res[f] = i - f;
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}