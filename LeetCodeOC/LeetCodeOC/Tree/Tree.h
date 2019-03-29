//
//  Tree.h
//  LeetCodeOC
//
//  Created by fgy on 2019/3/26.
//  Copyright © 2019 test. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Tree : NSObject
@property (nonatomic,assign) NSInteger val;
@property (nonatomic,strong) Tree *left;
@property (nonatomic,strong) Tree *right;

+ (instancetype)loadWithVal:(NSInteger)val;

- (void)configLeft:(Tree *)left right:(Tree *)right;
@end

NS_ASSUME_NONNULL_END
