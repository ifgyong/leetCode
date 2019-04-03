#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Time    : 2019-04-03 14:12
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : Stack_Aciton.py
# @Software: PyCharm

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s = []

    def push(self, x: int) -> None:
        self.s.append(x)
    def pop(self) -> None:
        self.s.pop()
    def top(self) -> int:
        if len(self.s)==0:return None
        else:return self.s[len(self.s)-1]
    def getMin(self) -> int:
        return min(self.s)