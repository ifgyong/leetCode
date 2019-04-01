//
//  main.swift
//  LeetcodeSwift
//
//  Created by fgy on 2019/3/22.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation

//var handle = QueenHandle();
//
//var n = 8,x = 0,y = 0;
//    handle.callback(x: x, y: y, n: n);
////handle.handle();
//    handle.printWays();


//var handle = Treehandle();
//let t = handle.createTree();
//handle.handle();
//let x =  myPow(x: 2.0000, n: 10);
//print(x);
var list = [1,2,5,3,1,2,10,5];
quickSort(list: &list, low: 0, high: list.count-1);
print(list);
