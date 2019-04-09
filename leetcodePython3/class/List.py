#!/usr/bin/python3
# -*- coding: utf-8 -*-
#//                       _oo0oo_
#//                      o8888888o
#//                      88" . "88
#//                      (| -_- |)
#//                      0\  =  /0
#//                    ___/`---'\___
#//                  .' \\|     //               |   | \\\  -  /// |   |
#|// '.
#//                 / \\|||  :  |||// \
#//                / _||||| -:- |||||- \
#//               | \_|  ''\---/''  |_/ |
#//               \  .-\__  '-'  ___/-. /
#//             ___'. .'  /--.--\  `. .'___
#//          ."" '<  `.___\_<|>_/___.' >' "".
#//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
#//         \  \ `_.   \_ __\ /__ _/   .-` /  /
#//     =====`-.____`.___ \_____/___.-`___.-'=====
#//                       `=---='
#//
#//
#//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#//
#//               佛祖保佑         永无BUG
# @Time    : 2019/4/1 下午3:49
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : List.py
# @Software: PyCharm
import types
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):

        if len(lists) == 0:
            return None
        l_head = ListNode(0)
        l_head.next = lists[0]
        i = 0
        while i<len(lists)-1:
            subnode = lists[i]
            while True:
                if hasattr(subnode,'_next'):
                   subnode = subnode.next
                else:
                    break
            subnode2 = lists[i+1]
            subnode.next = subnode2
            i +=1;

        array = []
        i = 0
        while l_head != None:
            array.append(l_head.val);
            i += 1
            l_head = l_head.next;
        l_head= ListNode(0);
        last_node = l_head
        i = 0;
        array.sort();
        print(array);
        while i < len(array):
            new_node = ListNode(array[i])
            l_head.next = new_node
            l_head = l_head.next
            i += 1

        return last_node.next
    #88合并2个有序数组
    def merge(self, nums1: [], m: int, nums2: [], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        比较大小 从大到小  大的排在最后
        """
        while m > 0 and n > 0:
                if nums1[m-1] >= nums2[n-1]:
                    nums1[m+n-1] = nums1[m-1]
                    m -= 1
                else:
                    nums1[m+n-1] = nums2[n-1]
                    n -= 1
        if n > 0:
            nums1[:n] = nums2[:n]

    #118 杨辉三角
    def generate(self, numRows: int) -> [[int]]:
        if numRows == 0:return [[]]
        elif numRows ==1:return [[1]]
        else:
            result = [[1]]
            sub = [1]
            for i in range(1,numRows):
                sub_new =[]
                for j in range(i+1):
                    if j == 0 or j == i:sub_new.append(1)
                    else:
                        sub_new.append(sub[j]+sub[j-1])
                sub = sub_new
                result.append(sub_new)
        return result
    #119 获取行内容 杨辉三角
    def getRow(self, rowIndex: int) -> [[int]]:
        rowIndex += 1
        if rowIndex == 0:return []
        elif rowIndex ==1:return [1]
        else:
            sub = [1]
            for i in range(1,rowIndex):
                sub_new =[]
                for j in range(i+1):
                    if j == 0 or j == i:sub_new.append(1)
                    else:
                        sub_new.append(sub[j]+sub[j-1])
                sub = sub_new
            return sub
    #141链表是否有环
    def hasCycle(self, head:ListNode):
        if head is None:return False
        h1,h2 = head,head
        while h1 and h2:
            if h1.next and h2.next and h2.next.next:
                h1=h1.next
                h2 = h2.next.next
            else:return False
            if h1 == h2:return True
        return  False
    def hasCycle2(self, head:ListNode):
        try:
            slow = head
            fast :ListNode= head.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
        except:
            return  False
    #167
    def twoSum(self, numbers: list, target: int) -> list:
        hi = len(numbers)-1
        low = 0
        while low<hi:
            if numbers[low]+numbers[hi]>target:
                hi -=1
                continue
            if numbers[low]+numbers[hi] < target:
                low +=1
                continue
            elif numbers[low]+numbers[hi] == target:
                break
        return [low+1,hi+1]
    #168
    def convertToTitle(self, n: int) -> str:
        capitals = [chr(x) for x in range(ord('A'), ord('Z') + 1)]
        result = []
        while n > 0:
            result.append(capitals[(n - 1) % 26])
            n = (n - 1) // 26#取整数
        result.reverse()
        return ''.join(result)
    #169
    def majorityElement(self, nums: list) -> int:
        lenth = len(nums)
        major = nums[0]
        count = 1
        for i in range(1,lenth):
            if nums[i] ==major:
                count += 1
            elif count == 0:
                count +=1
                major = nums[i]
            else:
                count -=1
        return major
    #200 岛屿个数

    def numIslands(self, grid: list) -> int:
        def dfs( grid: list, x: int, y: int):
            if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or grid[x][y] != "1":
                return
            grid[x][y] = "#"
            dfs(grid, x + 1, y)
            dfs(grid, x - 1, y)
            dfs(grid, x, y + 1)
            dfs(grid, x, y - 1)
        count = 0
        h = len(grid)
        for i in range(h):
            w = len(grid[i])
            for j in range(w):
                if grid[i][j] == "1":
                    dfs(grid,i,j)
                    count +=1
        return count
#130. 被围绕的区域
    def solve(self, board: [[str]]) -> None:
        def issolve(b: [[str]], k: int, j: int) -> None:
            if k >= 0 and j >= 0 and k <= (len(b) - 1) and j <= (len(b[0]) - 1):
                if b[k][j] == 'O':
                    b[k][j]='*'
                    issolve(b,k-1,j)
                    issolve(b, k+1, j)
                    issolve(b, k, j-1)
                    issolve(b, k, j+1)

        if len(board)==0:return
        w = len(board)
        h = len(board[0])

        for i in range(w):
            if board[i][0] == 'O':
                board[i][0] = '*'
                issolve(board,i,1)
            if board[i][h-1] == 'O':
                board[i][h-1] = '*'
                issolve(board, i, h-2)

        for i in range(h):
            if board[0][i] == 'O':
                board[0][i] = '*'
                issolve(board, 1, i)
            if board[w-1][i] == 'O':
                board[w-1][i] = '*'
                issolve(board, w-2, i)
        for i in range(w):
            for j in range(h):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                if board[i][j] == '*':
                    board[i][j] = 'O'







    #147. 对链表进行插入排序
    def insertionSortList(self, head: ListNode) -> ListNode:

        def insert(head_new:ListNode,node:ListNode)->ListNode:
            node.next = head_new
            head_new  = node
            while node.next and node.next and node.val > node.next.val:
                node.val,node.next.val = node.next.val,node.val
                node = node.next
            return head

        result = None

        while head:
            node = head
            head=head.next
            node.next = None
            result= insert(result,node)
        return result
    #82删除重复的节点
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        array = []
        while head:
            array.append(head.val)
            head = head.next
        i = len(array)-1
        last = -999
        while i >=0 and i<len(array):
            if array[i] == last:
                del  array[i]
                if i >=0 and i < len(array):
                    if array[i] == last:
                        del  array[i]
            else:
                last = array[i]
            i -= 1
        pro = ListNode(0)
        res = pro
        for i in range(len(array)):
            new_node = ListNode(array[i])
            res.next = new_node
            res = res.next
        return pro.next
    def deleteDuplicates2(self, head: ListNode) -> ListNode:
        dummy = pr = ListNode(0)
        dummy.next = head
        while head and head.next:
            if head.val != head.next.val:
                pr = pr.next
                head = head.next
            else:
                while head and head.next and head.val == head.next.val:
                    head = head.next
                head = head.next
                pr.next = head
        return dummy.next




    def createListNode(self,nums:list) -> ListNode:
        pro = ListNode(0)
        res = pro
        for i in nums:
            new_node=ListNode(i)
            res.next = new_node
            res = res.next
        return pro.next
    def priNode(self,li:ListNode):
        node = li
        while node:
            print(node.val)
            node = node.next
 #86分隔链表
    def partition(self, head: ListNode, x: int) -> ListNode:
        h1 = l1 =ListNode(0)
        h2 = l2 =ListNode(0)
        while head:
            if head.val<x:
                l1.next = head
                l1 = l1.next
            else:
                l2.next = head
                l2 = l2.next
            head = head.next
        l2.next = None#大数后边
        l1.next = h2.next
        return h1.next

    #92 翻转链表
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if m >= n:
            return head
        l2 = ListNode(head.val)
        l1 = ListNode(head.val)
        l2.next  = head
        m1=m2=ListNode(0)
        for i in range(1,m):
            head = head.next
        l1.next = head#开始翻转的位置

        for i in range(n-m+1):
            if i == 0:
                m2 = ListNode(head.val)
                m1 = m2
            else:
                new =ListNode(head.val)
                new.next = m1
                m1 = new
            head = head.next
        m2.next = head
        l1.next.next = m1
        return l2.next
#143重排链表
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None :return
        slow = head
        faster = head
        #分隔链表
        while slow.next and  faster.next:
            if faster.next.next is None:
                break
            else:
                slow = slow.next
                faster = faster.next
                faster = faster.next
        currentNode = slow.next

        last = None#翻转后边的链表
        while currentNode:
            nexNode = currentNode.next
            currentNode.next = last
            last = currentNode
            currentNode = nexNode
        slow_new1 = head

        while True:#拼接链表
            nextNode = slow_new1.next
            next_last = last.next
            last.next = nextNode
            slow_new1.next = last
            slow_new1 = nextNode
            if next_last is None:#最后一个节点的next置None
                slow_new1.next = None
                break
            last = next_last
            #148排序链表
    def sortList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        pro,slow,faster = None,head,head
        while faster and faster.next:
            pro ,slow,faster = slow,slow.next,faster.next.next
        if pro:
            pro.next = None#切断链表
        if head and slow:
            l1 = self.sortList(head)
            l2 = self.sortList(slow)
            return self.mergeListnode(l1,l2)
        return None
#合并两个链表
    def mergeListnode(self,low:ListNode,hi:ListNode)->ListNode:
            dummy = tail = ListNode(None)
            while low and hi:
                if low.val<hi.val:
                    tail.next,tail,low = low,low,low.next
                else:
                    tail.next,tail,hi = hi,hi,hi.next
            tail.next = hi or low
            return dummy.next
#127 单词接龙
    def ladderLength(self, beginWord: str, endWord: str, wordList: [str]) -> int:
        visited = set()
        queue = [(beginWord, 1)]
        while queue:
            word, dist = queue.pop(0)
            if word == endWord:
                return dist
            for i in range(len(word)):
                for j in 'abcdefghijklmnopqrstuvwxyz':
                    tmp = word[:i] + j + word[i + 1:]
                    if tmp not in visited and tmp in wordList:
                        queue.append((tmp, dist + 1))
                        visited.add(tmp)
        return 0
#120 三角形最小路径和
    def minimumTotal(self, triangle:list):
        if len(triangle) == 0:return 0
        for row in  range(len(triangle)-2,-1,-1):
            for i in range(0,len(triangle[row])):
                triangle[row][i] +=  min(triangle[row+1][i],triangle[row+1][i+1])
        return  triangle[0][0]







sol = Solution()
# l =[["O","O","O","O","X","X"],
#      ["O","O","O","O","O","O"],
#      ["O","X","O","X","O","O"],
#      ["O","X","O","O","X","O"],
#      ["O","X","O","X","O","O"],
#      ["O","X","O","O","O","O"]]
li = sol.minimumTotal([[1],
                       [1,2],
                       [3,4,5],
                       [6,7,8,9]])
print(li)
# for i in l:
#     print(i)

