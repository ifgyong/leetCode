//
//  findMaxAverage.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/3/28.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation

func largestTimeFromDigits( A: [Int]) -> String {
    var array = A.sorted();
    var time = "";
    
    var n1 = -1;
    var n2 = -1;
    var n3 = -1;
    var n4 = -1;
    var index = 0;
    
    
    
    
    while true {
        var i = 0;
        
         while i < array.count{
            if index == 0{
                if array[i] < 3 && array[i] > n1{
                    n1 = i;
                    array.remove(at: i);
                    break;
                }
            }else if index == 1{
                if n1  != -1 {
                    if (n1 == 0 || n1 == 1) && array[i] > n2{
                        n2 = i;
                    }else if(n1 == 2){
                        if array[i] > n2 && array[i] < 4{
                            n2 = array[i];
                            array.remove(at: i);break;
                        }
                    }
                }
            }else if index == 2{
                if n2 == -1{break;}else{
                    if array[i] < 6 && array[i] > n3{
                        n3 = i;
                    }
                }
            }
        }
    }
    if array[0] == 0 || array[0] == 1 {
         if(array[1] < 6){
            if array[1] < 3{
                
                if array[2] < 6{
                    time = "\(array[1])\(array[3]):\(array[2])\(array[1])"
                }else{
                    time = "\(array[1])\(array[3]):\(array[1])\(array[2])"
                }
            }else{
                if array[2] < 6{
                    time = "\(array[0])\(array[3]):\(array[2])\(array[1])"
                }else{
                    time = "\(array[0])\(array[3]):\(array[1])\(array[2])"
                }
            }
           
        }
    }else  if(array[0] == 2 && array[1] < 4){
        if array[3] < 4{
            time = "\(array[0])\(array[3]):\(array[2])\(array[1])"
        }else if(array[2] < 4){
            if array[3] < 6{
                time = "\(array[0])\(array[2]):\(array[3])\(array[1])"
            }else{
                time = "\(array[0])\(array[2]):\(array[1])\(array[3])"
            }
        }else if(array[1] < 4){
            if array[3] < 6{
                time = "\(array[0])\(array[2]):\(array[3])\(array[1])"
            }else if(array[2] < 6 ){
                time = "\(array[0])\(array[2]):\(array[1])\(array[3])"
            }
        }
    }
    return time;
}
func removeComments(_ source: [String]) -> [String] {
    var sourceCopy = source;
    
    var l_index = -1;
    var r_index = -1;
    var i = 0
    //从大到小
    while i < sourceCopy.count  {
        let item = sourceCopy[i];
        if item.contains("/*") && l_index == -1{
            l_index = i;
        }
        if item.contains("*/") && r_index == -1 && l_index != -1{
            r_index = i;
        }
        if l_index == r_index{
            l_index = -1;
            r_index = -1;
            let l_rang = item.range(of: "/*");
            let r_rang = item.range(of: "*/");
            let index = item.index(before: l_rang?.lowerBound ?? item.startIndex);
            let index2 = item.index(after: r_rang?.upperBound ?? item.endIndex);
            let  newS = item.prefix(upTo: index);//前半截
            let  newS2 = item.suffix(from: index2);//后半截
            let  new = String(newS) + String(newS2);
            sourceCopy[i] = String(new);
            print(newS);
        }else if(l_index != -1 && r_index != -1){
            if l_index < r_index{
                let r =  Range.init(uncheckedBounds: (l_index+1,r_index))
                for k in r.reversed(){
                    sourceCopy.remove(at: k);
                }
                let l_str = source[l_index];
                let r_str = source[l_index + 1];
                
                
                let l_rang = l_str.range(of: "/*");
                let r_rang = r_str.range(of: "*/");
                
                
                let index  = l_str.index(l_str.startIndex, offsetBy: l_rang?.lowerBound.encodedOffset ?? 0);
                let index2 = r_str.index(r_str.startIndex, offsetBy: (r_rang?.upperBound.encodedOffset ?? 0 + 1));
                let  newS = l_str.prefix(upTo: index);//前半截
                let  newS2 = r_str.suffix(from: index2);//后半截
                let  new = String(newS) + String(newS2);
                if new.count > 0{
                    sourceCopy.insert(new, at: l_index+2);
                }
                sourceCopy.remove(at: l_index+1);
                sourceCopy.remove(at: l_index);
                i = l_index;//下一个
                l_index = -1;
                r_index = -1;
            }else{
                
            }
        }
        
        i += 1;
    }
    return sourceCopy;
    
}
func maxPoints(_ points: [Point]) -> Int {
    var xy = 0.0;
    var x = 0;
    for i in 1..<points.count {
        let now_XY:Double = Double((points[i].x-points[i-1].x))/Double((points[i].y - points[i-1].y))
        if now_XY != xy{
            xy = now_XY;
        }else{
            if points[i].x > x{
                x = points[i].x;
            }
        }
    }
    return x;
}
func myPow( x: Double,  n: Int) -> Double {
    return pow(x, Double(n));
}
func reverseOnlyLetters(_ S: String) -> String {
    var str = "";
    var arrayCount = [String]();
    for i in 0..<S.count {
        let item = S[S.index(S.startIndex, offsetBy: i)];
        arrayCount.append(String(item));
    }
    var i  = 0;
    var j = S.count - 1;
    
    
    while true {
        let z = Character("z")
        let a = Character("A")
        
        while i<j {
            let iString = S[S.index(S.startIndex, offsetBy: i)];
            if iString > z || iString < a{
                i += 1;
            }else{break;}
        }
        while i<j {
            let iString = S[S.index(S.startIndex, offsetBy: j)];
            if iString > z || iString < a{
                j -= 1;
            }else{break;}
        }
        if i >= j{
            break;
        }
        arrayCount[i] = String( S[S.index(S.startIndex, offsetBy: j)]);
        arrayCount[j] = String(S[S.index(S.startIndex, offsetBy: i)]);
        i += 1;
        j -= 1;
    }
    for k in 0..<arrayCount.count{
        str += String(arrayCount[k]);
    }
    return str;
}
func findMaxAverage(_ nums: [Int], _ k: Int) -> Double {
    
    var max = 0.0;
    var number = 0.0;
    for i in 0..<k {
        number = number + Double(nums[i]);
    }
    max = number;
    for i in k..<nums.count {
        number = number + Double(nums[i]) - Double(nums[i-k]);
        if number > max {
            max = number;
        }
    }
    return max/Double(k);
}
