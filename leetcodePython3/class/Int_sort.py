#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Time    : 2019-04-10 16:23
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : Int_sort.py
# @Software: PyCharm

#得出root为最大值 左右儿子为左右堆的最大值
def big_endian(arr:list,start:int,end:int):
    root = start
    while True:
        child = root*2 +1#左孩子
        if child>end:
            break#取出最大孩子
        if child +1 <= end and arr[child] < arr[child + 1]:
            child +=1
        if arr[root] < arr[child]:#最大孩子和root交换
            arr[root],arr[child] = arr[child],arr[root]
            root = child            ####调整子树为大堆子树#####
        else:
            break
#堆排序主函数时间复杂度 0(n*log2 N)  辅助内存0(1)
def head_sort(arr:list) ->[]:
    firt = len(arr)//2-1#从倒数第2层扫描 调整到 root>child
    for start in range(firt,-1,-1):#然后扫描倒数第三行 直到扫描root节点
        big_endian(arr,start,len(arr)-1)#调整为root 为最大值 左右儿子为次大小
    for end in range(len(arr)-1,0,-1):
        arr[0],arr[end] = arr[end],arr[0]
        big_endian(arr,0,end-1)#顶部和尾部交换，调整大小堆
    return arr
#选择排序  时间复杂度0(n^2) 辅助内存0(1)
#每次挑选最大或者最小值放到最前边
def selection_sort(list2):
  for i in range(0, len (list2)-1):
    min_ = i
    for j in range(i + 1, len(list2)):
      if list2[j] < list2[min_]:
        min_ = j
    list2[i], list2[min_] = list2[min_], list2[i]  # swap
    return list2

#插入排序 时间复杂度 0(n^2) 辅助内存0(1) 最好：0(n) 最坏0(n^2)
def insert_sort(lis:list):
    for i in range(1,len(lis)):                   #默认第一个元素已经在有序序列中，从后面元素开始插入
        for j in range(i,0,-1):                 #逆向遍历比较，交换位置实现插入
            if lis[j] < lis[j-1]:
                lis[j],lis[j-1] = lis[j-1],lis[j]
    return lis
#冒泡排序 时间复杂度 0(n^2) 辅助内存0(1) 最好：0(n) 最坏0(n^2)
def bubble_sort(nums):
    for i in range(len(nums) - 1):  # 这个循环负责设置冒泡排序进行的次数
        for j in range(len(nums) - i - 1):  # j为列表下标
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
    return nums
#快速排序 时间复杂度0(nlog2 N) 最好0(nlog2 N) 最坏0(n^2) 辅助内存 0(nlog2 N)
def quick_sort(li:list,low:int,hi:int) ->None:
    if low>=hi:return
    i = low
    h = hi
    tmp = li[i]#双指针 左右比较 最后空下来的位子是之前的存储的tmp
    while  i < h:
        while i<h and li[h] > tmp:
            h -=1
        li[i] = li[h]
        while i < h and li[i] < tmp:
            i +=1
        li[h]= li[i]
    li[i] = tmp
    quick_sort(li,low,i-1)
    quick_sort(li,i+1,hi)

#希尔排序 step 由大变小 最后变成有序时间复杂度0(n^1.3-2)最坏0(n^2)
def shell_sort(li:list)->None:
    step = len(li)
    while step > 1:
        step = step // 3 + 1
        for i in range(step, len(li)):
            if li[i - step] > li[i]:
                li[i], li[i - step] = li[i - step], li[i]
### 归并排序
def merge_sort(li:list):
    if len(li)<=1:return li
    mi = len(li)//2
    l = merge_sort(li[:mi])
    r = merge_sort(li[mi:])
    return merge(l,r)
### 合并数组
def merge(left:list,right:list)->list:
    i,j=0,0
    res = []
    while i<len(left) and j<len(right):
        if left[i]<right[j]:
            res.append(left[i])
            i +=1
        else:
            res.append(right[j])
            j+=1
    res +=left[i:]
    res += right[j:]
    return res
def main():
   l = [1,3,2,0,12,10,8]
   print(merge_sort(l))  # 原地排序
   # print(l)

if __name__ == "__main__":
    main()

