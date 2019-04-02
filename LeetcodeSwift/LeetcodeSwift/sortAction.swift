//
//  sortAction.swift
//  LeetcodeSwift
//
//  Created by fgy on 2019/3/29.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation
//统计二进制的 1的数字个数
//负数统计陷入死循环
func numberToTwoAndOneCount(n:Int) ->Int{
    var x = n;
    var count = 0;
    
    while x>0 {
        if x&1 == 1{
            count += 1;
        }
        x = x>>1;
    }
    return count;
func divide(_ dividend: Int, _ divisor: Int) -> Int {
    
    let di = dividend>0;
    let di2 = divisor>0;
    var new_d = abs(dividend);
    let di2_new = abs(divisor);
    var  count = 0;
    
    while new_d >= abs(divisor) {
        new_d -= di2_new;
        count += 1;
    }
    if (di2 && di)||(di2==false && di==false){
        let max = Int(pow(2.0, 31)-1)
        
        if count > max{
            return max;
        }
        return count;
    }else{
        let  min = -Int(pow(2.0, 31))
        
        if 0-count < min{
            return min;
        }
        return 0-count;
    }
}
//贪婪算法剪绳子
func cutCount(length:Int) -> Int{
    
    if length < 2 {
        return 0;
    }else if length == 2{
        return 1;
    }else if length == 3{
        return 2;
    }
    var timeof3 = length/3;
    if length%3 == 1 {
        timeof3 -= 1;
    }
    let timeof2 = (length - timeof3 * 3)/2;
    return Int(pow(3.0,Double(timeof3))*pow(2, Double(timeof2)));
}
//动态规划 解决切绳子问题
func cutlineCount_suloution(length:Int) -> Int{
    if length < 2{
        return 0;
    }else if length == 2{
        return 1;
    }else if length == 3{
        return 2;
    }
    var max = 0;
    var countArray = [Int]()
    countArray.append(0);
    countArray.append(1);
    countArray.append(2);
    countArray.append(3);
    for i  in 4...length {
        max = 0;
        for j in 1...i/2{
            let currentLength = countArray[j] * countArray[i-j];
            if currentLength > max{
                max = currentLength;
            }
            countArray.insert(max, at: i);
        }
    }
    max = countArray[length];
    return max;
}





func quickSort(list:inout [Int],low:Int,high:Int) -> Void {
    if low >= high || low < 0 || list.count == 0 || high > list.count-1 {
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
            h -= 1;
        }
        list[l] = pro; //将哨兵存储到最后空的值
    }
    quickSort(list: &list, low: low, high: l-1);
    quickSort(list: &list, low: l+1, high: high);
}
}
