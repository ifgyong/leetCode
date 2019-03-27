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
    
    func handle() -> Void {
        let t = createTree();
        travIn_C(tree: t);
        printTree(list: self.valsArray,type: 1);
        self.valsArray.removeAll();
        
        travIn_I_C(tree: t);
        printTree(list: self.valsArray,type: 1);
        self.valsArray.removeAll();
        
        travIn_I_L(tree: t);
        printTree(list: self.valsArray,type: 0);
        self.valsArray.removeAll();
        
        travIn_L(tree: t);
        printTree(list: self.valsArray,type: 0);
        self.valsArray.removeAll();
        
        
        travIn_R(tree: t);
        printTree(list: self.valsArray,type: 2);
        self.valsArray.removeAll();
        travIn_I_R(tree: t);
        printTree(list: self.valsArray,type: 2);
        self.valsArray.removeAll();
    }
    
    func createTree() -> Tree {
        //    0
        //   1  2
        // 3 4 5 6
        let top = Tree.loadTree(val: 0);
        let l_1 = Tree.loadTree(val: 1);
        let l_2 = Tree.loadTree(val: 3);
        let l_4 = Tree.loadTree(val: 4);
        let r_1 = Tree.loadTree(val: 2);
        let r_2 = Tree.loadTree(val: 5);
        let r_3 = Tree.loadTree(val: 6);

        top.left = l_1;
        top.right = r_1;
        l_1.left = l_2;
        l_1.right = l_4;
        r_1.left = r_2;
        r_1.right = r_3;
        return top;
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
    func printTree(list:[Int],type:Int) -> Void {
        if type == 0 {
            print("前序遍历");
        }else if type == 1{
            print("中序遍历");
        }else if type == 2{
            print("后序遍历");
        }
        print(list);
    }
}
