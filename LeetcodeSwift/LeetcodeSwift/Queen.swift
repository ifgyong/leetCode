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
    var locations:Point = Point(x: 0, y: 0);
    func unrejectWith(queen:Queen) -> Bool {
        let x   = queen.locations.x;
        let y   = queen.locations.y;
        let x1   = self.locations.x;
        let y1  = self.locations.y;
        if x == x1 || y == y1 ||
            (abs(x-x1) == abs(y-y1)){
            return false
        }
        return true
    }
    func printQueen() -> Void {
        var ss = ""

        for i in 0...8 {
            if i == self.locations.x {
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
        for k in 0..<count{
            let qSub = queens[k];
            if qSub.unrejectWith(queen: queen) == false{
                //有能打架的皇后
                pass = false;
                break;
            }
        }
        return pass;
    }
    //递归解法
    mutating func callback(x:inout Int,y:inout Int , n:inout
        Int,xMax:Int,yMax:Int) -> Void {
        let q = Queen(locations: Point(x: x, y: y));
        let can = self.canStandWithOthers(queens: self.queensArray, queen: q);
        if can {
            self.queensArray.append(q);
            y += 1;
            x = 0;
            if y > yMax
            {
                if (self.queensArray.count == n){
                self.queensWay.append(self.queensArray);
                    self.queensArray.removeAll();
                    x = self.queensWay.count;
                    y = 0;
                    if (x == n){return}else{
                        callback(x: &x, y: &y, n: &n, xMax: xMax, yMax: yMax);
                    }
                }else{
                    if self.queensArray.count > 0{
                        let lastQ = self.queensArray.removeLast();
                        x = lastQ.locations.x + 1;
                        y -= 1;
                    }
                }
            }else if(y <= yMax){
                callback(x: &x, y: &y, n: &n, xMax: xMax, yMax: yMax);
            }
        }else if(x < xMax){
            x += 1;
            callback(x: &x, y: &y, n: &n, xMax: xMax, yMax: yMax);
        }else if(x >= xMax){
            if self.queensArray.count > 0{
                let lastQ = self.queensArray.removeLast();
                x = lastQ.locations.x + 1;
                y -= 1;
                if x > xMax{
                    let lastQ = self.queensArray.removeLast();
                    x = lastQ.locations.x + 1;
                    y -= 1;
                }
                callback(x: &x, y: &y, n: &n, xMax: xMax, yMax: yMax);
            }
        }
    }
    //迭代解法
    public mutating func handle() -> Void {
        var number = 0
        
        while number<8 {
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
            let queen = Queen(locations: Point(x: x, y: y));
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
                    x = self.queensArray.removeLast().locations.x + 1;
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
            for j in 0..<countSub{
                let q = queens[j];
                q.printQueen();
            }
            print("--------------------");
        }
    }
}


