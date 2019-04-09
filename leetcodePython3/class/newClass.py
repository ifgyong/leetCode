#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Time    : 2019-04-09 10:57
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : newClass.py
# @Software: PyCharm

class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random
class Node2:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors

class Node3:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
class So:
    #深拷贝 随机链表
    def copyRandomList(self, head: Node) -> Node:
        if not  head:return head
        new_head = Node(head.val,None,None)
        res = new_head
        while head:
            if head.next:
                res.next = Node(head.next.val,None,None)
            if head.random:
                x = Node(head.random)
                res.random = x
            res = res.next
            head = head.next


        return new_head
    #133 拷贝无向图 XXX
    # def cloneGraph(self, node: Node2) -> Node2:
    #     def dfs(node:Node2,dic):
    #         for ne in  node.neighbors:
    #             if ne not  in dic:
    #                 neCopy = Node2(ne.val,ne.neighbors)
    #                 dic[neCopy] = ne
    #                 dic[node].neighbors.append(neCopy)
    #                 dfs(neCopy,dic)
    #             else:
    #                 dic[node].neighbors.append(dic[ne])
    #     if not node:return
    #     nodeCopy = Node2(node.val,Node)
    #     for ne  in node.neighbors:
    #
    #
    #
    #
    #     res = Node2(node.val,node.neighbors)
    #     rr = res
    #     while node.neighbors != rr.neighbors:
    #
    #     return rr
    #117 填充下每个节点下一个节点的右侧结点指针
    def connect(self, root: Node3) -> Node3:
        if root is None:return None
        if root.left:
            root.left.next = root.right if root.right else self.fineNextNode(root.next)
        if root.right:
            root.right.next = self.fineNextNode(root.next)
        self.connect(root.right)#先链接右侧 再连接左侧
        self.connect(root.left)
        return root

    def fineNextNode(self,root:Node3) ->Node3:
        if not root:
            return None
        if root.left:
            return root.left
        if root.right:
            return  root.right
        return self.fineNextNode(root.next)


s = So().copyRandomList(Node(1,None,None))