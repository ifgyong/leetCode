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
    
    
    func handle() -> Void {
        let t = createTree();
        travIn_C(tree: t);
        printTree(list: self.valsArray);
//        
//        self.valsArray.removeAll();
//        travIn_L(tree: t);
//        printTree(list: self.valsArray);
//
//        self.valsArray.removeAll();
//        travIn_R(tree: t);
//        printTree(list: self.valsArray);
//
//        self.valsArray.removeAll();
    }
    
    func createTree() -> Tree {
//        let top = Tree.loadTree(val: 0);
//        let l_1 = Tree.loadTree(val: 1);
//        let l_2 = Tree.loadTree(val: 2);
//        let r_1 = Tree.loadTree(val: 3);
//        let r_2 = Tree.loadTree(val: 4);
//        top.left = l_1;
//        top.right = r_1;
//        l_1.left = l_2;
//        r_1.left = r_2;
//        return top;
        let list = [0,1,2,3,4,5,6,7,8,9,10];
        
        let top:Tree = Tree.loadTree(val: list[0]);
        
        self.depth = depth(list: list);
        top = createTreeWithArray(t: top, dept: 0, index: 0,count: list.count,inlineIndex: 0);
        return top;
        
    }
    func depth(list:[Int]) -> Int {
        var count = list.count;
        var  number = 0
        
        while count>0 {
            count /= 2;
            number += 1;
        }
        return number;
    }
    func createTreeWithArray(t:Tree,dept:Int,index:Int,count :Int,inlineIndex:Int) -> Tree {
        if t == nil {
            if depth > self.depth || index >= count{
                return nil;
            }
        }
        t.left = createTreeWithArray(t: t, dept: dept,
                                     index: index+1,count: count,
                                     inlineIndex: inlineIndex + dept*2);
        t.right = createTreeWithArray(t: t, dept: dept,
                                      index: index+2,count: count,
                                      inlineIndex: inlineIndex+dept*2+1);
        
        return t;
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
