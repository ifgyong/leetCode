#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Time    : 2019-04-11 10:58
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : TreeNode_Action.py
# @Software: PyCharm
class TreeNode:
    val = 0
    left = None
    right = None
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Sol:
    ### 递归前序遍历
    def ergodicFont(self,root:TreeNode,li:list):
        if not  root:return
        li.append(root.val)
        self.ergodicFont(root.left,li)
        self.ergodicFont(root.right,li)
### 循环前序遍历
    def ergodicFont2(self, root: TreeNode, li: list):
        res = []
        while root or len(res):
            if root:#add的时候添加记录
                res.append(root)
                li.append(root.val)
                root = root.left
            else:
                root = res[-1]
                res.pop()
                root = root.right


    ### 递归中序遍历
    def ergodicMiddle(self, root: TreeNode, li: list):
        if not root: return
        self.ergodicMiddle(root.left, li)
        li.append(root.val)
        self.ergodicMiddle(root.right, li)
        ### 循环中序遍历
    def ergodicMiddle2(self, root: TreeNode, li: list):
        res = []
        while root or len(res):
            if root:
                res.append(root)
                root = root.left
            else:
                root = res[-1]#pop的时候添加记录
                li.append(root.val)
                res.pop()
                root = root.right


    ### 递归后序遍历
    def ergodicAfter(self, root: TreeNode, li: list):
        if not root: return
        self.ergodicAfter(root.left, li)
        self.ergodicAfter(root.right, li)
        li.append(root.val)

    def ergodicAfter2(self, root: TreeNode, li: list):
        res = []
        last  = set()
        while root or len(res):
            if root:
                res.append(root)
                root = root.left
            else:
                root = res[-1]  #
                while root:
                    if root.right is None:
                        li.append(root.val)
                        res.pop()
                        if len(res) == 0:
                            return
                        else:
                            root = res[-1]
                    else:
                        if last.__contains__(root):
                            li.append(root.val)
                            res.pop()
                            if len(res) == 0:return
                            else:
                                root = res[len(res)-1]
                        else:
                            last.add(root)
                            root = root.right
                            break

    ### 递归翻转二叉树
    def exchangeNode(self,root:TreeNode)->None:
        if not  root:return None
        if root.left is None and root.right is None:return None
        root.left ,root.right= root.right,root.left
        self.exchangeNode(root.right)
        self.exchangeNode(root.left)
### 循环翻转二叉树
    def exchangeNode2(self, root: TreeNode) -> None:
        if not root: return None
        if root.left is None and root.right is None: return None
        ahead = root
        li = [ahead]
        l,i=len(li),0
        while i < l:
            ahead = li[i]
            if ahead.left:
                li.append(ahead.left)
            if ahead.right:
                li.append(ahead.right)
            ahead.left, ahead.right = ahead.right, ahead.left
            l = len(li)
            i += 1
        self.printNode([],root)

    def printNode(self,li:list,root:TreeNode):
        if root is None:return
        if len(li) == 0:
            li.append(root)
            self.printNode(li,root)
        else:
            i = 0
            x = len(li)
            while i< x:
                r :TreeNode = li[i]
                if not r:break
                print(r.val)
                if r.left :
                    li.append(r.left)
                if r.right:
                    li.append(r.right)
                i+=1
            if i >= len(li)-1:return
            self.printNode(li[i:],root)

t = TreeNode(1)
t1 = TreeNode(2)
t2 = TreeNode(3)
t11 = TreeNode(4)
t12 = TreeNode(5)
t21 = TreeNode(6)
t22 = TreeNode(7)
t.left= t1
t1.left = t11
t1.right = t12
t.right = t2
t2.left = t21
t2.right = t22
so = Sol()
# so.printNode([],t)
li = []
so.ergodicAfter2(t,li)
print(li)

