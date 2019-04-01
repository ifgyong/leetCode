//
//  TreeAction.swift
//  LeetcodeSwift
//
//  Created by Charlie on 2019/4/1.
//  Copyright © 2019年 test. All rights reserved.
//

import Foundation
func removeNthFromEnd(_ head: ListNode?, _ n: Int) -> ListNode? {
    if n < 0 {
        return nil;
    }
    var intArray = [Int]()
    var newHead = head;
    while newHead != nil  {
        intArray.append(newHead?.val ?? 0)
        newHead = newHead?.next;
    }
    if n > intArray.count{return nil};
    
    intArray .remove(at: intArray.count-n);
    if  intArray.count == 0 {
        return nil;
    }
    var lhead = ListNode(intArray[0]);
    let l_save = lhead;
    
    for i in 1..<intArray.count{
        let now_node = ListNode(intArray[i]);
        lhead.next = now_node;
        lhead = now_node;
    }
    return l_save;
}
