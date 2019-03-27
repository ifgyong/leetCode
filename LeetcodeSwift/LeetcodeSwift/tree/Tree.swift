//
//  Tree.swift
//  LeetCodeOC
//
//  Created by Charlie on 2019/3/26.
//  Copyright © 2019年 test. All rights reserved.
//
import Foundation

class Tree : NSObject {
    var val = 0;
    var left:Tree?;
    var right :Tree?;
    override init() {
        super.init();
    }
    class func loadTree(val:Int)->Tree{
        let t = Tree();
        t.val = val;
        return t;
    }
}

class Treehandle: NSObject {
    var valsArray = [Int]();
    var treesAray = [Tree]();
    var depth = 0;
    var vals = [Int]();
    var top:Tree?;
    
    func handle() -> Void {
        let t = createTree();
        trav_L_r(tree: t!);
        for i in 0..<self.treesAray.count {
            let t = self.treesAray[i];
            self.valsArray.append(t.val);
        }
        printTree(list: self.valsArray,type: 3);
        self.valsArray.removeAll();
//
//        travIn_I_C(tree: t);
//        printTree(list: self.valsArray,type: 1);
//        self.valsArray.removeAll();
//
//        travIn_I_L(tree: t);
//        printTree(list: self.valsArray,type: 0);
//        self.valsArray.removeAll();
//
//        travIn_L(tree: t);
//        printTree(list: self.valsArray,type: 0);
//        self.valsArray.removeAll();
//
//
//        travIn_R(tree: t);
//        printTree(list: self.valsArray,type: 2);
//        self.valsArray.removeAll();
//        travIn_I_R(tree: t);
//        printTree(list: self.valsArray,type: 2);
//        self.valsArray.removeAll();
    }
    func createTree() -> Tree? {
        self.vals = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
        
        self.top = createTreeWithArray(list: self.vals);
        return top;
    }
    func createTreeWithArray(list:[Int]) -> Tree {
        let length = list.count/2-1;
        
        var tArray:[Tree] = [Tree]();
        
        //生成数组 🌲
        for i in 0..<list.count{
            let tsub = Tree.loadTree(val: list[i]);
            tArray.append(tsub);
        }
        //构造二叉树🌲
        for i in 0..<length{
            let t :Tree = tArray[i];
            //构造左孩子
            t.left = tArray[i*2+1];
            //构造右孩子
            t.right = tArray[i*2+2];
        }
        //构造最后一个做孩子
        tArray[length].left = tArray[length*2+1];
        if list.count%2 == 1{//若数组为奇数则存在右孩子
            tArray[length].right = tArray.last;
        }
        //返回 topTree
        return tArray[0];
    }
    //中序遍历
    func travIn_C(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        travIn_C(tree: tree?.left);
        self.valsArray.append(tree?.val ?? 0);
        travIn_C(tree: tree?.right);
    }
    //中序遍历
    func travIn_I_C(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        var t = tree;
        while true {
            while t != nil {
                self.treesAray.append(t ?? Tree());
                t = t?.left;
            }
            if self.treesAray.count == 0 {
                break;
            }
            t = self.treesAray.removeLast();
            self.valsArray.append(t?.val ?? -1);
            //有右结点 则向右移动一个节点
            if t?.right != nil{
                t = t?.right;
            }else{//否则删除已经添加好的结点
                t = nil;
            }
        }
    }
    //先序遍历
    func travIn_I_L(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        var t = tree;
        while true {
            while t != nil {
                self.valsArray.append(t?.val ?? -1);
                if t?.right != nil{
                    self.treesAray.append(t?.right ?? Tree());
                }
                t = t?.left;
            }
            if self.treesAray.count == 0 {
                break;
            }
            t = self.treesAray.removeLast();
        }
    }
    //先序遍历
    func travIn_L(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        self.valsArray.append(tree?.val ?? 0);
        travIn_L(tree: tree?.left);
        travIn_L(tree: tree?.right);
    }
    //后续遍历
    func travIn_R(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        travIn_R(tree: tree?.left);
        travIn_R(tree: tree?.right);
        self.valsArray.append(tree?.val ?? 0);
    }
    //后续遍历
    func travIn_I_R(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        var t = tree;
        while true {
            while t != nil {
                self.treesAray.append(t ?? Tree());
                t = t?.left;
            }
            if self.treesAray.count == 0 {
                break;
            }
            t = self.treesAray.last;
            //有右结点 则向右移动一个节点
            if t?.right != nil{
                t = t?.right;
            }else{//否则删除已经添加好的结点
                self.valsArray.append(t?.val ?? -1);
                self.treesAray.removeLast();
                
                if self.treesAray.count > 0 {
                    let t1 = self.treesAray.last;
                    t1?.left = nil;
                    if t1?.right == t{//判断是否是向上攀爬 YES则删除右结点，否则不删除
                        t1?.right = nil;
                    }
                }
                t = nil;
            }
        }
    }
    //层序遍历
    func trav_L_r(tree:Tree) -> Void {
        var i = 0
        self.treesAray.append(tree);
        while true {
            if i >= self.treesAray.count{break};
            let t = self.treesAray[i];
            if t.left != nil{
                self.treesAray.append(t.left ?? Tree());
            }
            if t.right != nil{
                self.treesAray.append(t.right ?? Tree());
            }
            i += 1;
        }
    }
    func printTree(list:[Int],type:Int) -> Void {
        if type == 0 {
            print("前序遍历");
        }else if type == 1{
            print("中序遍历");
        }else if type == 2{
            print("后序遍历");
        }else if type == 3{
            print("层序遍历");
        }
        print(list);
    }
}
