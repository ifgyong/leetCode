//
//  main.cpp
//  LeetCodeC++
//
//  Created by fgy on 2019/3/30.
//  Copyright © 2019 test. All rights reserved.
//

#include <iostream>
<<<<<<< HEAD
#include "numberAction.hpp"


=======
#include "string_c.h"
>>>>>>> d7acdb417baba0f3104032b022d543007316a369

bool isValid(char* s);
int main(int argc, const char * argv[]) {
<<<<<<< HEAD
    int i = numberOf1(5);
    std::cout<<i<<std::endl;
=======

    char * p = "123";
    bool y = isValid(p);
//    std::cout<<isValid(p)<<std::endl;
>>>>>>> d7acdb417baba0f3104032b022d543007316a369
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
