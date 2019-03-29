//
//  MinimunTimeDifference.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/3/27.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation
class Minmun: NSObject {
    
    func findMinDifference(_ timePoints: [String]) -> Int {
        var times = [Int]();
        for i in 0..<timePoints.count {
            let timeString = timePoints[i];
            let strArray = timeString.split(separator: ":");
            let hh:String = String(strArray[0])
            let mm:String = String(strArray[1])
            let time:Int = Int(hh)! * 60 + Int(mm)!;
            times.append(time);
        }
        times.sort { (obj1, obj2) -> Bool in
            return (obj1 - obj2) < 0;
        }
//        times.append(60*24);
        var min = 60 * 24;
        let max = 60*24;
        
        for i in 0..<times.count{
            if i == times.count-1 {
                let sub = max - times[i] + times[0] ;
                
                if sub < min && sub >= 0 {
                    min = sub;
                }
            }else{
                let sub = times[i+1] - times[i] ;
                
                if sub < min && sub >= 0 {
                    min = sub;
                }
            }
          
        }
        return min;
        
        
        
        
    }
}
