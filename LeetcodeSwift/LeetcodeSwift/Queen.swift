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
class Queen:NSObject {
    var x:Int = 0;
    var y:Int = 0;
    init(x:Int,y:Int) {
        self.x = x;
        self.y = y;
    }
    
  public  func unrejectWith(queen:Queen) -> Bool {
    var ff = true;
    let pp = queen;
    
    let x:Int   = pp.x;
    let y:Int   = pp.y;
    let x1:Int  = self.x ;
    let y1:Int  = self.y ;
    
    if  (x == x1 || y == y1 ||
        (abs(x-x1) == abs(y-y1))){
        ff = false
    }else{
        ff = true;
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
        let q1 = Queen(x: queen.x,
                       y: queen.y);
        
            for k in 0..<count{
                let subP = Queen(x: 0, y: 0);
                subP.x = queens[k].x;
                subP.y = queens[k].y;

                let qSub = Queen(x: subP.x,
                                 y: subP.y);
                if qSub.unrejectWith(queen: q1) == false{
                    //有能打架的皇后
                    pass = false;
                    break;
                }
            }
        
        return pass;
    }
    //递归解法
    mutating func callback(x: Int,y: Int , n: Int) -> Void {
        let q = Queen(x: x, y: y);
        var xx = x;
        var yy = y;
        let xyMax = n - 1;
        
        
        if xx >= n || yy >= n || xx < 0 || yy < 0 {
            return;
        }
        let can = self.canStandWithOthers(queens: self.queensArray, queen: q);
        if can {
            self.queensArray.append(q);
            //解法
            if (self.queensArray.count < n){
                xx = 0;
                yy = q.y + 1;
                callback(x: xx,
                         y: yy,
                         n: n);
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
                    callback(x: xx,
                             y: yy,
                             n:n);
                }else{
                    callback(x: xx,
                             y: yy,
                             n:n);
                }
            }
        }else {//添加失败
            if(xx < xyMax){
                xx += 1;
                callback(x: xx,
                         y: yy,
                         n:n);
            }else if(xx >= xyMax){
                if self.queensArray.count > 0{
                    let lastQ = self.queensArray.removeLast();
                    xx = lastQ.x + 1;
                    yy = lastQ.y;
                    if xx > xyMax && self.queensArray.count > 0{
                        let lastQ2 = self.queensArray.removeLast();
                        xx = lastQ2.x + 1;
                        yy = lastQ2.y;
                    }
                    callback(x: xx, y: yy, n:n);
                }
            }
        }
    }
    //迭代解法
    public mutating func handle() -> Void {
        let number = 0
        self.find(index: number);
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
                    if(self.queensArray.count == 8){
                        self.queensWay.append(self.queensArray);
                        self.queensArray.removeLast();
                        x = queen.x + 1;
                        y = queen.y;
                        if x == 8{
                            let  last = self.queensArray.removeLast();
                            x = last.x + 1;
                            y = last.y;
                        }
                    }else{
                        x = 0;
                        y = queen.y + 1;
                    }
                }else{
                    x += 1;
                    if x == 8{
                        let  last = self.queensArray.removeLast();
                        x = last.x + 1;
                        y = last.y;
                        if x == 8 && self.queensArray.count > 0{
                            let  last2 = self.queensArray.removeLast();
                            x = last2.x + 1;
                            y = last2.y;
                        }
                    }
                    if x == 8 && y == 0{
                        x = 8;
                        y = 8;//跳出循环
                    }
                }
            }else{//添加成功跳出循环
                self.queensArray.append(queen);
                x = 0;
                y = queen.y + 1;
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


