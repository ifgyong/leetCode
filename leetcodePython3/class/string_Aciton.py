#!/usr/bin/python3
# -*- coding: utf-8 -*-
#//
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
# @Time    : 2019/4/1 下午2:18
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : string_Aciton.py
# @Software: PyCharm
import math
def isValid2( s: str) -> bool:
    sArray = [];
    for i in s:
        sArray += (i);
    count = len(sArray)
    if count%2 == 1:
        return  False;
    visi = True
    keys = {"(": ")", "[": "]", "{": "}"}
    i = 0;
    while len(sArray) > 1 and i < count-1:
        count = len(sArray)
        i_i = sArray[i];
        i_i1 = sArray[i + 1];
        if keys.keys().__contains__(i_i):
            if keys[i_i] is i_i1:
                del sArray[i + 1]
                del sArray[i]
                i -= 1;
                if i < 0:
                    i = 0;
            else:
                i += 1;
        else:
            i += 1;
        count = len(sArray);

    if len(sArray) == 0:
        return True;
    return False;
def isValid( s: str) -> bool:
    sArray = [];
    for i in s:
        sArray += (i);
    count = len(sArray)
    visi = True
    keys = {"(":")","[":"]","{":"}"}

    while visi and len(sArray)>1:
        count = len(sArray)
        for i in range(len(sArray)-1):
            i_i =  sArray[i];
            i_i1= sArray[i+1];
            if keys.keys().__contains__(i_i):
                if keys[i_i] is i_i1:
                    del  sArray[i+1]
                    del  sArray[i]
                    break;

        if len(sArray) == count:
            visi = False;

    if len(sArray) == 0:
        return  True;
    return False;

#searchInsert({1,2,3,4},target=4);
def longesPalindrome(s:str)->str:
    def isPalindrome(subStr:str) ->bool:
        length = int(len(subStr)/2)
        fullLength = len(subStr);
        isp = True;
        for i in range(0,length):
            l = subStr[i]
            r = subStr[fullLength-i-1]
            if l != r:
                isp = False
                break
        return  isp;
    maxLength = 0;
    pali = ""
    if len(s)<2:
        return  s;
    for i in reversed(range(0,len(s)+1)):
        if maxLength != 0:
            break;
        for j in range(0,len(s)-i+1):
            sub = s[j:j+i]
            sub_l = len(sub)
            if sub_l > 1:
                isSub = isPalindrome(sub)
                if isSub:
                    pali = sub
                    maxLength = sub_l
                    break
            else:
                maxLength = 1
                pali = sub
                break
    return  pali

# 72 ms 最长回文字符串
def longestPalindrome2( s: str) -> str:
    if len(s) == 0:
        return ""
    maxLen = 1
    start = 0
    for  i in reversed(range(len(s))):
        if i-maxLen >= 1 and s[i-maxLen-1:i+1] == s[maxLen-1:i+1][::-1]:
            start = i - maxLen -1
            maxLen += 1
            continue;
        if i - maxLen>=0 and  s[i - maxLen - 1:i + 1] == s[i - maxLen - 1:i + 1][::-1]:
            start = i - maxLen
            maxLen += 1
    return  s[start:start+maxLen]

def longestValidParentheses( s: str) -> int:
    maxlen = 1
    start = 0
    for i in range(len(s)):
        old = s[i-maxlen-1:i+1]
        new =  s[i-maxlen-1:i+1][::-1]
        if i-maxlen>=1 and old == new:
            maxlen +=2
            start = i-maxlen-1
    return maxlen

class Solution:
    #波兰表达式计算器
    def evalRPN(self, tokens: list) -> int:
        if len(tokens) == 0:return 0
        elif len(tokens)==1:return int(tokens[0])
        else:
            count = 0
            i = 0
            con = "+-*/"
            while i<len(tokens):
                if con.__contains__(tokens[i]):
                    nu1 = int(tokens[i - 2])
                    nu2 = int(tokens[i - 1])
                    index = con.index(tokens[i],0,len(con))
                    if index == 0:
                        count = nu1 + nu2
                    elif index == 1:
                        count = nu1 - nu2
                    elif index == 2:
                        count = nu1 * nu2
                    elif index == 3:
                        count = int( nu1 / nu2)
                    tokens.__delitem__(i)
                    tokens.__delitem__(i-1)
                    tokens.__delitem__(i-2)
                    tokens.insert(i-2,str(count))
                    i -=2
                    if len(tokens) == 1:
                        break
                i +=1
            return count
    #125
    def isPalindrome(self, s: str) -> bool:
        new = ""
        con = "0123456789"
        for i in s:
            if (i.lower() <= "z" and i.lower() >= 'a')or(con.__contains__(i)):
                new +=i.lower()
        return  new == new[::-1]
    #171
    def titleToNumber(self, s: str) -> int:
        nums =[]
        for i in range(1,26):
            nums.append(i)
        count = 0
        for i in range(len(s)):
            x = s[::-1][i]
            xx = ((ord(x) - 65+1))* pow(26,i)
            count += xx
        return count
    #187
    def findRepeatedDnaSequences(self, s: str) -> list:
        if len(s)<10:
            return []
        keys = set()
        array = set()
        for i in range(0,len(s)-9):
            sub = s[i:i+10]
            if sub in keys and sub not  in array:
                array.add(sub)
            else:
                keys.add(sub)
        return list(array)
    #166. 分数到小数 未完成
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator ==0 or denominator == 0:return ''
        isReapt =False
        s = ''
        n = numerator
        de = denominator
        while not isReapt:
            ne = math.floor(n/de)
            if ne > 0:
                item = ne
                s += str(item)
                n = n%de if n%de != 0 else 0
                if n == 0:
                    break
            else:
                if len(s) and not s.__contains__('.'):
                    s += '.'
                elif len(s)==0:
                    s ='0.'
                item = math.floor(n*10/de)
                s += str(item)
                n = n*10 % de if n*10 % de != 0 else 0
                if n == 0:
                    break
        return  s
    #165 比较版本号
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = version1.split(".")
        v2 = version2.split(".")
        length = max(len(v1), len(v2))
        res = 0
        for i in range(length):
            l1 =int(v1[i] if i <len(v1) else 0)
            l2 =int(v2[i] if i < len(v2) else 0)
            if l1<l2:
                res= -1
                break
            elif l1>l2:
                res = 1
                break
        return res

    # 162. 寻找峰值
    def findPeakElement(self, nums: list) -> int:

        def findPeak(ns:list,l:int,h:int)->int:
            if l == h:return l
            if l+1 == h:return l if ns[l]>ns[h] else h
            m = math.floor((l+h)/2)
            if ns[m] >ns[m-1] and ns[m]>ns[m+1]:return m
            elif ns[m-1]>ns[m] and ns[m]>ns[m+1]:
                return findPeak(ns,l,m)
            else:return findPeak(ns,m+1,h)
        return   findPeak(nums,0,len(nums)-1)
    def findPeakElement2(self, nums: list) -> int:
        if len(nums) == 1:return 0
        l ,h= 0,len(nums)-1
        ns = nums
        while True:
            m = math.floor((l + h) / 2)
            if ns[m] >ns[m-1] and ns[m]>ns[m+1]:return m
            elif ns[m-1]>ns[m] and ns[m]>ns[m+1]:
                h=m
            else:l=m+1
            if l == h: return l
    #153. 寻找旋转排序数组中的最小值
    def findMin(self, nums: list) -> int:
        return  min(nums)
    def findMin2(self, nums: list) -> int:
        l ,h= 0,len(nums)-1
        if l == h:return nums[0]
        while l!=h:
            if l +1 == h:
                l= l if nums[l]<nums[h] else h
                break
            m = int((l+h)/2)
            if nums[m]<nums[h]:
                h=m
            elif nums[m]>nums[h]:
                l=m
        return nums[l]

    #151
    def reverseWords(self, s: str) -> str:
        s_new:list = s.split(' ')[::-1]
        s_array=[]
        for i in s_new:
            s_sub = i.strip()
            if len(s_sub):
                s_array.append(s_sub)
        return ' '.join(s_array).strip()
    #139. 单词拆分
    def wordBreak(self, s: str, wordDict: list) -> bool:
        if len(s) == 0:return True
        i,j,h = 1,0,len(s)
        isAll = True
        while h:
            ss=s[j:i]
            if wordDict.count(ss)>0:
                j = i
                i+= len(ss)
                isAll = True
            else:
                i+=1
                isAll = False


        return False
#132 分割回文字符串
    def partition(self, s: str) -> [[str]]:
        if len(s)==1:return [[s]]
        array=[]
        for i in range(1,len(s)+1):
            s_sub,item = s[0:i],[]
            if s_sub == s_sub[::-1]:
                item.append(s_sub)
                if s_sub != s:
                    item2 = self.partition(s[i:len(s)+1])
                    if len(item2):
                        for j in item2:
                            if len(''.join(item + j)) == len(s):
                                array.append(item + j)
                else:
                    array.append(item)
        return array
#79 单词搜索 XXX
    def exist(self, board: [[str]], word: str) -> bool:
        if len(board) == 0:return False
        if word is None:return False
        def isExistin(bo:[[str]],ch: str,x:int,y:int) -> bool:
            if x<len(bo[0]) and y<len(bo) and x >= 0 and y >= 0:
                return bo[x][y] in  ch

        w = len(board[0])
        h = len(board)
        index = 0
        i,j = 0,0
        res = []
        while j<h:
            item = board[j]
            s_sub =  word[index:index+1]
            if item.__contains__(s_sub) and ([i,j] in res) == False:
                if len(res):
                    last = res[len(res)-1]
                    if abs(abs(last[0] -i) - abs(last[1]-j)) == 1:
                        res.append([i,j])
                    else:
                        continue
                else:
                    res.append([i,j])
                i = item.index(s_sub, 0, len(item))
                indexs = []
                while True:
                    if indexs.__contains__([i,j]) == False:
                        indexs.append([i,j])
                        index +=1
                        x,y= i,j
                        if index >= len(word):
                            return True
                        s = word[index:index+1]
                        if isExistin(board,s,x+1,y) and indexs.__contains__([x+1,y])==False:
                                i = x + 1
                        elif isExistin(board,s,x-1,y) and indexs.__contains__([x-1,y])==False:
                                i = x - 1
                        elif isExistin(board,s,x,y-1) and indexs.__contains__([x,y-1])==False:
                                j = y - 1
                        elif isExistin(board,s,x,y+1) and indexs.__contains__([x,y+1])==False:
                                j = y + 1
                        else:
                            break
            else:
                j +=1
        return False
    #80删除重复选项
    def removeDuplicates(self, nums: list) -> int:
        i = len(nums)-1
        isRepeat = False
        while i >=1:
            if nums[i] == nums[i-1] and isRepeat:
                nums.pop(i)
            elif nums[i] == nums[i-1]:
                isRepeat = True
            elif nums[i] != nums[i-1]:
                isRepeat = False
            i -= 1
        return  len(nums)
    #91解码方法
    def numDecodings(self, s: str) -> int:
        if len(s) == 0: return 0
        if len(s) == 1:
            if int(s) == 0: return 0
            return 1
        elif len(s) == 2 and int(s) < 27 and int(s) > 0:
            if int(s[0:1]) == 0:
                return 0
            if int(s[1:2]) == 0:
                return 1
            return self.numDecodings(s[1:]) + 1
        elif len(s) >= 2:
            if int(s[0:1]) == 0:
                return 0
            x = self.numDecodings(s[1:])
            y = self.numDecodings(s[2:])
            m = x + y if x != 0 and y != 0 else 0
            return m




s = Solution().numDecodings("301")
print(s)