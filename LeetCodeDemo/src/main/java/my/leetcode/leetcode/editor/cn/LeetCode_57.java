package my.leetcode.leetcode.editor.cn;

//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组

/**
 * 思路：
 *   一.old[?][1]  比  new[0] 小的 直接放进返回的队列。
 *
 *   二.主要就是中间合并的过程：
 *      找出第一个old[?][1] 大于 new[0]的下标 index
 *      对index下标的数组判断 ：
 *              1.old[index][0] > old[1],那么old直接放入
 *              2.old[index][0] <= old[1] 则需要合并区间，即寻找 第一个 old[1] >= new[1]的值。
 *                组成区间[Min(old(0),new(0)),Max(old(1),new(1))]
 *    三.old[?][0]  比  new[1] 大的 也直接放进返回的队列。
 */


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_57{
    public static void main(String[] args) {
        Solution solution = new LeetCode_57().new Solution();
//        int[][] intervals = new int[][]{new int[]{1,2},new int[]{3,5},new int[]{6,7},new int[]{8,10},new int[]{12,16}};
//        int[] newInterval = new int[]{4,8};

        int[][] intervals = new int[][]{new int[]{1,5}};
        int[] newInterval = new int[]{0,0};

        System.out.println(JSON.toJSONString(solution.insert(intervals,newInterval)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            int oldSize = intervals.length;
            if (oldSize == 0 ) return new int[][]{newInterval};

            List<int[]> res = new ArrayList<>();

            int head = newInterval[0],tail = newInterval[1],index=0;

            for (int[] interval : intervals) {
                if (interval[1]>=head) break;
                res.add(interval);
                index++;
            }

            if (index<oldSize){
                int [] temp1 = null;
                int [] temp2 = null;
                boolean b = true;
                if (intervals[index][0]>tail){
                    res.add(newInterval);
                    b = false;
                }
                else {
                    temp1 = intervals[index];
                    temp1[0] = Math.min(temp1[0], head);
                    if (intervals[index][1]>tail){
                        res.add(temp1);
                        b = false;
                        index++;
                    }
                    temp1[1] = Math.max(temp1[1], tail);
                }

                for (;index<oldSize;index++){
                    temp2 = intervals[index];
                    if (intervals[index][0]>tail){
                        if (b) {
                            res.add(temp1);
                            b=false;
                        }
                        res.add(temp2);
                    }else {
                        temp1[1] = Math.max(temp2[1], tail);
                    }
                }
                if (b) res.add(temp1);
            }else
                res.add(newInterval);

            return res.toArray(new int[res.size()][2]);
        }
    }
}