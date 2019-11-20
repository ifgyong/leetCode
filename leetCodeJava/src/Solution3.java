import apple.laf.JRSUIUtils;
import sun.jvm.hotspot.utilities.HashtableEntry;

import java.lang.reflect.Array;
import java.util.*;
class NumArray {
    int[] a;
    public NumArray(int[] nums) {
        a = nums;
    }

    public int sumRange(int i, int j) {
        int ret = 0;
        for (int k = i; k <=j ; k++) {
            ret += a[k];
        }
        return ret;
    }
}
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
    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        if (nums .length == 0)return null;
        return toBST(nums,0,nums.length-1);
    }
    public TreeNode toBST(int[] nums,int l,int r){
        if (l > r)return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,l,mid-1);
        root.right = toBST(nums,mid+1,r);
        return root;
    }
    //获取二叉树高度
    public int getHeight(TreeNode node){
        if (node == null)return 0;
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)return ret;
        ret.add(root.val);
        List<TreeNode> arr = new ArrayList<>();
        arr.add(root);
        while (arr.isEmpty() ==false){
            List<TreeNode> sub = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                TreeNode node = arr.get(i);
                if (node.left != null)sub.add(node.left);
                if (node.right != null)sub.add(node.right);
            }
            if (sub.size() > 0){
                ret.add(sub.get(sub.size()-1).val);
            }
            arr = sub;
        }
        return ret;

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
        return null;
    }

//删除已排序的链表的重复节点  83
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null){
            if (node.next != null){
                if (node.val == node.next.val){
                    node.next = node.next.next;
                }else {
                    node = node.next;
                }
            }else {
                node = node.next;
            }
        }
        return head;
    }
//120 三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        //子上而下计算每个位置的最小值 最终 最后一行的最小值则是 最短路径
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> sub0 = triangle.get(i-1);
            List<Integer> sub = triangle.get(i);
            for (int j = 0; j < sub.size(); j++) {
                if (j == 0){
                    sub.set(j,sub.get(j)+sub0.get(j));
                }else if (j == sub.size()-1){
                    sub.set(j,sub.get(j)+sub0.get(j-1));
                }else {
                    Integer min = Math.min(sub0.get(j),sub0.get(j-1));
                    sub.set(j,min+sub.get(j));
                }
            }
            triangle.set(i,sub);
        }
        List<Integer> sub = triangle.get(triangle.size()-1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <sub.size() ; i++) {
            min = Math.min(sub.get(i),min);
        }
        return min;
    }
    public int minimumTotal2(List<List<Integer>> triangle) {
        //子下而上计算每个位置的最小值 最终 第一行的值则是 最短路径
        if (triangle.size() == 0)return 0;
        for (int i = triangle.size()-2; i >-1; i--) {
            List<Integer> sub0 = triangle.get(i);
            List<Integer> sub = triangle.get(i+1);
            for (int j = 0; j < sub.size()-1; j++) {
                Integer min = Math.min(sub.get(j),sub.get(j+1));
                sub0.set(j,min+sub0.get(j));
            }
        }
        return triangle.get(0).get(0);
    }


    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Integer intMax = 0,intMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])==false){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
            intMax = Math.max(intMax,nums[i]);
            intMin = Math.min(intMin,nums[i]);
        }
        int ret = 0;
        for (Integer item:map.keySet()) {

            if (map.containsKey(item-1)==false){
                int now = item;
                while (map.containsKey(now)){
                    now ++;
                }
                ret = Math.max(now-1 - item,ret);
            }
        }
        return ret;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dp = new  int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            int j = 0,jj=0;
            for (; j <= gas.length; j++) {
                jj = (i+j)%gas.length;
                if (j == 0)dp[jj] = gas[jj];
                else {
                    if (jj == 0){
                        int maxIndex = gas.length-1;
                        dp[jj] = dp[maxIndex] - cost[maxIndex];
                    }else {
                        dp[jj] = dp[jj-1] - cost[jj-1] ;
                    }
                    if (dp[jj] < 0){
                        break;//这次不行了
                    }
                    if (jj != i)
                    {
                        dp[jj] += gas[jj];//添加当前的加油站的油
                    }
                }
            }
            //循环一遍 回到原点中间没有 <=0的油量
            if (dp[jj] >= 0){
                return i;
            }
        }
        return -1;
    }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int total = 0,current = 0,start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i];
            total -= cost[i];
            current += gas[i];
            current -= cost[i];
            if (current < 0){
                current = 0;
                start = i+1;
            }
        }
        if (total >= 0)return start;
        return -1;
    }

    public int candy(int[] ratings) {

        int[] d = new int[ratings.length];
        Arrays.fill(d,1);
        //从左向右计算应该发多少钱
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                d[i] = d[i-1]+1;
            }
        }
        int s  = d[d.length-1];
        //从右向左发糖果
        //最后的结果就是 中间大的比两边小的 都大。
        for (int i = ratings.length-2; i > -1 ; i--) {
            if (ratings[i] > ratings[i+1]){
                d[i] = Math.max(d[i],d[i+1]+1);
            }
            s += d[i];
        }
        return s;

    }

//221
    public int maximalSquare(char[][] matrix) {
        int ret = 0;
        if (matrix.length == 0)return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i < matrix.length+1; i++) {
            for (int j = 1; j < matrix[0].length+1; j++) {
                if (matrix[i-1][j-1] == '1'){
                    int m = Math.min(dp[i-1][j-1],dp[i-1][j]);
                    m = Math.min(m,dp[i][j-1]);
                    dp[i][j] = 1 + m;
                    ret = Math.max(dp[i][j],ret);
                }
            }
        }
        return ret*ret;
    }
//246
    public int nthUglyNumber(int n) {
        if (n <0)return -1;
        List<Integer> arr= new ArrayList<>();
        arr.add(1);
        int i3 = 0,i2=0,i5=0;
        while (arr.size() < n){
            int i22 = arr.get(i2) * 2;
            int i33=  arr.get(i3) * 3;
            int i55 = arr.get(i5) * 5;
            int min = Math.min(i22,i33);
            min = Math.min(min,i55);
            if (min == i22)i2++;
            if (min == i33)i3++;
            if (min == i55)i5++;
            arr.add(min);
        }
        return arr.get(arr.size()-1);
    }
    public int[] reser(int[] ints,int index){
        if (index <0 || index>ints.length-1)return null;
        for (int i = 0; i < index/2; i++) {
            int tap = ints[i];
            ints[i] = ints[index - i];
            ints[index-i] = tap;
        }
        int resetSecond = index+1+ (ints.length-index)/2;
        for (int i = index+1; i < resetSecond; i++) {
            int tap = ints[i];
            ints[i] = ints[ints.length - 1-i];
            ints[ints.length-i-1] = tap;
        }
        for (int i = 0; i <= ints.length/2; i++) {
            int tap = ints[i];
            ints[i] = ints[ints.length - 1-i];
            ints[ints.length-1-i] = tap;
        }
        return ints;
    }
}

