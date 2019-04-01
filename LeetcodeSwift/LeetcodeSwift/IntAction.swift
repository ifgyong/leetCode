//
//  IntAction.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/3/29.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation
//快速排序
func quickSort(list:inout [Int],low:Int,high:Int) -> Void {
    if low >= high {
        return;
    }
    var l = low;
    var h = high;
    let pro = list[low];
    while l < h {
        while l < h && list[h] >= pro  {
            h -= 1;
        }
        list[l] = list[h];
        while l < h && list[l] <= pro{
            l += 1;
        }
        list[h] = list[l];
    }
    list[l] = pro;
    
    quickSort(list: &list, low: 0, high: low);
    quickSort(list: &list, low: low+1, high: high);
}
// 时间负责度O（n）
func maxArea(_ height: [Int]) -> Int {
    if height.count == 0 {
        return 0;
    }
    var max = 0;
    let count = height.count
    var l = 0;var r = count-1;
    while l < r {
        let min = height[l] > height[r] ? height[r]:height[l];
        
        let now  = min * (r-l);
        if max < now{max = now;}
        if height[l] < height[r]{
            l += 1;
        }else{
            r -= 1;
        }
    }
    return max;
}
func maxArea2(_ height: [Int]) -> Int {
    if height.count == 0 {
        return 0;
    }
    var max = 0;
    let count = height.count// 时间负责度O（n^2）
    for i  in 0..<count {
        for j  in i+1..<count {
            let minNumber = height[i] > height[j] ? height[j]:height[i];
            let now = minNumber * (j-i);
            if max < now{
                max = now;
            }
        }
    }
    return max;
}
