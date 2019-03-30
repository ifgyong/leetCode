//
//  sortAction.swift
//  LeetcodeSwift
//
//  Created by fgy on 2019/3/29.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation
//贪婪算法剪绳子
func cutCount(length:Int) -> Int{
    
    if length == 0 {
        return 0;
    }else if length == 1{
        return 1;
    }else if length == 2{
        return 2;
    }else if length == 3{
        return 3;
    }
    var timeof3 = length/3;
    if length%3 == 1 {
        timeof3 -= 1;
    }
    let timeof2 = (length - timeof3 * 3)/2;
    
    return Int(pow(3.0,Double(timeof3))*pow(2, Double(timeof2)));
}






func quickSort(list:inout [Int],low:Int,high:Int) -> Void {
    if low >= high {
        return;
    }
    var l = low;
    var h = high;
    let pro = list[low];
    
    while l < h {
        while l < h && list[h] > pro{
            h -= 1;
        }
        if l < h {
            //判断 是由于list[h] >pro 引起中断的  所以list[h] > pro 交换位置 list[h] 为空
            list[l] = list[h];
            l += 1;
        }
        
        while l < h && list[l] < pro{
            l += 1;
        }
        if l < h{
            //判断 是由于list[h] >pro 引起中断的  所以list[l]<pro 为空的list[h]接受新的list[l]的值
            list[h] = list[l];
            h += 1;
        }
        list[l] = pro; //将哨兵存储到最后空的值
    }
    quickSort(list: &list, low: low, high: l);
    quickSort(list: &list, low: l+1, high: high);
    
    
}
