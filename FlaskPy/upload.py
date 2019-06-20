import requests


url_path='127.0.0.1:5000/upload'
im = open('/Users/fgy/Desktop/iOS高级开发4年.doc','rb')
file ={'files':('name',im,'multipart/form-data',{})}#后边的是其他参数
print(im)
r = requests.post(url_path,data={'name':'lisi'})
print(r.text)