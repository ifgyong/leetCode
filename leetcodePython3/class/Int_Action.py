#!/usr/bin/python3# -*- coding: utf-8 -*-#//                       _oo0oo_#//                      o8888888o#//                      88" . "88#//                      (| -_- |)#//                      0\  =  /0#//                    ___/`---'\___#//                  .' \\|     //               |   | \\\  -  /// |   |#|// '.#//                 / \\|||  :  |||// \#//                / _||||| -:- |||||- \#//               | \_|  ''\---/''  |_/ |#//               \  .-\__  '-'  ___/-. /#//             ___'. .'  /--.--\  `. .'___#//          ."" '<  `.___\_<|>_/___.' >' "".#//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |#//         \  \ `_.   \_ __\ /__ _/   .-` /  /#//     =====`-.____`.___ \_____/___.-`___.-'=====#//                       `=---='#//#//#//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#//#//               佛祖保佑         永无BUG# @Time    : 2019/4/2 上午9:01# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145# @Site    : http://fgyong.cn 兜兜转转的技术博客# @File    : Int_Action.py# @Software: PyCharm#找到数组中target 索引范围 无返回[-1,-1]def searchRange(nums:list, target:int)->list:    if nums.__contains__(target):        start = nums.index(target,0,len(nums))        end = 0;        for i in range(start,len(nums)):            if nums[i] == target:                end = i        return [start,end]    return [-1,-1]# 数组搜索并返回插入的索引def searchInsert( nums:list, target:int)->int:    """    :type nums: List[int]    :type target: int    :rtype: int    """    if nums.__contains__(target):return nums.index(target,0,len(nums))    if target<nums[0] :        return 0    if target > nums[len(nums) - 1]:        return len(nums)    def sear(num:list,target:int,low:int,high:int)->int:        if low >= high:return 0        middle = int((low+high)/2)        if middle == low and num[low]<target and num[high]>target:            return  low+1        if num[middle]>target:           return  sear(num,target,low,middle)        elif num[middle]<target:            return sear(num, target, middle, high)        else:            return middle    mm = sear(nums,target,0,len(nums))    return mmdef isValidSudoku( board: [list]) -> bool:    isVisiable = True    def additem(item,list):        if item != ".":            list.append(item)    for i in range(0,len(board)):        h =[]        h_2 = []        for j in range(len(board)):            additem(board[j][i],h)            additem(board[i][j],h_2)        for k in range(len(h)):            if h.count(h[k])>1:                isVisiable = False                break        if isVisiable == False:            break        for k in range(len(h_2)):            if h_2.count(h_2[k])>1:                isVisiable = False                break        if isVisiable == False:            break    for i in range(0,len(board),3):        for j in range(0,len(board),3):            h = []            additem(board[i][j],h)            additem(board[i][j+1],h)            additem(board[i][j+2],h)            additem(board[i+1][j],h)            additem(board[i+1][j+1],h)            additem(board[i + 1][j + 2],h)            additem(board[i + 2][j],h)            additem(board[i+2][j+1],h)            additem(board[i + 2][j + 2],h)        for k in range(len(h)):            if h.count(h[k])>1:                isVisiable = False                break        if isVisiable == False:            break    return isVisiable#翻转数组def rotate( matrix: [list]) -> None:    h =  matrix    for i in range(len(h)):        sub = []        count=  len(h)-1        for j in range(len(h[i])):            matrix[i][count] = h[j][i]            count -= 1    for i in range(len(matrix)):        print(matrix[i])# 保存左边的》0的值，小余0 则不保存 则保存的数据是从左往右的最大值def maxSubArray( nums: [int]) -> int:    maxNum=0    for i in range(1,len(nums)):        if nums[i-1]>0:            nums[i] = nums[i] + nums[i-1]            maxNum = nums[i] if nums[i]>maxNum else maxNum    return  maxNumclass Interval:    def __init__(self, s=0, e=0):        self.start = s        self.end = e    def p(self):        print("s:",self.start,"end:",self.end)def merge( intervals: [Interval]) -> [Interval]:    i = len(intervals)-1    def cons(val:Interval,val2:Interval):        if val.end < val2.start or val.start>val2.end:            return False;        return True;    def join(val:Interval,val2:Interval):        minS = min( val.start,val2.start)        maxE = max(val.end,val2.end)        return Interval(minS,maxE)    while i > 0:        l:Interval = intervals[i]        l_l:Interval = intervals[i-1]        if cons(l_l,l):            intervals.__delitem__(i)            intervals.__delitem__(i-1)            res = join(l_l,l)            intervals.append(res)            i -= 1        else:            i -= 1    return  intervalsclass Solution:    #70爬楼梯    def climbStairs(self, n: int) -> int:        if n<3:return n        return self.climbStairs(n-1)+self.climbStairs(n-2)    #斐波那契额数列应用    def climbStairs2(self, n: int) -> int:        if n<3:return n        count,l1,l2=0,1,1        for i in range(3,n+2):            count = l1+l2            l1 = l2            l2 = count        return count    #买卖股票最佳时机I 121    def maxProfit(self, prices: [int]) -> int:        max_p,min_proice= 0,float("inf")        for i in prices:            min_proice = min(min_proice,i)            max_p = max(max_p,i-min_proice)        return max_p    #买卖股票最佳时机II 122    def maxProfit2(self, prices: [int]) -> int:       return  sum(max(prices[i+1]-prices[i],0) for i in range(len(prices)-1))#136 用异或取反操作进行处理，双数取2次还是0，单数则不变    def singleNumber(self, nums: list) -> int:        result = 0        for i in range(len(nums)):            result  ^= nums[i]        return result#172    def trailingZeroes(self, n: int) -> int:        return 0 if n == 0 else n // 5 + self.trailingZeroes(n // 5)    def rotate(self, nums: list, k: int) -> None:        k = len(nums)%k        c = k        while c:            item = nums[len(nums)-1]            del  nums[len(nums)-1]            nums.insert(item,0)            c -=1    def largestNumber(self, nums: list) -> str:        array  = []        for i in nums:            array.append(str(i))        for i in range(len(array)):            for j in range(i+1,len(array)):                a =array[i]                b = array[j]                if a+b<b+a:                    array[i] = b                    array[j] = a        s = ''.join(array)        s = s.lstrip('0')        if len(s) == 0:            s = "0"        return s#152. 乘积最大子序列    def maxProduct(self, nums: list) -> int:        big=small=maxN=nums[0]        for i in nums[1:]:            big,small = max(i,i*big,i*small), min(i,i*big,i*small)            maxN = max(big,maxN)        return maxN#137 只出现一次的数 其他是三次    def singleNumber2(self, nums: list) -> int:            a=b=0            for i in nums:                b =b^i & ~a                a =a^i & ~b            return a|b    #18.四数之和    def fourSum(self, nums: list, target: int) -> [[int]]:        result = []        if len(nums) == 0:return []        def sumList(nu:list,tar:int,count:int) -> [[]]:            if count == 0 or len(nu) == 0:return []            if nu[0] * count > target or nu[len(nu) - 1] * count < target: return []            res = []            for i in range(len(nu)):                item1=[nu[i]]                if count == 1:                    if nu[i] == tar:                        res.append(item1)                else:                    item = sumList(nu[i+1:],tar-nu[i],count-1)                    if item:                        if len(item):                                for j in item:                                    if sum(item1 + j) == tar:                                        res.append(item1 + j)            return  res        nums.sort()        if nums[0] * 4 >target or nums[len(nums)-1] *4 < target: return[]        for i in range(len(nums)):            re = target - nums[i]            item = [nums[i]]            subItem = sumList(nums[i+1:],re,3)            if subItem:                if len(subItem):                    for j in subItem:                        new_item = item + j                        new_item.sort()                        if result.__contains__(new_item) == False and len(new_item) == 4:                            result.append(new_item)        return  result    def fourSum2(self, nums: list, target: int) -> [[int]]:        return []    #31 下一个排列    def nextPermutation(self, nums: list) -> None:        new_n = nums        new_n.sort()        print(new_n)    #46 全排列 47包含重复的元素    def permute(self, nums: list) -> [[int]]:        if len(nums) == 0:return []        elif len(nums) == 1 :return [nums]        # elif len(nums) == 2: return [nums,nums[::-1]]        else:            res = []            for k in range(len(nums)).__reversed__():                zero = nums[k]                newlist =[] + nums                newlist.pop(k)                item = self.permute(newlist)                for i in  item:                    if i:                        if len(i):                            for index in range(len(i)):                                new_item = []+i                                new_item.insert(index,zero)                                if res.__contains__(new_item) == False:                                    res.append(new_item)                            new_item = [] + i                            new_item.append(i)                            if res.__contains__(new_item):                                res.append(new_item)            return res        #旋转 二维数组    def rotate(self, matrix: [[int]]) -> None:        lenth = len(matrix)        n = int(lenth/2)        if lenth%2 ==1:            n+=1        for i in range(n):            for j in range(i,lenth-i-1):                ij=matrix[i][j]                n_j_1_i_1=matrix[lenth-j-1][i]                n_i_1_j_1=matrix[lenth-i-1][lenth-j-1]                j_n_i_1=matrix[j][lenth-i-1]                print(ij,n_j_1_i_1,n_i_1_j_1,j_n_i_1)                matrix[i][j]=n_j_1_i_1                matrix[lenth-j-1][i] = n_i_1_j_1                matrix[lenth-i-1][lenth-j-1] = j_n_i_1                matrix[j][lenth-i-1] = ij    #74二维矩阵搜索目标值    def searchMatrix(self, matrix: [[int]], target: int) -> bool:        def seatchArray(li:list,target:int)->bool:            low ,high= 0,len(li)-1            while low < high:                middle = int((low + high) / 2)                if li[middle]<target:                    low=middle+1                elif li[middle]>target:                    high = middle-1                elif li[middle] == target:                    return True            if li[low] == target:                return True            return False        for i in matrix:            if len(i):                if i[0] <=target and i[len(i)-1]>=target:                    return seatchArray(i,target)        return False    #75 颜色分类    def sortColors(self, nums: [int]) -> None:        zeroCount,f_count,s_count = 0,0,0        for i in nums:            if i == 0:                zeroCount +=1            elif i == 1:                f_count +=1            elif i == 2:                s_count +=1        for i in range(len(nums)):            if i<zeroCount:                nums[i] = 0            elif i <zeroCount+f_count:                nums[i] = 1            elif i<zeroCount+f_count+s_count:                nums[i] = 2#77 组合    def combine(self, n: int, k: int) -> [[int]]:        if n<k or k <=0 or n <=0:return []        res = []        stack = []        i,j = 1,1        while True:            if len(stack) == k:                new_stack = []+ stack                res.append(new_stack)                while True:                    if len(stack):                        popint = stack.pop()                        maxCurrentInt = n-(k-len(stack))                        if popint > maxCurrentInt:                            pass                        else:                            stack.append(popint+1)                            i = popint+2                            break                    else:                        return res            else:                stack .append(i)                i += 1    #78 子集    def subsets(self, nums: list) -> [[int]]:        nums.sort()        result = [[]]        for num in nums:            item = [i + [num] for i in result]            result += item        return result#81    def search(self, nums: list, target: int) -> bool:        return nums.__contains__(target)    #90 肯能包含重复的整数数组 的所有子集    def subsetsWithDup(self, nums: [int]) -> [[int]]:        res = [[]]        for i in nums:            item = []            for j in res:                new_item= [i]+j                new_item.sort()                if res.__contains__(new_item) == False and item.__contains__(new_item) == False and len(new_item):                    item .append(new_item)            res += item            # res +=[[i]+ j for j in res]        return  res#134加油站问题 https://leetcode.com/problems/gas-station/submissions/    def canCompleteCircuit(self, gas: list, cost: list) -> int:        cur,val,res = 0,0,0        for i in range(len(gas)):            cc = gas[i] - cost[i]            val += cc            cur += cc            if cur<0:                res = i+1                cur = 0        if val<0:return -1        else:            return res#73 矩阵置零    def setZeroes(self, matrix: [[int]]) -> None:        row = set()        h   = set()        for i in range(len(matrix)):            for j in range(len(matrix[0])):                if matrix[i][j] == 0 :                    row.add(i)                    h.add(j)        for i in row:                for j in range(len(matrix[0])):                    matrix[i][j] = 0        for i in h:                for j in range(len(matrix)):                    matrix[j][i] = 0#71简化路径    def simplifyPath(self, path: str) -> str:        array = path.split('/')        for i in  range(len(array)-1,-1,-1):            if len(array[i]) == 0:                del  array[i]            elif array[i] == '/':                del array[i]            elif array[i] == '.':                del array[i]        i = 0        while i < len(array):            if array[i] in '..':                del array[i]                i -= 1                if i >= 0:                    del array[i]                    i -=1            i += 1        return '/'+'/'.join(array)#64 最小路径和    def minPathSum(self, grid: [[int]]) -> int:        new_list:list = grid        if len(new_list) == 0:return 0        elif len(new_list) == 1:return sum(new_list[0])        w = len(new_list)        h = len(new_list[0])        for i in range(w):            for j in range(h):                if i == 0 and j == 0:continue                elif i == 0:                    new_list[i][j] += new_list[i][j-1]                elif j == 0:                    new_list[i][j] += new_list[i-1][j]                else:                    new_list[i][j] += min(new_list[i][j - 1],new_list[i-1][j])        return new_list[-1][-1]#63 不同路径II    def uniquePathsWithObstacles(self, obstacleGrid:list) -> int:        h = len(obstacleGrid)        if len(obstacleGrid) == 0:return 0        w = len(obstacleGrid[0])        new_list =[[0]*w for _ in range(h)]        if obstacleGrid[0][0] == 0:            new_list[0][0] = 1        else:            return 0        for i in range(h):            for j in  range(w):                if obstacleGrid[i][j] == 1:                    continue                if i > 0 :                    new_list[i][j] += new_list[i-1][j]                if j>0:                    new_list[i][j] += new_list[i][j-1]        return new_list[-1][-1]    def uniquePaths2(self, m: int, n: int) -> int:        if m == 0 or n == 0:return 0        new_list = [[0] * m for _ in range(n)]        new_list[0][0] = 1        h,w = n,m        for i in range(h):            for j in range(w):                if i > 0:                    new_list[i][j] += new_list[i - 1][j]                if j > 0:                    new_list[i][j] += new_list[i][j - 1]        return new_list[-1][-1]# l = [[1,2,3,4],#      [5,6,7,8],#      [9,10,11,12],#      [13,14,15,16]]l = [[0,0],[1,1],[0,0]]sol = Solution().uniquePaths2(1,1)print(sol)# ll = [#   [ 5, 1, 9,11],#   [ 2, 4, 8,10],#   [13, 3, 6, 7],#   [15,14,12,16]# ]# res = Interval(1,3)# res1 = Interval(0,2)# res2 = Interval(3,5)# rr = merge([res,res1,res2])# for i in rr:#     i.p()# def spiralOrder( matrix: [list[int]]) -> list[int]:#     if len(matrix) == 0:return []#     xMax = len(matrix)#     yMax = len(matrix[0])#     if yMax == 1:#         return  matrix[0]#     x,y = 0 ,0# ar =  [["5","3",".",".","7",".",".",".","."],#        ["6",".",".","1","9","5",".",".","."],#        [".","9","8",".",".",".",".","6","."],#        ["8",".",".",".","6",".",".",".","3"],#        ["4",".",".","8",".","3",".",".","1"],#        ["7",".",".",".","2",".",".",".","6"],#        [".","6",".",".",".",".","2","8","."],#        [".",".",".","4","1","9",".",".","5"],#        [".",".",".",".","8",".",".","7","9"]]# print( isValidSudoku(ar))