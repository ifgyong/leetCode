//
//  Tree.m
//  LeetCodeOC
//
//  Created by fgy on 2019/3/26.
//  Copyright © 2019 test. All rights reserved.
//

#import "Tree.h"

@implementation Tree
+ (instancetype)loadWithVal:(NSInteger)val{
    Tree *t =[Tree new];
    t.val = val;
    return t;
}
- (void)configLeft:(Tree *)left right:(Tree *)right{
    if (left) {
        self.left = left;
    }
    if (right) {
        self.right = right;
    }
}
@end
