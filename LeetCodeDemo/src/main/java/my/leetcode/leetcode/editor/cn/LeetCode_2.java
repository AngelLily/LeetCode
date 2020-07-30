package my.leetcode.leetcode.editor.cn;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

import com.alibaba.fastjson.JSON;
public class LeetCode_2{
      public static void main(String[] args) {
           Solution solution = new LeetCode_2().new Solution();

          ListNode l11 = new LeetCode_2().new ListNode(2);
          ListNode l12 = new LeetCode_2().new ListNode(4);
          ListNode l13 = new LeetCode_2().new ListNode(5);
          l11.next=l12; l12.next=l13;

          ListNode l21 = new LeetCode_2().new ListNode(5);
          ListNode l22 = new LeetCode_2().new ListNode(6);
          ListNode l23 = new LeetCode_2().new ListNode(4);
          l21.next=l22; l22.next=l23;

           System.out.println(JSON.toJSONString(solution.addTwoNumbers(l11,l21)));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        int t = 0;
        while(l1 !=null || l2 !=null){
            if (l1!=null && l2!=null){
                int s = l1.val + l2.val + t;
                temp = getListNode(temp, s);
                t = s/10;
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1!=null){
                int s = l1.val + t;
                temp = getListNode(temp, s);
                t = s/10;
                l1 = l1.next;
            }else {
                int s = l2.val + t;
                temp = getListNode(temp, s);
                t = s/10;
                l2 = l2.next;
            }
        }

        if (t >0) getListNode(temp,t);
        return res.next;
    }


    private ListNode getListNode(ListNode temp, int s) {
        temp.next = new ListNode(s % 10);
        return temp.next;
    }
}


//leetcode submit region end(Prohibit modification and deletion)


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}