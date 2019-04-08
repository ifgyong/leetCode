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
    
    