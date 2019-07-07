package simple;


import java.util.ArrayList;
import java.util.List;

public class MergeList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node = new ListNode(-1);
        node1.next=node2;
        List<ListNode> lists = new ArrayList<>();
        lists.add(node1);
        lists.add(null);
        lists.add(node);
        ListNode result = new MergeList().mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        ListNode root = null;
        ListNode indexNode = null;
        int value = Integer.MAX_VALUE;
        ListNode maxNode = null;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = lists.size() - 1; i >= 0; i--) {
                ListNode node = lists.get(i);
                if (node != null && value > node.val) {
                    flag = true;
                    value = node.val;
                    maxNode = node;
                }
                if (flag && i == 0) {
                    //连接链表
                    if (root == null) {
                        root = new ListNode(value);
                        indexNode = root;
                    } else {
                        ListNode nowNode = new ListNode(value);
                        indexNode.next = nowNode;
                        indexNode = nowNode;
                    }
                    value = Integer.MAX_VALUE;
                    int index = lists.indexOf(maxNode);
                    if (maxNode.next == null) {
                        lists.remove(index);
                        continue;
                    }
                    lists.set(index, lists.get(index).next);
                }
                if(node==null){
                    lists.remove(i);
                }
            }

        }
        return root;
    }
}

