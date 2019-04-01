//
//  StringAction.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/3/29.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation

//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
func generateParenthesis(_ n: Int) -> [String] {
    var l_array = [String]();
  
    func g(array:inout [String],str:String,lo:Int,hi:Int){
        if lo > hi {
            return;
        }
        if lo > 0 {
            g(array: &array, str: str+"(", lo: lo-1, hi: hi);
        }
        if hi > 0 {
            g(array: &array, str: str+")", lo: lo, hi: hi-1);
        }
        if lo == 0 && hi == 0 {
            array.append(str);
            return;
        }
    }
      g(array: &l_array, str: "", lo: n, hi: n);
    return l_array;
}
//电话号码所有可能的拼音
func letterCombinations(_ digits: String) -> [String] {
    if digits.count == 0 {
        return [];
    }
    let array = [[],
                 [],
                 ["a","b","c"],
                 ["d","e","f"],
                 ["g","h","i"],
                 ["j","k","l"],
                 ["m","n","o"],
                 ["p","q","r","s"],
                 ["t","u","v"],
                 ["w","x","y","z"]];
    
    var result_sub = [String]();

    
    for (_,ch) in digits.enumerated() {
        let str = String(ch);
        let ch_news = array[Int(str) ?? 0];
        if result_sub.count == 0{
            result_sub = ch_news;
        }else{
            var chs_newArray = [String]()
            
            for i in 0..<ch_news.count{
                var  j = 0;
                while j < result_sub.count{
                    var str_sub = result_sub[j];
                    str_sub = str_sub + ch_news[i];
                    chs_newArray.append(str_sub);
                    j += 1;
                }
            }
            result_sub = chs_newArray;
        }
    }
    return result_sub;
}
//三个数字和最近的值
func threeSumClosest(_ nums: [Int], _ target: Int) -> Int  {
    if nums.count < 3{
        return 0;
    }
    var array = nums.sorted();
    let count = array.count;
    var  min = Int(INT32_MAX);
    var num = 0;
    
    
    for i in 0..<count-2{
        var low = i+1;
        var hi = count-1;
        let tar = array[i];
        

        while low < hi{
            let nowResult = array[low] + array[hi] + tar;
            if abs(nowResult - target) < min{
                min = abs(nowResult - target);
                num = nowResult;
            }
            if abs(nowResult - target) == 0{
                return target;
            }else if (nowResult < target){
                low += 1;
            }else{
                hi -= 1;
            }
        }
    }
    return num;
}
func threeSum(_ nums: [Int]) -> [[Int]] {
    if nums.count < 3{
        return [];
    }
    var array = nums.sorted();
    var result = [[Int]]();
    let count = array.count;
    var  isaddZero = false;
    
    for i in 0..<count-2{
        var low = i+1;
        var hi = count-1;
        let tar = -array[i];
        
        if array[i] == array[i+1] && array[i+1] == array[i+2] && array[i] == 0{
            if isaddZero == false{
                result.append([0,0,0]);
                isaddZero = true;
            }
            continue;
        }
        if i > 0 && array[i] == array[i-1]{
            continue;
        }
        if array[i] > 0 {
            break;
        }
        while low < hi{
            
            let nowResult = array[low] + array[hi];
            if nowResult == tar{
                result.append([array[i],array[low],array[hi]])
                while low < hi && (array[low] == array[low+1]){
                    low += 1;
                }
                while low < hi && (array[hi] == array[hi-1]){
                    hi -= 1;
                }
                low += 1;
                hi -= 1;
            }else if nowResult < tar{
                low += 1;
            }else if nowResult > tar{
                hi -= 1;
            }
        }
    }
    return result;
}
func romanToInt(_ s: String) -> Int {
    if  s.isEmpty {
        return 0;
    }
    
    var count = 0;
    var  last = 0;
    var list = ["I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000];
    
    for (_,i) in s.enumerated().reversed() {
        let nowInt = list[String(i)] ?? 0;
        if last > nowInt{
            count -= nowInt;
        }else{
            count += nowInt;
        }
        last = nowInt;
    }
    return count;
}
func intToRoman(_ num: Int) -> String {
    if num < 1 || num > 3999 {
        return "";
    }
    var n = 0;
    var number = num;
    var str = "";
    var h1 = ["I","X","C","M"];
    var h2 = ["V","L","D"];
    
    
    while number > 0 {
        let d = number%10;
        
        var xx = "";//
        if n < 3{
            xx = h2[n];//位数
        }
        
        let x1 = h1[n];
        if d == 0{}
        else if d < 4 {
            for _ in 1...d{
                str = x1 + str;
            }
        }else if d == 4{
            let x4 = h1[n]+xx
            str = x4 + str;
        }else if d == 5  {
            str = xx + str;
        }else if d > 5 && d < 9{
            
            for _ in 6...d{
                str = x1 + str;
            }
            str = xx + str;
        }else if d == 9{
            str = x1 + h1[n+1] + str;
        }
        number /= 10;
        n += 1;
    }
    return str;
}

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
