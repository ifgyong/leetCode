#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Time    : 2019-10-14 16:02
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : bfs.py
# @Software: PyCharm

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.arr=[]
    def push(self, x: int) -> None:
        self.arr.append(x)
    def pop(self) -> None:
        self.arr.pop()
    def top(self) -> int:
        return self.arr[-1]
    def getMin(self) -> int:
        return min(self.arr)