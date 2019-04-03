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

        if len(lists)==0 :return None
        l_head = ListNode(0)
        l_head.next = lists[0]
        i = 0;
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


l1 = ListNode(1)
l2 = ListNode(4)


c1= ListNode(1)
c2= ListNode(2)

d1 = ListNode(1)
d2 = ListNode(3)

