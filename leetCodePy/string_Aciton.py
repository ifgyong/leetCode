#!/usr/bin/env python
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


s  = "{[]}"
print( isValid2(s));


