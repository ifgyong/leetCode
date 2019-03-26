//
//  FYQueenHandle.h
//  LeetCodeOC
//
//  Created by fgy on 2019/3/25.
//  Copyright © 2019 test. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Queen.h"
NS_ASSUME_NONNULL_BEGIN
//8皇后问题 92 种方案已解决
@interface FYQueenHandle : NSObject

@property (nonatomic,strong) NSMutableArray *queenMutArray;
@property (nonatomic,strong) NSMutableArray *queensLine;



+ (void)doItWithCallBack:(BOOL)callback;

- (void)handle;
+(BOOL)fightQueen:(Queen*)queen inList:(NSArray *)array;
@end

NS_ASSUME_NONNULL_END
