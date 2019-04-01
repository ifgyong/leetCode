//
//  main.cpp
//  LeetCodeC++
//
//  Created by fgy on 2019/3/30.
//  Copyright © 2019 test. All rights reserved.
//

#include <iostream>
#include "string_c.h"

bool isValid(char* s);
int main(int argc, const char * argv[]) {

    char * p = "123";
    bool y = isValid(p);
//    std::cout<<isValid(p)<<std::endl;
    return 0;
}
bool isValid(char* s) {
    unsigned long  length = strlen(s);
    char p [length];
    for (int i = 0; i < length; i ++) {
        p[i] = *s+i;
    }
    while (true) {
        for (int i = 0; i < length-1; i ++) {
            printf("%c",p[i]);
            if (p[i] == p[i+1]) {
                p
            }
        }
    }
  
    printf("\n");
    return   true;
    
}
