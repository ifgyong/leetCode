import apple.laf.JRSUIUtils;
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
//    Map<Integer,Node> map = new HashMap<>();
//    public Node cloneGraph(Node node) {
//        Node n = new Node();
//        n.val = node.val;
//        map.put(n.val,n);
//        for (int i = 0; i < n.neighbors.size(); i++) {
//            Node item = n.neighbors.get(i);
//            if (map.containsKey(item.val)==false){
//                Node item2 = new Node();
//                item2.val = item.val;
//
//            }
//        }
//        return n;
//    }
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
// 993 二叉树的堂兄弟节点
    public boolean isCousins(TreeNode root, int x, int y) {

        Stack<TreeNode> stack = new Stack<>();
        if (root == null)return false;
        stack.add(root);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size()>0){
             int count = 0;
             List<TreeNode> sub = new ArrayList<>();

            for (int i = 0; i < list.size(); i++) {
                TreeNode n2= list.get(i);
                if (n2.left != null)sub.add(n2.left);
                if (n2.right != null)sub.add(n2.right);
                if (n2.left != null && n2.right != null){
                    if ((n2.left.val == x && n2.right.val == y ) ||(n2.left.val == y && n2.right.val == x))return false;

                }
                if (n2.val == x || n2.val == y)count++;
            }
            if (count > 1 )return true;
            list = sub;
        }
        return false;
    }
//994 腐烂的橘子
    public int orangesRotting(int[][] grid) {
        class Node{
            int x;
            int y;
            public Node(int x,int y){
                this.x = x;
                this.y = y;
            }
        }
        List<Node> arr= new ArrayList<>();
        int count = 0;
        int localCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    Node node = new Node(i,j);
                    arr.add(node);
                    localCount--;
                }
                if (grid[i][j] != 0)localCount ++;
            }
        }

        while (arr.size() > 0){
            List<Node> sub = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                Node n = arr.get(i);
                if (getValue(grid,n.x-1,n.y) == 1){
                    grid[n.x-1][n.y] = 2;
                    sub.add(new Node(n.x-1,n.y));
                    localCount -- ;
                }
                if (getValue(grid,n.x+1,n.y) == 1){
                    grid[n.x+1][n.y] = 2;
                    sub.add(new Node(n.x+1,n.y));
                    localCount -- ;
                }
                if (getValue(grid,n.x,n.y+1) == 1){
                    grid[n.x][n.y+1] = 2;
                    sub.add(new Node(n.x,n.y+1));
                    localCount -- ;
                }
                if (getValue(grid,n.x,n.y-1) == 1){
                    grid[n.x][n.y-1] = 2;
                    sub.add(new Node(n.x,n.y-1));
                    localCount -- ;
                }
            }

            if (sub.size()>0){
                count ++;
            }
            arr = sub;
        }


        return localCount == 0 ?count:-1;
    }
    public int getValue(int[][] grid,int x,int y){
        if (x < 0 || y < 0||x > grid.length-1 || y>grid[0].length)return -1;
        return grid[x][y];
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;//最坏情况是 n个1
            for (int j = 1; i-j*j>=0 ; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null)return true;
        int dis = treeHeight(root.left) - treeHeight(root.right);// 左子树和右子树差 绝对值小余1
        if (dis >= -1 && dis <= 1 )return isBalanced(root.left) && isBalanced(root.right);//子树的 左右子树高度差绝对值小余等于1
        return false;
    }
    public int treeHeight(TreeNode node){
        if (node == null)return 0;
        return Math.max(treeHeight(node.left),treeHeight(node.right))+1;
    }
    List<String> arr = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)return new ArrayList<String>();
        return null;
    }
//打家劫舍3
    public int rob(TreeNode root) {

        if (root == null)return 0;
        if (root.right == null && root.left == null){
            return root.val;
        }
        int c1 =  rob(root.left)+rob(root.right);
        int c2 = 0;
        //偷左右子树
        if (root.left != null)c2+=rob(root.left.left) + rob(root.left.right);
        //偷左右子树的子树和当前节点
        if (root.right != null)c2+=rob(root.right.left) + rob(root.right.right) ;
        c2 += root.val;
        return Math.max(c1,c2);
    }
// 火柴拼正方形
    public boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int line_width = 0;
        int line_all_w = 0;
        for (int i = nums.length-1; i >= 0 ; i--) {
            line_all_w += nums[i];
        }
        if (line_all_w %4 != 0 ){
            return false;
        }
        line_width = line_all_w/4;
        if (nums[nums.length-1]> line_all_w/4)return false;//某一个线段太长 无法构成正方形
        int now_line_add = 0;
        for (int i = nums.length-1; i >= 0 ; i--) {
            now_line_add += nums[i];

        }
        return false;
    }

//    public List<List<Integer>> findSubsequences(int[] nums) {
//        List<List<Integer>> ret = new ArrayList<>();
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length ; i++) {
//            List<Integer> sub = new ArrayList<>();
//            sub.add(nums[i]);
//            for (int j = i+1; j <nums.length ; j++) {
//
//            }
//        }
//    }
//547
    public int findCircleNum(int[][] M) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < M.length ; i++) {
            if (M[i][0] == -1){continue;}
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1){
                    set.add(j);
                    stack.add(i);
                }
            }
            if (set.size()>0)break;
        }
        if (set.size() == 0)return 0;
        while (stack.size() > 0){
            int a = stack.pop();
            if (M[a][0] != -1){
                for (int j = 0; j < M[0].length; j++) {
                    if (M[a][j] == 1){
                        M[a][j] = 0;
                        set.add(j);
                        stack.add(j);
                    }
                    M[a][0] = -1;
                }
            }
        }
        return 1 + findCircleNum(M);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = i+1; j < accounts.size(); j++) {
                String name1 = accounts.get(i).get(0);
                String name2 = accounts.get(j).get(0);
                if (name1.equals(name2)){
                    
                }
            }
        }
    }
}
