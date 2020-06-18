package my.leetcode.leetcode.editor.cn;

//我们从二叉树的根节点 root 开始进行深度优先搜索。 
//
// 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。
//根节点的深度为 0）。 
//
// 如果节点只有一个子节点，那么保证该子节点为左子节点。 
//
// 给出遍历输出 S，还原树并返回其根节点 root。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入："1-2--3--4-5--6--7"
//输出：[1,2,5,3,4,6,7]
// 
//
// 示例 2： 
//
// 
//
// 输入："1-2--3---4-5--6---7"
//输出：[1,2,5,3,null,6,null,4,null,7]
// 
//
// 示例 3： 
//
// 
//
// 输入："1-401--349---90--88"
//输出：[1,401,null,349,88,90]
// 
//
// 
//
// 提示： 
//
// 
// 原始树中的节点数介于 1 和 1000 之间。 
// 每个节点的值介于 1 和 10 ^ 9 之间。 
// 
// Related Topics 树 深度优先搜索

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_1028{
    public static void main(String[] args) {
        Solution solution = new LeetCode_1028().new Solution();
        System.out.println(JSON.toJSONString(solution.recoverFromPreorder("1-401--349---90--88")));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         * 用栈
         */
        public TreeNode recoverFromPreorder(String S) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            int cur = 0;
            while (cur < S.length()){
                int deep = 0;
                while (S.charAt(cur)=='-') {
                    deep++;
                    cur++;
                }
                //拼接数字
                int value = 0;
                while (cur < S.length() && S.charAt(cur)!='-'){
                    value = value * 10 + Character.getNumericValue(S.charAt(cur));
                    cur++;
                }
                TreeNode tn = new TreeNode(value);
                if (stack.size()!=0) {
                    //栈长等于深度 即父节点无子节点，直接左子树
                    if (stack.size() == deep ){
                        stack.getFirst().left = tn;
                    }else {
                        //栈长不等于深度。需要逐个出栈左子树上的节点，找到父节点，并右子树
                        while (stack.size() != deep){
                            stack.removeFirst();
                        }
                        stack.getFirst().right = tn;
                    }
                }
                stack.push(tn);
            }
            return stack.peekLast();
        }

        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }

//leetcode submit region end(Prohibit modification and deletion)


        /**
         * 递归调用
         */
        public TreeNode recoverFromPreorder1(String S) {
            if (S.isEmpty()) return null;
            return buildTreeNode(S, 0);
        }

        //定义个全局指针
        int cur = 0;
        public TreeNode buildTreeNode(String S, int deep ) {

            //超长 没有子节点返回null
            if (cur + deep >= S.length() ) return null;
            // deep代表"-"数量,如果没有deep个 -，证明没有子节点了。
            for (int i = cur; i < cur + deep; i ++) {
                if (S.charAt(i) != '-') return null;
            }
            //方便找到下一个node的value，deep代表"-"数量
            cur += deep;

            //获取value
            int value = 0;
            while (cur < S.length() && S.charAt(cur)!='-'){
                value = value * 10 + Character.getNumericValue(S.charAt(cur));
                cur++;
            }
            //生成树，递归生成子树
            TreeNode root = new TreeNode(value);
            root.left = buildTreeNode(S, deep + 1);
            root.right = buildTreeNode(S, deep + 1);
            return root;
        }


    }

}





