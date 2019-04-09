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
    