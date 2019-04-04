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

ss = Solution()
t = TreeNode(1)
t2 = TreeNode(1)
t3 = TreeNode(1)
t.left = t2
t2.right = t3



s1=ss.hasPathSum(t,3)
print(s1)





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