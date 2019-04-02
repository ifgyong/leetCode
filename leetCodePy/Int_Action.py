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
# @Time    : 2019/4/2 上午9:01
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : Int_Action.py
# @Software: PyCharm


#找到数组中target 索引范围 无返回[-1,-1]
def searchRange(nums:list, target:int)->list:
    if nums.__contains__(target):
        start = nums.index(target,0,len(nums))
        end = 0;
        for i in range(start,len(nums)):
            if nums[i] == target:
                end = i
        return [start,end]
    return [-1,-1]
# 数组搜索并返回插入的索引
def searchInsert( nums:list, target:int)->int:
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    if nums.__contains__(target):return nums.index(target,0,len(nums))
    if target<nums[0] :
        return 0;
    if target > nums[len(nums) - 1]:
        return len(nums)
    def sear(num:list,target:int,low:int,high:int)->int:
        if low >= high:return 0
        middle = int((low+high)/2)
        if middle == low and num[low]<target and num[high]>target:
            return  low+1
        if num[middle]>target:
           return  sear(num,target,low,middle)
        elif num[middle]<target:
            return sear(num, target, middle, high)
        else:
            return middle
    mm = sear(nums,target,0,len(nums))
    return mm
def isValidSudoku( board: [list]) -> bool:
    isVisiable = True
    def additem(item,list):
        if item != ".":
            list.append(item)
    for i in range(0,len(board)):
        h =[]
        h_2 = []
        for j in range(len(board)):
            additem(board[j][i],h)
            additem(board[i][j],h_2)
        for k in range(len(h)):
            if h.count(h[k])>1:
                isVisiable = False
                break
        if isVisiable == False:
            break
        for k in range(len(h_2)):
            if h_2.count(h_2[k])>1:
                isVisiable = False
                break
        if isVisiable == False:
            break

    for i in range(0,len(board),3):
        for j in range(0,len(board),3):
            h = []
            additem(board[i][j],h)
            additem(board[i][j+1],h)
            additem(board[i][j+2],h)
            additem(board[i+1][j],h)
            additem(board[i+1][j+1],h)
            additem(board[i + 1][j + 2],h)
            additem(board[i + 2][j],h)
            additem(board[i+2][j+1],h)
            additem(board[i + 2][j + 2],h)
        for k in range(len(h)):
            if h.count(h[k])>1:
                isVisiable = False
                break
        if isVisiable == False:
            break

    return isVisiable


def rotate( matrix: [list]) -> None:
    h =  matrix
    for i in range(len(h)):
        sub = []
        count=  len(h)-1
        for j in range(len(h[i])):
            matrix[i][count] = h[j][i]
            count -= 1
        # h.append(sub)
    for i in range(len(matrix)):
        print(matrix[i])

# 保存左边的》0的值，小余0 则不保存 则保存的数据是从左往右的最大值
def maxSubArray( nums: [int]) -> int:
    maxNum=0;
    for i in range(1,len(nums)):
        if nums[i-1]>0:
            nums[i] = nums[i] + nums[i-1]
            maxNum = nums[i] if nums[i]>maxNum else maxNum
    return  maxNum
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e
    def p(self):
        print("s:",self.start,"end:",self.end)
def merge( intervals: [Interval]) -> [Interval]:
    i = len(intervals)-1
    def cons(val:Interval,val2:Interval):
        if val.end < val2.start or val.start>val2.end:
            return False;
        return True;
    def join(val:Interval,val2:Interval):
        minS = min( val.start,val2.start)
        maxE = max(val.end,val2.end)
        return Interval(minS,maxE)
    while i > 0:
        l:Interval = intervals[i]
        l_l:Interval = intervals[i-1]
        if cons(l_l,l):
            intervals.__delitem__(i)
            intervals.__delitem__(i-1)
            res = join(l_l,l)
            intervals.append(res)
            i -= 1
        else:
            i -= 1
    return  intervals

ll = [
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
]
res = Interval(1,3)
res1 = Interval(0,2)
res2 = Interval(3,5)
rr = merge([res,res1,res2])
for i in rr:
    i.p()
# def spiralOrder( matrix: [list[int]]) -> list[int]:
#     if len(matrix) == 0:return []
#     xMax = len(matrix)
#     yMax = len(matrix[0])
#     if yMax == 1:
#         return  matrix[0]
#     x,y = 0 ,0





ar =  [["5","3",".",".","7",".",".",".","."],
       ["6",".",".","1","9","5",".",".","."],
       [".","9","8",".",".",".",".","6","."],
       ["8",".",".",".","6",".",".",".","3"],
       ["4",".",".","8",".","3",".",".","1"],
       ["7",".",".",".","2",".",".",".","6"],
       [".","6",".",".",".",".","2","8","."],
       [".",".",".","4","1","9",".",".","5"],
       [".",".",".",".","8",".",".","7","9"]]
# print( isValidSudoku(ar))