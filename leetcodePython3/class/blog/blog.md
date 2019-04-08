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
    