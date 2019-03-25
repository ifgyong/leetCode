//
//  FYQueenHandle.m
//  LeetCodeOC
//
//  Created by fgy on 2019/3/25.
//  Copyright © 2019 test. All rights reserved.
//

#import "FYQueenHandle.h"

@implementation FYQueenHandle
+ (void)doIt{
    FYQueenHandle *handle=[FYQueenHandle new];
    [handle handle];
    NSLog(@"%@",handle.description);
}
- (NSMutableArray *)queensLine{
    if (_queensLine == nil) {
        _queensLine=[NSMutableArray array];
    }
    return _queensLine;
}
- (NSMutableArray *)queenMutArray{
    if (_queenMutArray == nil) {
        _queenMutArray=[NSMutableArray arrayWithCapacity:1];
    }
    return _queenMutArray;
}
+(BOOL)fightQueen:(Queen *)queen inList:(NSArray *)array
{
    BOOL pass = NO;
    if (array.count == 0) {
        return NO;
    }
    for (Queen * item in array) {
        NSInteger xx = labs(item.x - queen.x);
        NSInteger yy = labs(item.y - queen.y);
        BOOL is = xx == yy ? YES:NO;
        if (item.x == queen.x ||
            item.y == queen.y || is
            ) {
            pass = YES;
            break;
        }
    }
    return pass;
}
- (void)handle{
    for (NSInteger y = 0; y < 8; y ++) {
        for (NSInteger x = 0; x < 8; x ++) {
            Queen *q = [Queen new];
            q.x = x;
            q.y = y;
            if( [FYQueenHandle fightQueen:q
                                   inList:self.queensLine] == NO){
                [self.queensLine addObject:q];
                
                if (self.queensLine.count == 8) {
                    [self.queenMutArray addObject:[self.queensLine copy]];
                    [self.queensLine removeLastObject];
                    if (x == 7) {
                        if (self.queensLine.count) {
                            Queen * last = self.queensLine.lastObject;
                            x = last.x;
                            y = last.y;
                            [self.queensLine removeLastObject];
                        }else{
                            x = 8;//跳出循环
                            y = 8;
                        }
                    }
                }else{
                    break;//跳出来y +1
                }
            }else{//添加不上去
                if (x == 7) {
                    if (self.queensLine.count) {
                        Queen * last = self.queensLine.lastObject;
                        x = last.x;
                        y = last.y;
                        [self.queensLine removeLastObject];
                        if (x == 7) {
                            if (self.queensLine.count) {
                                Queen * last2 = self.queensLine.lastObject;
                                x = last2.x;
                                y = last2.y;
                                [self.queensLine removeLastObject];
                            }else{
                                y = 8;
                                x = 8;
                            }
                        }
                    }else{
                        x = 8;//跳出循环
                        y = 8;
                    }
                }
            }
        }
    }
}
- (NSString *)description{
    return [NSString stringWithFormat:@"皇后：%ld",self.queenMutArray.count];
}
@end
