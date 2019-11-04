//
//  ArrayExtren.swift
//  leetCode01
//
//  Created by fgy on 2019/3/18.
//  Copyright © 2019 test. All rights reserved.
//

import Foundation
import Cocoa

extension Array{
    func sortBy()->Array<Int>  {
        var sorted = false;
        let list = self;
        
        let count = list.count;
        var countJ = 0;
        
        var listCopy = list;
        
        while (!sorted ) {
            sorted = true;
            for index in 0 ..< count-1-countJ{
                let indexValue:Int = (listCopy[index] as! Int);
                let indexValue2:Int = (listCopy[index+1] as! Int);
                if(indexValue > indexValue2 ){
                    listCopy[index] = indexValue2 as! Element;
                    listCopy[index+1] = indexValue as! Element;
                    sorted = false;
                }
            }
            countJ+=1;
        }
        return listCopy as! Array<Int>;
    }
    
}
