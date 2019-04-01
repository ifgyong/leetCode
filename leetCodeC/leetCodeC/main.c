//
//  main.c
//  leetCodeC
//
//  Created by Charlie on 2019/3/29.
//  Copyright © 2019年 www.fgyong.cn. All rights reserved.
//

#include <stdio.h>
#include "StringAction.h"

char * keepAlpChar(char *fromString,char *charList );
bool isPalindrome(int x);
int main(int argc, const char * argv[]) {
 
    
    
    return 0;
}
bool isPalindrome(int x) {
    if (x < 0) {
        return NO;
    }else if (x == 0){
        return true;
    }else {
        let str = String(x);
        let count = str.count;
        
        if count == 1{
            return true;
        }else{
            let i  = 0;
            let  isPalin   = true;
            let sChar = str[1];
            
            while i < count/2{
                if str
                    }
        }
        
    }
    return true;
}

char * keepAlpChar(char *fromString,char *charList )
{
    charList = fromString;
    int i = 0;
    while(*fromString)
    {
        if(*fromString>'9' ||  *fromString<'0')
            fromString[i++] = *fromString;
        fromString++;
    }
    fromString[i] = '\0';
    return charList;
    }
