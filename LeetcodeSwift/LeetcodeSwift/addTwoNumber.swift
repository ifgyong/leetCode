//
//  addTwoNumber.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/3/27.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation

// * Definition for singly-linked list.
  public class ListNode {
      public var val: Int
      public var next: ListNode?
      public init(_ val: Int) {
          self.val = val
          self.next = nil
      }
  }
 
class Solution {
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        let nodel = ListNode(0);
        var node2 = nodel;
        var l11 = l1;
        var l22 = l2;
        
        
        while l11 != nil ||  l22 != nil  {
            if l11 != nil && l22 != nil{
                let count1 = (l11?.val);
                let count2 = (l22?.val);
                let t = ListNode(count2! + count1!);
                if node2.next == nil{
                    node2.next = t;
                    let t_nex_Val = node2.val;
                    if t_nex_Val > 9{
                        t.val = (t.val) + 1;
                        node2.val = t_nex_Val % 10;
                    }
                }else{
                    node2 = (node2.next)!;
                    node2.next = t;
                    let t_nex_Val = node2.val;
                    
                    if t_nex_Val > 9{
                        t.val = (t.val) + 1;
                        node2.val = t_nex_Val % 10;
                        if l11?.next == nil ||  l22?.next == nil {
                            if t.val > 9{
                                t.val = t.val % 10;
                                let tSub = ListNode(1);
                                t.next = tSub;
                            }
                        }
                    }
                }
            }else if(l11 != nil){
                let tSub = ListNode((l11?.val)!);
                node2.next = tSub;
                node2 = node2.next!;
            }else if(l22 != nil){
                let tSub = ListNode((l22?.val)!);
                node2.next = tSub;
                node2 = node2.next!;
            }
            
            l11 = l11?.next;
            l22 = l22?.next;
        }
        return nodel;
    }
}
