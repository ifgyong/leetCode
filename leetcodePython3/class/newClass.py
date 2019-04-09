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


s = So().copyRandomList(Node(1,None,None))