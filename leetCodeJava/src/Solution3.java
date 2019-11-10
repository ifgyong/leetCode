import sun.jvm.hotspot.utilities.HashtableEntry;

import java.lang.reflect.Array;
import java.util.*;

public class Solution3 {
//    class Node {
//        public int val;
//        public List<Node> neighbors;
//
//        public Node() {}
//
//        public Node(int _val,List<Node> _neighbors) {
//            val = _val;
//            neighbors = _neighbors;
//        }
//    };
    Map<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node n = new Node();
        n.val = node.val;
        map.put(n.val,n);
        for (int i = 0; i < n.neighbors.size(); i++) {
            Node item = n.neighbors.get(i);
            if (map.containsKey(item.val)==false){
                Node item2 = new Node();
                item2.val = item.val;

            }
        }
        return n;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        List<Node> list = new ArrayList<>();
        if (root == null)return root;
        list.add(root);
        while (list.size()>0){
            List<Node> subList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Node n = list.get(i);
                if (n.left != null){
                    subList.add(n.left);
                }
                if (n.right!= null){
                    subList.add(n.right);
                }
            }
            for (int i = 0; i < subList.size()-1; i++) {
                subList.get(i).next = subList.get(i+1);
            }
            list = subList;
        }
        return root;
    }

// 103
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean toRight = false;
        if (root == null)return ret;
        List<Integer> top = new ArrayList<>();
        top.add(root.val);
        ret.add(top);
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size()>0){
            List<TreeNode> subNodes = new ArrayList<>();
            List<Integer> subInt = new ArrayList<>();
            if (toRight){
                //------>
                for (int i = 0; i < nodes.size(); i++) {
                    TreeNode n = nodes.get(i);
                    if (n.left != null){
                        subNodes.add(n.left);
                        subInt.add(n.left.val);
                    }
                    if (n.right != null){
                        subNodes.add(n.right);
                        subInt.add(n.right.val);
                    }

                }
                nodes = subNodes;
            }else {
                // <--------
                for (int i = nodes.size()-1; i > -1; i--) {
                    TreeNode n = nodes.get(i);
                    if (n.right != null){
                        subNodes.add(0,n.right);
                        subInt.add(n.right.val);
                    }

                    if (n.left != null){
                        subNodes.add(0,n.left);
                        subInt.add(n.left.val);
                    }
                }
                nodes = subNodes;
            }
            if (subInt.size()>0) ret.add(subInt);//添加一层的int
            toRight = !toRight;
        }


        return ret;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != root){
            if (root.left == null && root.right == null && sum==root.val)return true;
        }
        if (root == null)return false;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    //最大路径和124
    int maxRootSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxRootSum(root);
        return maxRootSum;
    }
    private int getMaxRootSum(TreeNode root){
        if (root == null)return 0;
        int left = Math.max(getMaxRootSum(root.left),0);//节点的和小于0 则舍弃 重置为0
        int right = Math.max(getMaxRootSum(root.right),0);////节点的和小于0 则舍弃 重置为0
        maxRootSum = Math.max(maxRootSum,root.val+left+right);//每次和最大值进行对比，保存最大值
        return root.val + Math.max(left,right);////当前节点的最大值等于左边和右边的最大值加上当前节点
    }
    //230 二叉搜索树第k小
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)return -1;
        Stack<TreeNode>arr= new Stack<>();
        TreeNode n = root;
        int count = 0;
        while (n != null&&arr.isEmpty()){
            while (n != null){
                arr.add(n);
                n=n.left;
            }
            n = arr.pop();
            count++;
            if (count == k)return n.val;
            n = n.right;
        }
        return -1;
    }


}
