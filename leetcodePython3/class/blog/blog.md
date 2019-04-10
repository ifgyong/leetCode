## 经典题型
- 岛屿数量 将相邻1变成#，循环查找所有元素0(n*n)

    ### 78 不重复数组的所有子集
    在已经添加好的集合中再添加一个元素，然后新的集合再添加到之前的集合中
    
    
    def subsets(self, nums: list) -> [[int]]:
        nums.sort()
        result = [[]]
        for num in nums:
            item = [i + [num] for i in result]
            result += item
        return result
    
    
   ###82 删除重复链表的结点
   
       def deleteDuplicates2(self, head: ListNode) -> ListNode:
        dummy = pr = ListNode(0)
        dummy.next = head
        while head and head.next:
        //不相等都往后移动
            if head.val != head.next.val:
                pr = pr.next
                head = head.next
            else:
            //相等寻找下一个不相等的节点
                while head and head.next and head.val == head.next.val:
                    head = head.next
                head = head.next
                pr.next = head
        return dummy.next
    
   ###91 解码方法
   
       def numDecodings(self, s: str) -> int:
        n = len(s)
        if n == 0:return 0
        memo = []
        for i in  range(n+1):
            memo.append(0)
        memo[n] = 1
        if s[n-1] in '0':
            memo[n-1]= 0
        else: memo[n-1] = 1
        //倒序 当char*2 <27 有两种肯能 当>26有一种可能
        for i in  range(0,n-1).__reversed__():
            if s[i] in '0':
                continue
            else: 
                memo[i] = memo[i+1] +memo[i+2] if int(s[i:i+2])<=26 else memo[i+1]
        return memo[0]
    
   ###148排序链表
    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        def mergeListnode(low:ListNode,hi:ListNode)->ListNode:
            dummy = tail = ListNode(None)
            while low and hi:
                if low.val<hi.val:
                    tail.next,tail,low = low,low,low.next
                else:
                    tail.next,tail,hi = hi,hi,hi.next
            tail.next = hi or low
            return dummy.next



        pro,slow,faster = None,head,head
        while faster and faster.next:
            pro ,slow,faster = slow,slow.next,faster.next.next
        if pro:
            pro.next = None#切断链表
        if head and slow:
            l1 = self.sortList(head)
            l2 = self.sortList(slow)
            return mergeListnode(l1,l2)
        return None
   ### 129 左右子树之和 每个子树到叶子为一个数字
        def sumNumbers(self, root: TreeNode) -> int:
        self.res = 0
        self.dfs(root, 0)
        return self.res

        def dfs(self, root, value):
            if root:
                self.dfs(root.left, value*10+root.val)
                self.dfs(root.right, value*10+root.val)
                if not root.left and not root.right:
                    self.res += value*10 + root.val
   
   ### 114  二叉树展开为链表
    def __init__(self):
        self.prev = None
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #先讲右链表组装到做链表 然后左链表在组装到root的右链表
        if not root:
            return None
        self.flatten(root.right)
        self.flatten(root.left)

        root.right = self.prev
        root.left = None
        self.prev = root
        
    
  ### 106 后续中序遍历的数组 组成二叉树
    def buildTree(self, inorder:list, postorder:list) -> TreeNode:
        if not  inorder or not  postorder:return None
        root = TreeNode(postorder.pop())
        index = inorder.index(root.val)
        root.right = self.buildTree(inorder[index+1:],postorder)
        root.left = self.buildTree(inorder[:index],postorder)
        return root
        
   ### 105 前续中序遍历的数组 组成二叉树
    def buildTree2(self, inorder:list, preorder:list) -> TreeNode:
        if not  inorder or not  preorder:return None
        root = TreeNode(preorder.pop(0))
        index = inorder.index(root.val)
        root.left = self.buildTree(preorder,inorder[:index])
        root.right = self.buildTree(preorder,inorder[index+1:])
        return root
        
     # 96.
   ##### [不同的二叉搜索树](https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1\)-*-G(n-i))
    #public int numTrees(int n) {
    #     int [] G = new int[n+1];
    #     G[0] = G[1] = 1;
    #
    #     for(int i=2; i<=n; ++i) {
    #         for(int j=1; j<=i; ++j) {
    #             G[i] += G[j-1] * G[i-j];
    #         }
    #     }
    #     return G[n];
    # }
    def numTrees(self,n:int)->int:
        li = []
        for i in range(n+1):
            li[i] = 0
        li[0] = li[1] = 1
        for i in  range(2,n):
            for j in range(1,i):
                li[i]+= li[j-1] *li[i-j]
        return li[n]
        
   #### 95 不同的二叉搜索树
    def generateTrees(self, n: int) -> [TreeNode]:
        if n==0:return []
        elif n ==1:return [TreeNode(1)]
        self.genTrees(1,n)
    def genTrees(self,start:int,end:int)-> [TreeNode]:
        list = []
        if start > end:
            list.append(None)
            return list
        elif start == end:
            list.append(TreeNode(start))
            return list

        left = []
        right = []
        for i in  range(start,end+1):
            left = self.genTrees(start,i-1)
            right = self.genTrees(i+1,end)
            for l_node in left:
                for r_node in right:
                    root = TreeNode(i)
                    root.left = l_node
                    root.right = r_node
                    list.append(root)
        return list
   #### [格雷编码答案](https://leetcode.com/problems/gray-code/discuss/29884/What-is-the-best-solution-for-Gray-Code-problem-No-extra-space-used-and-no-recursion) 
        0 00
        1 01
        2 10
        3 11
        相邻的必须是一位不同总结 使用异或实现
        
        def grayCode(self, n: int) -> List[int]:
            res = []
            for i in range(1<<n):
                res .append(i^i>>1)
            return res
   ###60全排列的 第k个排列
    def getPermutation(self, n, k):
        numbers = [x for x in range(1, n + 1)]
        permutation = ''
        k -= 1
        while n > 0:
            n -= 1
            # get the index of current digit
            index, k = divmod(k, math.factorial(n))
            permutation += str(numbers[index])
            # remove handled number
            numbers.remove(numbers[index])

        return permutation
   ####40 组合总和 元素不能重复 
    def combinationSum2(self, candidates: list, target: int) -> [[int]]:
        if len(candidates) == 0:return []
        elif len(candidates) == 1 and candidates[0] != target:
            return []
        li = candidates
        li.sort()
        res = []
        self.combine_sum_m(start=0,li=li,path=[],res=res,target=target)
        return res

    def combine_sum_m(self,start:int,li:list,path:list,res:list,target:int):
        if target == 0:
            res.append(path)
            return
        for i in range(start,len(li)):
            if i > start and li[i] == li[i-1]:#相同的过滤
                continue
            if li[i] > target:#大于 中断掉
                break
                #重复的话i+1 换成i
            self.combine_sum_m(i+1,li,path+[li[i]],res,target-li[i])
            
   #### 6字符串 z 形状输出
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s): return s
        res = [[] for _ in range(numRows)]
        for i in range(len(s)):
            res[numRows -1 - abs(numRows - 1 - i % (2 * numRows - 2))].append(s[i])
        return "".join(["".join(res[i]) for i in range(numRows)])