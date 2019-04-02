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










n1 = TreeNode(5)
n2 = TreeNode(1)
n3 = TreeNode(4)
n4 = TreeNode(3)
n5 = TreeNode(6)
n1.left = n2
n1.right = n3
n3.left = n4
n3.right = n5
print( isValidBST(n1))