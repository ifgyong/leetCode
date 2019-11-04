//
//  main.swift
//  leetCode01
//
//  Created by fgy on 2019/3/18.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation


print("Hello, World!")


//func sort(list :Array<Int>) -> Array<Int> {
//    var sorted = false;
//    let count = list.count;
//    var countJ = 0;
//
//    var listCopy = list;
//
//    while (!sorted ) {
//        sorted = true;
//        for index in 0 ..< count-1-countJ{
//            let indexValue = listCopy[index];
//            let indexValue2 = listCopy[index+1];
//            if(indexValue > indexValue2){
//                listCopy[index] = indexValue2;
//                listCopy[index+1] = indexValue;
//                sorted = false;
//            }
//        }
//        countJ+=1;
//    }
//    return listCopy;
//}
let listOld = [2,3,1,4,7,5,8,6];

var list = listOld.sortBy();
print(list);

