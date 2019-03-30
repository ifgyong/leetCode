//
//  StringAction.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/3/29.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation


//z乘积最大子序列  性能比较慢
func maxProduct(_ nums: [Int]) -> Int {
    
    if nums.count == 1 {
        return nums[0];
    }
    var max:Int32 = INT16_MIN;
    var pro:Int32 = 1;
    
    for  i in 0..<nums.count {
        var new = nums[i];
        if new == 0 || i == nums.count{
            
        }else{
            pro *= Int32( new);
            if pro > max{
                max = pro;
            }
        }
        for j in i..<nums.count{
            if i == j{
                new =  nums[j];
            }else{
                new *=  nums[j];
            }
            if new > max{
                max = Int32(new);
            }
            if new == 0{
                break;
            }
        }
    }
    return Int(max);
    
}
//翻转字符串
func reverseWords(_ s: String) -> String {
    if s.count == 0 {
        return "";
    }
    let strArray = s.split(separator: " ");
    if strArray.count == 1{
        return String( strArray[0]);
    }else{
        var newSArray = [String]();
        let rang = Range(uncheckedBounds: (lower: 0, upper: strArray.count));
        
        for i in rang.reversed(){
            newSArray.append(String(strArray[i]));
        }
        return newSArray.joined(separator: " ");
    }
}
