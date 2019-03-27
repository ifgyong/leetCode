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
        printTree(list: self.valsArray);
        
        self.valsArray.removeAll();
        travIn_L(tree: t);
        printTree(list: self.valsArray);

        self.valsArray.removeAll();
        travIn_R(tree: t);
        printTree(list: self.valsArray);

        self.valsArray.removeAll();
    }
    
    func createTree() -> Tree {
        let top = Tree.loadTree(val: 0);
        let l_1 = Tree.loadTree(val: 1);
        let l_2 = Tree.loadTree(val: 2);
        let r_1 = Tree.loadTree(val: 3);
        let r_2 = Tree.loadTree(val: 4);
        top.left = l_1;
        top.right = r_1;
        l_1.left = l_2;
        r_1.left = r_2;
        return top;
    }
    func travIn_C(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        self.valsArray.append(tree?.val ?? 0);
        travIn_C(tree: tree?.left);
        travIn_C(tree: tree?.right);
    }
    func travIn_L(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        travIn_L(tree: tree?.left);
        self.valsArray.append(tree?.val ?? 0);
        travIn_L(tree: tree?.right);
    }
    func travIn_R(tree:Tree?) -> Void {
        if tree == nil{
            return;
        }
        travIn_R(tree: tree?.left);
        travIn_R(tree: tree?.right);
        self.valsArray.append(tree?.val ?? 0);
    }
    func printTree(list:[Int]) -> Void {
        print(list);
    }
}
