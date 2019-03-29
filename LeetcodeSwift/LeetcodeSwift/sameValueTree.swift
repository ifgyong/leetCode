//
//  sameValueTree.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/3/27.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation

 //* Definition for a binary tree node.
  public class TreeNode {
      public var val: Int
      public var left: TreeNode?
      public var right: TreeNode?
      public init(_ val: Int) {
          self.val = val
          self.left = nil
          self.right = nil
      }
  }


class SolutionSameValue {
    func isUnivalTree(_ root: TreeNode?) -> Bool {
        let rootValue = root?.val;
        var rootsArray:[TreeNode] = [TreeNode]();
        var i  = 0;
        var result = true;
        
        if root != nil {
            rootsArray.append(root!);
        }
        while true {
            if i >= rootsArray.count {break};
            let tree = rootsArray[i];
            if tree.val != rootValue{
                result = false;
                break;
            }
            if tree.left != nil{
                rootsArray.append(tree.left!);
            }
            if tree.right != nil{
                rootsArray.append(tree.right!)
            }
            
            i += 1;
            
        }
        return result;
    }
}
