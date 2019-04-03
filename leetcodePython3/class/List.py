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
sol = Solution()
s=sol.majorityElement([0,0,0,1,2,3,0])
print(s)




l1 = ListNode(1)
l2 = ListNode(4)
c1= ListNode(1)
c2= ListNode(2)
d1 = ListNode(1)
d2 = ListNode(3)
