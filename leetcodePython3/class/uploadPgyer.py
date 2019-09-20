#!/usr/bin/python
# -*- coding: utf-8 -*-
# @Time    : 2019-06-20 15:05
# @Author  : fgyong 简书:_兜兜转转_  https://www.jianshu.com/u/6d1254c1d145
# @Site    : http://fgyong.cn 兜兜转转的技术博客
# @File    : uploadPgyer.py
# @Software: PyCharm

import os
import requests
from flask import jsonify
from requests_toolbelt import MultipartEncoder, MultipartEncoderMonitor
import sys
import time


class UpLoadIPA:

    file_size = 1
    def pack(self):#打包
        pass
    def upload(self):#上传
        self.progress=0
        self.fileName = urlPath+scheme_Name+'.ipa'#'/Users/Jerry/Desktop/doctor-iphone/doctor-iphone.ipa'
        self.fileName = '/Users/Jerry/Desktop/Demo/test/test.ipa'
        self.file_size=os.path.getsize(self.fileName)/1024/1024.0
        url = "http://www.pgyer.com/apiv2/app/upload?" \
              "_api_key=2e8571d626b9a8c8b752e59624481847&" \
              "userKey=e34bf7d5e70d78339d60ea7bb68867c8&" \
              "enctype=multipart/form-data"
        file = open(self.fileName)
        filejson = {'file': ('doctor-iphone', file)}  # 后边的是其他参数
        e = MultipartEncoder(fields=filejson)
        m = MultipartEncoderMonitor(e,callback=self.callBack)
        # r = requests.post(url, files=filejson)#没有进度展示
        r = requests.post(url,data=m,headers={'Content-Type': m.content_type})
        j = r.json()
        if j:
            jsReult = j
            print ('\n')
            if j['code'] == '0':

                print ('**upload success!\n ipa下载地址：'+jsReult['buildShortcutUrl']+'**')
            else:
                print ('**fail:' + jsReult['message']+'**')

    def callBack(self,monitor):
        self.progress = monitor.bytes_read//1024/1024.0
        progress = str(round(self.progress/self.file_size,2))
        log = '\r 上传ipa进度：'+progress+'% 总大小:'+str(round(self.file_size,2))+'M'
        print (log)

    def curlUpload(self):
        filePath = '/Users/Jerry/Desktop/doctor-iphone/doctor-iphone.ipa'
        filePath = '/Users/Jerry/Desktop/Demo/test/test.ipa'
        # ret = os.system('gym --scheme '+pro_name)
        os.system("curl -F 'file=@"+filePath+"' -F '_api_key=2e8571d626b9a8c8b752e59624481847'"
                                         " http://www.pgyer.com/apiv2/app/upload")



archive_Path = './arch'
scheme_Name = 'doctor-iphone'
project_name = scheme_Name+'.xcworkspace'
# urlPath = '/Users/Jerry/Desktop/Demo/test/'
urlPath = '/Users/Jerry/Desktop/doctor-iphone/'
PlistPath = urlPath+'exportOptionsPlist.plist'
#编译
cmd = "xcodebuild archive    -archivePath '"+archive_Path+"' " \
                            "-project '"+urlPath+scheme_Name+".xcworkspace' " \
                            "-scheme '"+scheme_Name+"' " \
                            "-configuration Debug -sdk iphoneos12.2"
print(cmd)
os.system(cmd)
#打包ipa
export= "xcodebuild -exportArchive -archivePath '"+urlPath+archive_Path+".xcarchive' " \
                                   "-exportPath '"+urlPath+"'" \
                                   " -exportOptionsPlist "+PlistPath
print(export)
os.system(export)
UpLoadIPA().upload()