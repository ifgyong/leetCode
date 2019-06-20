from flask import Flask
from flask import  request
from flask import jsonify
from werkzeug import secure_filename


app = Flask(__name__)


@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/upload',methods=['POST','GET'])
def upload():
    age = request.form.to_dict()
    gt =request.args.to_dict()
    if request.method == 'POST':
        ff = request.files['file']
        if not ff:
            return jsonify({'error':'没有文件'})
        else:
            ff.save(secure_filename(ff.filename))
            return jsonify({'msg':'文件保存成功'})

    # name = request.form['name']
    f =  request.files
    return jsonify(gt)
if __name__ == '__main__':
    app.run()
