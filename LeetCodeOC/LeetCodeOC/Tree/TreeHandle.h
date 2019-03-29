//
//  TreeHandle.h
//  LeetCodeOC
//
//  Created by fgy on 2019/3/26.
//  Copyright © 2019 test. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Tree.h"

NS_ASSUME_NONNULL_BEGIN

@interface TreeHandle : NSObject


@property (nonatomic,strong)NSMutableArray *valsArray;
- (void)travIn_C:(Tree *)tree;
- (void)travIn_L:(Tree *)tree;
- (void)travIn_R:(Tree *)tree;


- (void)travIn_I_C:(Tree *)tree;
- (void)travIn_I_L:(Tree *)tree;
- (void)travIn_I_R:(Tree *)tree;


@end

NS_ASSUME_NONNULL_END
