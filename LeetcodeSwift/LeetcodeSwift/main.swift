//
//  main.swift
//  LeetcodeSwift
//
//  Created by fgy on 2019/3/22.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation

var handle = QueenHandle();
var n = 8,x = 0,y = 0,xMax = 7,yMax = 7;
    handle.callback(x: &x, y: &y, n: &n, xMax: xMax, yMax: yMax);
    handle.printWays();
