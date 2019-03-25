//
//  Queen.swift
//  LeetcodeSwift
//
//  Created by fgy on 2019/3/22.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation
struct Point {
    var x:Int = 0;
    var y:Int = 0;
    
    
    init(x:Int ,y:Int) {
        self.x = x;
        self.y = y;
    }
}

/// 8皇后算法
struct Queen {
    var x:Int = 0;
    var y:Int = 0;
    init(x:Int,y:Int) {
        self.x = x;
        self.y = y;
    }
    
  public  func unrejectWith(queen:Queen) -> Bool {
        var ff = true;
        autoreleasepool{
            let x   = queen.x;
            let y   = queen.y;
            let x1   = self.x ;
            let y1  = self.y ;
            
            if  (x == x1 || y == y1 ||
                (abs(x-x1) == abs(y-y1))) &&
                (x>=0 && y >= 0 && x<=7 && y <= 7) &&
                (x1 >= 0 && y1 >= 0 && x1 <= 7 && y1 <= 7){
                ff = false
            }else{
                ff = true;
            }
        }
        return ff;
    }
  public  func printQueen() -> Void {
        var ss = ""

        for i in 0...8 {
            if i == self.x {
                ss += "* "
            }else{
                ss += "_ "
            }
        }
        print(ss);
    }
}
struct QueenHandle {
    var queensArray:[Queen] = [Queen]();
    var queensWay:[[Queen]] = [[Queen]]();
    
    init() {
    }
    func canStandWithOthers(queens:[Queen],queen:Queen) -> Bool {
        var pass = true;
        let count = queens.count;
        if count == 0 {
            return true;
        }
        let q1 = Queen(x: queen.x, y: queen.y);
        
        autoreleasepool{
            for k in 0..<count{
                let qSub = Queen(x: queens[k].x, y: queens[k].y);
                if qSub.unrejectWith(queen: q1) == false{
                    //有能打架的皇后
                    pass = false;
                    break;
                }
            }
        };
        
        return pass;
    }
    //递归解法
    mutating func callback(x: Int,y: Int , n: Int) -> Void {
        let q = Queen(x: x, y: y);
        var xx = x;
        var yy = y;
        
        
        if xx >= n || yy >= n {
            return;
        }
        let can = self.canStandWithOthers(queens: self.queensArray, queen: q);
        if can {
            self.queensArray.append(q);
            xx = 0;
            //解法
            if (self.queensArray.count < n){
                yy = q.y + 1;
                callback(x: xx, y: yy, n: n);
            }else{//找到其中一个方案
                self.queensWay.append(self.queensArray);
                self.printOneWay(List: self.queensArray);
                self.queensArray.removeLast();
                xx = q.x + 1;
                yy = q.y;
                if (xx >= n){
                    let queenSub2 = self.queensArray.removeLast();
                    xx = queenSub2.x+1;
                    yy = queenSub2.y;
                    callback(x: xx, y: yy, n:n);
                }else{
                    callback(x: xx, y: yy, n:n);
                }
            }
        }else {//添加失败
            if(xx < n-1){
                xx += 1;
                callback(x: xx, y: yy, n:n);
            }else if(xx >= n-1){
                if self.queensArray.count > 0{
                    let lastQ = self.queensArray.removeLast();
                    xx = lastQ.x + 1;
                    yy = lastQ.y;
                    
                    if xx > n-1{
                        let lastQ2 = self.queensArray.removeLast();
                        xx = lastQ2.x + 1;
                        yy = lastQ2.y;
                    }
                    if xx >= n-1 && yy == 0{
                        return;
                    }
                    callback(x: xx, y: yy, n:n);                }
            }
        }
    }
    //迭代解法
    public mutating func handle() -> Void {
        var number = 0
        
        while number<92 {
            self.find(index: number);
            //首行的8种可能
            if self.queensArray.count == 8 {
                self.queensWay.append(self.queensArray);
            }
            self.queensArray.removeAll();
            number += 1;
        }
    
    }
    public mutating func find(index:Int) -> Void
{
    var y = 0;
    var x = index;
    while y<8 {
        while x<8{
            let queen = Queen(x: x, y: y);
            let count = self.queensArray.count;
            
            if count>0 {
                var pass = true;
                for k in 0..<count{
                    let qSub = self.queensArray[k];
                    if qSub.unrejectWith(queen: queen) == false{
                        //有能打架的皇后
                        pass = false;
                        break;
                    }
                }
                if pass{//添加成功
                    self.queensArray.append(queen);
                    break;
                }else{
                    x += 1;
                }
            }else{//添加成功跳出循环
                self.queensArray.append(queen);
                break;
            }
        }
        //每一行找出一个 跳下一行
        if(self.queensArray.count == y+1){
            y += 1;
            x = 0;
        }else{
            if self.queensArray.count > 0{
                while x > 7{
                    //回溯法 寻找上一个可能的皇后 当x==8，继续找上一行的皇后
                    x = self.queensArray.removeLast().x + 1;
                    y -= 1;
                }
            }else{
                y += 1;
            }
        }
    }
}
    public func printWays() -> Void{
        let count = self.queensWay.count;
        for i in 0..<count {
            let queens = self.queensWay[i];
            let countSub = queens.count;
            var s = "";
            
            for j in 0..<countSub{
                let q = queens[j];
                s += "\(q.x)";
            }
            print(s);
        }
        print("皇后数量：\(self.queensWay.count)--------------------");
    }
    public func printOneWay(List:[Queen]) -> Void{
            let countSub = List.count;
            var s = "";
            for j in 0..<countSub{
                let q = List[j];
                s += "\(q.x)";
            }
            print(s);
        print("皇后数量：\(self.queensWay.count)--------------------");
    }
}


