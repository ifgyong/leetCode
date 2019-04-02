//
//  numbeAction.cpp
//  LeetCodeC++
//
//  Created by fgy on 2019/3/30.
//  Copyright © 2019 test. All rights reserved.
//

#include <iostream>
//统计二进制的1的个数
int numberOf1(int n){
    unsigned int flag = 1;
    int count = 0;
    while (flag) {
        if (n&flag) {
            count ++;
        }
        flag = flag<<1;
    }
    return count;
}
