//
//  main.swift
//  LeetcodeSwift
//
//  Created by fgy on 2019/3/22.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation


//var handle = Treehandle();
//let t = handle.createTree();
//handle.handle();
//let x =  myPow(x: 2.0000, n: 10);
//print(x);
var list = [1,2,5,3,1,2,10,5];
quickSort(list: &list, low: 0, high: list.count-1);
print(list);
//var list = [0,4,3,2,1,5,6]

// quickSort(list: &list, low: 0, high: list.count-1);
//print(list);
let length = 12;

print(cutCount(length: length));
print(cutlineCount_suloution(length: length));

>>>>>>> 2fd248de47aad0b2318e7b7a8658b8cab7962f38
