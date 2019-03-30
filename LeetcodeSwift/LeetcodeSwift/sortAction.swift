//
//  sortAction.swift
//  LeetcodeSwift
//
//  Created by fgy on 2019/3/29.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation
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
