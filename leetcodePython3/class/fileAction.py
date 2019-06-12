#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Time    : 2019-06-12 14:20
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : fileAction.py
# @Software: PyCharm
import os
import shutil
import time

class FileManger:

    def getAllFileAndDir(self,pwd):
        if not pwd:
            print(os.listdir(pwd))
        else:
            print('path is null')
# manger = FileManger()
# path = os.getcwd()
# manger.getAllFileAndDir(path)



old_path = "/Users/Jerry/Desktop/11"
new_path = "/Users/Jerry/Desktop/11_copy"
times_sleep_s = 10#60*60*24

def getSubDic(old_p):
    f = os.listdir(old_p)
    for item in f:
        if item[0] == '.':
            continue
        sub_path = '/'+item
        full_sub_path = old_p+sub_path
        # if os.path.exists(full_sub_path):
        if os.path.isdir(full_sub_path):#遍历目录
            print(full_sub_path+' is exit')
            getSubDic(full_sub_path)
        elif os.path.isfile(full_sub_path):#移动文件
            getMoveToPath(full_sub_path)
        else:
            print("error:"+full_sub_path+" not understand")

def getMoveToPath(sub_Path):
    if os.path.exists(new_path):
        if sub_Path:
            # r_index = sub_Path.rfind(old_path,0,len(sub_Path))
            full_new_path = new_path + sub_Path[len(old_path):]
            full_old_path = sub_Path
            new_path_dir = os.path.dirname(full_new_path)
            if os.path.exists(new_path_dir):#目录是否存在
                if os.path.exists(full_new_path):#文件存在
                    if os.path.getsize(full_new_path) != os.path.getsize(full_old_path):
                        print('正在复制文件:' + full_new_path)
                        shutil.move(full_old_path,full_new_path)
                else:
                    print('正在复制文件:' + full_new_path)
                    shutil.move(full_old_path,full_new_path)


            else:
                os.makedirs(new_path_dir)
                getMoveToPath(sub_Path)
    else:
        os.mkdir(new_path)
        getMoveToPath(sub_Path)

if  __name__ == '__main__':
    while True:
        getSubDic(old_path)
        print("循环一次")
        time.sleep(times_sleep_s)