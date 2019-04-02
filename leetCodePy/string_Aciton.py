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
                    break;
            else:
                maxLength = 1
                pali = sub;
                break;
    return  pali;
longstr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

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
    maxlen = 1;
    start = 0;
    for i in range(len(s)):
        old = s[i-maxlen-1:i+1]
        new =  s[i-maxlen-1:i+1][::-1]
        if i-maxlen>=1 and old == new:
            maxlen +=2;
            start = i-maxlen-1;
    return maxlen


ss = "()()()";
s = longestValidParentheses(ss)
print(s)



