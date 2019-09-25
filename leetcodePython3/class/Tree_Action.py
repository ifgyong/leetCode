#!/usr/bin/python3
# -*- coding: utf-8 -*-
#//                       _oo0oo_
#//                      o8888888o
#//                      88" . "88
#//                      (| -_- |)
#//                      0\  =  /0
#//                    ___/`---'\___
#//                  .' \\|     //               
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
# @Time    : 2019/4/2 上午9:09
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : Tree_Action.py
# @Software: PyCharm
import sys


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def isValidBST( root: TreeNode) -> bool:
    def isBST(root:TreeNode)->bool:
        if root is None:return True;
        if root.left and root.right:
            if root.left.val < root.val< root.right.val:
                return isBST(root.left) and isBST(root.right)
            else: return False
        if root.left and(root.right is None):
            if root.left.val < root.val:
                return  isBST(root.left)
            else:return False
        elif root.right and (root.left is None):
            if root.right.val > root.val:
                return  isBST(root.right)
            else:return False
        elif root.left is None and root.right is None:
            return True
    return isBST(root)
#102
def levelOrder( root:TreeNode):
    if root is None:return []
    vales =[]
    count = 0
    nodes =[root]
    levelCount = 0
    while count<len(nodes):
        sub =[]
        for i in range(count,len(nodes)):
            t = nodes[i]
            sub.append(t.val)
            count += 1
            if t.left:
                nodes.append(t.left)
            if t.right:
                nodes.append(t.right)
        vales.append(sub[::-1])
    return vales
#103
def zigzagLevelOrder( root: TreeNode) -> [[int]]:
    if root is None:return []
    vales =[]
    count = 0
    nodes =[root]
    from_left_right = True

    while count<len(nodes):
        sub =[]

        for i in range(count,len(nodes)):
            t = nodes[i]
            sub.append(t.val)
            count += 1
            if t.left:
                nodes.append(t.left)
            if t.right:
                nodes.append(t.right)
        if from_left_right ==False:
            from_left_right = True
            vales.append(sub[::-1])
        else:
            from_left_right = False
            vales.append(sub)
    return vales

    return [[]]
# class Solution:
    # 144
def preorderTraversal( root: TreeNode) -> [int]:
    if root is None:return []
    def proNode(root:TreeNode,l:list):
            l.append(root.val)
            if root.left:
                 proNode(root.left,l)
            if root.right:
                 proNode(root.right,l)
    l = []
    proNode(root,l)
    return l
#
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.array=list()
        self.findall(root)
    def next(self) -> int:
        """
        @return the next smallest number
        """
        p :TreeNode= self.array.pop()
        self.findall(p.right)
        return p.val



    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.array)>0

    def findall(self,r:TreeNode):
        while r:
            self.array.append(r)
            r=r.left
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:



    def minDepth(self, root: TreeNode) -> int:
        if root is None:return 0
        left = self.minDepth(root.left)
        right = self.minDepth(root.right)
        if left==0 or right == 0:
            return left+right+1
        else:return min(left,right)+1;
#66
    def plusOne(self, digits: [int]) -> [int]:
        i = len(digits)-1
        isadd :int= 1
        while i >=0:
            if isadd == 0: break
            n = digits[i]
            if i == 0 and n==9:
                digits[0] = 0
                digits.insert(0,1)
                break
            else:
                n +=isadd
                isadd = int(n/10)
                n %=10
                digits[i] = n
            i -= 1
        return digits
#67
    def addBinary(self, a: str, b: str) -> str:
        sub,s1,s2 = "",a,b
        isAdd = False
        while len(s1) or len(s2):
            s_sub1 = s1[::-1][0] if len(s1)>0 else ""
            s_sub2 = s2[::-1][0] if len(s2)>0 else ""
            if len(s1) <= 1:
                s1=""
            else:
                s1 = s1[:len(s1) - 1]
            if len(s2) <= 1:
                s2=""
            else:
                s2 = s2[:len(s2) - 1]
            if s_sub2 is "1" and s_sub1 is "1":
                new_sub = "0"
                if isAdd:new_sub = "1"
                sub = new_sub + sub
                isAdd = True
            elif s_sub1 is "1" or s_sub2 is "1":
                if isAdd:
                    sub = "0" + sub
                    isAdd = True
                else:
                    sub = "1" + sub
                    isAdd = False
            else:
                if isAdd:
                    sub = "1" + sub
                else:
                    sub = "0" + sub
                isAdd = False
        if isAdd:
            sub = "1"+sub
        return sub
    #83 顺序链表去重
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None:return None
        h =ListNode(0)
        h1 = head
        h.next = h1
        while h1.next:
            if h1.val == h1.next.val:
                h1.next = h1.next.next
            else:
                h1=h1.next
            if h1 is None:break
        return h.next
    #112path sum  路径总和 sum减去根节点 等于root.val 而且左右无节点则true
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:return False
        if not root.left and not root.right and  root.val == sum:return True
        sum -= root.val
        return self.hasPathSum(root.left,sum) or self.hasPathSum(root.right,sum)
    #199 思路是左边右边同时添加，取出来右边和左边的数组中的右半部分相加
    def rightSideView(self, root: TreeNode) -> list:
        if not root:
            return []
        right = self.rightSideView(root.right)
        left = self.rightSideView(root.left)
        return [root.val] + right + left[len(right):]

    #23. 合并K个排序链表
    def mergeKLists(self, lists: [ListNode]) -> ListNode:
        if len(lists) == 0: return None
        if len(lists) == 1: return lists[0]
        li: list = []
        for i in lists:
            if i:
                li.append(i)

        if len(li) == 2:
            new_li = ListNode(0)
            re = new_li
            new_li_1 = li[0]
            new_li_2 = li[1]

            while new_li_1 and new_li_2:
                min_val = 0
                if new_li_1.val <= new_li_2.val:
                    min_val = new_li_1.val
                    new_li_1 = new_li_1.next
                else:
                    min_val = new_li_2.val
                    new_li_2 = new_li_2.next
                new_sub = ListNode(min_val)
                new_sub.next = None
                new_li.next = new_sub
                new_li = new_li.next
            if new_li_2:
                new_li.next = new_li_2
            elif new_li_1:
                new_li.next = new_li_1
            return re.next
        elif len(li) > 2:
            count = len(li)//2
            count_l = len(li) % 2
            new_list_add = []
            for i in range(0, len(li), 2):
                if i+2 <= len(li):
                    item = self.mergeKLists(li[i:i+2])
                    if item:
                        new_list_add.append(item)
            if count_l:
                new_list_add.append(li[len(li)-1])
            if len(new_list_add) == 1:
                return new_list_add[0]
            elif len(new_list_add) > 1:
                return self.mergeKLists(new_list_add)
        elif len(li) == 1:
            return li[0]
        elif len(li) == 0:
            return None

#94二叉树 中序遍历
    def inorderTraversal(self, root: TreeNode) -> [int]:
        res =[ ]
        def sortLeft(root:TreeNode,li:list):
            if root.left:
                sortLeft(root.left)
            li.append(root.val)
            if root.right:
                sortLeft(root.right)
        sortLeft(root,res)
        return res
#129 二叉树 和
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

    # 114  二叉树展开为链表
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
#113 路径总和 将总和减去当前节点
    def pathSum(self, root: TreeNode, sum: int) -> [[int]]:
        if not  root:
            return []
        if root.val == sum and root.left is None and root.right is None:
            return [[root.val]]
        res = []
        if root.left:
            item = self.pathSum(root.left,sum-root.val)
            if len(item):
                for i in item:
                    if len(i):
                        res.append([root.val]+i)
        if root.right:
            item = self.pathSum(root.right,sum-root.val)
            if len(item):
                for i in item:
                    if len(i):
                        res.append([root.val]+i)
        return res
    #109 链表转化成 平衡二叉树
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        li = []
        while head:
            li.append(head.val)
            head = head.next
        return self.listToBST(li,0,len(li)-1)
    def listToBST(self,li:list,start:int,end:int)->TreeNode:
        if len(li) == 0:return None
        if start == end:return TreeNode(li[start])
        elif start>end:
            return None
        mi = (start+end) >> 1
        root = TreeNode(li[mi])
        root.left = self.listToBST(li,start,mi-1)
        root.right = self.listToBST(li,mi+1,end)
        return root
        #106 后续中序遍历的数组 组成二叉树
    def buildTree(self, inorder:list, postorder:list) -> TreeNode:
        if not  inorder or not  postorder:return None
        root = TreeNode(postorder.pop())
        index = inorder.index(root.val)
        root.right = self.buildTree(inorder[index+1:],postorder)
        root.left = self.buildTree(inorder[:index],postorder)
        return root

    #105 前续中序遍历的数组 组成二叉树
    def buildTree2(self, inorder:list, preorder:list) -> TreeNode:
        if not  inorder or not  preorder:return None
        root = TreeNode(preorder.pop(0))
        index = inorder.index(root.val)
        root.left = self.buildTree(preorder,inorder[:index])
        root.right = self.buildTree(preorder,inorder[index+1:])
        return root

    # 96.
    # 不同的二叉搜索树 https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
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
    #95 不同的二叉搜索树
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

#树的最大深度
    def maxDepth(self, root: TreeNode) -> int:
        if  root:
            if not root.left and not root.right:
                return 1
        else:
            return 0
        return max(self.maxDepth(root.left),self.maxDepth(root.right))+1

ss= Solution()



li = [[-8,-7,-7,-5,1,1,3,4],
      [-2],
      [-10,-10,-7,0,1,3],
      [2]]
res = []
for i in li:
    r = ListNode(0)
    r2 = r
    for j in i:
        r_sub = ListNode(j)
        r_sub.next = None
        r.next = r_sub
        r = r.next
    res.append(r2.next)


t = TreeNode(1)
t1 = TreeNode(2)
t2 = TreeNode(3)
t11 = TreeNode(4)
t22 = TreeNode(5)
t.left= t1
t1.left = t11
t1.right = t22
t.right = t2
s1 = ss.sumNumbers(t)
print(s1)
# while s1:
#     print(s1.val)
#     s1 = s1.next





# n1 = TreeNode(5)
# n2 = TreeNode(1)
# n3 = TreeNode(4)
# n4 = TreeNode(3)
# n5 = TreeNode(6)
# n1.left = n2
# n1.right = n3
# n3.left = n4
# n3.right = n5
# print( isValidBST(n1))